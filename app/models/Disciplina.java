package models;

import java.util.ArrayList;
import java.util.List;

import play.data.validation.Constraints.*;

import javax.persistence.Entity;
import javax.persistence.Id;

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
	private int periodo;
	
	private int creditos;
	
	private boolean alocadaCorretamente = true;
	private List<String> preRequisitos;
	private int dificuldade;
	
	public Disciplina(String nome, int creditos, int dificuldade) {
		setNome(nome);
		setCreditos(creditos);
		setDificuladade(dificuldade);
		
		preRequisitos = new ArrayList<String>();
	}

	public Disciplina(String nome, int creditos, List<String> preRequesitos,
			int dificuldade) {
		setNome(nome);
		setCreditos(creditos);
		setDificuladade(dificuldade);
		setPreRequisitos(preRequesitos);
	}
	
	public boolean isAlocadaCorretamente() {
		return alocadaCorretamente;
	}

	public void setAlocadaCorretamente(boolean alocadaCorretamente) {
		this.alocadaCorretamente = alocadaCorretamente;
		
	}
	
	public void setPreRequisitos(List<String> preRequisitos){
		if(preRequisitos != null){
			this.preRequisitos = preRequisitos;
		}
	}

	public String getNome() {
		return nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public List<String> getPreRequisitos() {
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