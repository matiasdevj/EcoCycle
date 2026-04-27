package com.eco.cycle.domain.model;

import com.eco.cycle.domain.Enum.NivelBateriaEnum;
import com.eco.cycle.domain.Enum.StatusBicicletaEnum;

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
@Table(name = "bicicletas")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Bicicleta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name = "ativo", nullable = false)
	private Boolean ativo;
	
	@Column(name = "usuario_id", nullable = true)
	private Long usuario_id;
	
	@Column(name = "modelo", nullable = false)
	private String modelo;
	
	@Column(name = "nivel_bateria", nullable = false)
	private NivelBateriaEnum nivel_bateria;
	
	@Column(name = "status_bicicleta", nullable = false)
	private StatusBicicletaEnum status_bicicleta;
	
	@Column(name = "estacao_id", nullable = true)
	private Long estacao_id;
}
