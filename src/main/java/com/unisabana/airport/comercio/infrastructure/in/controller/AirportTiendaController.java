package com.unisabana.airport.comercio.infrastructure.in.controller;

import com.unisabana.airport.comercio.application.port.in.IAgregarTienda;
import com.unisabana.airport.comercio.application.port.in.ICobrarArriendoMensual;
import com.unisabana.airport.comercio.application.port.in.IReubicarTienda;
import com.unisabana.airport.comercio.application.usecase.TiendaDTO;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirportTiendaController {

    private final ICobrarArriendoMensual cobrarArriendoMensual;
    private final IReubicarTienda reubicarTienda;
    private final IAgregarTienda agregarTienda;


    public AirportTiendaController(ICobrarArriendoMensual cobrarArriendoMensual, IReubicarTienda reubicarTienda, IAgregarTienda agregarTienda) {
        this.cobrarArriendoMensual = cobrarArriendoMensual;
        this.reubicarTienda = reubicarTienda;
        this.agregarTienda = agregarTienda;
    }

    @PutMapping("/aeropuertoSeguimiento/reubicarTienda")
    public void reubicarTienda(@RequestParam String nombreTienda) {
        reubicarTienda.reubicarTienda(nombreTienda);
    }

    @PostMapping("/aeropuertoSeguimiento/cobrarArriendo")
    public void cobrarArriendoMensual(@RequestParam String nombreTienda) {
        cobrarArriendoMensual.cobrarArriendoMensual(nombreTienda);
    }

    @PostMapping("/aeropuertoSeguimiento/agregarTienda")
    public void cobrarArriendoMensual(@RequestBody TiendaDTO dto) {
        agregarTienda.agregarTienda(dto);
    }

}
