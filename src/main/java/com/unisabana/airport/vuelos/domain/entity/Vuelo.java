package com.unisabana.airport.vuelos.domain.entity;

import com.unisabana.airport.vuelos.domain.enums.EstadoVuelo;
import com.unisabana.airport.vuelos.domain.exception.CapacidadAvionException;
import com.unisabana.airport.vuelos.domain.exception.VueloCanceladoException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vuelo {
    private Long id;
    private String origen;
    private String destino;
    private int cantidadPasajeros;
    private Avion avion;
    private EstadoVuelo estado;

    public boolean estaLleno() {
        return cantidadPasajeros - 1 == avion.getCapacidadPasajeros();
    }

    public void verificarCancelado() {
        if (EstadoVuelo.CANCELADO.equals(estado)) {
            throw new VueloCanceladoException(this.id);
        }
    }

    public void actualizarCapacidadAvion() {

        if (destino.equalsIgnoreCase("USA")) {
            throw new CapacidadAvionException();
        } else {
            this.cantidadPasajeros --;
            System.out.println("La capacidad del avión ha sido actualizada.");
        }
    }
}
