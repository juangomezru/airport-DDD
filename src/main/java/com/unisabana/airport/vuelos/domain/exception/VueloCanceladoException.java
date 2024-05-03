package com.unisabana.airport.vuelos.domain.exception;

public class VueloCanceladoException extends RuntimeException{
    public VueloCanceladoException(Long id){
        super("El vuelo con Id: " + id + "está cancelado");
    }
}
