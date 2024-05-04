package com.unisabana.airport.seguridad.application.usecase;

import com.unisabana.airport.seguridad.domain.enums.TipoArticulo;

public record EquipajeDTO(String id, double peso, String idPasajero, TipoArticulo tipoArticulo) {
}
