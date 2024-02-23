package com.proyecto.ReadRift.models;

import com.proyecto.ReadRift.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;

    @ManyToOne
    @JoinColumn(name = "borrower_id")
    private User borrower; // Usuario que solicita el préstamo

    @ManyToOne
    @JoinColumn(name = "donor_id")
    private User donor; // Usuario que dona los libros

    @OneToMany(mappedBy = "exchange")
    private List<Book> borrowedBooks; // Lista de libros prestados en este intercambio

    private LocalDateTime requestDate; // Fecha de solicitud de préstamo

    private LocalDateTime loanDate; // Fecha de inicio del préstamo

    private LocalDateTime returnDate; // Fecha de devolución del préstamo

    private LocalDateTime donationDate; // Fecha de donación (solo se usa si es una donación)

    @Enumerated(EnumType.STRING)
    private ExchangeStatus status; // Estado del intercambio (por ejemplo, "Completado", "En proceso", etc.)
}