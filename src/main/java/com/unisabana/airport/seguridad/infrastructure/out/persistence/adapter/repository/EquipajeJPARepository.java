package com.unisabana.airport.seguridad.infrastructure.out.persistence.adapter.repository;

import com.unisabana.airport.seguridad.infrastructure.out.persistence.orm.EquipajeORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipajeJPARepository extends JpaRepository<EquipajeORM, String> {
}
