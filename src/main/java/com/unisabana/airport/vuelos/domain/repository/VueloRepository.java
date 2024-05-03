package com.unisabana.airport.vuelos.domain.repository;

import com.unisabana.airport.vuelos.domain.entity.Vuelo;
import com.unisabana.airport.vuelos.infrastructure.out.persistence.orm.VueloORM;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VueloRepository {
    Vuelo guardarVuelo(Vuelo vuelo);
    Vuelo obtenerVueloPorId(Long idVuelo);
    List<VueloORM> obtenerTodosVuelos();
}
