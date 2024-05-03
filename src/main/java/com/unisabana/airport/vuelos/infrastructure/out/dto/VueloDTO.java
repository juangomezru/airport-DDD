package com.unisabana.airport.vuelos.infrastructure.out.dto;

import lombok.Data;

@Data
public class VueloDTO {
    private Long id;
    private String origen;
    private String destino;
    private Long idAvion;
}
