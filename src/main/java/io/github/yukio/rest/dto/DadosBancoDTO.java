package io.github.yukio.rest.dto;

import io.github.yukio.domain.entity.DadosBanco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosBancoDTO {
	
	private String nomeBanco;
	private Integer cnpj;
	private String local;
	private Integer idPessoa;
	
	// DadosBanco para DTO @GetMapping
	public DadosBancoDTO(DadosBanco dadosBanco) {
		nomeBanco = dadosBanco.getNomeBanco();
		cnpj = dadosBanco.getCnpj();
		local = dadosBanco.getLocal();
	}
}
