package com.eco.cycle.domain.Enum;

import lombok.Getter;

@Getter
public enum StatusBicicletaEnum {
	
	DISPONIVEL("Disponível"),
	EM_USO("Em uso"),
	MANUTENCAO("Manutenção");
	
	private String status_bicicleta;
	
	private StatusBicicletaEnum(String string) {
	}
}
