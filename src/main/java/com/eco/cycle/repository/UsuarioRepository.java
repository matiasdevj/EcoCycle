package com.eco.cycle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eco.cycle.domain.model.Usuario;
import com.eco.cycle.repository.custom.UsuarioRepositoryCustom;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>, UsuarioRepositoryCustom {
	
	public String validaLocacaoAtiva(Long usuario_id);
	
}