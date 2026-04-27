package com.eco.cycle.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BicicletaException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

    public BicicletaException(String mensagem) {
        super(mensagem);
    }

    public BicicletaException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}
