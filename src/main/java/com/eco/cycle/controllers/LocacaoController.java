package com.eco.cycle.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eco.cycle.domain.base.BaseResponseDto;
import com.eco.cycle.service.LocacaoService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "locacao")
public class LocacaoController {

	@Autowired
	private LocacaoService locacaoService;

	@PostMapping(value = "check-out")
	public ResponseEntity<BaseResponseDto> realizarCheckOut(@RequestParam(required = true) Long usuario_id,
			@RequestParam(required = true) Long estacao_id) throws Exception {

		BaseResponseDto dto = new BaseResponseDto();

		try {
			ResponseEntity<BaseResponseDto> response = ResponseEntity.status(HttpStatus.OK).body(
					BaseResponseDto.builder().data(locacaoService.realizarCheckOut(usuario_id, estacao_id)).build());
			return response;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
}
