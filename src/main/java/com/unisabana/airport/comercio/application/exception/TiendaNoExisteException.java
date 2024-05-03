package com.unisabana.airport.comercio.application.exception;

public class TiendaNoExisteException extends RuntimeException{

    public TiendaNoExisteException(String nombreTienda) {
        super("La tienda " + nombreTienda + ", no se encuentra en los registros de los E-comerce del aeropuerto");
    }

}
