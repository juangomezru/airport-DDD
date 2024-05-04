package com.unisabana.airport.seguridad.application.exception;

public class CheckMigNoCompletado extends RuntimeException{
    public CheckMigNoCompletado(String numPasaporte) {
        super("No completó el BioMig para el pasaporte: " + numPasaporte);
    }
}
