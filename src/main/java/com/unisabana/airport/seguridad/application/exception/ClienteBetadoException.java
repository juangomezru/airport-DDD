package com.unisabana.airport.seguridad.application.exception;

public class ClienteBetadoException extends RuntimeException {
    public ClienteBetadoException(String idCliente) {
        super("El cliente con ID: " + idCliente + " ha sido vetado");
    }
}