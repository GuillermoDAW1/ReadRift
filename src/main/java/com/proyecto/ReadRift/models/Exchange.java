package com.proyecto.ReadRift.models;

import com.proyecto.ReadRift.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User borrower; // Usuario que solicita el préstamo
    @ManyToOne
    private User donor; // Usuario que dona los libros
    @ManyToOne
    private Book book;

  //  private LocalDateTime reqst_date; // Fecha de solicitud de préstamo
    @Enumerated(EnumType.STRING)
    private ExchangeStatus status; // Estado del intercambio (por ejemplo, "Completado", "En proceso", etc.)
    private LocalDateTime requestDate; // Fecha de solicitud de préstamo

    private LocalDateTime responseDate; // Fecha de respuesta del préstamo
}