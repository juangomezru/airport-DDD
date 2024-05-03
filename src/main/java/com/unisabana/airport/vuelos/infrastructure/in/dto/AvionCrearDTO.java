package com.unisabana.airport.vuelos.infrastructure.in.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class AvionCrearDTO {
    private Long id;
    private String modelo;
    private int capacidadPasajeros;
    private String aerolinea;
    private String fabricante;
}

