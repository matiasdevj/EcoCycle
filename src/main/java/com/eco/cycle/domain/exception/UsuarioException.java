package com.eco.cycle.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public UsuarioException(String mensagem) {
        super(mensagem);
    }

    public UsuarioException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}