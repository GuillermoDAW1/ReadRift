package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.repositories.BookRepository;
import org.springframework.stereotype.Service;
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
    public List<Book> getBookHistory(Long id) {
        // Implementa la lógica para obtener el historial de libros aquí
        return null;
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
    public List<Book> findByIsbn(String isbn) {
        return (List<Book>) bookRepository.findByIsbn(isbn);
    }

    @Override
    public List<Book> findByOwner(User owner) {
        return bookRepository.findByOwner(owner);
    }
}