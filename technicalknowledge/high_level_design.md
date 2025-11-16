# High-Level System Design

## Core Principles and Strategies

### 1. Design For Failure
Systems will fail. It's not a matter of *if*, but *when*. A resilient system anticipates failures and is designed to handle them gracefully.

*   **Embrace Redundancy**: Have multiple copies of components (servers, databases, etc.) so that if one fails, another can take over.
*   **Fault Isolation**: Isolate components so that a failure in one does not cascade to others. This can be achieved through techniques like bulkheads and circuit breakers.
*   **Automated Recovery**: Implement mechanisms for automatic recovery from failures, such as auto-scaling and self-healing.

### 2. Keep Things Simple and Robust (KISS)
Complex systems are harder to build, maintain, and debug. Strive for simplicity in your design.

*   **Avoid Over-engineering**: Don't add complexity for features that are not needed right now.
*   **Use Proven Technologies**: Choose technologies that are well-understood and have a proven track record.
*   **Modularity**: Break down the system into smaller, independent modules that are easier to understand and manage.

### 3. Redundancy and Fault Recovery
Redundancy is about having duplicate components, while fault recovery is about how the system recovers from a failure.

*   **Active-Passive vs. Active-Active**: In an active-passive setup, one component is on standby, while in an active-active setup, both components are active and share the load.
*   **Backup and Restore**: Regularly back up your data and have a well-tested process for restoring it.
*   **Graceful Degradation**: If a non-critical component fails, the system should continue to function, albeit with reduced functionality.

### 4. Multi-tenancy
Multi-tenancy is an architecture in which a single instance of a software application serves multiple customers. Each customer is called a tenant.

*   **Data Isolation**: Ensure that each tenant's data is isolated and not accessible by other tenants.
*   **Resource Pooling**: Share resources among tenants to reduce costs.
*   **Scalability**: The architecture should be able to scale to support a large number of tenants.

### 5. Service Health Check
Health checks are used to determine if a service is running and healthy.

*   **Liveness Probe**: Checks if the application is running. If the liveness probe fails, the application is restarted.
*   **Readiness Probe**: Checks if the application is ready to accept traffic. If the readiness probe fails, the application is not sent any traffic.
*   **Deep Health Checks**: Go beyond simple pings and check the health of downstream services and dependencies.

### 6. Development Parity with Production
The development environment should be as similar to the production environment as possible. This helps to catch issues early and reduces the risk of surprises when deploying to production.

*   **Infrastructure as Code**: Use tools like Terraform or CloudFormation to provision and manage your infrastructure in a repeatable way.
*   **Containerization**: Use containers (e.g., Docker) to package your application and its dependencies, ensuring consistency across environments.
*   **Continuous Integration/Continuous Deployment (CI/CD)**: Automate the build, test, and deployment process.

### 7. Zero Trust Architecture
In a zero-trust architecture, no user or device is trusted by default, whether inside or outside the network.

*   **Authenticate and Authorize Everything**: Every request must be authenticated and authorized.
*   **Least Privilege**: Give users and services only the permissions they need to do their job.
*   **Micro-segmentation**: Divide the network into small, isolated segments to limit the blast radius of an attack.

### 8. Don't Repeat Yourself (DRY)
The DRY principle is aimed at reducing repetition of software patterns, replacing it with abstractions or using data normalization to avoid redundancy.

*   **Code Reusability**: Create reusable libraries and services.
*   **Single Source of Truth**: Have a single source of truth for your data.
*   **Avoid Copy-Paste**: Don't copy and paste code. Instead, create a function or a class.

### 9. Independent Workloads/Clusters
Isolate workloads and clusters to prevent them from interfering with each other.

*   **Resource Quotas**: Set resource quotas to prevent one workload from consuming all the resources.
*   **Separate Environments**: Use separate environments for development, testing, and production.
*   **Cell-based Architecture**: The system is divided into a collection of self-contained cells, each with its own data and services.

### 10. Autonomous with Emergency Human Intervention
The system should be able to operate autonomously, but there should be a way for humans to intervene in case of an emergency.

*   **Automated Alerts**: Set up alerts to notify the team when something goes wrong.
*   **Runbooks**: Have well-defined procedures for handling common issues.
*   **Feature Flags**: Use feature flags to enable or disable features without deploying new code.

## Common High-Level Design Interview Questions

*   Design a URL shortener (like TinyURL).
*   Design a social media feed (like Twitter or Facebook).
*   Design a ride-sharing service (like Uber or Lyft).
*   Design a video streaming service (like YouTube or Netflix).
*   Design a distributed key-value store (like Redis or Cassandra).
*   Design a search engine (like Google).
*   Design a notification service.
*   Design a distributed message queue (like Kafka or RabbitMQ).
