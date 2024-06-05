package com.proyecto.ReadRift.repositories;

import com.proyecto.ReadRift.models.Exchange;
import com.proyecto.ReadRift.models.ExchangeStatus;
import com.proyecto.ReadRift.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    List<Exchange> findByBorrowerId(Long borrowerId);
    List<Exchange> findByDonorId(Long donorId);
    List<Exchange> findByBookId(Long bookId);
    List<Exchange> findByStatus(ExchangeStatus status);

}