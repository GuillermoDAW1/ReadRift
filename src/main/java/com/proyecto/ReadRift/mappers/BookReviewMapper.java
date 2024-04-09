package com.proyecto.ReadRift.mappers;

import com.proyecto.ReadRift.dtos.BookReviewRequestDto;
import com.proyecto.ReadRift.dtos.BookReviewResponseDto;
import com.proyecto.ReadRift.models.BookReview;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookReviewMapper {

    public BookReviewResponseDto toResponse(BookReview bookReview){
        return new BookReviewResponseDto(
                bookReview.getId(),
                bookReview.getBook().getId(),
                bookReview.getRating(),
                bookReview.getComment()
        );
    }
    public List<BookReviewResponseDto> toResponse(List<BookReview> bookReviews){
        return bookReviews.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public BookReview toModel(BookReviewRequestDto bookReviewRequestDto){
        return new BookReview(
                null,
                null,
                bookReviewRequestDto.getRating(),
                bookReviewRequestDto.getComment(),
                null

        );
    }

}


