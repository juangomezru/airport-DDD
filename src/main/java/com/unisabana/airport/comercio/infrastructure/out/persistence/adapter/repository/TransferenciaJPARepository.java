package com.unisabana.airport.comercio.infrastructure.out.persistence.adapter.repository;

import com.unisabana.airport.comercio.infrastructure.out.persistence.orm.TransferenciaORM;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransferenciaJPARepository extends JpaRepository<TransferenciaORM, UUID> {
}
