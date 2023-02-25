package io.github.yukio.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import io.github.yukio.domain.entity.Pessoa;

public interface PessoaRespository extends JpaRepository<Pessoa, Integer>{
	
	@Query("select p from Pessoa p left join fetch p.itens where p.id =:id")
	Optional<Pessoa> findByIdFetchItens(@Param("id") Integer id);
}
