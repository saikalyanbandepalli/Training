package org.example;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DBConnection {
    private static MongoDatabase db;

    private DBConnection(){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        db = mongoClient.getDatabase("test");
        System.out.println("Connection established");
    }

    public MongoDatabase getDb(){
        return db;
    }

    public static DBConnection getInstance(){
        return new DBConnection();
    }
}
