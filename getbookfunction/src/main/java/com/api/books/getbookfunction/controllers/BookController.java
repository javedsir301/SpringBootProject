package com.api.books.getbookfunction.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.api.books.getbookfunction.entities.Book;
import com.api.books.getbookfunction.service.BookService;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    // All Books Handler

    @GetMapping("/getbook")
    public List<Book> getBooks() {
        return this.bookService.getAllBooks();
    }

    // Single Book Handler By Id
    @GetMapping("/getbook/{id}")
    public Book getBook(@PathVariable("id") int id) {
        return bookService.getBookById(id);
    }

    // New Book Handler
    @PostMapping("/getbook")
    public Book addBook(@RequestBody Book book) {
        Book b = this.bookService.addBook(book);
        return b;
    }

    // Delete Book Handler

    @DeleteMapping("/getbook/{bookid}")
    public void deleteBook(@PathVariable("bookid") int bookid) {
        this.bookService.deleteBook(bookid);
    }

    // Update Book Handler

    @PutMapping("/getbook/{bookid}")
    public Book updateBook(@RequestBody Book book, @PathVariable("bookid") int bookid) {
        this.bookService.updateBook(book, bookid);
        return book;
    }

}
