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
    public List<Exchange> findByBorrower(Long borrower) {
        return exchangeRepository.findByBorrower_Id(borrower);
    }

    @Override
    public List<Exchange> findByDonor(Long donor) {
        return exchangeRepository.findByDonor_Id(donor);
    }
    @Override
    public List<Exchange> findByBook(Long book) {
        return exchangeRepository.findByBook_Id(book);
    }

    @Override
    public List<Exchange> findByStatus(ExchangeStatus status) {
        return exchangeRepository.findByStatus(status);
    }

    @Override
    public Exchange save(Exchange exchange) {
        return exchangeRepository.save(exchange);
    }


    @Override
    public List<Exchange> findAll() {
        return exchangeRepository.findAll();
    }


   /* @Override
    public Exchange findByRequestDate(LocalDateTime requestDate) {
        return exchangeRepository.findByReqst_date(requestDate);
    }*/


}