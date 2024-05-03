package com.unisabana.airport.comercio.infrastructure;

import com.unisabana.airport.comercio.application.exception.TiendaNoExisteException;
import com.unisabana.airport.comercio.infrastructure.out.dto.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionAeropuertoException {
    @ExceptionHandler(TiendaNoExisteException.class)
    public ResponseEntity handlerCuentaNoExiste(TiendaNoExisteException ex) {
        log.info("Se intento realizar operación con cuenta no existente ", ex);
        return ResponseEntity
                .status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(
                        new ErrorDTO(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
                                "CONSTANTE_DEL_ERROR_1"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handlerGeneral(Exception ex) {
        //log.error("");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex.getMessage());
    }
}
