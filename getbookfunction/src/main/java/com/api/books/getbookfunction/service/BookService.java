package com.api.books.getbookfunction.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.books.getbookfunction.entities.Book;

@Component
public class BookService {

    private static List<Book> list = new ArrayList<>();

    static {
        list.add(new Book(1, "Complete Reference of Spring Boot", "ABC"));
        list.add(new Book(2, "Java Complete Reference", "XYZ"));
        list.add(new Book(3, "Head First to Java", "ASD"));
    }

    // get all books
    public List<Book> getAllBooks() {
        return list;
    }

    // get single book by id
    public Book getBookById(int id) {
        Book book = null;
        book = list.stream().filter(e -> e.getId() == id).findFirst().get();
        return book;

    }

    // adding the new book
    public Book addBook(Book b) {
        list.add(b);
        return b;
    }

    // delete book
    public void deleteBook(int bid) {
        list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());
    }

    // update book

    public void updateBook(Book book, int bookid) {
        list = list.stream().map(b -> {
            if (b.getId() == bookid) {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());
            }
            return b;
        }).collect(Collectors.toList());
    }

}
