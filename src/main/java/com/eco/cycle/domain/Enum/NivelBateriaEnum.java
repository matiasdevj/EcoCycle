package com.eco.cycle.domain.Enum;

import lombok.Getter;

@Getter
public enum NivelBateriaEnum {

	COMPLETA("COMPLETA"),
	MEDIA("MEDIA"),
	BAIXA("BAIXA");
	
	private String nivel_bateria;
	
	NivelBateriaEnum(String string) {
	}
}
