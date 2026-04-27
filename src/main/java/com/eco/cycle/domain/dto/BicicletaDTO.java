package com.eco.cycle.domain.dto;

import com.eco.cycle.domain.Enum.NivelBateriaEnum;
import com.eco.cycle.domain.Enum.StatusBicicletaEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BicicletaDTO {

	private Long id;
	private Boolean ativo;
	private Long usuario_id;
	private String modelo;
	private NivelBateriaEnum nivel_bateria;
	private StatusBicicletaEnum status_bicicleta;
	private Long estacao_id;
}