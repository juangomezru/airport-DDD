package com.unisabana.airport.comercio.domain.repository;

import com.unisabana.airport.comercio.application.usecase.TiendaDTO;
import com.unisabana.airport.comercio.domain.entity.Tienda;

public interface TiendaRepository {

    Tienda obtenerTienda(String nombreTienda);

    void actualizarUbicacion(String nombreTienda, String ubicacion);

    void agregarTienda(TiendaDTO dto);
}
