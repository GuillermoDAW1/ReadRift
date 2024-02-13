package com.proyecto.ReadRift.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import com.proyecto.ReadRift.models.Libro;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
public class CategoryResponseDto {
    private final Long id;
    private final UUID uuid;
    private final String area;
    private List<Libro> libros;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
