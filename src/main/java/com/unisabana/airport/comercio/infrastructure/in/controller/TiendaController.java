package com.unisabana.airport.comercio.infrastructure.in.controller;

import com.unisabana.airport.comercio.application.port.in.ITiendaManagement;
import com.unisabana.airport.comercio.application.usecase.ComprarDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TiendaController {

    private final ITiendaManagement compra;
    
    public TiendaController(ITiendaManagement compra) {
        this.compra = compra;
    }

    @PostMapping(path = "/tienda/comprar")
    public void comprar(@RequestBody ComprarDTO comprarDTO) {
        compra.comprar(comprarDTO);
    }

}
