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

    List<Exchange> findByBorrower_Id(Long borrower);
    List<Exchange> findByDonor_Id(Long donor);
    List<Exchange> findByBook_Id(Long book);
    List<Exchange> findByStatus(ExchangeStatus status);

}