package com.unisabana.airport.comercio.infrastructure.in.controller;

import com.unisabana.airport.comercio.application.port.in.IAgregarTienda;
import com.unisabana.airport.comercio.application.port.in.ITiendaManagement;
import com.unisabana.airport.comercio.application.usecase.ComprarDTO;
import com.unisabana.airport.comercio.application.usecase.TiendaDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TiendaController {

    private final ITiendaManagement compra;
    private final IAgregarTienda tienda;
    
    public TiendaController(ITiendaManagement compra, IAgregarTienda tienda) {
        this.compra = compra;
        this.tienda = tienda;
    }

    @PostMapping(path = "/tienda/comprar")
    public void comprar(@RequestBody ComprarDTO comprarDTO) {
        compra.comprar(comprarDTO);
    }

    @PostMapping(path = "/tienda/agregarTienda")
    public void agregarTienda(@RequestBody TiendaDTO dto){
        tienda.agregarTienda(dto);
    }

}
