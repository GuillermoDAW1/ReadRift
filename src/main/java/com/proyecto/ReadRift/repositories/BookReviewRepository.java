package com.proyecto.ReadRift.repositories;

import com.proyecto.ReadRift.models.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookReviewRepository  extends JpaRepository<BookReview, Long> {
    List<BookReview> findByBookId(Long bookId);
}
