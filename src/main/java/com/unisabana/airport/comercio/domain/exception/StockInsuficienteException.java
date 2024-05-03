package com.unisabana.airport.comercio.domain.exception;

public class StockInsuficienteException extends RuntimeException{

    public StockInsuficienteException(int stock, int cantidad) {
        super("El inventario tiene " + stock + " , y se quiere vender " + cantidad);
    }

}
