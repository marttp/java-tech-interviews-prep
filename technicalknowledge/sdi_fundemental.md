# System Design Components You Must Know (องค์ประกอบ System Design ที่ต้องรู้)

## 1. Load Balancers

Load balancer คืออุปกรณ์ที่ทำหน้าที่เป็น reverse proxy และกระจายทราฟฟิกของเครือข่ายหรือแอปพลิเคชันไปยังเซิร์ฟเวอร์หลายตัว Load balancers ใช้เพื่อเพิ่มความจุ (รองรับผู้ใช้พร้อมกัน) และความน่าเชื่อถือของแอปพลิเคชัน

[INSERT_DIAGRAM] A diagram showing a load balancer distributing traffic from clients to multiple web servers.

**Types of Load Balancers:**

- **Layer 4 (Transport Layer)**: กระจายทราฟฟิกโดยดูจาก IP addresses และ ports
- **Layer 7 (Application Layer)**: กระจายทราฟฟิกโดยดูจากข้อมูลระดับแอปพลิเคชัน เช่น HTTP headers หรือ cookies

**Common Load Balancing Algorithms:**

- **Round Robin**: กระจายคำขอไปยังกลุ่มเซิร์ฟเวอร์ตามลำดับวนไปเรื่อยๆ
- **Least Connections**: ส่งทราฟฟิกไปยังเซิร์ฟเวอร์ที่มีการเชื่อมต่อ active น้อยที่สุด
- **IP Hash**: ใช้ IP address ของ client เพื่อกำหนดว่าเซิร์ฟเวอร์ใดจะได้รับคำขอ

## 2. Web Server

Web server คือระบบคอมพิวเตอร์ที่ประมวลผลคำขอผ่าน HTTP ซึ่งเป็นโปรโตคอลเครือข่ายพื้นฐานที่ใช้ในการเผยแพร่ข้อมูลบน World Wide Web

**Common Web Servers:**

- Nginx
- Apache

## 3. Cache (แคช)

Cache คือส่วนประกอบฮาร์ดแวร์หรือซอฟต์แวร์ที่จัดเก็บข้อมูลเพื่อให้สามารถตอบสนองคำขอข้อมูลนั้นในอนาคตได้เร็วขึ้น

[INSERT_DIAGRAM] A diagram showing a cache sitting between an application and a database. When the application requests data, it first checks the cache. If the data is in the cache (a "cache hit"), it is returned to the application. If the data is not in the cache (a "cache miss"), the application retrieves it from the database, stores it in the cache, and then returns it.

**Caching Strategies:**

- **Cache-Aside**: แอปพลิเคชันมีหน้าที่ในการอ่านและเขียนข้อมูลลงใน cache เอง
- **Read-Through**: Cache มีหน้าที่ในการอ่านข้อมูลจากฐานข้อมูลให้
- **Write-Through**: ข้อมูลจะถูกเขียนลงใน cache และฐานข้อมูลพร้อมกัน
- **Write-Back**: ข้อมูลจะถูกเขียนลงใน cache ก่อน แล้วจึงเขียนลงฐานข้อมูลแบบ asynchronously ในภายหลัง

**Common Caching Technologies:**

- Redis
- Memcached

## 4. Application Server

Application server คือเซิร์ฟเวอร์ที่โฮสต์แอปพลิเคชัน ทำหน้าที่จัดเตรียม framework สำหรับนักพัฒนาในการสร้างและรันแอปพลิเคชัน

## 5. Database Server

Database server คือเซิร์ฟเวอร์ที่ใช้แอปพลิเคชันฐานข้อมูลในการให้บริการข้อมูลแก่โปรแกรมคอมพิวเตอร์หรือคอมพิวเตอร์เครื่องอื่น ตามโมเดล client–server

**Types of Databases:**

- **Relational (SQL)**: ข้อมูลถูกเก็บในตารางที่มีแถวและคอลัมน์ ตัวอย่าง: MySQL, PostgreSQL, Oracle
- **NoSQL**: ข้อมูลถูกเก็บในรูปแบบที่ไม่ใช่ตาราง ตัวอย่าง: MongoDB, Cassandra, DynamoDB

## 6. Distributed Messaging Systems

Distributed messaging systems ใช้เพื่ออำนวยความสะดวกในการสื่อสารระหว่างส่วนประกอบต่าง ๆ ของระบบแบบกระจาย (distributed system)

- **Message Queue**: โมเดลการสื่อสารแบบจุดต่อจุด (point-to-point) ที่ข้อความถูกส่งจากผู้ผลิต (producer) ไปยังผู้บริโภค (consumer) ตัวอย่าง: RabbitMQ, Amazon SQS
- **Pub/Sub**: โมเดล publish-subscribe ที่ข้อความถูก publish ไปยังหัวข้อ (topic) และได้รับโดย subscribers ทั้งหมดของหัวข้อนั้น ตัวอย่าง: Apache Kafka, Google Cloud Pub/Sub
- **Streaming**: โมเดลการประมวลผลข้อมูลแบบเรียลไทม์ที่ข้อมูลถูกประมวลผลในขณะที่ถูกสร้างขึ้น ตัวอย่าง: Apache Kafka, Amazon Kinesis

## 7. Distributed File Systems

Distributed file system คือระบบไฟล์ที่กระจายอยู่บนไฟล์เซิร์ฟเวอร์หรืออุปกรณ์จัดเก็บข้อมูลหลายตัว

**Common Distributed File Systems:**

- Hadoop Distributed File System (HDFS)
- Google File System (GFS)
- Amazon S3

## 8. API (Application Programming Interface)

API คือชุดของกฎและโปรโตคอลสำหรับการสร้างและโต้ตอบกับแอปพลิเคชันซอฟต์แวร์

**Common API Styles:**

- **REST (Representational State Transfer)**: สถาปัตยกรรมแบบ stateless ที่ใช้ HTTP methods (GET, POST, PUT, DELETE) ในการทำงานกับทรัพยากร
- **RPC (Remote Procedure Call)**: Client จะเรียกใช้ procedure หรือฟังก์ชันบนเซิร์ฟเวอร์ระยะไกล
- **GraphQL**: ภาษา query สำหรับ APIs ที่อนุญาตให้ clients ขอข้อมูลที่ต้องการได้อย่างแม่นยำ

## 9. Content Delivery Networks (CDN)

CDN คือเครือข่ายของ proxy servers และศูนย์ข้อมูลที่กระจายอยู่ตามภูมิศาสตร์ เป้าหมายคือเพื่อให้มีความพร้อมใช้งานและประสิทธิภาพสูงโดยการกระจายบริการไปตามพื้นที่ที่ใกล้กับผู้ใช้ปลายทาง

[INSERT_DIAGRAM] A diagram showing a user in a specific geographic location requesting content from a website. The request is routed to the nearest CDN edge server, which serves the content to the user.

## 10. Cloud Computing & Cloud Infrastructure

Cloud computing คือความพร้อมใช้งานตามความต้องการของทรัพยากรระบบคอมพิวเตอร์ โดยเฉพาะที่เก็บข้อมูลและพลังประมวลผล โดยที่ผู้ใช้ไม่ต้องจัดการเองโดยตรง

**Cloud Service Models:**

- **Infrastructure as a Service (IaaS)**: ให้บริการทรัพยากรประมวลผลแบบเสมือนจริงผ่านอินเทอร์เน็ต
- **Platform as a Service (PaaS)**: ให้บริการแพลตฟอร์มที่อนุญาตให้ลูกค้าพัฒนา รัน และจัดการแอปพลิเคชันโดยไม่ต้องยุ่งยากกับการสร้างและบำรุงรักษาโครงสร้างพื้นฐาน
- **Software as a Service (SaaS)**: ให้บริการแอปพลิเคชันซอฟต์แวร์ผ่านอินเทอร์เน็ตโดยคิดค่าบริการแบบสมาชิก

## 11. Notifications and Alerts

Notifications และ alerts ใช้เพื่อแจ้งเตือนผู้ใช้หรือผู้ดูแลระบบเกี่ยวกับเหตุการณ์สำคัญในระบบ

**Common Notification Channels:**

- Email
- SMS
- Push notifications

## 12. Observability Tools

Observability คือความสามารถในการวัดสถานะภายในของระบบโดยการตรวจสอบผลลัพธ์ภายนอก

**The Three Pillars of Observability:**

- **Logs**: บันทึกของเหตุการณ์ที่เกิดขึ้นในระบบ
- **Metrics**: การแสดงข้อมูลในรูปแบบตัวเลขที่วัดได้ในช่วงเวลาหนึ่ง
- **Traces**: การแสดงภาพของชุดเหตุการณ์ที่สัมพันธ์กันแบบกระจาย ที่เข้ารหัสการไหลของคำขอตั้งแต่ต้นจนจบผ่านระบบแบบกระจาย

## 13. Full-Text Search

Full-text search คือเทคนิคในการค้นหาเอกสารที่เก็บไว้ในคอมพิวเตอร์หรือคอลเลกชันในฐานข้อมูลแบบ full-text

**Common Full-Text Search Engines:**

- Elasticsearch
- Apache Solr

## 14. API Gateway

API Gateway คือเซิร์ฟเวอร์พร็อกซีที่ทำหน้าที่เป็นจุดเข้าใช้งานเดียวสำหรับ API ทั้งหมดของระบบ

**Common API Gateway Features:**

- Authentication and authorization
- Rate limiting
- Request routing
- Response transformation
