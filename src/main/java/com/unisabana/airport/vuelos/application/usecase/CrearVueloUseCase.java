package com.unisabana.airport.vuelos.application.usecase;

import com.unisabana.airport.vuelos.application.exception.AvionNoEncontradoException;
import com.unisabana.airport.vuelos.application.port.in.CrearVueloInPort;
import com.unisabana.airport.vuelos.application.port.out.CrearVueloOutPort;
import com.unisabana.airport.vuelos.domain.entity.Avion;
import com.unisabana.airport.vuelos.domain.entity.Vuelo;
import com.unisabana.airport.vuelos.domain.enums.EstadoVuelo;
import com.unisabana.airport.vuelos.domain.repository.AvionRepository;
import com.unisabana.airport.vuelos.domain.repository.VueloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrearVueloUseCase implements CrearVueloInPort, CrearVueloOutPort {

    private final VueloRepository vueloRepository;
    private final AvionRepository avionRepository;

    @Override
    public void crearVuelo(String origen, String destino, Long idAvion, EstadoVuelo estadoVuelo) {
        Avion avion = avionRepository.obtenerAvionPorId(idAvion);

        if (avion == null) {
            throw new AvionNoEncontradoException(idAvion);
        }

        int capacidad = avion.getCapacidadPasajeros();
        if (estadoVuelo == null) {
            estadoVuelo = EstadoVuelo.PROGRAMADO;
        }

        Vuelo vuelo = new Vuelo();
        vuelo.setOrigen(origen);
        vuelo.setDestino(destino);
        vuelo.setCantidadPasajeros(capacidad);
        vuelo.setAvion(avion);
        vuelo.setEstado(estadoVuelo);

        vueloRepository.guardarVuelo(vuelo);
        vueloCreado();
    }

    @Override
    public void vueloCreado() {
        System.out.println("El vuelo ha sido creado");
    }
}
