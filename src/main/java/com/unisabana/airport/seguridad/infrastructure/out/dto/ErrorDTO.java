package com.unisabana.airport.seguridad.infrastructure.out.dto;

public record ErrorDTO(String message, int codigoHTTP, String error) {
}
