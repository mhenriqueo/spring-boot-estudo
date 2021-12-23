package br.com.mhenrique.spring.boot.estudo.model;

//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "atores")
public class AtoresModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String nomeAtor;
	
//	@OneToMany(mappedBy = "nomeAtor")
//	private List<FilmesModel> filmesModel;
	
}
