### Spring Boot Transaction Management

Transaction management is an essential aspect of any enterprise application to ensure data integrity and consistency. Spring Boot simplifies transaction management by providing declarative and programmatic options.

### 1. **Understanding Transactions**
A transaction is a sequence of operations performed as a single logical unit of work. The key properties of a transaction (ACID properties) are:
- **Atomicity:** All operations in a transaction are completed successfully or none are.
- **Consistency:** A transaction brings the system from one valid state to another.
- **Isolation:** Transactions are isolated from each other to prevent concurrent transaction interference.
- **Durability:** Once a transaction is committed, its changes are permanent.

### 2. **Spring Boot Declarative Transaction Management**
Spring Boot supports declarative transaction management, which allows you to manage transactions using annotations.

#### a. **Enable Transaction Management**
To enable transaction management, annotate your Spring Boot application configuration class with `@EnableTransactionManagement`:

```java
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class AppConfig {
    // Other bean definitions
}
```

#### b. **Use @Transactional Annotation**
Apply the `@Transactional` annotation to methods or classes where you want to manage transactions. When applied to a class, all public methods of that class are transactional.

```java
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

    @Transactional
    public void performOperation() {
        // Business logic that involves transactions
    }
}
```

### 3. **Transaction Propagation**
Propagation defines how transactions relate to each other. Spring provides several propagation options:

- **REQUIRED (default):** Joins an existing transaction or creates a new one if none exists.
- **REQUIRES_NEW:** Suspends the current transaction and creates a new one.
- **MANDATORY:** Must run within an existing transaction, throws an exception if none exists.
- **SUPPORTS:** Supports the current transaction but doesn’t create a new one if none exists.
- **NOT_SUPPORTED:** Executes non-transactionally, suspending the current transaction.
- **NEVER:** Throws an exception if there’s an existing transaction.
- **NESTED:** Creates a nested transaction if a current transaction exists, otherwise behaves like REQUIRED.

Example:

```java
@Transactional(propagation = Propagation.REQUIRES_NEW)
public void anotherOperation() {
    // This method will start a new transaction, suspending the existing one if present
}
```

### 4. **Transaction Isolation Levels**
Isolation levels define the degree of isolation between concurrent transactions:
- **DEFAULT:** Uses the default isolation level of the database.
- **READ_UNCOMMITTED:** Allows dirty reads, non-repeatable reads, and phantom reads.
- **READ_COMMITTED:** Prevents dirty reads; non-repeatable reads and phantom reads may occur.
- **REPEATABLE_READ:** Prevents dirty reads and non-repeatable reads, but phantom reads can occur.
- **SERIALIZABLE:** The strictest level, preventing dirty reads, non-repeatable reads, and phantom reads.

Example:

```java
@Transactional(isolation = Isolation.SERIALIZABLE)
public void isolatedOperation() {
    // This method will run with the SERIALIZABLE isolation level
}
```

### 5. **Handling Rollbacks**
By default, Spring rolls back a transaction on runtime exceptions (`RuntimeException` or its subclasses). You can customize this behavior:

- **Rollback on Checked Exceptions:**

```java
@Transactional(rollbackFor = Exception.class)
public void operationWithRollback() throws Exception {
    // The transaction will roll back even if a checked exception is thrown
}
```

- **No Rollback on Specific Exceptions:**

```java
@Transactional(noRollbackFor = SomeSpecificException.class)
public void operationWithoutRollback() {
    // The transaction will not roll back on SomeSpecificException
}
```

### 6. **Programmatic Transaction Management**
For more control, you can manage transactions programmatically using the `PlatformTransactionManager` and `TransactionTemplate`:

```java
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.beans.factory.annotation.Autowired;

public class MyService {

    @Autowired
    private PlatformTransactionManager transactionManager;

    public void performOperation() {
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(def);
        
        try {
            // Business logic
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
            throw e;
        }
    }
}
```

### 7. **Testing Transaction Management**
When testing transactional methods, Spring Boot by default rolls back transactions after the test is complete to keep the database clean. This is done using the `@Transactional` annotation at the class or method level in test cases.

```java
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;

@SpringBootTest
@Transactional
public class MyServiceTests {

    @Test
    public void testTransaction() {
        // Test logic here
    }
}
```

### 8. **Best Practices**
- **Use `@Transactional` at the service layer** to separate concerns and ensure that transactions span multiple repository calls.
- **Keep transactions short and avoid long-running operations** within a transactional context to reduce the risk of locking issues.
- **Handle exceptions carefully** and configure rollback rules appropriately to ensure data consistency.

This covers the basics of transaction management in Spring Boot. Let me know if you need further details or specific examples!