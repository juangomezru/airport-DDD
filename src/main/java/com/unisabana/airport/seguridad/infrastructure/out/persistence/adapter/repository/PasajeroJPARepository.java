package com.unisabana.airport.seguridad.infrastructure.out.persistence.adapter.repository;

import com.unisabana.airport.seguridad.infrastructure.out.persistence.orm.PasajeroORM;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasajeroJPARepository extends JpaRepository<PasajeroORM, String> {
}
