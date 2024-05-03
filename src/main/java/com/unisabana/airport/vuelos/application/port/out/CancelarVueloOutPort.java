package com.unisabana.airport.vuelos.application.port.out;

import org.springframework.stereotype.Component;

@Component
public interface CancelarVueloOutPort {
    void vueloCancelado(Long idVuelo);
}
