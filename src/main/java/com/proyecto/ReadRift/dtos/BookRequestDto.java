package com.proyecto.ReadRift.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRequestDto {
    private final String author;
    private final String title;
    private final String description;
    private final String condition;
    private final Boolean available;
    private final String url_image;
    private final String isbn;
    private final Long ownerId;
}