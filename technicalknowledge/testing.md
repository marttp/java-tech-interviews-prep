# Software Testing

## 1. The Testing Pyramid

Testing Pyramid คือกรอบแนวคิดที่ช่วยให้ทีมพัฒนาวางกลยุทธ์การทดสอบได้อย่างสมดุลและมีประสิทธิภาพ โดยแบ่งลำดับชั้นของการทดสอบดังนี้:

![Testing Pyramid](img/testing/Testing%20Pyramid.webp)

- **Unit Tests**: การทดสอบส่วนประกอบที่เล็กที่สุด (เช่น Function หรือ Class) แยกจากกัน เป็น Layer ฐานที่สำคัญที่สุด เพราะทำงานได้รวดเร็ว (Fast), ค่าใช้จ่ายต่ำ (Cheap), และตรวจสอบได้ง่าย
- **Integration Tests**: การทดสอบการทำงานร่วมกันของหลายส่วนประกอบ (Components/Modules) หรือการเชื่อมต่อกับ External Systems (เช่น Database, API) การทดสอบนี้จะใช้เวลาและทรัพยากรมากกว่า Unit Test
- **End-to-End (E2E) Tests**: การทดสอบระบบทั้งหมดจากมุมมองของผู้ใช้งานจริง (User Persona) จำลองสถานการณ์การใช้งานตั้งแต่ต้นจนจบ เป็นการทดสอบที่ช้าที่สุดและมีค่าใช้จ่ายสูงสุด (Costly & Slow)

## 2. Types of Testing

### a. Functional Testing

การทดสอบเพื่อตรวจสอบว่าซอฟต์แวร์ทำงานได้ถูกต้องตาม **Business Requirements** หรือฟังก์ชันที่ออกแบบไว้หรือไม่

- **Unit Testing**: ทดสอบการทำงานของหน่วยย่อยที่สุดของโค้ด (Isolated logic)
- **Integration Testing**: ทดสอบการส่งต่อข้อมูลและการทำงานร่วมกันระหว่าง Modules
- **System Testing**: ทดสอบระบบแบบองค์รวม (Whole System) ในสภาพแวดล้อมที่ใกล้เคียงการใช้งานจริง
- **Acceptance Testing**: (UAT) การทดสอบโดยผู้ใช้จริงเพื่อให้มั่นใจว่าระบบตรงตามความต้องการทางธุรกิจ

### b. Non-Functional Testing

การทดสอบด้าน **คุณภาพและประสิทธิภาพ** ของระบบ (Quality Attributes) ที่นอกเหนือจากฟังก์ชันการทำงานหลัก

- **Performance Testing**: วัดประสิทธิภาพการประมวลผลและการตอบสนองของระบบ (Response Time/Throughput)
- **Load Testing**: ทดสอบการรองรับปริมาณผู้ใช้งาน (Concurrent Users) ตามที่คาดการณ์ไว้
- **Stress Testing**: ทดสอบขีดจำกัดของระบบในสภาวะที่โหดร้าย (Extreme workload) เพื่อดู Point of failure
- **Usability Testing**: ทดสอบความยากง่ายในการใช้งาน (UX)
- **Security Testing**: ตรวจสอบช่องโหว่และความปลอดภัยของระบบ

## 3. Testing Best Practices

- **Clean Test Code**: ให้ความสำคัญกับคุณภาพโค้ดของ Test เท่ากับ Production Code ต้องอ่านง่ายและดูแลรักษาได้ (Maintainable)
- **Independent & Deterministic**: แต่ละ Test Case ต้องเป็นอิสระต่อกัน (ไม่พึ่งพา State จาก Test อื่น) และต้องให้ผลลัพธ์เหมือนเดิมทุกครั้งที่รัน (Flaky tests are bad)
- **Test Scenarios**: ครอบคลุมทั้ง **Happy Path** (กรณีปกติ) และ **Edge/Negative Cases** (กรณีที่ผิดพลาดหรือข้อมูลไม่ถูกต้อง)
- **Naming Convention**: ตั้งชื่อ Test Case ให้สื่อความหมายชัดเจน ว่าทดสอบอะไร ภายใต้เงื่อนไขใด และคาดหวังผลลัพธ์อะไร
- **Quality over Quantity**: อย่ามุ่งเน้นแค่ตัวเลข Code Coverage แต่ให้เน้น Test Case ที่มีคุณค่าและช่วยป้องกัน Bug ได้จริง (Avoid checking implementation details)
- **CI/CD Integration**: ควรนำ Automated Tests เข้าไปอยู่ใน CI/CD Pipeline เพื่อให้มีการตรวจสอบคุณภาพ (Feedback Loop) อย่างสม่ำเสมอในทุกการเปลี่ยนแปลง
- **Use Testing Frameworks**: เลือกเครื่องมือให้เหมาะสมกับภาษาที่ใช้ เช่น JUnit/TestNG (Java), PyTest (Python), หรือ Jest/Vitest (JavaScript)
