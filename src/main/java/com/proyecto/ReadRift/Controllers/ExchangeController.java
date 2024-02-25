package com.proyecto.ReadRift.Controllers;

import com.proyecto.ReadRift.dtos.ExchangeResponseDto;
import com.proyecto.ReadRift.mappers.ExchangeMapper;
import com.proyecto.ReadRift.models.Exchange;
import com.proyecto.ReadRift.models.ExchangeStatus;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.services.ExchangeService;
import com.proyecto.ReadRift.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/exchanges")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;
    private final UserDetailsServiceImpl userService;
    private final ExchangeMapper exchangeMapper;




    @GetMapping("/borrower/{borrowerId}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByBorrower(@PathVariable User borrowerId) {
        // Suponiendo que tienes un método para obtener un usuario por ID en tu servicio de usuario
        List<Exchange> exchanges = exchangeService.findByBorrower(borrowerId); //Mirar User
        List<ExchangeResponseDto> exchangeResponseDtos = exchanges.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(exchangeResponseDtos);
    }

    @GetMapping("/donor/{donorId}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByDonor(@PathVariable Long donorId) {
        // Suponiendo que tienes un método para obtener un usuario por ID en tu servicio de usuario
        User user= userService.findById(donorId);
        List<Exchange> exchanges = exchangeService.findByDonor(user);
        List<ExchangeResponseDto> exchangeResponseDtos = exchanges.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(exchangeResponseDtos);
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByStatus(@PathVariable ExchangeStatus status) {
        List<Exchange> exchanges = exchangeService.findByStatus(status);
        List<ExchangeResponseDto> exchangeResponseDtos = exchanges.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(exchangeResponseDtos);
    }

  /*  @GetMapping("/requestDate/{requestDate}")
    public ResponseEntity<ExchangeResponseDto> getExchangesByRequestDate(@PathVariable LocalDateTime requestDate) {
        Exchange exchanges = exchangeService.findByRequestDate(requestDate);
        return ResponseEntity.ok(exchangeMapper.toResponse(exchanges));
    }*/


    // Método para convertir un objeto Exchange a ExchangeResponseDto
    private ExchangeResponseDto convertToDto(Exchange exchange) {
        ExchangeResponseDto exchangeResponseDto = new ExchangeResponseDto();
        BeanUtils.copyProperties(exchange, exchangeResponseDto);
        return exchangeResponseDto;
    }
}