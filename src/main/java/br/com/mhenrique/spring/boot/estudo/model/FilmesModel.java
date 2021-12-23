package br.com.mhenrique.spring.boot.estudo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "filmes")
public class FilmesModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	@Column
	private String nomeFilme;
	@Column
	private String duracaoFilme;
	@Column
	private String classificacaoIndicativa;
	@Column
	private String tipoFilme;
	@Column
	private double valorProducaoFilme;
	@Column
	private int qntTotalFuncionarios;
	@Column
	private String nomeDiretor;
	
//	@ManyToOne
//	@JoinColumn(name = "ator_protagonista")
//	private AtoresModel atorProtagonista;
	
//	targetEntity = AtoresModel.class,
//	@Override
//	public String toString() {
//		return "Filme: " + nomeFilme + " / Duração: " + duracaoFilme + " / Classificação: " + classificacaoIndicativa;
//	}
}
