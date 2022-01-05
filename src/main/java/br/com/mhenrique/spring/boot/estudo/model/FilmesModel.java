package br.com.mhenrique.spring.boot.estudo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
	private String nomeDiretor;
	@Column
	private String tipoFilme;
	@Column
	private double valorProducaoFilme;
	@Column
	private int qntTotalFuncionarios;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "filmes_id")
	private List<AtoresModel> atores;
	
//	@JoinTable(name = "Filmes_Atores", joinColumns = @JoinColumn(name = "filmes_id"), inverseJoinColumns = @JoinColumn(name = "ator_id"))
	
	
//	@Override
//	public String toString() {
//		return "Filme: " + nomeFilme + " / Duração: " + duracaoFilme + " / Classificação: " + classificacaoIndicativa;
//	}
}
