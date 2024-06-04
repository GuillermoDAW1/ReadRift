package com.proyecto.ReadRift.mappers;

import com.proyecto.ReadRift.dtos.ExchangeRequestDto;
import com.proyecto.ReadRift.dtos.ExchangeResponseDto;
import com.proyecto.ReadRift.models.Exchange;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ExchangeMapper {

    @Autowired
    private  UserMapper userMapper;
    @Autowired
    private  BookMapper bookMapper;

    public ExchangeResponseDto toResponse(Exchange exchange) {
        return new ExchangeResponseDto(
                exchange.getId(),
                exchange.getBorrower().getId(),
                exchange.getDonor().getId(),
                exchange.getBook().getId(),
                exchange.getStatus(),
                exchange.getRequestDate(),
                exchange.getResponseDate()
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
                userMapper.toModel(exchangeRequestDto.getBorrower_id()),
                userMapper.toModel(exchangeRequestDto.getDonor_id()),
                bookMapper.toModel(exchangeRequestDto.getBook_id()),
                exchangeRequestDto.getStatus(),
                exchangeRequestDto.getRequestDate(),
                exchangeRequestDto.getResponseDate()
        );
    }
}