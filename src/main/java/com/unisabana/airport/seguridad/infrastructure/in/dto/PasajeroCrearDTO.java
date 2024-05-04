package com.unisabana.airport.seguridad.infrastructure.in.dto;

import com.unisabana.airport.seguridad.domain.enums.EstadoPasaporte;

public record PasajeroCrearDTO(String id, String nombre, EstadoPasaporte estadoPasaporte, String visa, boolean isBetado) {
}
