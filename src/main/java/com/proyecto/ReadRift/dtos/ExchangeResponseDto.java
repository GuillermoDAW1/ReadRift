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
    private Long borrower_id;
    private Long donor_id;
    private Long book_id;
    private ExchangeStatus status;
    private LocalDateTime requestDate;
    private LocalDateTime responseDate;
}