package com.proyecto.ReadRift.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookReviewResponseDto {
    private Long id;
    private Long bookId;
    private int rating;
    private String comment;
    private Long author_id;

}
