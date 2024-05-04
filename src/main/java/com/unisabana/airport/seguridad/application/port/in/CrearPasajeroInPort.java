package com.unisabana.airport.seguridad.application.port.in;

import com.unisabana.airport.seguridad.application.usecase.PasajeroDTO;
import com.unisabana.airport.seguridad.domain.enums.EstadoPasaporte;
import org.springframework.stereotype.Component;


public interface CrearPasajeroInPort {
    void crearPasajero(PasajeroDTO dto);
}