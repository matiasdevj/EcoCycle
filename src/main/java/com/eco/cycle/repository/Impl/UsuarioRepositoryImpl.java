package com.eco.cycle.repository.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.eco.cycle.repository.UsuarioRepository;
import com.eco.cycle.repository.custom.UsuarioRepositoryCustom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class UsuarioRepositoryImpl implements UsuarioRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public String validaLocacaoAtiva(Long usuario_id) {
		StringBuilder sql = new StringBuilder();

		sql.append("SELECT * FROM ");
		sql.append("usuarios u ");
		sql.append("INNER JOIN locacao l ON u.id = l.usuario_id ");
		sql.append("WHERE u.id = :usuario_id");
		
		// arrumar sql para ativo true

		Query qry = em.createNativeQuery(sql.toString());

		qry.setParameter("usuario_id", usuario_id);

		List<?> loc = qry.getResultList();
		return loc.isEmpty() ? "false" : "true";
	}
}
