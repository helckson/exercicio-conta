package io.github.yukio.rest.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import io.github.yukio.domain.entity.Pessoa;
import io.github.yukio.domain.repository.PessoaRespository;
import io.github.yukio.exception.PessoaNaoEncontradaException;
import io.github.yukio.rest.dto.CadastroCompletoDTO;
import io.github.yukio.rest.dto.PessoaDTO;
import io.github.yukio.service.PessoaService;

@RestController
@RequestMapping("/api/pessoa")
public class PessoaController {

	@Autowired
	private PessoaRespository pessoaRepository;
	
	@Autowired
	private PessoaService pessoaService;

	@Autowired
	private CadastroCompletoDTO dto;
	
	@GetMapping
	public List<PessoaDTO> findAll() {
		return pessoaService.findAll();
	}
	
	@GetMapping(value = "/{id}")
	public CadastroCompletoDTO findById(@PathVariable Integer id) {
		return  dto = pessoaService.ObterCadastroCompleto(id)
				.map(p -> dto.converter(p))
				.orElseThrow(() -> new PessoaNaoEncontradaException("Erro"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pessoa save(@RequestBody PessoaDTO dto) {
		return pessoaService.salvar(dto);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delele(@PathVariable Integer id) {
		pessoaRepository.findById(id)
						.map(pessoa -> {
							pessoaRepository.delete(pessoa);
							return pessoa;
						}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
								"Pessoa não encontrada"));
	}
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody Pessoa pessoa) {
		pessoaRepository.findById(id)
						.map(pessoaexistence -> {
							pessoa.setId(pessoaexistence.getId());
							pessoaRepository.save(pessoa);
							return pessoaexistence;
						}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
								"Pessoa não encontrada"));
	}
}
