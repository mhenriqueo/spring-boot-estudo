package br.com.mhenrique.spring.boot.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.mhenrique.spring.boot.estudo.model.AtoresModel;

@Repository
public interface AtoresRepository extends JpaRepository<AtoresModel, Long>{
	AtoresModel findByNomeAtor(String nomeAtor);
}
