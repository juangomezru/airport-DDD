package com.unisabana.airport.vuelos.application.port.in;

import com.unisabana.airport.vuelos.domain.enums.EstadoVuelo;
import org.springframework.stereotype.Component;

@Component
public interface CrearVueloInPort {
    void crearVuelo(String origen, String destino, Long idAvion, EstadoVuelo estadoVuelo);
}