package com.proyecto.ReadRift.dtos;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewResponseDTO {

    private Long id;
    private Long userId;
    private Long bookId;
    private int rating;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}