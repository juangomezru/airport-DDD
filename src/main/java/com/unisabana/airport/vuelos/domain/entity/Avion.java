package com.unisabana.airport.vuelos.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avion {
    private Long id;
    private String modelo;
    private int capacidadPasajeros;
}
