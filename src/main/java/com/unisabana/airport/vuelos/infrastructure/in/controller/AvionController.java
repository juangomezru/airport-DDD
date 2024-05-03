package com.unisabana.airport.vuelos.infrastructure.in.controller;

import com.unisabana.airport.vuelos.application.port.in.CrearAvionInPort;
import com.unisabana.airport.vuelos.infrastructure.in.dto.AvionCrearDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/aviones")
@AllArgsConstructor
public class AvionController {
    private final CrearAvionInPort crearAvionInPort;

    @PostMapping("")
    public void crearAvion(@RequestBody AvionCrearDTO avionCrearDTO) {
        crearAvionInPort.crearAvion(avionCrearDTO.getId(), avionCrearDTO.getModelo(), avionCrearDTO.getCapacidadPasajeros(), avionCrearDTO.getAerolinea(), avionCrearDTO.getFabricante());
    }
}