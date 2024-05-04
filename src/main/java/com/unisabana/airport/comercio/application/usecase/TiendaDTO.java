package com.unisabana.airport.comercio.application.usecase;

import com.unisabana.airport.comercio.domain.enums.CategoriaTienda;

public record TiendaDTO(String nombreTienda, CategoriaTienda tipoTienda, String ubicacion, int numProductosStock, int saldoNegocio) {
}
