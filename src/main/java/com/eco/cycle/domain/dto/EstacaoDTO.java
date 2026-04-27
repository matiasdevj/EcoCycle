package com.eco.cycle.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstacaoDTO {

	private Long id;
	private String nome;
	private String latitude;
	private String longitude;
	private Boolean capacidade_maxima;
	
}