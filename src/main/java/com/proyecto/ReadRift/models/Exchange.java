package com.proyecto.ReadRift.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Exchange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "borrower_id")
    private Long borrowerId;

    @Column(name = "donor_id")
    private Long donorId;


    @Enumerated(EnumType.STRING)
    private ExchangeStatus status;
    private LocalDateTime requestDate;

}