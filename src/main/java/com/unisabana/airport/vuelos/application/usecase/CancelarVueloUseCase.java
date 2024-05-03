package com.unisabana.airport.vuelos.application.usecase;

import com.unisabana.airport.vuelos.application.exception.VueloNoEncontradoException;
import com.unisabana.airport.vuelos.application.port.in.CancelarVueloInPort;
import com.unisabana.airport.vuelos.application.port.out.CancelarVueloOutPort;
import com.unisabana.airport.vuelos.domain.entity.Vuelo;
import com.unisabana.airport.vuelos.domain.enums.EstadoVuelo;
import com.unisabana.airport.vuelos.domain.repository.VueloRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CancelarVueloUseCase implements CancelarVueloInPort, CancelarVueloOutPort {

    private final VueloRepository vueloRepository;

    @Override
    public void cancelarVuelo(Long idVuelo) {
        try {
            Vuelo vuelo = vueloRepository.obtenerVueloPorId(idVuelo);
            vuelo.setEstado(EstadoVuelo.CANCELADO);
            vueloCancelado(idVuelo);
        } catch (VueloNoEncontradoException e){
            throw new VueloNoEncontradoException(idVuelo);
        }
    }

    @Override
    public void vueloCancelado(Long idVuelo) {
        System.out.println("El vuelo " + idVuelo + "ha sido cancelado");
    }
}