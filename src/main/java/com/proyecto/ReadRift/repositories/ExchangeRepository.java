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

    // Buscar intercambios por usuario que solicita el préstamo
    List<Exchange> findByBorrower(User borrower);

    // Buscar intercambios por usuario que dona los libros
    List<Exchange> findByDonor(User donor);

    // Buscar intercambios por estado
    List<Exchange> findByStatus(ExchangeStatus status);

    // Buscar intercambios por fecha de solicitud
//    Exchange findByReqst_date(LocalDateTime requestDate);

}