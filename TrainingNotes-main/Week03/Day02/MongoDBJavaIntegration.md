Integrating MongoDB with Java involves using the MongoDB Java Driver, which provides the necessary tools to connect to MongoDB, perform CRUD operations, and utilize the aggregation framework. Here's a detailed guide on how to get started with MongoDB integration in Java:

## 1. **Setting Up the Environment**

### Prerequisites

- Java Development Kit (JDK) installed.

- MongoDB server running.

- Maven or Gradle for dependency management.

### Adding Dependencies

#### Maven

Add the following dependencies to your `pom.xml` file:

```xml

<dependency>

    <groupId>org.mongodb</groupId>

    <artifactId>mongodb-driver-sync</artifactId>

    <version>4.4.0</version>

</dependency>

```

#### Gradle

Add the following dependencies to your `build.gradle` file:

```groovy

dependencies {

    implementation 'org.mongodb:mongodb-driver-sync:4.4.0'

}

```

## 2. **Connecting to MongoDB**

Create a MongoDB client and connect to the database.

### Example Code:

```java

import com.mongodb.client.MongoClient;

import com.mongodb.client.MongoClients;

import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    public static void main(String[] args) {

        // Create a MongoClient object

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        // Connect to the database

        MongoDatabase database = mongoClient.getDatabase("testdb");

        // Print the database name

        System.out.println("Connected to database: " + database.getName());

    }

}

```

## 3. **CRUD Operations**

### Creating Documents

Insert a document into a collection.

```java

import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoDatabase;

import org.bson.Document;

public class MongoDBCreate {

    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase database = mongoClient.getDatabase("testdb");

        MongoCollection<Document> collection = database.getCollection("books");

        Document book = new Document("title", "Unlocking Android")

                .append("author", "W. Frank Ableson")

                .append("publisher", "Manning Publications")

                .append("year", 2011);

        collection.insertOne(book);

        System.out.println("Document inserted successfully");

    }

}

```

### Reading Documents

Read documents from a collection.

```java

import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoDatabase;

import org.bson.Document;

import com.mongodb.client.FindIterable;

public class MongoDBRead {

    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase database = mongoClient.getDatabase("testdb");

        MongoCollection<Document> collection = database.getCollection("books");

        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {

            System.out.println(doc.toJson());

        }

    }

}

```

### Updating Documents

Update documents in a collection.

```java

import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.Filters;

import com.mongodb.client.model.Updates;

import org.bson.Document;

public class MongoDBUpdate {

    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase database = mongoClient.getDatabase("testdb");

        MongoCollection<Document> collection = database.getCollection("books");

        collection.updateOne(Filters.eq("title", "Unlocking Android"), Updates.set("year", 2012));

        System.out.println("Document updated successfully");

    }

}

```

### Deleting Documents

Delete documents from a collection.

```java

import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.Filters;

import org.bson.Document;

public class MongoDBDelete {

    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase database = mongoClient.getDatabase("testdb");

        MongoCollection<Document> collection = database.getCollection("books");

        collection.deleteOne(Filters.eq("title", "Unlocking Android"));

        System.out.println("Document deleted successfully");

    }

}

```

## 4. **Using the Aggregation Framework**

Perform aggregation operations using the aggregation pipeline.

### Example Code:

```java

import com.mongodb.client.MongoCollection;

import com.mongodb.client.MongoDatabase;

import com.mongodb.client.model.Aggregates;

import com.mongodb.client.model.Filters;

import com.mongodb.client.model.Sorts;

import org.bson.Document;

import java.util.Arrays;

public class MongoDBAggregation {

    public static void main(String[] args) {

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");

        MongoDatabase database = mongoClient.getDatabase("testdb");

        MongoCollection<Document> collection = database.getCollection("orders");

        var pipeline = Arrays.asList(

            Aggregates.match(Filters.eq("status", "A")),

            Aggregates.group("$cust_id", new Document("totalAmount", new Document("$sum", "$amount"))),

            Aggregates.sort(Sorts.descending("totalAmount"))

        );

        collection.aggregate(pipeline).forEach(doc -> System.out.println(doc.toJson()));

    }

}

```

## 5. **Handling Errors**

Always include error handling to manage potential issues during database operations.

### Example Code:

```java

import com.mongodb.MongoException;

public class MongoDBErrorHandling {

    public static void main(String[] args) {

        try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {

            MongoDatabase database = mongoClient.getDatabase("testdb");

            MongoCollection<Document> collection = database.getCollection("books");

            Document book = new Document("title", "Unlocking Android")

                    .append("author", "W. Frank Ableson")

                    .append("publisher", "Manning Publications")

                    .append("year", 2011);

            collection.insertOne(book);

            System.out.println("Document inserted successfully");

        } catch (MongoException e) {

            e.printStackTrace();

        }

    }

}

```

## 6. **Using Morphia or Spring Data MongoDB for ODM**

For more complex applications, you can use Object-Document Mapping (ODM) libraries such as Morphia or Spring Data MongoDB.

### Example with Spring Data MongoDB:

Add the dependency:

```xml

<dependency>

    <groupId>org.springframework.boot</groupId>

    <artifactId>spring-boot-starter-data-mongodb</artifactId>

    <version>2.5.4</version>

</dependency>

```

Define an entity and repository:

```java

import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.mongodb.repository.MongoRepository;

@Document(collection = "books")

public class Book {

    @Id

    private String id;

    private String title;

    private String author;

    private String publisher;

    private int year;

    // Getters and setters

}

public interface BookRepository extends MongoRepository<Book, String> {

    // Custom query methods can be defined here

}

```

Use the repository in your application:

```java

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

public class MongoDbApplication implements CommandLineRunner {

    @Autowired

    private BookRepository bookRepository;

    public static void main(String[] args) {

        SpringApplication.run(MongoDbApplication.class, args);

    }

    @Override

    public void run(String... args) throws Exception {

        Book book = new Book();

        book.setTitle("Unlocking Android");

        book.setAuthor("W. Frank Ableson");

        book.setPublisher("Manning Publications");

        book.setYear(2011);

        bookRepository.save(book);

        System.out.println("Book saved successfully");

    }

}

```

Integrating MongoDB with Java using drivers provides a flexible and powerful way to interact with your MongoDB data. For more complex scenarios, consider using an ODM library like Morphia or Spring Data MongoDB.