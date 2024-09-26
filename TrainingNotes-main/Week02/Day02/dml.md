DML (Data Manipulation Language) in MySQL consists of commands used to manage data within database objects such as tables. These commands allow you to insert, retrieve, update, and delete data from tables. Here are the key DML commands in MySQL along with examples:

### 1. INSERT Statement

**Purpose**: Adds new rows of data into a table.

**Syntax**:

```sql

INSERT INTO table_name (column1, column2, ...)

VALUES (value1, value2, ...);

```

**Example**:

```sql

-- Insert a single row into the Employees table

INSERT INTO Employees (EmployeeID, FirstName, LastName, DepartmentID, Salary)

VALUES (1, 'Alice', 'Smith', 101, 50000.00);

-- Insert multiple rows into the Employees table

INSERT INTO Employees (EmployeeID, FirstName, LastName, DepartmentID, Salary)

VALUES (2, 'Bob', 'Johnson', 102, 60000.00),

(3, 'Claire', 'Davis', 101, 55000.00);

```

### 2. SELECT Statement

**Purpose**: Retrieves data from one or more tables.

**Syntax**:

```sql

SELECT column1, column2, ...

FROM table_name

WHERE condition;

```

**Example**:

```sql

-- Select all columns from the Employees table

SELECT *

FROM Employees;

-- Select specific columns with a condition

SELECT FirstName, LastName, Salary

FROM Employees

WHERE DepartmentID = 101;

```

### 3. UPDATE Statement

**Purpose**: Modifies existing data in a table.

**Syntax**:

```sql

UPDATE table_name

SET column1 = value1, column2 = value2, ...

WHERE condition;

```

**Example**:

```sql

-- Update salary for employees in DepartmentID 101

UPDATE Employees

SET Salary = 52000.00

WHERE DepartmentID = 101;

```

### 4. DELETE Statement

**Purpose**: Removes existing rows from a table.

**Syntax**:

```sql

DELETE FROM table_name

WHERE condition;

```

**Example**:

```sql

-- Delete employees who have left the company

DELETE FROM Employees

WHERE DepartmentID = 102;

```

### 5. MERGE Statement (Conditional Insert or Update)

**Purpose**: Combines INSERT and UPDATE operations based on a condition.

**Syntax**:

MySQL does not have a direct MERGE statement like some other databases. Instead, you typically use INSERT ... ON DUPLICATE KEY UPDATE to achieve similar functionality.

**Example**:

```sql

-- Insert a new record or update an existing one based on the primary key

INSERT INTO Employees (EmployeeID, FirstName, LastName, DepartmentID, Salary)

VALUES (4, 'David', 'Lee', 102, 58000.00)

ON DUPLICATE KEY UPDATE
FirstName = VALUES(FirstName),
LastName = VALUES(LastName),
DepartmentID = VALUES(DepartmentID),
Salary = VALUES(Salary);

```

### 6. TRUNCATE Statement

**Purpose**: Removes all rows from a table.

**Syntax**:

```sql

TRUNCATE TABLE table_name;

```

**Example**:

```sql

-- Truncate the Employees table (removes all rows)

TRUNCATE TABLE Employees;

```

### Notes:

- **Transaction Management**: DML statements are typically part of transactions. Commit (`COMMIT`) or rollback (`ROLLBACK`) statements are used to manage transactions in MySQL.

- **Concurrency**: DML operations may lock rows temporarily, depending on transaction isolation levels and the scope of the operation.

- **Data Integrity**: Use constraints (PRIMARY KEY, FOREIGN KEY, UNIQUE) to enforce data integrity when modifying data with DML statements.

DML commands in MySQL are fundamental for manipulating data within tables, allowing applications to interact with and manage database contents effectively.