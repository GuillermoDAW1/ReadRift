package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.Exchange;
import com.proyecto.ReadRift.models.ExchangeStatus;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.repositories.ExchangeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeRepository exchangeRepository;

    public ExchangeServiceImpl(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }

    @Override
    public List<Exchange> findByBorrower(User borrower) {
        return exchangeRepository.findByBorrower(borrower);
    }

    @Override
    public List<Exchange> findByDonor(User donor) {
        return exchangeRepository.findByDonor(donor);
    }

    @Override
    public List<Exchange> findByStatus(ExchangeStatus status) {
        return exchangeRepository.findByStatus(status);
    }

   /* @Override
    public Exchange findByRequestDate(LocalDateTime requestDate) {
        return exchangeRepository.findByReqst_date(requestDate);
    }*/


}