package com.eco.cycle.repository.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.eco.cycle.domain.Enum.NivelBateriaEnum;
import com.eco.cycle.domain.Enum.StatusBicicletaEnum;
import com.eco.cycle.repository.custom.BicicletaRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class BicicletaRepositoryImpl implements BicicletaRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Long> buscaIdsBicicletasDisponiveisPorEstacao(StatusBicicletaEnum status, int ativo,
			NivelBateriaEnum nivelBateria, Long estacao_id) {

		StringBuilder sql = new StringBuilder();

		sql.append("SELECT b.id FROM bicicletas b ");
	    sql.append("WHERE b.estacao_id = :estacao_id ");
	    sql.append("AND b.status_bicicleta = :status ");
	    sql.append("AND b.ativo = :ativo ");
	    sql.append("AND b.nivel_bateria >= :nivelBateria ");
	    sql.append("ORDER BY b.nivel_bateria DESC ");

		Query qry = em.createNativeQuery(sql.toString());

		qry.setParameter("status", status.name()); 
	    qry.setParameter("ativo", ativo);
	    qry.setParameter("nivelBateria", nivelBateria.getPorcentagem());
	    qry.setParameter("estacao_id", estacao_id);

	    List<Object> bicicletas = qry.getResultList();
	    return bicicletas.stream()
	    		.map(id -> ((Number) id).longValue())
	    		.collect(Collectors.toList());
	}

}
