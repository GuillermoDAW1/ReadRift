package com.proyecto.ReadRift.Controllers;

import com.proyecto.ReadRift.dtos.ExchangeResponseDto;
import com.proyecto.ReadRift.mappers.ExchangeMapper;
import com.proyecto.ReadRift.models.Exchange;
import com.proyecto.ReadRift.services.ExchangeService;
import com.proyecto.ReadRift.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exchanges")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;
    private final ExchangeMapper exchangeMapper;

    @GetMapping
    public ResponseEntity<List<ExchangeResponseDto>> getExchanges() {
        // Suponiendo que tienes un método para obtener un usuario por ID en tu servicio de usuario
        List<Exchange> exchanges = exchangeService.findAll(); //Mirar User

        return ResponseEntity.ok(exchangeMapper.toResponse(exchanges));
    }
    @GetMapping("/borrower/{borrowerId}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByBorrower(@PathVariable Long borrowerId) {
        // Suponiendo que tienes un método para obtener un usuario por ID en tu servicio de usuario
        List<Exchange> exchanges = exchangeService.findByBorrower(borrowerId); //Mirar User

        return ResponseEntity.ok(exchangeMapper.toResponse(exchanges));
    }

    @GetMapping("/donor/{donorId}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByDonor(@PathVariable Long donorId) {
        // Suponiendo que tienes un método para obtener un usuario por ID en tu servicio de usuario
        List<Exchange> exchanges = exchangeService.findByDonor(donorId);

        return ResponseEntity.ok(exchangeMapper.toResponse(exchanges));
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByStatus(@PathVariable String status) {
        List<Exchange> exchanges = exchangeService.findByStatus(status);

        return ResponseEntity.ok(exchangeMapper.toResponse(exchanges));
    }

  /*  @GetMapping("/requestDate/{requestDate}")
    public ResponseEntity<ExchangeResponseDto> getExchangesByRequestDate(@PathVariable LocalDateTime requestDate) {
        Exchange exchanges = exchangeService.findByRequestDate(requestDate);
        return ResponseEntity.ok(exchangeMapper.toResponse(exchanges));
    }*/



}