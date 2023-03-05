package io.github.yukio.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "dados_banco")
public class DadosBanco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nome_banco", length = 20)
	private String nomeBanco;
	
	@Column(name = "cnpj", length = 14)
	private Integer cnpj;
	
	@Column(name = "local", length = 20)
	private String local;

	@JsonIgnore
	@ManyToOne
	private Pessoa pessoa;
}
