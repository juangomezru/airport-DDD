package com.unisabana.airport.seguridad.domain.exception;

public class PasaporteNoValidoException extends RuntimeException{
    public PasaporteNoValidoException(String numeroPasaporte) {
        super("El pasaporte número: " + numeroPasaporte + "no se encuentra habilitado para viajar");
    }
}
