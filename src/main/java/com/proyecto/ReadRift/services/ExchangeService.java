package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.Exchange;
import com.proyecto.ReadRift.models.ExchangeStatus;
import com.proyecto.ReadRift.models.user.User;
import java.time.LocalDateTime;
import java.util.List;

public interface ExchangeService {
    List<Exchange> findByBorrower(User borrower);
    List<Exchange> findByDonor(User donor);
    List<Exchange> findByStatus(ExchangeStatus status);
    List<Exchange> findByRequestDate(LocalDateTime requestDate);
    List<Exchange> findByLoanDate(LocalDateTime loanDate);
    List<Exchange> findByReturnDate(LocalDateTime returnDate);
    List<Exchange> findByDonationDate(LocalDateTime donationDate);
}