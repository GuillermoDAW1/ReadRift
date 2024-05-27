package com.proyecto.ReadRift.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookReviewRequestDto {
    private Long bookId;
    private int rating;
    private String comment;
}
