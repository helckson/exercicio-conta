package io.github.yukio.rest.dto;

import java.util.List;
import java.util.stream.Collectors;

import io.github.yukio.domain.entity.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PessoaDTO {
	private String nome;
	private String nomeMae;
	private Integer numConta;
	
	// DTO para pessoa @PostMapping
	public Pessoa build() {
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		pessoa.setNomeMae(nomeMae);
		pessoa.setNumConta(numConta);
		
		return pessoa;
	}
	
	// Pessoa para DTO @GetMapping
	public PessoaDTO(Pessoa pessoa) {
		nome = pessoa.getNome();
		nomeMae = pessoa.getNomeMae();
		numConta = pessoa.getNumConta();
	}

	public static List<PessoaDTO> converter(List<Pessoa> pessoa) {
		return pessoa.stream().map(PessoaDTO::new).collect(Collectors.toList());
	}


}
