package com.unisabana.airport.seguridad.application.usecase;

import com.unisabana.airport.seguridad.application.exception.ClienteBetadoException;
import com.unisabana.airport.seguridad.application.port.in.CrearPasajeroInPort;
import com.unisabana.airport.seguridad.domain.entity.Pasajero;
import com.unisabana.airport.seguridad.domain.exception.PasaporteNoValidoException;
import com.unisabana.airport.seguridad.domain.repository.PasajeroRepository;
import org.springframework.stereotype.Service;

@Service
public class CrearPasajeroUseCase implements CrearPasajeroInPort {
    private final PasajeroRepository pasajeroRepository;

    public CrearPasajeroUseCase(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    @Override
    public void crearPasajero(PasajeroDTO dto) {
        try {
            Pasajero pasajero = new Pasajero(dto.id(), dto.nombre(), dto.estadoPasaporte(), dto.visa(), dto.isBetado(),false);
            pasajero.verificarPasaporte();
            pasajeroRepository.agregarPasajero(pasajero);
        } catch (PasaporteNoValidoException e){
            throw new ClienteBetadoException(dto.id());
        }
    }
}