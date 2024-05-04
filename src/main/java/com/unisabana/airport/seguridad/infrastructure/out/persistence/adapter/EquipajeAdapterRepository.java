package com.unisabana.airport.seguridad.infrastructure.out.persistence.adapter;

import com.unisabana.airport.seguridad.domain.entity.Equipaje;
import com.unisabana.airport.seguridad.domain.entity.Pasajero;
import com.unisabana.airport.seguridad.domain.repository.EquipajeRepository;
import com.unisabana.airport.seguridad.infrastructure.out.persistence.adapter.repository.EquipajeJPARepository;
import com.unisabana.airport.seguridad.infrastructure.out.persistence.orm.EquipajeORM;
import com.unisabana.airport.seguridad.infrastructure.out.persistence.orm.PasajeroORM;
import com.unisabana.airport.vuelos.infrastructure.out.persistence.adapter.repository.AvionJPARepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EquipajeAdapterRepository implements EquipajeRepository {
    private final EquipajeJPARepository repo;
    @Override
    public Equipaje obtenerEquipaje(String id) {
        EquipajeORM equipaje=repo.findById(id).orElse(null);
        assert equipaje != null;
        return new Equipaje(equipaje.getId(),equipaje.getPeso(),equipaje.getPasajero(),equipaje.getTipoArticulo());
    }

    @Override
    public void agregarEquipaje(Equipaje equipaje) {
        EquipajeORM equipajeORM = new EquipajeORM();
        equipajeORM.setId(equipaje.getId());
        equipajeORM.setPeso(equipaje.getPeso());
        equipajeORM.setPasajero(new Pasajero(equipaje.getPasajero()));
        equipajeORM.setTipoArticulo(equipaje.getTipoArticulo());
        repo.save(equipajeORM);
    }

}
