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
    private Long borrower_id;
    private Long donor_id;
    private Long book_id;
    private ExchangeStatus status;
    private LocalDateTime requestDate;
    private LocalDateTime responseDate;

}