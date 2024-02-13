package com.proyecto.ReadRift.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class BookResponseDto {
    private Long id;
    private UUID uuid;
    private String author;
    private String title;
    private String stock;
    private String condition;
    private boolean available;
    private String urlImage;
    private String isbn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
