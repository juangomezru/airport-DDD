package com.unisabana.airport.vuelos.application.exception;

public class AvionNoEncontradoException extends RuntimeException {
    public AvionNoEncontradoException(Long idAvion) {
        super("No se encontró el avión con ID: " + idAvion);
    }
}
