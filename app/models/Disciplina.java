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
	@Required
	private int creditos;
	
	private boolean alocadaCorretamente = true;

	// Information Expert: Cada disciplina é quem deve conhecer seus
	// pre-requisitos.
	private List<String> preRequisitos;
	private int dificuldade;

	
	public Disciplina(String nome, int creditos, int dificuldade) {
		setNome(nome);
		setCreditos(creditos);
		this.dificuldade = dificuldade;
		preRequisitos = new ArrayList<String>();
	}

	public Disciplina(String nome, int creditos, List<String> preRequesitos,
			int dificuldade) {
		this.nome = nome;
		this.creditos = creditos;
		this.dificuldade = dificuldade;
		this.preRequisitos = preRequesitos;
	}
	

	public boolean isAlocadaCorretamente() {
		return alocadaCorretamente;
	}

	public void setAlocadaCorretamente(boolean alocadaCorretamente) {
		this.alocadaCorretamente = alocadaCorretamente;
		
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
		this.nome = nome;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
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