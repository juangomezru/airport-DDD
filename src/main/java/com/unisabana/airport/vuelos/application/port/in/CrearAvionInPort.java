package com.unisabana.airport.vuelos.application.port.in;

public interface CrearAvionInPort {
    void crearAvion(Long id, String modelo, int capacidadPasajeros, String aerolinea, String fabricante);
}
