package com.proyecto.ReadRift.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespondToLoanRequestDto {
    private Long exchangeId;
    private boolean approve;
}
