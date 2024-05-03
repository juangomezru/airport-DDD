package com.unisabana.airport.comercio.infrastructure.out.persistence.orm;

import com.unisabana.airport.comercio.domain.entity.Tienda;
import com.unisabana.airport.comercio.domain.enums.CategoriaTienda;
import com.unisabana.airport.comercio.domain.enums.EstadoTienda;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class TiendaORM {
    @Id
    @Column
    private String nombreTienda;

    @Column
    private CategoriaTienda tipoTienda;

    @Column
    private String ubicacion;

    @Column
    private int numProductosStock;

    @Column
    private int saldoNegocio;

    @Column
    private EstadoTienda estado;

    @Column
    private Date fechaUltimaModificacion;

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public CategoriaTienda getTipoTienda() {
        return tipoTienda;
    }

    public void setTipoTienda(CategoriaTienda tipoTienda) {
        this.tipoTienda = tipoTienda;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNumProductosStock() {
        return numProductosStock;
    }

    public void setNumProductosStock(int numProductosStock) {
        this.numProductosStock = numProductosStock;
    }

    public int getSaldoNegocio() {
        return saldoNegocio;
    }

    public void setSaldoNegocio(int saldoNegocio) {
        this.saldoNegocio = saldoNegocio;
    }

    public EstadoTienda getEstado() {
        return estado;
    }

    public void setEstado(EstadoTienda estado) {
        this.estado = estado;
    }

    public Date getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public Tienda convertToModel() {
        return new Tienda(this.nombreTienda, this.tipoTienda, this.ubicacion, this.numProductosStock, this.saldoNegocio);
    }



}
