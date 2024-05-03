package com.unisabana.airport.vuelos.infrastructure.out.persistence.adapter;

import com.unisabana.airport.vuelos.domain.entity.Avion;
import com.unisabana.airport.vuelos.domain.repository.AvionRepository;
import com.unisabana.airport.vuelos.infrastructure.out.persistence.adapter.repository.AvionJPARepository;
import com.unisabana.airport.vuelos.infrastructure.out.persistence.orm.AvionORM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AvionAdapterRepositrory implements AvionRepository {
    private final AvionJPARepository avionJPARepository;
    @Override
    public Avion guardarAvion(Avion avion, String aerolinea, String fabricante) {
        AvionORM avionORM = new AvionORM();
        avionORM.setId(avion.getId());
        avionORM.setModelo(avion.getModelo());
        avionORM.setCapacidadPasajeros(avion.getCapacidadPasajeros());
        avionORM.setAerolinea(aerolinea);
        avionORM.setFabricante(fabricante);
        avionJPARepository.save(avionORM);
        return avion;
    }

    @Override
    public Avion obtenerAvionPorId(Long idAvion) {
        AvionORM avionORM = avionJPARepository.findById(idAvion).orElse(null);
        if (avionORM == null) {
            return null;
        }
        Avion avion = new Avion();
        avion.setId(avionORM.getId());
        avion.setModelo(avionORM.getModelo());
        avion.setCapacidadPasajeros(avionORM.getCapacidadPasajeros());
        return avion;
    }

    @Override
    public List<AvionORM> obtenerTodosVuelos() {
        return avionJPARepository.findAll();
    }

}
