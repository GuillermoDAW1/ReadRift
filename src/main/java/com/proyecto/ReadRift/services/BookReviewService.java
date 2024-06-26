package com.proyecto.ReadRift.services;


import com.proyecto.ReadRift.models.BookReview;

import java.util.List;


public interface BookReviewService {
    BookReview findById(Long id);
    void deleteReviewById(Long id);
    BookReview save(BookReview bookReview);
    List<BookReview> findReviewsByBookId (Long bookId);
    List<BookReview> findAllReviewsByAuthorId(Long authorId);
    BookReview update(Long id, BookReview bookReview);
    List<BookReview> findAll();
}
