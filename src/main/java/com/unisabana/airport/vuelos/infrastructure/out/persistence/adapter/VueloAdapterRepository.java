package com.unisabana.airport.vuelos.infrastructure.out.persistence.adapter;

import com.unisabana.airport.vuelos.domain.entity.Vuelo;
import com.unisabana.airport.vuelos.domain.repository.VueloRepository;
import com.unisabana.airport.vuelos.infrastructure.out.persistence.adapter.repository.AvionJPARepository;
import com.unisabana.airport.vuelos.infrastructure.out.persistence.adapter.repository.VueloJPARepository;
import com.unisabana.airport.vuelos.infrastructure.out.persistence.orm.VueloORM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class VueloAdapterRepository implements VueloRepository {
    private final VueloJPARepository vueloJPARepository;
    private final AvionJPARepository avionJPARepository;
    @Override
    public Vuelo guardarVuelo(Vuelo vuelo) {
        VueloORM vueloORM = new VueloORM();
        vueloORM.setId(vuelo.getId());
        vueloORM.setOrigen(vuelo.getOrigen());
        vueloORM.setDestino(vuelo.getDestino());
        vueloORM.setCapacidad(vuelo.getCantidadPasajeros());
        vueloORM.setEstadoVuelo(vuelo.getEstado());
        vueloORM.setAvion(avionJPARepository.findById(vuelo.getAvion().getId()).orElse(null));
        vueloJPARepository.save(vueloORM);
        return vuelo;
    }


    @Override
    public Vuelo obtenerVueloPorId(Long idVuelo) {
        VueloORM vueloORM = vueloJPARepository.findById(idVuelo).orElse(null);
        if (vueloORM == null) {
            return null;
        }
        Vuelo vuelo = new Vuelo();
        vuelo.setId(vueloORM.getId());
        vuelo.setOrigen(vueloORM.getOrigen());
        vuelo.setDestino(vueloORM.getDestino());
        vuelo.setCantidadPasajeros(vueloORM.getCapacidad());
        return vuelo;
    }

    @Override
    public List<VueloORM> obtenerTodosVuelos() {
        return vueloJPARepository.findAll();
    }
}
