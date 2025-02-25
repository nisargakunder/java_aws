package com.bookappliaction.bookapp.controller;

import com.bookappliaction.bookapp.repo.Book;
import com.bookappliaction.bookapp.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    private BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }
    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findAllBooks());
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findById(id));
    }
    @GetMapping("/books/name/{name}")
    public ResponseEntity<Book> getBookByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findBookByTitle(name));
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id, @RequestBody @Valid Book book) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(book,id));
    }
    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody @Valid Book book) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.addBook(book));
    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/books/author/{author}")
    public ResponseEntity<Book> getBookByAuthor(@PathVariable String author) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findBookByAuthor(author));
    }
    @GetMapping("/books/year/{year}")
    public ResponseEntity<Book> getBookByYear(@PathVariable int year) {
        return ResponseEntity.status(HttpStatus.OK).body(bookService.findBookByYear(year));
    }

}
