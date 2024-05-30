package com.proyecto.ReadRift.models;


import com.proyecto.ReadRift.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_review")
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Column(nullable = false)
    private int rating;

    @Column(length = 1000) // Asumiendo un límite de 1000 caracteres para los comentarios
    private String comment;

    @Column(name = "author_id")
    private Long authorId;
}
