package com.unisabana.airport.seguridad.domain.exception;

public class ArticuloProhibidoException extends RuntimeException {
    public ArticuloProhibidoException(String nombreArticulo) {
        super("El artículo: " + nombreArticulo + " está prohibido");
    }
}
