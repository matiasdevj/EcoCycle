package com.eco.cycle.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eco.cycle.domain.Enum.StatusBicicletaEnum;
import com.eco.cycle.domain.dto.LocacaoDTO;
import com.eco.cycle.domain.model.Locacao;
import com.eco.cycle.repository.custom.LocacaoRepositoryCustom;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long>, LocacaoRepositoryCustom {

	public LocacaoDTO concluirLocacao(Boolean ativo, Long usuario_id, Long bicicleta_id, LocalDateTime data_inicio,
			LocalDateTime data_fim, Double saldo, Long estacao_id);
}
