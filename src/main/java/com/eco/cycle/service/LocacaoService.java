package com.eco.cycle.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eco.cycle.domain.Enum.NivelBateriaEnum;
import com.eco.cycle.domain.Enum.StatusBicicletaEnum;
import com.eco.cycle.domain.dto.LocacaoDTO;
import com.eco.cycle.domain.exception.BicicletaException;
import com.eco.cycle.domain.exception.BusinessException;
import com.eco.cycle.domain.exception.EstacaoException;
import com.eco.cycle.domain.exception.UsuarioException;
import com.eco.cycle.domain.model.Estacao;
import com.eco.cycle.domain.model.Usuario;
import com.eco.cycle.repository.BicicletaRepository;
import com.eco.cycle.repository.EstacaoRepository;
import com.eco.cycle.repository.LocacaoRepository;
import com.eco.cycle.repository.UsuarioRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class LocacaoService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BicicletaRepository bicicletaRepository;

	@Autowired
	private EstacaoRepository estacaoRepository;

	@Autowired
	private LocacaoRepository locacaoRepository;

	public LocacaoDTO realizarCheckOut(Long usuario_id, Long estacao_id) {

		Usuario usuario = usuarioRepository.findById(usuario_id)
				.orElseThrow(() -> new UsuarioException("Usuário não encontrado no banco de dados"));

		String validaLocacaoAtiva = usuarioRepository.validaLocacaoAtiva(usuario.getId());

		LocacaoDTO locacao = prosseguirCheckOut(estacao_id, usuario.getId(), validaLocacaoAtiva);

		return locacao;
	}

	private LocacaoDTO prosseguirCheckOut(Long estacao_id, Long usuario, String validaLocacaoAtiva) {
		if (validaLocacaoAtiva.equals("false")) {
			Estacao estacao = estacaoRepository.findById(estacao_id)
					.orElseThrow(() -> new EstacaoException("Estacão não encontrada"));
			
			List<Long> bicicletasDisponiveis = bicicletaRepository.buscaIdsBicicletasDisponiveisPorEstacao(
					StatusBicicletaEnum.DISPONIVEL, 1, NivelBateriaEnum.EXTREMAMENTE_BAIXA, estacao.getId());
			
			Long bicicletaEscolhida = bicicletasDisponiveis.stream().findFirst().orElseThrow(() -> {
				log.warn("Nenhuma bicicleta disponível para a estação: {}", estacao_id);
				return new BicicletaException("Nenhuma bicicleta disponível no momento.");
			});

			LocacaoDTO concluirCheckOut = locacaoRepository.concluirLocacao(true, usuario, bicicletaEscolhida,
					LocalDateTime.now(), null, 0.0, estacao.getId());
			
			return concluirCheckOut;
		} else {
			log.error("Usuário [{}] possuí locação ativa e não poderá realizar outra.", usuario);
			throw new BusinessException("Usuário possuí locação ativa e não poderá realizar outra.");
		}
	}
}