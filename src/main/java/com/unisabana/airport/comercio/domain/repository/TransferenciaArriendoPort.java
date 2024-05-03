package com.unisabana.airport.comercio.domain.repository;

import com.unisabana.airport.comercio.domain.entity.Tienda;

import java.util.UUID;

public interface TransferenciaArriendoPort {

    UUID guardarTransaccion(Tienda tienda, int valorArriendo);

}
