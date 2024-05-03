package com.unisabana.airport.vuelos.infrastructure.in.dto;

import com.unisabana.airport.vuelos.domain.enums.EstadoVuelo;
import lombok.Data;

@Data
public class VueloCrearDTO {
    private Long idAvion;
    private String origen;
    private String destino;
    private EstadoVuelo estadoVuelo;
}