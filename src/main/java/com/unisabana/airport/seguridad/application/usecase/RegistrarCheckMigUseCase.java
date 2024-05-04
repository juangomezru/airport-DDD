package com.unisabana.airport.seguridad.application.usecase;

import com.unisabana.airport.seguridad.application.exception.CheckMigNoCompletado;
import com.unisabana.airport.seguridad.application.port.in.RegistrarCheckMigInPort;
import com.unisabana.airport.seguridad.domain.entity.Pasajero;
import com.unisabana.airport.seguridad.domain.exception.PasaporteNoValidoException;
import com.unisabana.airport.seguridad.domain.repository.PasajeroRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrarCheckMigUseCase implements RegistrarCheckMigInPort {
    private final PasajeroRepository pasajeroRepository;

    public RegistrarCheckMigUseCase(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    @Override
    public void registrarCheckMig(String idPasajero) {
        try {
            Pasajero pasajero = pasajeroRepository.obtenerPasajero(idPasajero);
            pasajero.verificarCheckMig();
        } catch (CheckMigNoCompletado e) {
            throw new PasaporteNoValidoException(idPasajero);
        }
    }
}