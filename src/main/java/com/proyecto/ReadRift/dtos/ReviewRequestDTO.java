package com.proyecto.ReadRift.dtos;


import lombok.Data;

@Data
public class ReviewRequestDTO {
    private Long userId;
    private Long bookId;
    private int rating;
    private String comment;
}