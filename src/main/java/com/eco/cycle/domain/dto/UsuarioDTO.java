package com.eco.cycle.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO {
	
	private Integer id;
	private String nome;
	private String email;
	private Double saldo;

}