package com.unisabana.airport.seguridad.domain.entity;

import com.unisabana.airport.seguridad.application.exception.CheckMigNoCompletado;
import com.unisabana.airport.seguridad.application.exception.ClienteBetadoException;
import com.unisabana.airport.seguridad.domain.exception.PasaporteNoValidoException;
import com.unisabana.airport.seguridad.domain.enums.EstadoPasaporte;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pasajero {
    private String id;
    private String nombre;
    private EstadoPasaporte estadoPasaporte;
    private String visa;
    private boolean isBetado;
    private boolean tieneCheckMig;

    public Pasajero(Pasajero pasajero) {
    }

    public void verificarPasaporte() {
        if (estadoPasaporte == EstadoPasaporte.NO_VALIDO) {
            throw new PasaporteNoValidoException(id);
        }
    }

    public void verificarBetado() {
        if (isBetado) {
            throw new ClienteBetadoException(id);
        }
    }
    public void verificarCheckMig(){
        if(!tieneCheckMig){
            throw new CheckMigNoCompletado(this.id);
        }
    }
}