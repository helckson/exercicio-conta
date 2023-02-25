package io.github.yukio.rest.dto;

import io.github.yukio.domain.entity.DadosBanco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DadosBancoDTO {
	
	private String nomeBanco;
	private Integer cnpj;
	private String local;
	
	//DTO para DadosBanco @PostMapping
	public DadosBanco construir() {
		DadosBanco banco = new DadosBanco();
		banco.setNomeBanco(nomeBanco);
		banco.setCnpj(cnpj);
		banco.setLocal(local);
		
		return banco;
	}
	
	// DadosBanco para DTO @GetMapping
	public DadosBancoDTO(DadosBanco dadosBanco) {
		nomeBanco = dadosBanco.getNomeBanco();
		cnpj = dadosBanco.getCnpj();
		local = dadosBanco.getLocal();
	}
}
