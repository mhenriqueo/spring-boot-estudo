package br.com.mhenrique.spring.boot.estudo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mhenrique.spring.boot.estudo.model.FilmesModel;
import br.com.mhenrique.spring.boot.estudo.repository.FilmesRepository;

@Service
public class FilmesService {
	
	@Autowired
	private FilmesRepository filmesRepository;
		
	public FilmesModel cadastrarFilmes(FilmesModel filme){
		return filmesRepository.save(filme);
	}
	
	public List<FilmesModel> consultarListaDeFilmes() {
		return filmesRepository.findAll();
	}
	
	public FilmesModel consultarFilmesPorNome(String nomeFilme) {
		return filmesRepository.findByNomeFilmeContainingIgnoreCase(nomeFilme);
	}
	
	public FilmesModel alterarFilmePorNome(String nomeFilme, FilmesModel novoFilme) {
		var filmeAtual = filmesRepository.findByNomeFilmeContainingIgnoreCase(nomeFilme);
		novoFilme.setId(filmeAtual.getId());
		return filmesRepository.save(novoFilme);
	}
	
	public void removerFilmePorNome(String nomeFilme) {
		var filmeBuscado = filmesRepository.findByNomeFilmeContainingIgnoreCase(nomeFilme);
	    filmesRepository.deleteById(filmeBuscado.getId());
	}
	
}
