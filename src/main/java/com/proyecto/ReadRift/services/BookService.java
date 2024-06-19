package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.Book;

import java.util.List;

public interface BookService {

    Book findById(Long id);
    void deleteById(Long id);
    Book save(Book book, String email);
    Book update(Long id, Book book);
    List<Book> findAll();
    Book updateAvailability(Long id, Boolean available);
    Book getBookDetails(Long id);

    List<Book> searchBooks(String title, String author, String isbn);

    List<Book> findByAuthor(String author);

    List<Book> findByOwnerId(Long ownerId);

    List<Book> findByTitle(String title);

    List<Book> findByCondition(String condition);

    List<Book> findByAvailableTrue();

    Book findByIsbn(String isbn);



}

