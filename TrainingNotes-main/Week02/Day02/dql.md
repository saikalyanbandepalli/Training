DQL (Data Query Language) in MySQL refers to the `SELECT` statement primarily used to retrieve data from one or more tables. It includes several clauses to specify conditions, sorting, grouping, and more. Here are examples of the main clauses used with the `SELECT` statement in MySQL:

### 1. SELECT Statement

**Purpose**: Retrieves data from one or more tables.

**Syntax**:

```sql

SELECT column1, column2, ...

FROM table_name;

```

**Example**:

```sql

-- Select all columns from the Employees table

SELECT *

FROM Employees;

-- Select specific columns from the Employees table

SELECT FirstName, LastName, Salary

FROM Employees;

```

### 2. WHERE Clause

**Purpose**: Filters records based on specified conditions.

**Syntax**:

```sql

SELECT column1, column2, ...

FROM table_name

WHERE condition;

```

**Example**:

```sql

-- Select employees with a salary greater than 50000

SELECT FirstName, LastName, Salary

FROM Employees

WHERE Salary > 50000;

```

### 3. ORDER BY Clause

**Purpose**: Sorts the result set by specified columns.

**Syntax**:

```sql

SELECT column1, column2, ...

FROM table_name

ORDER BY column1 ASC|DESC, column2 ASC|DESC, ...;

```

**Example**:

```sql

-- Select employees and order them by LastName ascending

SELECT FirstName, LastName, Salary

FROM Employees

ORDER BY LastName ASC;

```

### 4. GROUP BY Clause

**Purpose**: Groups rows that have the same values into summary rows.

**Syntax**:

```sql

SELECT column1, column2, ..., aggregate_function(column)

FROM table_name

GROUP BY column1, column2, ...;

```

**Example**:

```sql

-- Count the number of employees in each department

SELECT DepartmentID, COUNT(*) AS NumberOfEmployees

FROM Employees

GROUP BY DepartmentID;

```

### 5. HAVING Clause

**Purpose**: Filters records grouped by the `GROUP BY` clause.

**Syntax**:

```sql

SELECT column1, aggregate_function(column)

FROM table_name

GROUP BY column1

HAVING condition;

```

**Example**:

```sql

-- Select departments with more than 2 employees

SELECT DepartmentID, COUNT(*) AS NumberOfEmployees

FROM Employees

GROUP BY DepartmentID

HAVING COUNT(*) > 2;

```

### 6. DISTINCT Clause

**Purpose**: Returns unique values in specified columns.

**Syntax**:

```sql

SELECT DISTINCT column1, column2, ...

FROM table_name;

```

**Example**:

```sql

-- Select distinct departments with employees

SELECT DISTINCT DepartmentID

FROM Employees;

```

### 7. LIMIT Clause

**Purpose**: Limits the number of rows returned in the result set.

**Syntax**:

```sql

SELECT column1, column2, ...

FROM table_name

LIMIT number_of_rows;

```

**Example**:

```sql

-- Select the first 10 employees

SELECT *

FROM Employees

LIMIT 10;

```

### 8. OFFSET Clause (with LIMIT)

**Purpose**: Skips a specified number of rows before returning the result set.

**Syntax**:

```sql

SELECT column1, column2, ...

FROM table_name

LIMIT number_of_rows OFFSET offset_value;

```

**Example**:

```sql

-- Select employees starting from the 6th row, limit 5 rows

SELECT *

FROM Employees

LIMIT 5 OFFSET 5;

```


### 9. UNION Clause

**Purpose**: Combines the result sets of two or more `SELECT` statements.

**Syntax**:

```sql

SELECT column1, column2, ...

FROM table1

UNION

SELECT column1, column2, ...

FROM table2;

```

**Example**:

```sql

-- Select employees from Employees and Managers from Managers

SELECT EmployeeID, FirstName, LastName

FROM Employees

UNION

SELECT ManagerID, FirstName, LastName

FROM Managers;

```

### 10. Subquery

**Purpose**: Executes a query within another query.

**Example**:

```sql

-- Select employees with a salary greater than the average salary

SELECT FirstName, LastName, Salary

FROM Employees

WHERE Salary > (SELECT AVG(Salary) FROM Employees);

```

### Notes:

- **Aggregate Functions**: Commonly used aggregate functions include `COUNT()`, `SUM()`, `AVG()`, `MIN()`, and `MAX()`.

- **Subqueries**: Can be used within `SELECT`, `INSERT`, `UPDATE`, or `DELETE` statements to perform operations based on the results of another query.

- **Performance**: Efficient use of indexes, proper table joins, and query optimization are crucial for improving query performance in MySQL.

These clauses and examples cover the fundamental capabilities of DQL in MySQL, providing powerful tools for querying and retrieving data from relational databases efficiently.