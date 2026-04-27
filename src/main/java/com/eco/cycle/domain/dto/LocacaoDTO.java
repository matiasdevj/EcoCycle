package com.eco.cycle.domain.dto;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocacaoDTO {

	private Long id;
	private Boolean ativo;
	private Long usuario_id;
	private Long bicicleta_id;
	private LocalDateTime data_inicio;
	private LocalDateTime data_fim;
	private Double saldo;
	private Long estacao_id;
}