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
public class BookReview {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Book book;

    @Column(nullable = false)
    private int rating;

    @Column(length = 1000) // Asumiendo un límite de 1000 caracteres para los comentarios
    private String comment;

    @ManyToOne
    private User author;
}
