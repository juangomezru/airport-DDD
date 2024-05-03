package com.unisabana.airport.vuelos.infrastructure.in.controller;

import com.unisabana.airport.vuelos.application.port.in.CancelarVueloInPort;
import com.unisabana.airport.vuelos.application.port.in.CrearVueloInPort;
import com.unisabana.airport.vuelos.application.port.in.ObtenerTodosVuelosInPort;
import com.unisabana.airport.vuelos.infrastructure.in.dto.VueloCrearDTO;
import com.unisabana.airport.vuelos.infrastructure.out.persistence.orm.VueloORM;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vuelos")
@AllArgsConstructor
public class VueloController {
    private final CrearVueloInPort crearVueloInPort;
    private final CancelarVueloInPort cancelarVueloInPort;
    private final ObtenerTodosVuelosInPort obtenerTodosVuelosInPort;

    @PostMapping("")
    public void crearVuelo(@RequestBody VueloCrearDTO vueloCrearDTO) {
        crearVueloInPort.crearVuelo(vueloCrearDTO.getOrigen(), vueloCrearDTO.getDestino(), vueloCrearDTO.getIdAvion(), vueloCrearDTO.getEstadoVuelo());
    }
    @PutMapping("/{id}")
    public void cancelarVuelo(@PathVariable Long id) {
        cancelarVueloInPort.cancelarVuelo(id);
    }

    @GetMapping("")
    public List<VueloORM> obtenerTodosVuelos() {
        return obtenerTodosVuelosInPort.obtenerTodosVuelos();
    }
}