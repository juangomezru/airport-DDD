package com.unisabana.airport.vuelos.infrastructure.out.persistence.adapter.repository;

import com.unisabana.airport.vuelos.infrastructure.out.persistence.orm.AvionORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvionJPARepository extends JpaRepository<AvionORM, Long> {
}
