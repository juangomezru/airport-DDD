package com.unisabana.airport.vuelos.application.port.in;

import org.springframework.stereotype.Component;

@Component
public interface CancelarVueloInPort {
    void cancelarVuelo(Long idVuelo);
}