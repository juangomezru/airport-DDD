package com.unisabana.airport.comercio.domain.entity;

import com.unisabana.airport.comercio.domain.enums.CategoriaTienda;
import com.unisabana.airport.comercio.domain.enums.EstadoTienda;
import com.unisabana.airport.comercio.domain.exception.SaldoNegocioInsuficienteException;
import com.unisabana.airport.comercio.domain.exception.StockInsuficienteException;

public class Tienda {

    private String nombreTienda;

    private CategoriaTienda tipoTienda;

    private String ubicacion;

    private int numProductosStock;

    private int saldoNegocio;

    private EstadoTienda estado = EstadoTienda.PRUEBA;

    private final short NUM_PRODUCTOS_PROVISIONADOS_MENSUALMENTE = 500;

    private final short VALOR_UNITARIO_DE_PRODUCTO = 10_000;

    public Tienda(String nombreTienda, CategoriaTienda tipoTienda, String ubicacion, int numProductosStock, int saldoNegocio) {
        this.nombreTienda = nombreTienda;
        this.tipoTienda = tipoTienda;
        this.ubicacion = ubicacion;
        this.numProductosStock = numProductosStock;
        this.saldoNegocio = saldoNegocio;
    }

    public void vender(int cantidad) {
        if(numProductosStock < cantidad) {
            throw new StockInsuficienteException(numProductosStock, cantidad);
        }
        numProductosStock -= cantidad;
        saldoNegocio += cantidad * VALOR_UNITARIO_DE_PRODUCTO;
    }

    public void pagarArriendo(int valorArriendo) {
        if (saldoNegocio < valorArriendo) {
            throw new SaldoNegocioInsuficienteException(valorArriendo, saldoNegocio);
        }
        saldoNegocio -= valorArriendo;
        estado= EstadoTienda.ACTIVA;
    }

    public void considerarContinuidad( int numProductosVendidosMes) {

        if (numProductosStock > numProductosVendidosMes && numProductosStock > NUM_PRODUCTOS_PROVISIONADOS_MENSUALMENTE * 0.9) {
            System.out.println("Como Negocio nos encontramos buscando Solucion...");
            estado = EstadoTienda.DESACTIVADA;
        }else {
            System.out.println("Seguimos en funcionamiento comun y corriente, hasta el proximo mes");
        }
    }

    public void provisionarStock(){
        if (numProductosStock <= NUM_PRODUCTOS_PROVISIONADOS_MENSUALMENTE * 0.4) {
            numProductosStock += NUM_PRODUCTOS_PROVISIONADOS_MENSUALMENTE;
        }
    }

    public EstadoTienda getEstado() {
        return estado;
    }

    public void setEstado(EstadoTienda estado) {
        this.estado = estado;
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
}
