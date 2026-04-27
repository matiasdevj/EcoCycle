package com.eco.cycle.domain.Enum;

import lombok.Getter;

@Getter
public enum StatusBicicletaEnum {
	
	DISPONIVEL("DISPONIVEL"),
	EM_USO("EM USO"),
	MANUTENCAO("MANUTENCAO");
	
	private String status_bicicleta;
	
	private StatusBicicletaEnum(String status) {
		this.status_bicicleta = status;
	}
}