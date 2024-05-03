package com.unisabana.airport.vuelos.application.exception;

public class VueloNoEncontradoException extends RuntimeException {
    public VueloNoEncontradoException(Long idVuelo) {
        super("No se encontró el vuelo con ID: " + idVuelo);
    }
}