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
    List<Exchange> findByBorrower_Id(Long borrower);

    // Buscar intercambios por usuario que dona los libros
    List<Exchange> findByDonor_Id(Long donor);
    List<Exchange> findByBook_Id(Long book);

    // Buscar intercambios por estado
    List<Exchange> findByStatus(ExchangeStatus status);

    // Buscar intercambios por fecha de solicitud
//    Exchange findByReqst_date(LocalDateTime requestDate);

}