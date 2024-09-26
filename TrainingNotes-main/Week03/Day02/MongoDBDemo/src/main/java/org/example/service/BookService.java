package org.example.service;

import org.example.dao.BookDAO;
import org.example.models.Book;

import java.util.Arrays;

public class BookService {

    public void addBook(){
        Book alchemist = new Book();
        alchemist.setTitle("Alchemist");
        alchemist.setAuthors(Arrays.asList("Paulo Coelho"));
        alchemist.setPageCount(460);
        alchemist.setStatus("AVAILABLE");

        BookDAO dao = new BookDAO();
        System.out.println(dao.insertBook(alchemist));
    }

    public void getAllBooks(){
        BookDAO dao = new BookDAO();
        dao.getAllBooks().forEach(book -> {System.out.println(book.getTitle());});
    }

    public void getBookByTitle(){
        BookDAO dao = new BookDAO();
        System.out.println(dao.findBookByTitle("Elixir in Action").getPageCount());

    }

    public void updateBook(){
        BookDAO dao = new BookDAO();
        System.out.println(dao.updateBook("Alchemist","Dummy Description"));
    }

}
