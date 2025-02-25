package com.bookappliaction.bookapp.service;

import com.bookappliaction.bookapp.exceptions.BookNotFoundException;
import com.bookappliaction.bookapp.repo.Book;
import com.bookappliaction.bookapp.repo.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private BookRepo bookRepo;

    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book addBook(Book book) {
        bookRepo.save(book);
        return book;
    }

    @Override
    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepo.findAll();
    }

    @Override
    public Book findBookByAuthor(String author) {
        return bookRepo.findByAuthor(author);
    }

    @Override
    public Book findById(int id) {
     return   bookRepo.findById(id)
               .orElseThrow(()-> new BookNotFoundException("Book with id "+id+" not found"));
    }

    @Override
    public Book findBookByTitle(String name) {
        Book book= bookRepo.findByTitle(name);
        if (book==null){
            throw new BookNotFoundException("Book with name "+name+" not found");
        }
        return book;
    }

    @Override
    public Book findBookByYear(int year) {
       Book book= bookRepo.findByYear(year);
        if (book==null){
            throw new BookNotFoundException("Book with year "+year+" not found");
        }
        return book;
    }

    @Override
    public Book updateBook(Book book, int id) {
        book.setPrice(book.getPrice());
        return bookRepo.save(book);
    }
}
