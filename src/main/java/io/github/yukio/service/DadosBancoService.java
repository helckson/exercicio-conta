package io.github.yukio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.yukio.domain.entity.DadosBanco;
import io.github.yukio.domain.repository.DadosBancoRepository;
import io.github.yukio.exception.BancoNaoEncontradoException;
import io.github.yukio.rest.dto.DadosBancoDTO;

@Service
public class DadosBancoService {

	@Autowired
	private DadosBancoRepository dadosBancoRepository;
	
	public DadosBanco salvar(DadosBancoDTO dadosBancoDTO) {
		DadosBanco dadosBanco = dadosBancoRepository.save(dadosBancoDTO.construir());
		return dadosBanco;
	}
	
	public DadosBancoDTO findById(Integer id) {
		DadosBanco dadosBanco = dadosBancoRepository.findById(id)
				.orElseThrow(() -> new BancoNaoEncontradoException("Banco não encontrado"));
		DadosBancoDTO dadosBancoDTO = new DadosBancoDTO(dadosBanco);
		return dadosBancoDTO;
	}
	
	
}
