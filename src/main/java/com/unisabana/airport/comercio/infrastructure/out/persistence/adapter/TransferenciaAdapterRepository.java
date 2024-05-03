package com.unisabana.airport.comercio.infrastructure.out.persistence.adapter;

import com.unisabana.airport.comercio.domain.entity.Tienda;
import com.unisabana.airport.comercio.domain.repository.TransferenciaArriendoPort;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TransferenciaAdapterRepository implements TransferenciaArriendoPort {
    @Override
    public UUID guardarTransaccion(Tienda tienda, int valorArriendo) {
        return UUID.randomUUID();
    }
}
