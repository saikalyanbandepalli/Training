Creating a Spring Boot CRUD application with MySQL involves several steps, including setting up your development environment, configuring the Spring Boot application, creating the database schema, and implementing the CRUD operations. Here's a step-by-step guide:

### Step 1: Set Up Your Development Environment
Ensure you have the following installed:
- Java Development Kit (JDK) 8 or higher
- Spring Boot CLI
- MySQL Server
- An IDE (like IntelliJ IDEA or Eclipse)

### Step 2: Create a Spring Boot Project
You can create a Spring Boot project using Spring Initializr (https://start.spring.io/) or directly from your IDE.

1. **Using Spring Initializr**:
   - Go to [Spring Initializr](https://start.spring.io/).
   - Select the following options:
     - Project: Maven Project
     - Language: Java
     - Spring Boot: Latest stable version
     - Project Metadata: Fill in the Group, Artifact, and other fields.
     - Dependencies: Add `Spring Web`, `Spring Data JPA`, and `MySQL Driver`.
   - Click "Generate" to download the project, then unzip it and open it in your IDE.

2. **Using Your IDE**:
   - Open your IDE and create a new Spring Boot project with the above dependencies.

### Step 3: Configure MySQL Database
In your `application.properties` or `application.yml` file, configure the MySQL database connection.

**application.properties**:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

**application.yml**:
```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/your_database
    username: your_username
    password: your_password
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
```

### Step 4: Create the Database Schema
Create a MySQL database named `your_database` (or any name you prefer).

```sql
CREATE DATABASE your_database;
```

### Step 5: Define the Entity Class
Create a JPA entity class that represents the database table.

```java
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    // Getters and Setters
}
```

### Step 6: Create the Repository Interface
Create a repository interface for the `User` entity.

```java
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
```

### Step 7: Create the Service Class
Create a service class to handle the business logic.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDetails.getName());
            user.setEmail(userDetails.getEmail());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
```

### Step 8: Create the Controller Class
Create a REST controller to handle the HTTP requests.

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
        return userService.updateUser(id, userDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
```

### Step 9: Run the Application
Run your Spring Boot application from your IDE or using the command line:
```sh
./mvnw spring-boot:run
```

### Step 10: Test the Application
Use Postman or any REST client to test the CRUD operations:

- **Create User**: POST `http://localhost:8080/api/users` with a JSON body containing `name` and `email`.
- **Get All Users**: GET `http://localhost:8080/api/users`.
- **Get User by ID**: GET `http://localhost:8080/api/users/{id}`.
- **Update User**: PUT `http://localhost:8080/api/users/{id}` with a JSON body containing `name` and `email`.
- **Delete User**: DELETE `http://localhost:8080/api/users/{id}`.

This tutorial covers the basic setup and implementation of a Spring Boot CRUD application with MySQL. Let me know if you need any further details or assistance!