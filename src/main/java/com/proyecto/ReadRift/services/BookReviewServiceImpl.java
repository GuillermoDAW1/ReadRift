package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.dtos.BookReviewRequestDto;
import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.models.BookReview;
import com.proyecto.ReadRift.repositories.BookRepository;
import com.proyecto.ReadRift.repositories.BookReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookReviewServiceImpl implements BookReviewService {

    private final BookReviewRepository bookReviewRepository;
    private final BookRepository bookRepository;

    public BookReviewServiceImpl(BookReviewRepository bookReviewRepository, BookRepository bookRepository) {
        this.bookReviewRepository = bookReviewRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public BookReview save(BookReview bookReview) {
        return bookReviewRepository.save(bookReview);

    }

    @Override
    public List<BookReview> findReviewsByBookId(Long bookId) {
        return bookReviewRepository.findByBookId(bookId);
    }

    @Override
    public List<BookReview> findAllReviewsByAuthorId(Long authorId) {
        return bookReviewRepository.findByAuthorId(authorId);
    }

    @Override
    public BookReview update(Long id, BookReview bookReview) {
        return null;
    }

    @Override
    public List<BookReview> findAll() {
        return bookReviewRepository.findAll();
    }

    @Override
    public BookReview findById(Long id) {
        return bookReviewRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteReviewById(Long id) {
        bookReviewRepository.deleteById(id);
    }


}
