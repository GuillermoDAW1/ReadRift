package com.proyecto.ReadRift.Controllers;

import com.proyecto.ReadRift.dtos.ExchangeResponseDto;
import com.proyecto.ReadRift.models.Exchange;
import com.proyecto.ReadRift.models.ExchangeStatus;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.services.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/exchanges")
public class ExchangeController {

    private final ExchangeService exchangeService;

    @Autowired
    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }

    @GetMapping("/borrower/{borrowerId}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByBorrower(@PathVariable Long borrowerId) {
        User borrower = new User(); // Aquí debes implementar la lógica para obtener el usuario por su ID
        List<Exchange> exchanges = exchangeService.findByBorrower(borrower);
        // Aquí deberías mapear los objetos Exchange a ExchangeResponseDto si es necesario
        return ResponseEntity.ok().build();
    }

    @GetMapping("/donor/{donorId}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByDonor(@PathVariable Long donorId) {
        User donor = new User(); // Aquí debes implementar la lógica para obtener el usuario por su ID
        List<Exchange> exchanges = exchangeService.findByDonor(donor);
        // Aquí deberías mapear los objetos Exchange a ExchangeResponseDto si es necesario
        return ResponseEntity.ok().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByStatus(@PathVariable ExchangeStatus status) {
        List<Exchange> exchanges = exchangeService.findByStatus(status);
        // Aquí deberías mapear los objetos Exchange a ExchangeResponseDto si es necesario
        return ResponseEntity.ok().build();
    }

    @GetMapping("/requestDate/{requestDate}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByRequestDate(@PathVariable LocalDateTime requestDate) {
        List<Exchange> exchanges = exchangeService.findByRequestDate(requestDate);
        // Aquí deberías mapear los objetos Exchange a ExchangeResponseDto si es necesario
        return ResponseEntity.ok().build();
    }

    @GetMapping("/loanDate/{loanDate}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByLoanDate(@PathVariable LocalDateTime loanDate) {
        List<Exchange> exchanges = exchangeService.findByLoanDate(loanDate);
        // Aquí deberías mapear los objetos Exchange a ExchangeResponseDto si es necesario
        return ResponseEntity.ok().build();
    }

    @GetMapping("/returnDate/{returnDate}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByReturnDate(@PathVariable LocalDateTime returnDate) {
        List<Exchange> exchanges = exchangeService.findByReturnDate(returnDate);
        // Aquí deberías mapear los objetos Exchange a ExchangeResponseDto si es necesario
        return ResponseEntity.ok().build();
    }

    @GetMapping("/donationDate/{donationDate}")
    public ResponseEntity<List<ExchangeResponseDto>> getExchangesByDonationDate(@PathVariable LocalDateTime donationDate) {
        List<Exchange> exchanges = exchangeService.findByDonationDate(donationDate);
        // Aquí deberías mapear los objetos Exchange a ExchangeResponseDto si es necesario
        return ResponseEntity.ok().build();
    }
}