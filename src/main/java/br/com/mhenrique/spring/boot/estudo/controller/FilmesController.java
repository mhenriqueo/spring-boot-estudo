package br.com.mhenrique.spring.boot.estudo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.mhenrique.spring.boot.estudo.model.AtoresModel;
import br.com.mhenrique.spring.boot.estudo.model.FilmesModel;
import br.com.mhenrique.spring.boot.estudo.service.FilmesService;
import io.swagger.annotations.Api;

@Api(value = "Manutenção de Filmes", tags = "Manutenção de Filmes")
@RestController
@RequestMapping("/api")
public class FilmesController {

	@Autowired
	private FilmesService filmesService;
	
	@PostMapping("/filmes")
	public ResponseEntity<FilmesModel> cadastrarFilmes(@RequestBody FilmesModel filme) {
		var filmeCriado = filmesService.cadastrarFilmes(filme);		
		return ResponseEntity.created(URI.create(String.format("/filmes/%s", filmeCriado.getNomeFilme()))).body(filmeCriado);
	}
	
	@PostMapping("/filmes/{nomeFilme}")
	public ResponseEntity<AtoresModel> escalarAtoresNoFilme(@PathVariable String nomeFilme, @RequestBody AtoresModel atores) {
		var atorEscalado = filmesService.escalarAtoresNoFilme(nomeFilme, atores);
		return ResponseEntity.created(URI.create(String.format("/filmes/{nomeFilme}/%s", atorEscalado.getNomeAtor()))).body(atorEscalado);
	}
	
	@GetMapping("/filmes")
	public ResponseEntity<List<FilmesModel>> consultarListaDeFilmes() {	
		return ResponseEntity.ok(filmesService.consultarListaDeFilmes());
	}

	@GetMapping("/filmes/{nomeFilme}")
	public ResponseEntity<FilmesModel> consultarFilmesPorNome(@PathVariable String nomeFilme) {
		return ResponseEntity.ok(filmesService.consultarFilmesPorNome(nomeFilme));
	}

	@PutMapping("/filmes/{nomeFilme}")
	public ResponseEntity<FilmesModel> alterarFilmePorNome(@PathVariable String nomeFilme, @RequestBody FilmesModel novoFilme) {		
		return ResponseEntity.ok(filmesService.alterarFilmePorNome(nomeFilme, novoFilme));
	}

	@DeleteMapping("/filmes/{nomeFilme}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removerFilmePorNome(@PathVariable String nomeFilme) {		
		filmesService.removerFilmePorNome(nomeFilme);
	}

}
