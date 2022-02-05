package br.com.mhenrique.spring.boot.estudo.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.mhenrique.spring.boot.estudo.model.FilmesModel;
import br.com.mhenrique.spring.boot.estudo.repository.FilmesRepository;

class FilmesServiceTest {

	@InjectMocks
	private FilmesService filmesService;
	
	@Mock
	private FilmesRepository mockFilmesRepository;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void deveCadastrarFilmes() {
		var filme = new FilmesModel();
		filmesService.cadastrarFilmes(filme);
		
		Mockito.doReturn(filme).when(mockFilmesRepository).save(Mockito.any());
		assertThat(filmesService.cadastrarFilmes(filme)).isNotNull();
	}

}
