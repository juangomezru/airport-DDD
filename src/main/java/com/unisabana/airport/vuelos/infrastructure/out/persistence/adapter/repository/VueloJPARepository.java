package com.unisabana.airport.vuelos.infrastructure.out.persistence.adapter.repository;

import com.unisabana.airport.vuelos.infrastructure.out.persistence.orm.VueloORM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloJPARepository extends JpaRepository<VueloORM, Long> {
}
