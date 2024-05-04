package com.unisabana.airport.seguridad.domain.repository;

import com.unisabana.airport.seguridad.domain.entity.Equipaje;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipajeRepository {
    Equipaje obtenerEquipaje(String id);
    void agregarEquipaje(Equipaje equipaje);
}