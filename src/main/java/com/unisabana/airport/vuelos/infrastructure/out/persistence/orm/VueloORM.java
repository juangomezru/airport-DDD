package com.unisabana.airport.vuelos.infrastructure.out.persistence.orm;

import com.unisabana.airport.vuelos.domain.enums.EstadoVuelo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class VueloORM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String origen;
    @Column
    private String destino;
    @Column
    private int capacidad;
    @Column
    private EstadoVuelo estadoVuelo;

    @ManyToOne
    @JoinColumn(name = "avion_id")
    private AvionORM avion;

}
