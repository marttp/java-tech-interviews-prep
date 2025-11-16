# System Design Components You Must Know

## 1. Load Balancers
A load balancer is a device that acts as a reverse proxy and distributes network or application traffic across a number of servers. Load balancers are used to increase capacity (concurrent users) and reliability of applications.

[INSERT_DIAGRAM] A diagram showing a load balancer distributing traffic from clients to multiple web servers.

**Types of Load Balancers:**
*   **Layer 4 (Transport Layer)**: Distributes traffic based on IP addresses and ports.
*   **Layer 7 (Application Layer)**: Distributes traffic based on application-level data, such as HTTP headers or cookies.

**Common Load Balancing Algorithms:**
*   **Round Robin**: Distributes requests sequentially among the group of servers.
*   **Least Connections**: Sends traffic to the server with the fewest active connections.
*   **IP Hash**: The IP address of the client is used to determine which server receives the request.

## 2. Web Server
A web server is a computer system that processes requests via HTTP, the basic network protocol used to distribute information on the World Wide Web.

**Common Web Servers:**
*   Nginx
*   Apache

## 3. Cache
A cache is a hardware or software component that stores data so that future requests for that data can be served faster.

[INSERT_DIAGRAM] A diagram showing a cache sitting between an application and a database. When the application requests data, it first checks the cache. If the data is in the cache (a "cache hit"), it is returned to the application. If the data is not in the cache (a "cache miss"), the application retrieves it from the database, stores it in the cache, and then returns it.

**Caching Strategies:**
*   **Cache-Aside**: The application is responsible for reading and writing from the cache.
*   **Read-Through**: The cache is responsible for reading data from the database.
*   **Write-Through**: Data is written to the cache and the database at the same time.
*   **Write-Back**: Data is written to the cache, and then asynchronously written to the database.

**Common Caching Technologies:**
*   Redis
*   Memcached

## 4. Application Server
An application server is a server that hosts applications. It provides a framework for developers to create and run applications.

## 5. Database Server
A database server is a server which uses a database application that provides database services to other computer programs or to computers, as defined by the client–server model.

**Types of Databases:**
*   **Relational (SQL)**: Data is stored in tables with rows and columns. Examples: MySQL, PostgreSQL, Oracle.
*   **NoSQL**: Data is stored in a non-tabular format. Examples: MongoDB, Cassandra, DynamoDB.

## 6. Distributed Messaging Systems
Distributed messaging systems are used to facilitate communication between different components of a distributed system.

*   **Message Queue**: A point-to-point communication model where a message is sent from a producer to a consumer. Examples: RabbitMQ, Amazon SQS.
*   **Pub/Sub**: A publish-subscribe model where a message is published to a topic and then received by all the subscribers of that topic. Examples: Apache Kafka, Google Cloud Pub/Sub.
*   **Streaming**: A real-time data processing model where data is processed as it is generated. Examples: Apache Kafka, Amazon Kinesis.

## 7. Distributed File Systems
A distributed file system is a file system that is distributed on multiple file servers or storage devices.

**Common Distributed File Systems:**
*   Hadoop Distributed File System (HDFS)
*   Google File System (GFS)
*   Amazon S3

## 8. API (Application Programming Interface)
An API is a set of rules and protocols for building and interacting with software applications.

**Common API Styles:**
*   **REST (Representational State Transfer)**: A stateless architecture that uses HTTP methods (GET, POST, PUT, DELETE) to operate on resources.
*   **RPC (Remote Procedure Call)**: A client executes a procedure or a function on a remote server.
*   **GraphQL**: A query language for APIs that allows clients to request exactly the data they need.

## 9. Content Delivery Networks (CDN)
A CDN is a geographically distributed network of proxy servers and their data centers. The goal is to provide high availability and performance by distributing the service spatially relative to end-users.

[INSERT_DIAGRAM] A diagram showing a user in a specific geographic location requesting content from a website. The request is routed to the nearest CDN edge server, which serves the content to the user.

## 10. Cloud Computing & Cloud Infrastructure
Cloud computing is the on-demand availability of computer system resources, especially data storage and computing power, without direct active management by the user.

**Cloud Service Models:**
*   **Infrastructure as a Service (IaaS)**: Provides virtualized computing resources over the internet.
*   **Platform as a Service (PaaS)**: Provides a platform allowing customers to develop, run, and manage applications without the complexity of building and maintaining the infrastructure.
*   **Software as a Service (SaaS)**: Provides software applications over the internet, on a subscription basis.

## 11. Notifications and Alerts
Notifications and alerts are used to inform users or administrators about important events in the system.

**Common Notification Channels:**
*   Email
*   SMS
*   Push notifications

## 12. Observability Tools
Observability is the ability to measure the internal states of a system by examining its external outputs.

**The Three Pillars of Observability:**
*   **Logs**: A record of events that have occurred in the system.
*   **Metrics**: A numerical representation of data measured over intervals of time.
*   **Traces**: A representation of a series of causally related distributed events that encode the end-to-end request flow through a distributed system.

## 13. Full-Text Search
Full-text search is a technique for searching a single computer-stored document or a collection in a full-text database.

**Common Full-Text Search Engines:**
*   Elasticsearch
*   Apache Solr