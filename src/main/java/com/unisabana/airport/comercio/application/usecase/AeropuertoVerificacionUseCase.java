package com.unisabana.airport.comercio.application.usecase;

import com.unisabana.airport.comercio.application.exception.TiendaNoExisteException;
import com.unisabana.airport.comercio.application.exception.TiendaPagoArriendoException;
import com.unisabana.airport.comercio.application.port.in.ICobrarArriendoMensual;
import com.unisabana.airport.comercio.application.port.in.ILiberarLocalTienda;
import com.unisabana.airport.comercio.application.port.in.IReubicarTienda;
import com.unisabana.airport.comercio.domain.entity.Tienda;
import com.unisabana.airport.comercio.domain.enums.EstadoTienda;
import com.unisabana.airport.comercio.domain.exception.SaldoNegocioInsuficienteException;
import com.unisabana.airport.comercio.domain.repository.TiendaRepository;
import com.unisabana.airport.comercio.domain.repository.TransferenciaArriendoPort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AeropuertoVerificacionUseCase implements ILiberarLocalTienda, ICobrarArriendoMensual, IReubicarTienda {

    private final List<String> UBICACIONES_DISPONIBLES = new ArrayList<>(List.of("A-100","A-201","A-090", "A-039", "A-045"));
    private final int ARRIENDO_MENSUAL = 1_500_000;
    private final TiendaRepository tiendaRepository;
    private final TransferenciaArriendoPort transferencia;

    public AeropuertoVerificacionUseCase(TiendaRepository tiendaRepository, TransferenciaArriendoPort transferencia) {
        this.tiendaRepository = tiendaRepository;
        this.transferencia = transferencia;
    }

    @Override
    public void liberarLocalTienda(String nombreTienda) {

        Tienda tienda = tiendaRepository.obtenerTienda(nombreTienda);

        if (EstadoTienda.DESACTIVADA.equals(tienda.getEstado())) {
            tiendaRepository.actualizarUbicacion(nombreTienda, "Desalojada");
        }

    }

    @Override
    public void cobrarArriendoMensual(String nombreTienda) {
        Tienda tienda = tiendaRepository.obtenerTienda(nombreTienda);
        try {
            tienda.pagarArriendo(ARRIENDO_MENSUAL);
            transferencia.guardarTransaccion(tienda, ARRIENDO_MENSUAL);
        } catch (SaldoNegocioInsuficienteException e){

            throw new TiendaPagoArriendoException(nombreTienda);

        }catch (TiendaPagoArriendoException e){

            tienda.setEstado(EstadoTienda.DESACTIVADA);
            liberarLocalTienda(nombreTienda);

        }
    }

    @Override
    public void reubicarTienda(String nombreTienda) {
        Tienda tienda = tiendaRepository.obtenerTienda(nombreTienda);

        if (EstadoTienda.DESACTIVADA.equals(tienda.getEstado())) {
            throw new TiendaNoExisteException(nombreTienda);
        }

        int indice = (int) (Math.random() * 10);

        tienda.setUbicacion(UBICACIONES_DISPONIBLES.get(indice));

        UBICACIONES_DISPONIBLES.remove(indice);

    }
}
