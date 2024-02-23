package com.proyecto.ReadRift.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class BookRequestDto {
    private final String author;
    private final String title;
    private final String description;
    private final String condition;
    private final Boolean available;
    private final String urlImage;
    private final String isbn;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;
}