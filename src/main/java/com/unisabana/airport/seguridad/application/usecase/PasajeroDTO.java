package com.unisabana.airport.seguridad.application.usecase;

import com.unisabana.airport.seguridad.domain.enums.EstadoPasaporte;

public record PasajeroDTO(String id, String nombre, EstadoPasaporte estadoPasaporte, String visa, boolean isBetado) {
}
