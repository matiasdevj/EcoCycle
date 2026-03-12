package com.eco.cycle.domain.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocacaoDTO {

	private Integer id;
	private Integer usuario_id;
	private Integer bicicleta_id;
	private LocalDateTime data_inicio;
	private LocalDateTime data_fim;
	private Double valor_total;
	
}