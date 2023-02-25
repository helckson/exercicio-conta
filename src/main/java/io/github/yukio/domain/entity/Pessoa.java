package io.github.yukio.domain.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "nome", length = 100)
	private String nome;
	
	@Column(name = "nome_mae", length = 100)
	private String nomeMae;
	
	@Column(name = "num_conta", length = 10)
	private Integer numConta;
	
	@Column(name = "cpf", length = 10)
	private Integer cpf;
	
	@OneToMany(mappedBy = "pessoa")
	private List<DadosBanco> itens;

}
