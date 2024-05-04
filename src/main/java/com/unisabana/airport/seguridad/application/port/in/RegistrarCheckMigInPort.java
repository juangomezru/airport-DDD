package com.unisabana.airport.seguridad.application.port.in;

import com.unisabana.airport.seguridad.application.usecase.EquipajeDTO;
import org.springframework.stereotype.Component;

@Component
public interface RegistrarCheckMigInPort {

    void registrarCheckMig(String idPasajero);
}
