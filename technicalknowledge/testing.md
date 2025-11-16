# Software Testing

## 1. The Testing Pyramid
The testing pyramid is a framework that helps developers and teams think about how to build a balanced and effective testing strategy.

[INSERT_DIAGRAM] A diagram of the testing pyramid. The pyramid has three layers: Unit Tests (at the bottom), Integration Tests (in the middle), and End-to-End Tests (at the top).

*   **Unit Tests**: (การทดสอบหน่วย) ทดสอบส่วนประกอบหรือฟังก์ชันแต่ละส่วนแยกกัน พวกมันรวดเร็ว ราคาถูก และเขียนง่าย
*   **Integration Tests**: (การทดสอบการรวมระบบ) ทดสอบว่าส่วนประกอบหลายส่วนทำงานร่วมกันอย่างไร พวกมันช้ากว่าและมีค่าใช้จ่ายสูงกว่าการทดสอบหน่วย
*   **End-to-End (E2E) Tests**: (การทดสอบแบบ End-to-End) ทดสอบแอปพลิเคชันทั้งหมดจากมุมมองของผู้ใช้ พวกมันเป็นการทดสอบที่ช้าที่สุดและมีค่าใช้จ่ายสูงที่สุด

## 2. Types of Testing

### a. Functional Testing
Functional testing is a type of testing that verifies that the software performs its intended functions.

*   **Unit Testing**: (การทดสอบหน่วย) การทดสอบหน่วยย่อยหรือส่วนประกอบแต่ละส่วนของซอฟต์แวร์
*   **Integration Testing**: (การทดสอบการรวมระบบ) การทดสอบการรวมกันของส่วนประกอบซอฟต์แวร์สองส่วนขึ้นไป
*   **System Testing**: (การทดสอบระบบ) การทดสอบซอฟต์แวร์ที่สมบูรณ์และรวมเข้าด้วยกัน
*   **Acceptance Testing**: (การทดสอบการยอมรับ) การทดสอบซอฟต์แวร์เทียบกับความต้องการของผู้ใช้

### b. Non-Functional Testing
Non-functional testing is a type of testing that verifies the non-functional aspects of the software, such as performance, usability, and reliability.

*   **Performance Testing**: (การทดสอบประสิทธิภาพ) การทดสอบว่าซอฟต์แวร์ทำงานอย่างไรในแง่ของการตอบสนองและความเสถียรภายใต้ภาระงานที่กำหนด
*   **Load Testing**: (การทดสอบโหลด) การทดสอบความสามารถของซอฟต์แวร์ในการรองรับผู้ใช้พร้อมกันจำนวนมาก
*   **Stress Testing**: (การทดสอบความเครียด) การทดสอบความสามารถของซอฟต์แวร์ในการรองรับภาระงานที่สูงมาก
*   **Usability Testing**: (การทดสอบความสามารถในการใช้งาน) การทดสอบว่าผู้ใช้สามารถใช้งานซอฟต์แวร์ได้ง่ายเพียงใด
*   **Security Testing**: (การทดสอบความปลอดภัย) การทดสอบซอฟต์แวร์เพื่อหาช่องโหว่ด้านความปลอดภัย

## 3. Testing Best Practices

*   **เขียนการทดสอบที่สะอาด อ่านง่าย และบำรุงรักษาได้**
*   **การทดสอบควรเป็นอิสระและสามารถทำซ้ำได้**
*   **ทดสอบทั้งกรณีที่เป็นบวกและลบ**
*   **ใช้รูปแบบการตั้งชื่อที่สอดคล้องกันสำหรับการทดสอบของคุณ**
*   **อย่าเขียนการทดสอบเพียงเพื่อจะเขียนการทดสอบ แต่จงเขียนการทดสอบที่เพิ่มคุณค่า**
*   **เรียกใช้การทดสอบของคุณโดยอัตโนมัติเป็นส่วนหนึ่งของ CI/CD pipeline**
*   **วัดความครอบคลุมของการทดสอบของคุณ แต่อย่าให้เป็นเป้าหมายในตัวเอง**
*   **ใช้เฟรมเวิร์กการทดสอบ**, เช่น JUnit สำหรับ Java, PyTest สำหรับ Python, หรือ Jest สำหรับ JavaScript
