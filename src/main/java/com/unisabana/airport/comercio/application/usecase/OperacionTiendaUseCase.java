package com.unisabana.airport.comercio.application.usecase;

import com.unisabana.airport.comercio.application.port.in.ITiendaManagement;
import com.unisabana.airport.comercio.domain.entity.Tienda;
import com.unisabana.airport.comercio.domain.exception.StockInsuficienteException;
import com.unisabana.airport.comercio.domain.repository.TiendaRepository;
import org.springframework.stereotype.Service;

@Service
public class OperacionTiendaUseCase implements ITiendaManagement {

    private final TiendaRepository tiendaRepository;

    private final short AEROPUERTO_MANAGEMENT_PRECIO_POR_PRODUCTO = 500;

    private final short VENTAS_PROMEDIO_MES_PASADO = 300;

    public OperacionTiendaUseCase(TiendaRepository tiendaRepository) {
        this.tiendaRepository = tiendaRepository;
    }

    @Override
    public void comprar(ComprarDTO dto) {
        Tienda tienda = tiendaRepository.obtenerTienda(dto.nombreTienda());
        try {
            tienda.vender(dto.cantidad());
        } catch (StockInsuficienteException e) {
            manejarInventarioTienda(tienda);
        }
    }

    @Override
    public void manejarInventarioTienda(Tienda tienda) {

        int productosActules = tienda.getNumProductosStock(), productosNuevos, costoInventario;

        tienda.provisionarStock();

        productosNuevos = tienda.getNumProductosStock() - productosActules;

        costoInventario = productosNuevos * AEROPUERTO_MANAGEMENT_PRECIO_POR_PRODUCTO;

        if (costoInventario > tienda.getSaldoNegocio()*0.2) {
            tienda.considerarContinuidad(VENTAS_PROMEDIO_MES_PASADO);
        }

    }

}
