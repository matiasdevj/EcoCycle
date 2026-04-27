package com.eco.cycle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eco.cycle.domain.Enum.NivelBateriaEnum;
import com.eco.cycle.domain.Enum.StatusBicicletaEnum;
import com.eco.cycle.domain.model.Bicicleta;
import com.eco.cycle.repository.custom.BicicletaRepositoryCustom;

@Repository
public interface BicicletaRepository extends JpaRepository<Bicicleta, Long>, BicicletaRepositoryCustom {

	List<Long> buscaIdsBicicletasDisponiveisPorEstacao(StatusBicicletaEnum status, int i,
			NivelBateriaEnum nivelBateria, Long estacao_id);
}