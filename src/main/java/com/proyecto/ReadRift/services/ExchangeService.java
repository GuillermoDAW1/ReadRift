package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.Exchange;
import com.proyecto.ReadRift.models.ExchangeStatus;

import java.util.List;

public interface ExchangeService {
    List<Exchange> findByBorrower(Long borrowerId);
    List<Exchange> findByDonor(Long donorId);
    List<Exchange> findByBook(Long bookId);
    List<Exchange> findByStatus(ExchangeStatus status);

    Exchange save(Exchange exchange);

    List<Exchange> findAll();

    Exchange findById(Long Id);


}