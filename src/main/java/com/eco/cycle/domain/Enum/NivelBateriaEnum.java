package com.eco.cycle.domain.Enum;

import lombok.Getter;

@Getter
public enum NivelBateriaEnum {

	COMPLETA("COMPLETA", 100),
	ALTA("ALTA", 80),
	MEDIA("MEDIA", 60),
	BAIXA("BAIXA", 40),
	EXTREMAMENTE_BAIXA("EXTREMAMENTE BAIXA", 20),
	VAZIA("VAZIA", 0);
	
	private String nivel_bateria;
	private Integer porcentagem;
	
	private NivelBateriaEnum(String nivel_bateria, Integer porcentagem) {
		this.nivel_bateria = nivel_bateria;
		this.porcentagem = porcentagem;
	}
	
	private NivelBateriaEnum(Integer porcentagem) {
		this.porcentagem = porcentagem;
	}
}