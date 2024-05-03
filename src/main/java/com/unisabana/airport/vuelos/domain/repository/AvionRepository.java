package com.unisabana.airport.vuelos.domain.repository;

import com.unisabana.airport.vuelos.domain.entity.Avion;
import com.unisabana.airport.vuelos.infrastructure.out.persistence.orm.AvionORM;

import java.util.List;

public interface AvionRepository {
    Avion guardarAvion(Avion avion, String aerolinea, String fabricante);
    Avion obtenerAvionPorId(Long idAvion);

    List<AvionORM> obtenerTodosVuelos();
}
