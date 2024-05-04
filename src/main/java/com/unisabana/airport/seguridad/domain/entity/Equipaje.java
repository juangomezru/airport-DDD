package com.unisabana.airport.seguridad.domain.entity;

import com.unisabana.airport.seguridad.domain.enums.TipoArticulo;
import com.unisabana.airport.seguridad.domain.exception.ArticuloProhibidoException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipaje {
    private String id;
    private double peso;
    private Pasajero pasajero;
    private TipoArticulo tipoArticulo;



    public void verificarArticulo(TipoArticulo tipoArticulo) {
        if (this.tipoArticulo == TipoArticulo.PROHIBIDO) {
            throw new ArticuloProhibidoException(this.tipoArticulo.name());
        }
    }
}