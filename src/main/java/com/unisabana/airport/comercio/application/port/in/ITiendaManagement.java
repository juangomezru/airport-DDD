package com.unisabana.airport.comercio.application.port.in;

import com.unisabana.airport.comercio.application.usecase.ComprarDTO;
import com.unisabana.airport.comercio.domain.entity.Tienda;

public interface ITiendaManagement {

    void comprar(ComprarDTO dto);

    void manejarInventarioTienda(Tienda tienda);

}
