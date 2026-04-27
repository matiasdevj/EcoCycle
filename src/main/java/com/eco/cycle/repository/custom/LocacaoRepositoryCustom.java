package com.eco.cycle.repository.custom;

import java.time.LocalDateTime;

import com.eco.cycle.domain.dto.LocacaoDTO;

public interface LocacaoRepositoryCustom {

	public LocacaoDTO concluirLocacao(Boolean ativo, Long usuario_id, Long bicicleta_id, LocalDateTime data_inicio,
			LocalDateTime data_fim, Double saldo, Long estacao_id);

}