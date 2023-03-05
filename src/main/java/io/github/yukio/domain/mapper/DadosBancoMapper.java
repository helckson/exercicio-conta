package io.github.yukio.domain.mapper;

import io.github.yukio.domain.entity.DadosBanco;
import io.github.yukio.rest.dto.DadosBancoDTO;

public class DadosBancoMapper {

	public static DadosBanco from(DadosBancoDTO dadosBancoDTO) {
		DadosBanco banco = new DadosBanco();
		banco.setNomeBanco(dadosBancoDTO.getNomeBanco());
		banco.setCnpj(dadosBancoDTO.getCnpj());
		banco.setLocal(dadosBancoDTO.getLocal());
		
		return banco;
	}
}
