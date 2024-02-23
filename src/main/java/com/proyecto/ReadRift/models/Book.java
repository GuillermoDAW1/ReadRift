package com.proyecto.ReadRift.models;

import com.proyecto.ReadRift.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;
    private String author;
    private String title;
    private String description; // Agregamos una descripción del libro
    private String condition;
    private boolean available;
    private String urlImage;
    private String isbn;

    @ManyToOne
    private User owner; // Cambiamos el nombre de 'user' a 'owner' para reflejar el propietario del libro

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}