package com.bookappliaction.bookapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepo extends JpaRepository<Book, Integer> {
    public Book findByTitle(String name);
    public Book findByAuthor(String author);
    public Book findByYear(int year);
}
