# Microservice Design Patterns (รูปแบบการออกแบบ Microservice)

> อ้างอิงจาก: [Microservice Design Patterns which you will face](https://portfolio.tpcoder.dev/blog/microservice-design-patterns-which-you-will-face-th/)

แนวคิดหลัก: ไม่ต้องใช้ทุก pattern พร้อมกัน — เริ่มจาก **Database per Microservice + API Gateway** แล้วค่อย ๆ เพิ่ม pattern ตามปัญหาที่พบ

## 1. Database per Microservice

แต่ละ service มี database ของตัวเอง ไม่ share กับ service อื่น การเข้าถึงข้อมูลของ service อื่นต้องผ่าน API เท่านั้น

- รองรับ polyglot persistence — เลือก database ที่เหมาะกับแต่ละ workload ได้อิสระ
- Schema changes ของ service หนึ่งไม่กระทบ service อื่น
- Trade-off: ความสัมพันธ์ข้ามข้อมูลมีความซับซ้อนมากขึ้น

## 2. CQRS (Command Query Responsibility Segregation)

แยก read และ write ออกจากกันโดยใช้ data store คนละตัว เพื่อ optimize แต่ละฝั่งได้อิสระ

```
Write ──► PostgreSQL (primary)
              │ sync via events
              ▼
Read  ◄── Elasticsearch (read model)
```

- **ตัวอย่าง**: Job board — recruiter post งาน (write → PostgreSQL), candidate ค้นหา (read → Elasticsearch)
- Trade-off: Eventual consistency — read model อาจ lag หลัง write model เล็กน้อย

## 3. Event Sourcing

เก็บทุก state change เป็น immutable events แทนการเก็บแค่ state ปัจจุบัน

- สามารถ replay events เพื่อ reconstruct state ณ เวลาใดก็ได้
- มี audit trail สมบูรณ์ — debug ง่าย
- มักใช้คู่กับ CQRS

**ตัวอย่าง**: Shopping cart เก็บ events `ItemAdded`, `QuantityChanged`, `CouponApplied` แทนการเก็บแค่ยอดรวม

## 4. Saga Pattern

จัดการ distributed transactions ข้ามหลาย services โดยใช้ local transactions + compensating actions เมื่อเกิดข้อผิดพลาด

### Choreography-based
Services publish events เองโดยไม่มี coordinator กลาง — เหมาะกับ flow ที่ไม่ซับซ้อน

```
OrderService ──► OrderCreated
                     │
              PaymentService ──► PaymentCompleted
                                       │
                              InventoryService ──► StockReserved
```

### Orchestration-based
มี orchestrator กลางที่ควบคุมลำดับการทำงานของแต่ละ service — เหมาะกับ flow ที่ซับซ้อนและต้องการ visibility

- Trade-off: orchestrator เป็น critical dependency ต้องมี high availability

## 5. BFF (Backend for Frontend)

Intermediate layer ที่รวมข้อมูลจากหลาย services และปรับแต่ง response ให้เหมาะกับแต่ละ client

- แยก Web BFF และ Mobile BFF ได้ เพราะแต่ละ platform ต้องการข้อมูลต่างกัน
- ไม่จำเป็นถ้า services มี UI อิสระหรือมี dependencies น้อย

## 6. API Gateway

Single entry point สำหรับ client ทุกตัว จัดการ cross-cutting concerns กลาง

**หน้าที่หลัก**: Authentication, Rate limiting, SSL termination, Routing, Caching

- ระวัง single point of failure — ต้องการ high availability
- ระวัง gateway ที่อ้วนเกินไป — อย่าใส่ business logic ไว้ที่นี่

## 7. Strangler Pattern

ค่อย ๆ แทนที่ monolith ด้วย microservices ทีละ module โดยไม่ต้อง rewrite ทั้งระบบในครั้งเดียว

```
1. เลือก module → 2. สร้าง microservice → 3. Route traffic บางส่วน
→ 4. เพิ่ม traffic ทีละน้อย → 5. ปิด monolith module
```

## 8. Resilience Patterns

ลำดับการใช้งานที่แนะนำ: **Rate Limiter → Bulkhead → Timeout → Circuit Breaker → Retry**

### Circuit Breaker
3 states: **Closed** (ปกติ) → **Open** (บล็อก requests เมื่อ failure เกินกำหนด) → **Half-Open** (ทดสอบว่า downstream ฟื้นแล้วหรือยัง)

### Retry
ใช้ exponential backoff + jitter เพื่อป้องกัน retry storm — retry เฉพาะ transient errors (5xx, timeout) ไม่ retry 4xx

### Rate Limiting
จำกัดปริมาณ request ต่อหน่วยเวลา — ทำได้ทั้งระดับ API Gateway, service, หรือ per-client (API key/IP) คืน HTTP 429 เมื่อเกิน

### Timeout
กำหนดเวลา maximum ที่รอ response จาก downstream — ป้องกัน thread pool exhaustion ค่า timeout ควรต่างกันตาม characteristic ของแต่ละ downstream

### Bulkhead
แยก resource pools ตาม downstream — ความช้าของ provider หนึ่งไม่กระทบ provider อื่น

## 9. Externalized Configuration

เก็บ config ไว้ภายนอก code — สามารถเปลี่ยน config ได้โดยไม่ต้อง redeploy

**เครื่องมือ**: HashiCorp Consul, etcd, Spring Cloud Config, Kubernetes ConfigMap

## 10. Consumer-Driven Contract Testing (CDCT)

Consumer กำหนด contract ของ API ที่ต้องการ, Provider ตรวจสอบว่า implement ตรงตาม contract

- ป้องกัน integration break ก่อน deploy ขึ้น production
- ลด dependency ต่อ E2E tests

**เครื่องมือ**: Pact, Spring Cloud Contract

## 11. Caching Patterns

| Pattern | วิธีทำงาน | เหมาะกับ | ข้อระวัง |
|---------|-----------|----------|----------|
| **Cache-Aside** | App จัดการ cache hit/miss เอง | Read-heavy, ข้อมูลเปลี่ยนน้อย | Request แรกช้า, app ต้องจัดการ cache logic |
| **Read-Through** | Cache layer ดึงจาก DB แทน app | ต้องการแยก logic จาก app | Cache layer ซับซ้อนขึ้น |
| **Write-Through** | Write ไปทั้ง cache และ DB พร้อมกัน | ต้องการ consistency สูง | Write ช้าลง |
