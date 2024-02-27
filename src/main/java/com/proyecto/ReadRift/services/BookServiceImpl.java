package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book findByUuid(UUID uuid) {
        return bookRepository.findByUuid(uuid);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, Book book) {
        Book existingBook = findById(id);
        if (existingBook != null) {
            book.setId(existingBook.getId());
            return bookRepository.save(book);
        }
        return null; // O puedes lanzar una excepción si prefieres
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

   // @Override
//    public List<Book> searchBooks(String title, String author, String areaOfStudy){return bookRepository.(String title, String author, String areaOfStudy); }



    @Override
    public Book updateAvailability(Long id, Boolean available) {
        Book existingBook = findById(id);
        if (existingBook != null) {
            existingBook.setAvailable(available);
            return bookRepository.save(existingBook);
        }
        return null; // O puedes lanzar una excepción si prefieres
    }

    @Override
    public Book getBookDetails(Long id) {
        return findById(id);
    }

    @Override
    public List<Book> searchBooks(String title, String author, String isbn) {
        // Implementa la lógica de búsqueda en función de los parámetros proporcionados
        if (title != null && author != null && isbn != null) {
            // Ejemplo: busca libros por título, autor y ISBN
            return bookRepository.findByTitleAndAuthorAndIsbn(title, author, isbn);
        } else if (title != null && author != null) {
            // Ejemplo: busca libros por título y autor
            return bookRepository.findByTitleAndAuthor(title, author);
        } else if (title != null) {
            // Ejemplo: busca libros por título
            return bookRepository.findByTitle(title);
        } else if (author != null) {
            // Ejemplo: busca libros por autor
            return bookRepository.findByAuthor(author);
        } else if (isbn != null) {
            // Ejemplo: busca libros por ISBN
            return Collections.singletonList(bookRepository.findByIsbn(isbn));
        } else {
            // Si no se proporcionan criterios de búsqueda, devuelve todos los libros
            return bookRepository.findAll();
        }
    }


    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthor(author);
    }

    @Override
    public List<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    @Override
    public List<Book> findByCondition(String condition) {
        return bookRepository.findByCondition(condition);
    }

    @Override
    public List<Book> findByAvailableTrue() {
        return bookRepository.findByAvailableTrue();
    }

    @Override
    public Book findByIsbn(String isbn) {
        return (Book) bookRepository.findByIsbn(isbn);
    }

}