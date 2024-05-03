package com.unisabana.airport.comercio.infrastructure.out.dto;

public record ErrorDTO(String message, int codigoHTTP, String error) {
}
