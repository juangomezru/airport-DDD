package com.unisabana.airport.seguridad.infrastructure.out.persistence.orm;

import com.unisabana.airport.seguridad.domain.enums.TipoArticulo;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class EquipajeORM {
    @Id
    @Column
    private String id;
    @Column
    private double peso;
    @ManyToOne
    @JoinColumn(name = "pasajero_id")
    private PasajeroORM pasajero;
    @Column
    private TipoArticulo tipoArticulo;
}