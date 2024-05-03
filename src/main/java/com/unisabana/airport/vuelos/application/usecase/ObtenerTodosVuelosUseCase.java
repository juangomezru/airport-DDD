package com.unisabana.airport.vuelos.application.usecase;

import com.unisabana.airport.vuelos.application.port.in.ObtenerTodosVuelosInPort;
import com.unisabana.airport.vuelos.domain.repository.VueloRepository;
import com.unisabana.airport.vuelos.infrastructure.out.persistence.orm.VueloORM;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ObtenerTodosVuelosUseCase implements ObtenerTodosVuelosInPort {
    private final VueloRepository vueloRepository;

    @Override
    public List<VueloORM> obtenerTodosVuelos() {
        return vueloRepository.obtenerTodosVuelos();
    }
}
