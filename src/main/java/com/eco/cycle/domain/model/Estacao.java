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
@Table(name = "estacoes")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estacao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name = "ativo", nullable = false)
	private Boolean ativo;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "latitude", nullable = false)
	private String latitude;
	
	@Column(name = "longitude", nullable = false)
	private String longitude;
	
	@Column(name = "capacidade_maxima", nullable = false)
	private Long capacidade_maxima;
	
	@Column(name = "bicicleta_id", nullable = false)
	private Long bicicleta_id;
}