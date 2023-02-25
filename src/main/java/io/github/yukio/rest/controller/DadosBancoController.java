package io.github.yukio.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.github.yukio.domain.entity.DadosBanco;
import io.github.yukio.rest.dto.DadosBancoDTO;
import io.github.yukio.service.DadosBancoService;

@RestController
@RequestMapping("/api/dadosbanco")
public class DadosBancoController {

	@Autowired
	private DadosBancoService dadosBancoService;
	
	@GetMapping(value = "/{id}")
	public DadosBancoDTO findById(@PathVariable Integer id) {
		return dadosBancoService.findById(id);		
	}
	
	@PostMapping 
	@ResponseStatus(HttpStatus.CREATED)
	public DadosBanco save(@RequestBody DadosBancoDTO dto) {
		return dadosBancoService.salvar(dto);
	}
}
