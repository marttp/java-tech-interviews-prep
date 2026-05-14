# Database Schema Design

## 1. Introduction to Database Schema Design

Database Schema เปรียบเสมือนพิมพ์เขียว (Blueprint) ของฐานข้อมูล ซึ่งระบุวิธีจัดระเบียบข้อมูล โครงสร้าง และความสัมพันธ์ระหว่างเอนทิตีข้อมูลต่าง ๆ การออกแบบ Schema ที่ดีมีความสำคัญอย่างยิ่งต่อความถูกต้องของข้อมูล (Data Integrity) ประสิทธิภาพ (Performance) และความสามารถในการขยายระบบ (Scalability)

## 2. Data Modeling

Data modeling คือกระบวนการสร้างแบบจำลองแนวคิดของข้อมูลที่จะจัดเก็บในฐานข้อมูล รูปแบบข้อมูลที่นิยมใช้มากที่สุดคือ **Entity-Relationship (ER) model**

- **Entities**: วัตถุในโลกแห่งความเป็นจริง แนวคิด หรือเหตุการณ์ (เช่น `Customer`, `Product`, `Order`)
- **Attributes**: คุณสมบัติของ Entity (เช่น `Customer` มี `CustomerID`, `FirstName`, `LastName`)
- **Relationships**: ความสัมพันธ์ระหว่าง Entities (เช่น `Customer` สามารถสร้าง `Orders` ได้หลายรายการ)

## 3. Normalization

Normalization คือกระบวนการจัดระเบียบคอลัมน์ (Attributes) และตาราง (Entities) ของฐานข้อมูลเชิงสัมพันธ์เพื่อลดความซ้ำซ้อนของข้อมูล (Data Redundancy)

- **First Normal Form (1NF)**: ตารางต้องมีความเป็นอะตอม (Atomic) แต่ละช่อง (Cell) ต้องมีค่าเดียว ไม่สามารถแบ่งย่อยได้ และแต่ละแถวต้องไม่ซ้ำกัน
- **Second Normal Form (2NF)**: ตารางต้องอยู่ในรูป 1NF และ Attribute ที่ไม่ใช่คีย์ทั้งหมดต้องขึ้นอยู่กับ Primary Key อย่างสมบูรณ์ (Fully Functional Dependency) หมายความว่า Attribute ที่ไม่ใช่คีย์ต้องขึ้นอยู่กับ Primary Key ทั้งหมด ไม่ใช่แค่บางส่วน (ในกรณีที่ Key เป็น Composite Key)
- **Third Normal Form (3NF)**: ตารางต้องอยู่ในรูป 2NF และ Attribute ทั้งหมดต้องขึ้นอยู่กับ Primary Key เท่านั้น ไม่ขึ้นอยู่กับ Attribute อื่นที่ไม่ใช่คีย์ (No Transitive Dependency)

## 4. Data Types

การเลือกประเภทข้อมูล (Data Types) ที่เหมาะสมสำหรับคอลัมน์มีความสำคัญต่อความถูกต้องของข้อมูลและประสิทธิภาพ

- **Numeric Types**: `INT`, `BIGINT`, `DECIMAL`, `FLOAT` เป็นต้น
- **String Types**: `VARCHAR`, `CHAR`, `TEXT` เป็นต้น
- **Date/Time Types**: `DATE`, `TIME`, `TIMESTAMP` เป็นต้น
- **Boolean Types**: `BOOLEAN` หรือ `TINYINT(1)`

## 5. Relationships

- **One-to-One**: แต่ละแถวในตาราง A สอดคล้องกับแถวเดียวในตาราง B (เช่น `User` และ `UserProfile`)
- **One-to-Many**: แถวในตาราง A สามารถเชื่อมโยงกับหลายแถวในตาราง B แต่แถวในตาราง B เชื่อมโยงได้กับแถวเดียวในตาราง A (เช่น `Customer` และ `Orders` ของพวกลูกค้า)
- **Many-to-Many**: แถวในตาราง A สามารถเชื่อมโยงกับหลายแถวในตาราง B และแถวในตาราง B ก็สามารถเชื่อมโยงกับหลายแถวในตาราง A ได้เช่นกัน โดยปกติจะใช้ตารางกลาง (Junction Table) ในการเชื่อม (เช่น `Students` และ `Courses`)

## 6. Indexing

Index ใช้สำหรับเพิ่มความเร็ในการดึงแถวข้อมูลจากตาราง

- **B-Tree Index**: ประเภทของ Index ที่พบบ่อยที่สุด เป็นโครงสร้างต้นไม้แบบสมดุลที่เก็บข้อมูลอย่างเป็นระเบียบ ช่วยให้การค้นหา การแทรก การลบ และการเข้าถึงแบบเรียงลำดับมีประสิทธิภาพ
- **Hash Index**: มีประโยชน์สำหรับการเปรียบเทียบความเท่ากัน แต่ไม่เหมาะกับการค้นหาเป็นช่วง (Range Queries)
- **Full-text Index**: ใช้สำหรับการค้นหาข้อมูลแบบข้อความ (Text-based search)

## 7. ACID Properties

ACID คือชุดของคุณสมบัติที่รับประกันว่า Database Transactions จะถูกประมวลผลอย่างน่าเชื่อถือ

- **Atomicity**: Transaction ทั้งหมดต้องสำเร็จครบถ้วน หรือไม่เกิดขึ้นเลย (all-or-nothing) — หากขั้นตอนใดล้มเหลว ระบบจะ rollback ทุกอย่างกลับ
- **Consistency**: Transaction ต้องนำฐานข้อมูลจากสถานะที่ถูกต้องหนึ่งไปยังอีกสถานะที่ถูกต้อง ไม่ละเมิด Constraints หรือ Rules ใด ๆ
- **Isolation**: Transactions ที่ทำงานพร้อมกันต้องไม่มีผลกระทบต่อกัน ราวกับว่าแต่ละ Transaction ทำงานตามลำดับ
- **Durability**: เมื่อ Transaction ได้รับการ commit แล้ว ข้อมูลจะคงอยู่ถาวรแม้ระบบจะล่ม (เช่น เก็บลง disk)

## 8. Denormalization

Denormalization คือการจงใจเพิ่มความซ้ำซ้อนของข้อมูล (Redundancy) เพื่อแลกกับประสิทธิภาพในการอ่านข้อมูลที่ดีขึ้น

**เมื่อไหรควรใช้:**
- ระบบที่มีการอ่านข้อมูลมาก (Read-heavy) และ Query มีความซับซ้อนสูง
- ต้องการลดจำนวน JOIN ที่มีค่าใช้จ่ายสูง
- ระบบ Analytics หรือ Reporting ที่ต้องการความเร็ว

**Trade-offs:**
- ✅ Query ที่อ่านข้อมูลเร็วขึ้น
- ❌ ข้อมูลซ้ำซ้อน ต้องอัปเดตหลายที่เมื่อข้อมูลเปลี่ยน
- ❌ เพิ่มความเสี่ยงต่อ Data Inconsistency

## 9. Constraints

Constraints คือกฎที่บังคับใช้กับคอลัมน์ข้อมูลเพื่อให้แน่ใจว่าข้อมูลมีความถูกต้องและเชื่อถือได้

- **PRIMARY KEY**: ระบุแถวแต่ละแถวในตารางอย่างไม่ซ้ำกัน (Unique Identifier)
- **FOREIGN KEY**: เชื่อมโยงสองตารางเข้าด้วยกัน
- **UNIQUE**: รับประกันว่าค่าทั้งหมดในคอลัมน์นั้นแตกต่างกัน
- **NOT NULL**: รับประกันว่าคอลัมน์นั้นไม่สามารถมีค่าว่าง (NULL) ได้
- **CHECK**: รับประกันว่าค่าในคอลัมน์เป็นไปตามเงื่อนไขที่กำหนด
- **DEFAULT**: กำหนดค่าเริ่มต้นสำหรับคอลัมน์เมื่อไม่ได้ระบุค่ามา
