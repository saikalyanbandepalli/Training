package org.example.dao;

import com.mongodb.client.*;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.example.DBConnection;
import org.example.models.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookDAO {
    MongoDatabase db;
    MongoCollection<Document> books_collection;

    public BookDAO(){
        db = DBConnection.getInstance().getDb();
        books_collection = db.getCollection("Books");
    }

    public String insertBook(Book book){
        Document doc = new Document("title",book.getTitle())
                .append("pageCount", book.getPageCount())
                .append("isbn", book.getIsbn())
                .append("status", book.getStatus())
                .append("authors", book.getAuthors());

        InsertOneResult res = books_collection.insertOne(doc);
        return res.getInsertedId().toString();

    }

    public List<Book> getAllBooks(){
        FindIterable<Document> books = books_collection.find();
        MongoCursor<Document> it = books.iterator();
        List<Book> result = new ArrayList<>();
        while(it.hasNext()){
            Book book = new Book();
            Document doc = it.next();
            book.setTitle(doc.getString("title"));
            book.setStatus(doc.getString("status"));
            book.setAuthors(doc.getList("authors",String.class));
            book.setIsbn(doc.getString("isbn"));
            book.setLongDescription(doc.getString("longDescription"));

            result.add(book);
        }
        return result;
    }

    public Book findBookByTitle(String title){
        Document doc = books_collection.find(Filters.eq("title",title)).first();
        Book book = new Book();
        book.setTitle(doc.getString("title"));
        book.setPageCount(doc.getInteger("pageCount"));
        book.setStatus(doc.getString("status"));

        return book;
    }

    public boolean updateBook(String title, String shortdesc){
        UpdateResult res = books_collection.updateOne(Filters.eq("title",title), Updates.set("shortDescription",shortdesc));
//        books_collection.deleteOne(Filters.eq("","")).
        return res.wasAcknowledged();
    }

    public int getBooksCountByCategory(String category){
        AggregateIterable<Document> it =  books_collection.aggregate(
                Arrays.asList(
                        Aggregates.match(Filters.in("categories",category)),
                        Aggregates.group("$categories", Accumulators.sum("totalCount","$categories"))
                )
        );
        int c = 0;
        for(Document doc : it){
            c = doc.getInteger("totalCount");
        }
        return c;

    }


}
