package com.proyecto.ReadRift.Controllers;

import com.proyecto.ReadRift.dtos.BookReviewRequestDto;
import com.proyecto.ReadRift.dtos.BookReviewResponseDto;
import com.proyecto.ReadRift.mappers.BookReviewMapper;
import com.proyecto.ReadRift.models.BookReview;
import com.proyecto.ReadRift.services.BookReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/book-reviews")
public class BookReviewController {

    private final BookReviewService bookReviewService;
    private final BookReviewMapper bookReviewMapper;

    @Autowired
    public BookReviewController(BookReviewService bookReviewService, BookReviewMapper bookReviewMapper) {
        this.bookReviewService = bookReviewService;
        this.bookReviewMapper = bookReviewMapper;
    }

    @PostMapping
    public ResponseEntity<BookReviewResponseDto> createReview(@RequestBody BookReviewRequestDto bookReviewRequestDto){
        BookReview bookReview = bookReviewService.save(bookReviewMapper.toModel(bookReviewRequestDto));
        BookReviewResponseDto bookReviewResponseDto = bookReviewMapper.toResponse(bookReview);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookReviewResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookReviewResponseDto> getReviewById(@PathVariable Long id){
        BookReview bookReview = bookReviewService.findById(id);
        if (bookReview != null){
            BookReviewResponseDto bookReviewResponseDto = bookReviewMapper.toResponse(bookReview);
            return ResponseEntity.ok(bookReviewResponseDto);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookReviewResponseDto> updateBookReview(@PathVariable Long id, @RequestBody BookReviewRequestDto bookReviewRequestDto){
        BookReview existingBookReview = bookReviewService.findById(id);
        if (existingBookReview != null){
            existingBookReview.setRating(bookReviewRequestDto.getRating());
            existingBookReview.setComment(bookReviewRequestDto.getComment());
            BookReview updatedReview = bookReviewService.save(existingBookReview);
            BookReviewResponseDto responseDto = bookReviewMapper.toResponse(updatedReview);
            return ResponseEntity.ok(responseDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<BookReviewResponseDto>> getAllBookReviews(){
        List<BookReview> bookReviews = bookReviewService.findAll();
        List<BookReviewResponseDto> bookReviewResponseDtos = bookReviewMapper.toResponse(bookReviews);
        return ResponseEntity.ok(bookReviewResponseDtos);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<BookReviewResponseDto>> getReviewsByBookId(@PathVariable Long bookId) {
        List<BookReview> reviews = bookReviewService.findReviewsByBookId(bookId);
        if (reviews != null && !reviews.isEmpty()) {
            List<BookReviewResponseDto> responseDtos = reviews.stream()
                    .map(bookReviewMapper::toResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(responseDtos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/author/{authorId}")
    public ResponseEntity<List<BookReviewResponseDto>> getAllReviewsByAuthorId(@PathVariable Long authorId) {
        List<BookReview> reviews = bookReviewService.findAllReviewsByAuthorId(authorId);
        if (reviews != null && !reviews.isEmpty()) {
            List<BookReviewResponseDto> responseDtos = reviews.stream()
                    .map(bookReviewMapper::toResponse)
                    .collect(Collectors.toList());
            return ResponseEntity.ok(responseDtos);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        bookReviewService.deleteReviewById(id);
        return ResponseEntity.noContent().build();
    }




}
