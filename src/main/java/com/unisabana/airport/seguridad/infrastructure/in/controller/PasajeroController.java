package com.unisabana.airport.seguridad.infrastructure.in.controller;

import com.unisabana.airport.seguridad.application.port.in.CrearEquipajeInPort;
import com.unisabana.airport.seguridad.application.port.in.CrearPasajeroInPort;
import com.unisabana.airport.seguridad.application.port.in.RegistrarCheckMigInPort;
import com.unisabana.airport.seguridad.application.usecase.PasajeroDTO;
import com.unisabana.airport.seguridad.infrastructure.in.dto.PasajeroCrearDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pasajeros")
@AllArgsConstructor
public class PasajeroController {

    private final CrearPasajeroInPort pasajeroInPort;
    private final RegistrarCheckMigInPort registrarCheckMigInPort;
    @PostMapping("/crear")
    public void crearPasajero(@RequestBody PasajeroCrearDTO pasajero){
        PasajeroDTO pasajeroDTO = new PasajeroDTO(pasajero.id(), pasajero.nombre(), pasajero.estadoPasaporte(),pasajero.visa(), pasajero.isBetado());
        pasajeroInPort.crearPasajero(pasajeroDTO);
    }
    @PutMapping("/checkmig")
    public void registrarCheckMig(@RequestParam String idPasajero) {
        registrarCheckMigInPort.registrarCheckMig(idPasajero);
    }

}
