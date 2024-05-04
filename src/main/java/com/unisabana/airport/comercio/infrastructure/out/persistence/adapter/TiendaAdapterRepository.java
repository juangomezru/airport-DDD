package com.unisabana.airport.comercio.infrastructure.out.persistence.adapter;

import com.unisabana.airport.comercio.application.usecase.TiendaDTO;
import com.unisabana.airport.comercio.domain.entity.Tienda;
import com.unisabana.airport.comercio.domain.enums.EstadoTienda;
import com.unisabana.airport.comercio.domain.repository.TiendaRepository;
import com.unisabana.airport.comercio.infrastructure.out.persistence.adapter.repository.TiendaJPARepository;
import com.unisabana.airport.comercio.infrastructure.out.persistence.orm.TiendaORM;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TiendaAdapterRepository implements TiendaRepository {

    private final TiendaJPARepository tiendaJPARepository;

    public TiendaAdapterRepository(TiendaJPARepository tiendaJPARepository) {
        this.tiendaJPARepository = tiendaJPARepository;
    }

    @Override
    public Tienda obtenerTienda(String nombreTienda) {
        Optional<TiendaORM> optionalTiendaORM = tiendaJPARepository.findByNombreTienda(nombreTienda);
        return optionalTiendaORM.map(TiendaORM::convertToModel).orElse(null);
    }

    @Override
    public void actualizarUbicacion(String nombreTienda, String ubicacion) {
        Optional<TiendaORM> optionalCuentaORM = tiendaJPARepository.findByNombreTienda(nombreTienda);
        optionalCuentaORM.ifPresent(TiendaORM -> {
            TiendaORM.setUbicacion("Ubi_actualizada");
            tiendaJPARepository.save(TiendaORM);
        });
    }

    @Override
    public void agregarTienda(TiendaDTO dto) {
        EstadoTienda estado = EstadoTienda.PRUEBA;
        Date fecha = new Date();

        TiendaORM orm = new TiendaORM();

        orm.setNombreTienda(dto.nombreTienda());
        orm.setTipoTienda(dto.tipoTienda());
        orm.setUbicacion(dto.ubicacion());
        orm.setNumProductosStock(dto.numProductosStock());
        orm.setSaldoNegocio(dto.saldoNegocio());
        orm.setEstado(estado);
        orm.setFechaInicioTienda(fecha);

        tiendaJPARepository.save(orm);
    }
}
