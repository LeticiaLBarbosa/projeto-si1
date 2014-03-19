package models;

import java.util.ArrayList;
import java.util.List;

import play.data.validation.Constraints.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import play.db.ebean.Model;

/**
 * Classe que representa as disciplinas a serem alocadas
 * 
 */
@Entity
public class Disciplina extends Model{

	private static final long serialVersionUID = 871291622882752052L;
	
	@Id
	public Long id;
	
	@Required
	private String nome;
	
	@Required
	private int creditos;
	
	private boolean alocadaCorretamente = true;
	private List<Disciplina> preRequisitos;
	private int dificuldade;
	
	public Disciplina(String nome, int creditos, int dificuldade) {
		setNome(nome);
		setCreditos(creditos);
		setDificuladade(dificuldade);
		
		preRequisitos = new ArrayList<Disciplina>();
	}

	public Disciplina(String nome, int creditos, List<Disciplina> list,
			int dificuldade) {
		setNome(nome);
		setCreditos(creditos);
		setDificuladade(dificuldade);
		setPreRequisitos(list);
	}
	
	public boolean isAlocadaCorretamente() {
		return alocadaCorretamente;
	}

	public void setAlocadaCorretamente(boolean alocadaCorretamente) {
		this.alocadaCorretamente = alocadaCorretamente;
		
	}
	
	public void setPreRequisitos(List<Disciplina> list){
		if(list != null){
			this.preRequisitos = list;
		}
	}

	public String getNome() {
		return nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public List<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}
	
	public int getNumPreRequisitos(){
		return preRequisitos.size();
	}

	public int getDificuldade() {
		return dificuldade;
	}
	
	public void setNome(String nome) {
		if(nome != null && !nome.equals("")){
			this.nome = nome;			
		}
	}

	public void setCreditos(int creditos) {
		if(creditos >= 0){
			this.creditos = creditos;
		}
	}

	public void setDificuladade(int dificuldade){
		if(dificuldade > 0 && dificuldade < 4 ){
			this.dificuldade = dificuldade;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Disciplina) {
			Disciplina compara = (Disciplina) obj;
			if (getNome().equals(compara.getNome()))
				return true;
		}
		return false;
	}

}