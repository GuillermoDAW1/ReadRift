package com.proyecto.ReadRift.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class BookResponseDto {
    private Long id;
    private UUID uuid;
    private String author;
    private String title;
    private String description;
    private String condition;
    private boolean available;
    private String urlImage;
    private String isbn;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}