package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.repositories.BookRepository;
import com.proyecto.ReadRift.repositories.UserDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final UserDetailsRepository userDetailsRepository;

    public BookServiceImpl(BookRepository bookRepository, UserDetailsRepository userDetailsRepository) {
        this.bookRepository = bookRepository;
        this.userDetailsRepository = userDetailsRepository;
    }


    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public List<Book> findByOwnerId(Long ownerId) {
        return bookRepository.findByOwnerId(ownerId);
    }


    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book save(Book book, String email) {
        User user = userDetailsRepository.findByEmail(email);
        book.setOwnerId(user.getId());
        return bookRepository.save(book);
    }

    @Override
    public Book update(Long id, Book book) {
        Book existingBook = findById(id);
        if (existingBook != null) {
            book.setId(existingBook.getId());
            book.setOwnerId(existingBook.getOwnerId());
            return bookRepository.save(book);
        }
        return null;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book updateAvailability(Long id, Boolean available) {
        Book existingBook = findById(id);
        if (existingBook != null) {
            existingBook.setAvailable(available);
            return bookRepository.save(existingBook);
        }
        return null;
    }

    @Override
    public Book getBookDetails(Long id) {
        return findById(id);
    }

    @Override
    public List<Book> searchBooks(String title, String author, String isbn) {
        if (title != null && author != null && isbn != null) {
            return bookRepository.findByTitleAndAuthorAndIsbn(title, author, isbn);
        } else if (title != null && author != null) {
            return bookRepository.findByTitleAndAuthor(title, author);
        } else if (title != null) {
            return bookRepository.findByTitle(title);
        } else if (author != null) {
            return bookRepository.findByAuthor(author);
        } else if (isbn != null) {
            return Collections.singletonList(bookRepository.findByIsbn(isbn));
        } else {
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
        return bookRepository.findByIsbn(isbn);
    }


}