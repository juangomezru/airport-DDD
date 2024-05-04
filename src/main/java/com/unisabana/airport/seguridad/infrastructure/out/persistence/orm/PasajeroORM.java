package com.unisabana.airport.seguridad.infrastructure.out.persistence.orm;

import com.unisabana.airport.seguridad.domain.enums.EstadoPasaporte;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pasajero")
@Data
public class PasajeroORM {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nombre")
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado_pasaporte")
    private EstadoPasaporte estadoPasaporte;

    @Column(name = "visa")
    private String visa;

    @Column(name = "is_betado")
    private boolean isBetado;

    @Column(name = "tiene_check_mig")
    private boolean tieneCheckMig;
}