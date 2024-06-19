package com.proyecto.ReadRift.dtos;

import com.proyecto.ReadRift.models.ExchangeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExchangeRequestDto {
    private Long bookId;
    private Long borrowerId;
    private Long donorId;
    private ExchangeStatus status;
    private LocalDateTime requestDate;

}