package com.unisabana.airport.seguridad.application.usecase;

import com.unisabana.airport.seguridad.application.exception.ClienteBetadoException;
import com.unisabana.airport.seguridad.application.port.in.CrearEquipajeInPort;
import com.unisabana.airport.seguridad.domain.entity.Equipaje;
import com.unisabana.airport.seguridad.domain.entity.Pasajero;
import com.unisabana.airport.seguridad.domain.exception.ArticuloProhibidoException;
import com.unisabana.airport.seguridad.domain.repository.EquipajeRepository;
import com.unisabana.airport.seguridad.domain.repository.PasajeroRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrearEquipajeUseCase implements CrearEquipajeInPort {
    private final EquipajeRepository equipajeRepository;
    private final PasajeroRepository pasajeroRepository;

    @Override
    public void crearEquipaje(EquipajeDTO dto) {
        try {
            Pasajero pasajero = pasajeroRepository.obtenerPasajero(dto.idPasajero());
            Equipaje equipaje = new Equipaje(dto.id(), dto.peso(), pasajero, dto.tipoArticulo());
            equipaje.verificarArticulo(equipaje.getTipoArticulo());
            equipajeRepository.agregarEquipaje(equipaje);
        } catch (ArticuloProhibidoException e){
            throw new ClienteBetadoException(dto.idPasajero());
        }

    }
}