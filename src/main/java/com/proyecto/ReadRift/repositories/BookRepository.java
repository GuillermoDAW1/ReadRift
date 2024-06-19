package com.proyecto.ReadRift.repositories;

import com.proyecto.ReadRift.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByAuthor(String author);
    List<Book> findByTitle(String title);
    List<Book> findByCondition(String condition);
    List<Book> findByAvailableTrue();
    Book findByIsbn(String isbn);
    List<Book> findByOwnerId(Long ownerId);

    List<Book> findByTitleAndAuthorAndIsbn(String title, String author, String isbn);

    List<Book> findByTitleAndAuthor(String title, String author);

}