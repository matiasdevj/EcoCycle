package com.eco.cycle.repository.custom;

import java.util.List;

import com.eco.cycle.domain.Enum.NivelBateriaEnum;
import com.eco.cycle.domain.Enum.StatusBicicletaEnum;

public interface BicicletaRepositoryCustom {
	
	List<Long> buscaIdsBicicletasDisponiveisPorEstacao(StatusBicicletaEnum status, int ativo,
			NivelBateriaEnum nivelBateria, Long estacao_id);

}
