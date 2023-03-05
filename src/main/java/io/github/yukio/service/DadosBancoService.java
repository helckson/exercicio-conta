package io.github.yukio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.yukio.domain.entity.DadosBanco;
import io.github.yukio.domain.entity.Pessoa;
import io.github.yukio.domain.mapper.DadosBancoMapper;
import io.github.yukio.domain.repository.DadosBancoRepository;
import io.github.yukio.domain.repository.PessoaRespository;
import io.github.yukio.exception.BancoNaoEncontradoException;
import io.github.yukio.rest.dto.DadosBancoDTO;

@Service
public class DadosBancoService {

	@Autowired
	private DadosBancoRepository dadosBancoRepository;
	
	@Autowired
	private PessoaRespository pessoaRespository;
	
	public DadosBanco salvar(DadosBancoDTO dadosBancoDTO) {
		var pessoa = getPessoa(dadosBancoDTO.getIdPessoa());
		
		DadosBanco banco = DadosBancoMapper.from(dadosBancoDTO);
		banco.setPessoa(pessoa);
		
		DadosBanco dadosBanco = dadosBancoRepository.save(banco);
		return dadosBanco;
	}
	
	private Pessoa getPessoa(Integer idPessoa) {
		var pessoa = pessoaRespository.findById(idPessoa);
		return pessoa.get();
	}
	
	public DadosBancoDTO findById(Integer id) {
		DadosBanco dadosBanco = dadosBancoRepository.findById(id)
				.orElseThrow(() -> new BancoNaoEncontradoException("Banco não encontrado"));
		DadosBancoDTO dadosBancoDTO = new DadosBancoDTO(dadosBanco);
		return dadosBancoDTO;
	}
	
	
}
