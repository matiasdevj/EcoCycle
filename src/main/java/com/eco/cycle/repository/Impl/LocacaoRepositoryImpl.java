package com.eco.cycle.repository.Impl;

import java.time.LocalDateTime;

import com.eco.cycle.domain.Enum.StatusBicicletaEnum;
import com.eco.cycle.domain.dto.LocacaoDTO;
import com.eco.cycle.repository.LocacaoRepository;
import com.eco.cycle.repository.custom.LocacaoRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public class LocacaoRepositoryImpl implements LocacaoRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public LocacaoDTO concluirLocacao(Boolean ativo, Long usuario_id, Long bicicleta_id, LocalDateTime data_inicio,
			LocalDateTime data_fim, Double saldo, Long estacao_id) {
		StringBuilder sql = new StringBuilder();

		sql.append("INSERT INTO locacao (ativo, usuario_id, bicicleta_id, data_inicio, data_fim, saldo, estacao_id) ");
		sql.append("VALUES (:ativo, :usuario_id, :bicicleta_id, :data_inicio, :data_fim, :saldo, :estacao_id) ");

		Query qry = em.createNativeQuery(sql.toString());

		qry.setParameter("ativo", ativo);
		qry.setParameter("usuario_id", usuario_id);
		qry.setParameter("bicicleta_id", bicicleta_id);
		qry.setParameter("data_inicio", data_inicio);
		qry.setParameter("data_fim", data_fim);
		qry.setParameter("saldo", saldo);
		qry.setParameter("estacao_id", estacao_id);

		qry.executeUpdate();
		
		Object idGeradoObj = em.createNativeQuery("SELECT LAST_INSERT_ID()").getSingleResult();
		Long idSequencial = ((Number) idGeradoObj).longValue();

		String attStatusBicicleta = "UPDATE bicicletas SET status_bicicleta = :status WHERE id = :bicicleta_id";
		em.createNativeQuery(attStatusBicicleta)
			.setParameter("status", StatusBicicletaEnum.EM_USO)
			.setParameter("bicicleta_id", bicicleta_id)
			.executeUpdate();

		LocacaoDTO locacao = new LocacaoDTO();
		locacao.setId(idSequencial);
		locacao.setAtivo(ativo);
		locacao.setUsuario_id(usuario_id);
		locacao.setBicicleta_id(bicicleta_id);
		locacao.setData_inicio(data_inicio);
		locacao.setData_fim(data_fim);
		locacao.setSaldo(saldo);
		locacao.setEstacao_id(estacao_id);

		return locacao;
	}

}