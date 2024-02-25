package com.proyecto.ReadRift.mappers;

import com.proyecto.ReadRift.dtos.ExchangeRequestDto;
import com.proyecto.ReadRift.dtos.ExchangeResponseDto;
import com.proyecto.ReadRift.models.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ExchangeMapper {

    private final UserMapper userMapper;
    public ExchangeResponseDto toResponse(Exchange exchange) {
        return new ExchangeResponseDto(
                exchange.getId(),
                exchange.getUuid(),
                exchange.getBorrower().getId(), // Obtenemos el ID del usuario que solicita el préstamo
                exchange.getDonor().getId(), // Obtenemos el ID del usuario que dona los libros
              //  exchange.getReq_date(),
                exchange.getStatus()
        );
    }

    public List<ExchangeResponseDto> toResponse(List<Exchange> exchanges) {
        return exchanges.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public Exchange toModel(ExchangeRequestDto exchangeRequestDto) {
        return new Exchange(
                null, // El ID se generará automáticamente por la base de datos
                UUID.randomUUID(),
                // Aquí deberías tener lógica para obtener los usuarios y los libros prestados según los IDs proporcionados en el DTO
                userMapper.toModel(exchangeRequestDto.getBorrower_id()),
                userMapper.toModel(exchangeRequestDto.getDonor_id()),
             //   exchangeRequestDto.getReq_date(),
                exchangeRequestDto.getStatus()
        );
    }
}