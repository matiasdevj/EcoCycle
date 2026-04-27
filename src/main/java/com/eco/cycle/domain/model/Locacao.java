package com.eco.cycle.domain.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "locacao")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Locacao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name = "ativo", nullable = false)
	private Boolean ativo;
	
	@Column(name = "usuario_id", nullable = false)
	private String usuario_id;
	
	@Column(name = "bicicleta_id", nullable = false)
	private String bicicleta_id;
	
	@Column(name = "data_inicio", nullable = false)
	private LocalDateTime data_inicio;
	
	@Column(name = "data_fim", nullable = false)
	private LocalDateTime data_fim;
	
	@Column(name = "saldo", nullable = false)
	private Double saldo;
	
	@Column(name = "estacao_id", nullable = false)
	private Long estacao_id;
}
