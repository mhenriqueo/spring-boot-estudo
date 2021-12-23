package br.com.mhenrique.spring.boot.estudo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mhenrique.spring.boot.estudo.model.AtoresModel;
import br.com.mhenrique.spring.boot.estudo.repository.AtoresRepository;

@Service
public class AtoresService {
	
	@Autowired
	private AtoresRepository atoresRepository;
	
	public AtoresModel cadastrarAtor(AtoresModel ator) {
		return atoresRepository.save(ator);
	}
	
	public List<AtoresModel> consultarListaDeAtores(){
		return atoresRepository.findAll();
	}
	
	public AtoresModel consultarAtorPorNome(String nomeAtor) {
		return atoresRepository.findByNomeAtor(nomeAtor);
	}
	
	public AtoresModel alterarAtorPorNome(String nomeAtor, AtoresModel novoAtor) {
		var atorAtual = atoresRepository.findByNomeAtor(nomeAtor);
		novoAtor.setId(atorAtual.getId());
		return atoresRepository.save(novoAtor);
	}
	
	public void removerAtorPorNome (String nomeAtor) {
		var atorBuscado = atoresRepository.findByNomeAtor(nomeAtor);
		atoresRepository.deleteById(atorBuscado.getId());
	}
	
}
