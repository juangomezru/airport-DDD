package com.unisabana.airport.comercio.infrastructure.out.persistence.adapter.repository;

import com.unisabana.airport.comercio.domain.entity.Tienda;
import com.unisabana.airport.comercio.infrastructure.out.persistence.orm.TiendaORM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TiendaJPARepository extends JpaRepository<TiendaORM, String> {
    Optional<TiendaORM> findByNombreTienda(String nombreTienda);
}
