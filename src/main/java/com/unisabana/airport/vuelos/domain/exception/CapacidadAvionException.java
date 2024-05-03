package com.unisabana.airport.vuelos.domain.exception;

public class CapacidadAvionException extends RuntimeException {
    public CapacidadAvionException() {
        super("No se puede actualizar la capacidad del avión si el destino es Estados Unidos (USA)");
    }
}
