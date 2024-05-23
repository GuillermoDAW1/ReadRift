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
    private Long borrower_id; // usuario que solicita el préstamo
    private Long donor_id; //  usuario que dona los libros
    private Long book_id;
//private LocalDateTime req_date; // Fecha de solicitud de préstamo
    private ExchangeStatus status; // Estado del intercambio
}