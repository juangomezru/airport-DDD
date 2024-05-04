package com.unisabana.airport.seguridad.infrastructure.in.dto;

import com.unisabana.airport.seguridad.domain.enums.TipoArticulo;

public record EquipajeCrearDTO(String id, double peso, String idPasajero, TipoArticulo tipoArticulo) {
}
