package io.github.yukio.rest.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import io.github.yukio.domain.entity.DadosBanco;
import io.github.yukio.domain.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Service
public class CadastroCompletoDTO {
	private Integer codigo;
	private String nome;
	private String nomeMae;
	private Integer numConta;
	private List<DadosBancoDTO> itens;
	
	
	public CadastroCompletoDTO converter(Pessoa pessoa) {
		return CadastroCompletoDTO.builder()
				.codigo(pessoa.getId())
				.nome(pessoa.getNome())
				.nomeMae(pessoa.getNomeMae())
				.numConta(pessoa.getNumConta())
				.itens(converterBanco(pessoa.getItens()))
				.build();
				
//		return codigo = pessoa.getId(); (linha com erro)
//				nome = pessoa.getNome();
//				nomeMae = pessoa.getNomeMae();
//				numConta = pessoa.getNumConta();
//				itens = converterBanco(pessoa.getItens());
	}
	
	public static List<DadosBancoDTO> converterBanco(List<DadosBanco> dadosBanco) {
		return dadosBanco.stream().map(DadosBancoDTO::new).collect(Collectors.toList());
	}
}
