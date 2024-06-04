package com.proyecto.ReadRift.services;

import com.proyecto.ReadRift.models.Book;
import com.proyecto.ReadRift.models.Exchange;
import com.proyecto.ReadRift.models.ExchangeStatus;
import com.proyecto.ReadRift.models.user.User;
import com.proyecto.ReadRift.repositories.BookRepository;
import com.proyecto.ReadRift.repositories.ExchangeRepository;
import com.proyecto.ReadRift.repositories.UserDetailsRepository;
import org.springframework.stereotype.Service;



import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    private final ExchangeRepository exchangeRepository;
    private final BookRepository bookRepository;
    private final UserDetailsRepository userDetailsRepository;

    public ExchangeServiceImpl(ExchangeRepository exchangeRepository, BookRepository bookRepository, UserDetailsRepository userDetailsRepository) {
        this.exchangeRepository = exchangeRepository;
        this.bookRepository = bookRepository;
        this.userDetailsRepository = userDetailsRepository;
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

    public Exchange requestLoan(Long bookId, User borrower) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book ID: " + bookId));
        User donor = userDetailsRepository.findById(book.getOwnerId()).orElseThrow(() -> new IllegalArgumentException("Invalid owner ID: " + book.getOwnerId()));

        if (borrower.getId().equals(donor.getId())) {
            throw new IllegalArgumentException("A user cannot request a loan to themselves.");
        }

        Exchange exchange = new Exchange();
        exchange.setBook(book);
        exchange.setBorrower(borrower);
        exchange.setDonor(donor);
        exchange.setStatus(ExchangeStatus.PENDING);
        exchange.setRequestDate(LocalDateTime.now());
        return exchangeRepository.save(exchange);
    }

    public Exchange respondToLoanRequest(Long exchangeId, boolean approve, User currentUser) {
        Exchange exchange = exchangeRepository.findById(exchangeId).orElseThrow(() -> new IllegalArgumentException("Invalid exchange ID: " + exchangeId));

        if (!exchange.getDonor().getId().equals(currentUser.getId())) {
            throw new IllegalArgumentException("Only the book owner can respond to the loan request.");
        }

        if (approve) {
            exchange.setStatus(ExchangeStatus.APPROVED);
            Book book = exchange.getBook();
            book.setOwnerId(exchange.getBorrower().getId());
            book.setAvailable(false);
            bookRepository.save(book);
        } else {
            exchange.setStatus(ExchangeStatus.CANCELLED);
        }
        exchange.setResponseDate(LocalDateTime.now());
        return exchangeRepository.save(exchange);
    }
}
