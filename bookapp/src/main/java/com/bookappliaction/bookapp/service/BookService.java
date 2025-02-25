package com.bookappliaction.bookapp.service;

import com.bookappliaction.bookapp.repo.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public Book addBook(Book book);
    public Book updateBook(Book book,int id);
    public void deleteBook(int id);
    public List<Book> findAllBooks();

    public Book findById(int id);
    public Book findBookByTitle(String name);
    public Book findBookByAuthor(String author);
    public Book findBookByYear(int year);
}
