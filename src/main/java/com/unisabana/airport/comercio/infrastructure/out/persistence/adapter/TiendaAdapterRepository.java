package com.unisabana.airport.comercio.infrastructure.out.persistence.adapter;

import com.unisabana.airport.comercio.domain.entity.Tienda;
import com.unisabana.airport.comercio.domain.repository.TiendaRepository;
import com.unisabana.airport.comercio.infrastructure.out.persistence.adapter.repository.TiendaJPARepository;
import com.unisabana.airport.comercio.infrastructure.out.persistence.orm.TiendaORM;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TiendaAdapterRepository implements TiendaRepository {

    private final TiendaJPARepository tiendaJPARepository;

    public TiendaAdapterRepository(TiendaJPARepository tiendaJPARepository) {
        this.tiendaJPARepository = tiendaJPARepository;
    }

    @Override
    public Tienda obtenerTienda(String nombreTienda) {
        Optional<TiendaORM> optionalTiendaORM = tiendaJPARepository.findByNombre(nombreTienda);
        return optionalTiendaORM.map(TiendaORM::convertToModel).orElse(null);
    }

    @Override
    public void actualizarUbicacion(String nombreTienda, String ubicacion) {
        Optional<TiendaORM> optionalCuentaORM = tiendaJPARepository.findByNombre(nombreTienda);
        optionalCuentaORM.ifPresent(TiendaORM -> {
            TiendaORM.setUbicacion("Ubi_actualizada");
            tiendaJPARepository.save(TiendaORM);
        });
    }
}
