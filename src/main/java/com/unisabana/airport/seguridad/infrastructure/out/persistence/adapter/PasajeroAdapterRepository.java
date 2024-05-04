package com.unisabana.airport.seguridad.infrastructure.out.persistence.adapter;

import com.unisabana.airport.seguridad.domain.entity.Pasajero;
import com.unisabana.airport.seguridad.domain.repository.PasajeroRepository;
import com.unisabana.airport.seguridad.infrastructure.out.persistence.adapter.repository.PasajeroJPARepository;
import com.unisabana.airport.seguridad.infrastructure.out.persistence.orm.PasajeroORM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PasajeroAdapterRepository implements PasajeroRepository {
    private final PasajeroJPARepository repo;

    @Override
    public Pasajero obtenerPasajero(String id) {
        PasajeroORM pasajero = repo.findById(id).orElse(null);
        assert pasajero != null;
        return new Pasajero(pasajero.getId(), pasajero.getNombre(), pasajero.getEstadoPasaporte(), pasajero.getVisa(), pasajero.isBetado(), pasajero.isTieneCheckMig());
    }

    @Override
    public void agregarPasajero(Pasajero pasajero) {
        PasajeroORM pasajeroORM = new PasajeroORM();
        pasajeroORM.setId(pasajero.getId());
        pasajeroORM.setNombre(pasajero.getNombre());
        pasajeroORM.setEstadoPasaporte(pasajero.getEstadoPasaporte());
        pasajeroORM.setVisa(pasajero.getVisa());
        pasajeroORM.setBetado(pasajero.isBetado());
        pasajeroORM.setTieneCheckMig(pasajero.isTieneCheckMig());
        repo.save(pasajeroORM);

    }


    @Override
    public void eliminarPasajero(String id) {
        repo.deleteById(id);
    }
}
