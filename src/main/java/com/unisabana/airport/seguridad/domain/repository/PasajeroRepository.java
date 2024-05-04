package com.unisabana.airport.seguridad.domain.repository;

import com.unisabana.airport.seguridad.domain.entity.Pasajero;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository {
    Pasajero obtenerPasajero(String id);
    void agregarPasajero(Pasajero pasajero);
    void eliminarPasajero(String id);

}