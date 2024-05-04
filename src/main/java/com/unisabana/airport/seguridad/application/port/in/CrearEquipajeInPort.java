package com.unisabana.airport.seguridad.application.port.in;

import com.unisabana.airport.seguridad.application.usecase.EquipajeDTO;
import com.unisabana.airport.seguridad.domain.enums.TipoArticulo;
import org.springframework.stereotype.Component;

public interface CrearEquipajeInPort {
    void crearEquipaje(EquipajeDTO dto);
}