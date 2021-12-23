package br.com.mhenrique.spring.boot.estudo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.mhenrique.spring.boot.estudo.model.FilmesModel;

@Repository
public interface FilmesRepository extends JpaRepository<FilmesModel, Long> {
	FilmesModel findByNomeFilme(String nomeFilme);
}
