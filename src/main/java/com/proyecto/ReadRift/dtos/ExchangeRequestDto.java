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
    private Long borrower_id; // El ID del usuario que solicita el préstamo
    private Long donor_id; // El ID del usuario que dona los libros
    private Long book_id;
    //private LocalDateTime reqst_date; // Fecha de solicitud de préstamo
    private ExchangeStatus status; // Estado del intercambio

}