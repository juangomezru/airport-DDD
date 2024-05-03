package com.unisabana.airport.vuelos.application.port.in;

import com.unisabana.airport.vuelos.infrastructure.out.persistence.orm.VueloORM;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ObtenerTodosVuelosInPort {
    List<VueloORM> obtenerTodosVuelos();
}
