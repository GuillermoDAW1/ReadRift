package com.proyecto.ReadRift.dtos;

import com.proyecto.ReadRift.models.ExchangeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeResponseDto {
    private Long id;
    private UUID uuid;
    private Integer borrower; // usuario que solicita el préstamo
    private Integer donor; //  usuario que dona los libros
    private List<Long> borrowedBooksIds; // Lista de IDs de los libros prestados en este intercambio
    private LocalDateTime requestDate; // Fecha de solicitud de préstamo
    private LocalDateTime loanDate; // Fecha de inicio del préstamo
    private LocalDateTime returnDate; // Fecha de devolución del préstamo
    private LocalDateTime donationDate; // Fecha de donación (solo se usa si es una donación)
    private ExchangeStatus status; // Estado del intercambio
}