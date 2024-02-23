package com.proyecto.ReadRift.mappers;

import com.proyecto.ReadRift.dtos.ExchangeRequestDto;
import com.proyecto.ReadRift.dtos.ExchangeResponseDto;
import com.proyecto.ReadRift.models.Exchange;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ExchangeMapper {

    public ExchangeResponseDto toResponse(Exchange exchange) {
        return new ExchangeResponseDto(
                exchange.getId(),
                exchange.getUuid(),
                exchange.getBorrower(), // Obtenemos el ID del usuario que solicita el préstamo
                exchange.getDonor(), // Obtenemos el ID del usuario que dona los libros
                exchange.getBorrowedBooks().stream().map(book -> book.getId()).collect(Collectors.toList()), // Obtenemos una lista de IDs de los libros prestados
                exchange.getRequestDate(),
                exchange.getLoanDate(),
                exchange.getReturnDate(),
                exchange.getDonationDate(),
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
                0L, // El ID se generará automáticamente por la base de datos
                UUID.randomUUID(),
                // Aquí deberías tener lógica para obtener los usuarios y los libros prestados según los IDs proporcionados en el DTO
                exchangeRequestDto.getBorrower(),
                exchangeRequestDto.getDonor(),
                exchangeRequestDto.getBorrowedBooksIds(),
                exchangeRequestDto.getRequestDate(),
                exchangeRequestDto.getLoanDate(),
                exchangeRequestDto.getReturnDate(),
                exchangeRequestDto.getDonationDate(),
                exchangeRequestDto.getStatus()
        );
    }
}