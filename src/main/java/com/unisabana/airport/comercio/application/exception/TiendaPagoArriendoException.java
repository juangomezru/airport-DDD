package com.unisabana.airport.comercio.application.exception;

public class TiendaPagoArriendoException extends RuntimeException{

    public TiendaPagoArriendoException(String nombreTienda) {
        super("No se registra pago del arriendo de esta tienda:" + nombreTienda);
    }

}
