package com.unisabana.airport.comercio.infrastructure.out.persistence.orm;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table
public class TransferenciaORM {
    @Id
    @Column
    private UUID uuid;

    @Column
    private LocalDateTime fechaTransferencia;

    @Column
    private int valorArriendo;
}
