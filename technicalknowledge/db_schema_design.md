# Database Schema Design

## 1. Introduction to Database Schema Design
A database schema is the blueprint of a database. It specifies how data is organized, how it's structured, and the relationships between different data entities. A well-designed schema is crucial for data integrity, performance, and scalability.

## 2. Data Modeling
Data modeling is the process of creating a conceptual model of the data that will be stored in the database. The most common data model is the Entity-Relationship (ER) model.

*   **Entities**: Real-world objects, concepts, or events. (e.g., `Customer`, `Product`, `Order`).
*   **Attributes**: Properties of an entity (e.g., `Customer` has `CustomerID`, `FirstName`, `LastName`).
*   **Relationships**: Associations between entities (e.g., a `Customer` can place many `Orders`).

[INSERT_DIAGRAM] An ER diagram showing a `Customer` entity with a one-to-many relationship to an `Order` entity. The `Customer` entity has attributes like `CustomerID`, `Name`, and `Email`. The `Order` entity has attributes like `OrderID`, `OrderDate`, and `TotalAmount`.

## 3. Normalization
Normalization is the process of organizing the columns (attributes) and tables (entities) of a relational database to minimize data redundancy.

*   **First Normal Form (1NF)**: Ensures that the table is atomic. Each cell should contain a single, indivisible value, and each record needs to be unique.
*   **Second Normal Form (2NF)**: The table must be in 1NF, and all non-key attributes must be fully functional on the primary key. This means that every non-key attribute must depend on the whole primary key, not just a part of it.
*   **Third Normal Form (3NF)**: The table must be in 2NF, and all attributes must be dependent only on the primary key, not on other non-key attributes.

[INSERT_DIAGRAM] A series of diagrams illustrating the process of normalizing a table from 1NF to 3NF. The example could be a table of `Orders` that initially contains redundant customer information, which is then separated into a `Customers` table.

## 4. Data Types
Choosing the right data types for your columns is important for data integrity and performance.

*   **Numeric Types**: `INT`, `BIGINT`, `DECIMAL`, `FLOAT`, etc.
*   **String Types**: `VARCHAR`, `CHAR`, `TEXT`, etc.
*   **Date/Time Types**: `DATE`, `TIME`, `TIMESTAMP`, etc.
*   **Boolean Types**: `BOOLEAN` or `TINYINT(1)`.

## 5. Relationships
*   **One-to-One**: Each record in Table A corresponds to one and only one record in Table B. (e.g., a `User` and a `UserProfile`).
*   **One-to-Many**: A record in Table A can be associated with multiple records in Table B, but a record in Table B can only be associated with one record in Table A. (e.g., a `Customer` and their `Orders`).
*   **Many-to-Many**: A record in Table A can be associated with multiple records in Table B, and a record in Table B can be associated with multiple records in Table A. This is usually implemented with a junction table. (e.g., `Students` and `Courses`).

## 6. Indexing
Indexes are used to speed up the retrieval of rows from a table.

*   **B-Tree Index**: The most common type of index. It's a balanced tree structure that keeps data sorted and allows for efficient searching, inserting, deleting, and sequential access.
*   **Hash Index**: Useful for equality comparisons, but not for range queries.
*   **Full-text Index**: Used for searching text-based data.

## 7. Constraints
Constraints are rules enforced on data columns to ensure data accuracy and reliability.

*   **PRIMARY KEY**: Uniquely identifies each record in a table.
*   **FOREIGN KEY**: Links two tables together.
*   **UNIQUE**: Ensures that all values in a column are different.
*   **NOT NULL**: Ensures that a column cannot have a NULL value.
*   **CHECK**: Ensures that the values in a column satisfy a specific condition.
*   **DEFAULT**: Provides a default value for a column when none is specified.
