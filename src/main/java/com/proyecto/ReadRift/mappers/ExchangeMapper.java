package com.proyecto.ReadRift.mappers;

import com.proyecto.ReadRift.dtos.ExchangeRequestDto;
import com.proyecto.ReadRift.dtos.ExchangeResponseDto;
import com.proyecto.ReadRift.models.Exchange;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExchangeMapper {

    public ExchangeResponseDto toResponse(Exchange exchange) {
        return new ExchangeResponseDto(
                exchange.getId(),
                exchange.getBorrowerId(),
                exchange.getDonorId(),
                exchange.getBookId(),
                exchange.getStatus(),
                exchange.getRequestDate()
        );
    }

    public List<ExchangeResponseDto> toResponse(List<Exchange> exchanges) {
        return exchanges.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Exchange toModel(ExchangeRequestDto exchangeRequestDto) {
        return new Exchange(
                null,
                exchangeRequestDto.getBookId(),
                exchangeRequestDto.getBorrowerId(),
                exchangeRequestDto.getDonorId(),
                exchangeRequestDto.getStatus(),
                exchangeRequestDto.getRequestDate()
        );
    }
}