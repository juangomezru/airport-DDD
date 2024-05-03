package com.unisabana.airport.comercio.infrastructure.in.controller;

import com.unisabana.airport.comercio.application.port.in.ICobrarArriendoMensual;
import com.unisabana.airport.comercio.application.port.in.ILiberarLocalTienda;
import com.unisabana.airport.comercio.application.port.in.IReubicarTienda;
import org.springframework.web.bind.annotation.*;

@RestController
public class AirportTiendaController {

    private final ICobrarArriendoMensual cobrarArriendoMensual;
    private final IReubicarTienda reubicarTienda;


    public AirportTiendaController(ICobrarArriendoMensual cobrarArriendoMensual, IReubicarTienda reubicarTienda) {
        this.cobrarArriendoMensual = cobrarArriendoMensual;
        this.reubicarTienda = reubicarTienda;
    }

    @PutMapping("/aeropuertoSeguimiento/reubicarTienda")
    public void reubicarTienda(@RequestParam String nombreTienda) {
        reubicarTienda.reubicarTienda(nombreTienda);
    }

    @PostMapping("/aeropuertoSeguimiento/cobrarArriendo")
    public void cobrarArriendoMensual(@RequestParam String nombreTienda) {
        cobrarArriendoMensual.cobrarArriendoMensual(nombreTienda);
    }

}
