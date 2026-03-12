package com.eco.cycle.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstacaoDTO {

	private Integer id;
	private String nome;
	private String latitude;
	private String longitude;
	private String capacidade_maxima;
	
}