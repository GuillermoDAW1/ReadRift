package com.proyecto.ReadRift.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookRequestDto {
    private final String author;
    private final String title;
    private final String stock;
    private final String condition;
    private final boolean available;
    private final String urlImage;
    private final String isbn;
}
