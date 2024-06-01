package com.proyecto.ReadRift.Controllers;

import com.proyecto.ReadRift.dtos.*;
import com.proyecto.ReadRift.mappers.ExchangeMapper;
import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.models.Exchange;
import com.proyecto.ReadRift.models.ExchangeStatus;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.services.ExchangeService;
import com.proyecto.ReadRift.services.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/exchanges")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ExchangeController {

    private final ExchangeService exchangeService;
    private final ExchangeMapper exchangeMapper;
    private final UserDetailsServiceImpl userService;


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
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByStatus(@PathVariable ExchangeStatus status) {
        List<Exchange> exchanges = exchangeService.findByStatus(status);
        return ResponseEntity.ok(exchangeMapper.toResponse(exchanges));
    }
/*
    @PostMapping
    public ResponseEntity<ExchangeResponseDto> createExchange(@RequestBody ExchangeRequestDto exchangeRequestDto) {
        Exchange exchange = exchangeService.save(exchangeMapper.toModel(exchangeRequestDto));
        ExchangeResponseDto exchangeResponseDto = exchangeMapper.toResponse(exchange);
        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeResponseDto);
    }


   @GetMapping("/requestDate/{requestDate}")
    public ResponseEntity<ExchangeResponseDto> getExchangesByRequestDate(@PathVariable LocalDateTime requestDate) {
        Exchange exchanges = exchangeService.findByRequestDate(requestDate);
        return ResponseEntity.ok(exchangeMapper.toResponse(exchanges));
    }*/


    @PostMapping("/request")
    public ResponseEntity<ExchangeResponseDto> requestLoan(@RequestBody ExchangeRequestDto exchangeRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User borrower = userService.loadUserByUsername(email);

        Exchange exchange = exchangeService.requestLoan(exchangeRequestDto.getBook_id(), borrower);
        ExchangeResponseDto exchangeResponseDto = exchangeMapper.toResponse(exchange);
        return ResponseEntity.status(HttpStatus.CREATED).body(exchangeResponseDto);
    }

    @PostMapping("/respond")
    public ResponseEntity<ExchangeResponseDto> respondToLoanRequest(@RequestBody RespondToLoanRequestDto respondToLoanRequestDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();
        User currentUser = userService.loadUserByUsername(email);

        Exchange exchange = exchangeService.respondToLoanRequest(respondToLoanRequestDto.getExchangeId(), respondToLoanRequestDto.isApprove(), currentUser);
        ExchangeResponseDto exchangeResponseDto = exchangeMapper.toResponse(exchange);
        return ResponseEntity.ok(exchangeResponseDto);
    }
}