package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.models.user.User;

import java.util.List;
import java.util.UUID;

public interface BookService {

    Book findById(Long id);
    void deleteById(Long id);
    Book save(Book book);
    Book update(Long id, Book book);
    List<Book> findAll();
   // List<Book> searchBooks(String title, String author, String areaOfStudy);
    Book updateAvailability(Long id, Boolean available);
    Book getBookDetails(Long id);

    List<Book> searchBooks(String title, String author, String isbn);

    List<Book> findByAuthor(String author);

    List<Book> findByTitle(String title);

    List<Book> findByCondition(String condition);

    List<Book> findByAvailableTrue();

    Book findByIsbn(String isbn);

   // List<Book> findByOwner(User owner);
}

