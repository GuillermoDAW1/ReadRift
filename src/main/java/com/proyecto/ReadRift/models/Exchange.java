package com.proyecto.ReadRift.models;

import com.proyecto.ReadRift.models.user.User;
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
    @ManyToOne
    private User borrower;
    @ManyToOne
    private User donor;
    @ManyToOne
    private Book book;

    @Enumerated(EnumType.STRING)
    private ExchangeStatus status;
    private LocalDateTime requestDate;

    private LocalDateTime responseDate;
}