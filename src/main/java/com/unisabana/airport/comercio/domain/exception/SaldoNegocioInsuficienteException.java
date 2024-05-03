package com.unisabana.airport.comercio.domain.exception;

public class SaldoNegocioInsuficienteException extends RuntimeException{

    public SaldoNegocioInsuficienteException(int valorArriendo, int saldoNegocio) {
        super("El negocio tiene de saldo" + saldoNegocio + " , y se debe pagar " + valorArriendo);
    }

}
