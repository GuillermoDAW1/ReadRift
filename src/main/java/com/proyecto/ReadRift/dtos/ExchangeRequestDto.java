package com.proyecto.ReadRift.dtos;

import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.models.ExchangeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRequestDto {
    private Integer borrower; // El ID del usuario que solicita el préstamo
    private Integer donor; // El ID del usuario que dona los libros
    private List<Book> borrowedBooksIds; // Lista de IDs de los libros prestados en este intercambio
    private LocalDateTime requestDate; // Fecha de solicitud de préstamo
    private LocalDateTime loanDate; // Fecha de inicio del préstamo
    private LocalDateTime returnDate; // Fecha de devolución del préstamo
    private LocalDateTime donationDate; // Fecha de donación (solo se usa si es una donación)
    private ExchangeStatus status; // Estado del intercambio
}