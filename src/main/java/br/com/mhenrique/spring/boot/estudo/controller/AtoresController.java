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
import br.com.mhenrique.spring.boot.estudo.service.AtoresService;

@RestController
@RequestMapping("/api")
public class AtoresController {
	
	@Autowired
	private AtoresService atoresService;
	
	@PostMapping("/atores")
	public ResponseEntity<AtoresModel> cadastrarAtor(@RequestBody AtoresModel ator){		
		var atorCadastrado = atoresService.cadastrarAtor(ator);
		return ResponseEntity.created(URI.create(String.format("/atores/%s", atorCadastrado.getNomeAtor()))).body(atorCadastrado);
	}
	
	@GetMapping("/atores")
	public ResponseEntity<List<AtoresModel>> consultarListaDeAtores(){
		return ResponseEntity.ok(atoresService.consultarListaDeAtores());
	}
	
	@GetMapping("/atores/{nomeAtor}")
	public ResponseEntity<AtoresModel> consultarAtorPorNome(@PathVariable String nomeAtor){
		return ResponseEntity.ok(atoresService.consultarAtorPorNome(nomeAtor));
	}
	
	@PutMapping("/atores/{nomeAtor}")
	public ResponseEntity<AtoresModel> alterarAtorPorNome(@PathVariable String nomeAtor, @RequestBody AtoresModel novoAtor){
		return ResponseEntity.ok(atoresService.alterarAtorPorNome(nomeAtor, novoAtor));
	}
	
	@DeleteMapping("/atores/{nomeAtor}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void removerAtorPorNome(@PathVariable String nomeAtor) {
		atoresService.removerAtorPorNome(nomeAtor);
	}
	
}
