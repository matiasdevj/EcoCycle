package com.eco.cycle.domain.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	
	private Long id;
	private Boolean ativo;
	private String nome;
	private String email;
	private Double saldo;
	private LocalDateTime data_cadastro;
}