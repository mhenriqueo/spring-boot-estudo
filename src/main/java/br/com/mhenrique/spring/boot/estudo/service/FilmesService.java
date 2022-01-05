package br.com.mhenrique.spring.boot.estudo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mhenrique.spring.boot.estudo.model.AtoresModel;
import br.com.mhenrique.spring.boot.estudo.model.FilmesModel;
import br.com.mhenrique.spring.boot.estudo.repository.AtoresRepository;
import br.com.mhenrique.spring.boot.estudo.repository.FilmesRepository;

@Service
public class FilmesService {
	
	@Autowired
	private FilmesRepository filmesRepository;
	
	@Autowired
	private AtoresRepository atoresRepository;
		
	public FilmesModel cadastrarFilmes(FilmesModel filme){
		return filmesRepository.save(filme);
	}
	
	public AtoresModel escalarAtoresNoFilme(String nomeFilme, AtoresModel atores) {
		var filmeBuscado = filmesRepository.findByNomeFilme(nomeFilme);
		atores.setFilmesModel(filmeBuscado);
		return atoresRepository.save(atores);
	}
	
	public List<FilmesModel> consultarListaDeFilmes() {
		return filmesRepository.findAll();
	}
	
	public FilmesModel consultarFilmesPorNome(String nomeFilme) {
		return filmesRepository.findByNomeFilme(nomeFilme);
	}
	
	public FilmesModel alterarFilmePorNome(String nomeFilme, FilmesModel novoFilme) {
		var filmeAtual = filmesRepository.findByNomeFilme(nomeFilme);
		novoFilme.setId(filmeAtual.getId());
		return filmesRepository.save(novoFilme);
	}
	
	public void removerFilmePorNome(String nomeFilme) {
		var filmeBuscado = filmesRepository.findByNomeFilme(nomeFilme);
	    filmesRepository.deleteById(filmeBuscado.getId());
	}
	
}
