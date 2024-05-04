package com.unisabana.airport.seguridad.infrastructure.in.controller;

import com.unisabana.airport.seguridad.application.port.in.CrearEquipajeInPort;
import com.unisabana.airport.seguridad.application.usecase.EquipajeDTO;
import com.unisabana.airport.seguridad.infrastructure.in.dto.EquipajeCrearDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/equipajes")
@AllArgsConstructor
public class EquipajeController {
    private final CrearEquipajeInPort equipajeInPort;

    @PostMapping("/crear")
    public void crearEquipaje(@RequestBody EquipajeCrearDTO equipaje){
        EquipajeDTO equipajeDTO = new EquipajeDTO(equipaje.id(), equipaje.peso(),equipaje.idPasajero() ,equipaje.tipoArticulo());
        equipajeInPort.crearEquipaje(equipajeDTO);
    }

}
