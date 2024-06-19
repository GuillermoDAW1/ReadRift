package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.models.Exchange;
import com.proyecto.ReadRift.models.ExchangeStatus;
import com.proyecto.ReadRift.repositories.BookRepository;
import com.proyecto.ReadRift.repositories.ExchangeRepository;
import com.proyecto.ReadRift.repositories.UserDetailsRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final BookRepository bookRepository;


    public ExchangeServiceImpl(ExchangeRepository exchangeRepository, BookRepository bookRepository) {
        this.exchangeRepository = exchangeRepository;
        this.bookRepository = bookRepository;

    }

    @Override
    public List<Exchange> findByBorrower(Long borrowerId) {
        return exchangeRepository.findByBorrowerId(borrowerId);
    }

    @Override
    public List<Exchange> findByDonor(Long donorId) {
        return exchangeRepository.findByDonorId(donorId);
    }

    @Override
    public List<Exchange> findByBook(Long bookId) {
        return exchangeRepository.findByBookId(bookId);
    }

    @Override
    public List<Exchange> findByStatus(ExchangeStatus status) {
        return exchangeRepository.findByStatus(status);
    }

    @Override
    public Exchange save(Exchange exchange) {
        // Actualiza el estado del libro a no disponible cuando se aprueba el intercambio
        if (exchange.getStatus() == ExchangeStatus.APPROVED) {
            Book book = bookRepository.findById(exchange.getBookId()).orElse(null);
            if (book != null) {
                book.setAvailable(false);
                bookRepository.save(book);
            }
        }
        return exchangeRepository.save(exchange);
    }

    @Override
    public List<Exchange> findAll() {
        return exchangeRepository.findAll();
    }
    @Override
    public Exchange findById(Long Id) {
        return exchangeRepository.findById(Id).orElseThrow(() -> new RuntimeException("Exchange not found"));
    }




}
