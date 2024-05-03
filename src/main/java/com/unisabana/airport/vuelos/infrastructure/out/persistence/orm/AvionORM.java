package com.unisabana.airport.vuelos.infrastructure.out.persistence.orm;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class AvionORM {
    @Id
    @Column
    private Long id;
    @Column
    private String modelo;
    @Column
    private int capacidadPasajeros;
    @Column
    private String aerolinea;
    @Column
    private String fabricante;
}
