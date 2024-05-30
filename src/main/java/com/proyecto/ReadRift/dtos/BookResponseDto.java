package com.proyecto.ReadRift.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class BookResponseDto {
    private final Long id;
    private final String author;
    private final String title;
    private final String description;
    private final String condition;
    private final Boolean available;
    private final String url_image;
    private final String isbn;
    private final Long ownerId;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}