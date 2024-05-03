package com.unisabana.airport.vuelos.application.usecase;

import com.unisabana.airport.vuelos.application.port.in.CrearAvionInPort;
import com.unisabana.airport.vuelos.domain.entity.Avion;
import com.unisabana.airport.vuelos.domain.repository.AvionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CrearAvionUseCase implements CrearAvionInPort {
    private final AvionRepository avionRepository;


    @Override
    public void crearAvion(Long id, String modelo, int capacidadPasajeros, String aerolinea, String fabricante) {
        Avion avion = new Avion();
        avion.setId(id);
        avion.setModelo(modelo);
        avion.setCapacidadPasajeros(capacidadPasajeros);
        avionRepository.guardarAvion(avion, aerolinea, fabricante);
    }
}
