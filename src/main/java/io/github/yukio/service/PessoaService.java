package io.github.yukio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.yukio.domain.entity.Pessoa;
import io.github.yukio.domain.repository.PessoaRespository;
import io.github.yukio.exception.PessoaNaoEncontradaException;
import io.github.yukio.rest.dto.PessoaDTO;

@Service
public class PessoaService {

	@Autowired
	private PessoaRespository pessoaRespository;
	
	public Pessoa salvar(PessoaDTO dto) {
		Pessoa pessoa = pessoaRespository.save(dto.build());
			return pessoa;
	}
	
	public List<PessoaDTO> findAll() {
		List<Pessoa> lista = pessoaRespository.findAll();
		return PessoaDTO.converter(lista);
	}
	
	public Optional<Pessoa> ObterCadastroCompleto(Integer id) {
		return pessoaRespository.findByIdFetchItens(id);
	}
	
	public PessoaDTO findById(Integer id) {	
			Pessoa pessoa = pessoaRespository.findById(id)
					.orElseThrow(() -> new PessoaNaoEncontradaException("Não encontrtado"));
			PessoaDTO dto = new PessoaDTO(pessoa);
			return dto;
	}
}
