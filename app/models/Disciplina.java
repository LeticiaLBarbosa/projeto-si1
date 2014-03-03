package models;

import java.util.ArrayList;
import java.util.List;

import play.data.validation.Constraints.*;

/**
 * Classe que representa as disciplinas a serem alocadas
 * 
 */

public class Disciplina {

	@Required
	private String nome;
	@Required
	private int periodo;
	private int creditos;

	// Information Expert: Cada disciplina é quem deve conhecer seus
	// pre-requisitos.
	private List<String> preRequisitos;
	private boolean alocada;
	private int dificuldade;

	/**
	 * Construtor para disciplinas sem preRequisitos
	 * 
	 * @param nome
	 *            Nome da disciplina
	 * @param creditos
	 *            Creditos da disciplina
	 * @param dificuldade
	 *            Dificuldade da disciplina
	 */

	public Disciplina(String nome, int creditos, int dificuldade) {
		setNome(nome);
		setCreditos(creditos);
		alocada = false;
		this.dificuldade = dificuldade;
		preRequisitos = new ArrayList<String>();
	}

	/**
	 * 
	 * Construtor para disciplinas com preRequisitos
	 * 
	 * @param nome
	 *            Nome da disciplina
	 * @param creditos
	 *            Creditos da disciplina
	 * @param preRequesitos
	 *            Lista de String com o nome das disiciplinas que sao
	 *            preRequesitos da disciplina inicializada
	 * 
	 * @param dificuldade
	 *            Dificuldade da disciplina
	 */
	public Disciplina(String nome, int creditos, List<String> preRequesitos,
			int dificuldade) {
		this.nome = nome;
		this.creditos = creditos;
		this.dificuldade = dificuldade;
		alocada = false;
		this.preRequisitos = preRequesitos;
	}

	/**
	 * 
	 * @return Retorna o nome da disciplina
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * @return Retorn os creditos da disciplina
	 */
	public int getCreditos() {
		return creditos;
	}

	/**
	 * 
	 * @return Retorna a lista de preRequisitos da disciplina
	 */
	public List<String> getPreRequisitos() {
		return preRequisitos;
	}

	/**
	 * Information Expert
	 * A classe disciplina é que tem que saber a quantidade de pré-requisitos
	 * @return numero de pré-requisitos
	 */
	public int getNumPreRequisitos(){
		return preRequisitos.size();
	}

	/**
	 * 
	 * @return Retorna se a disciplina já está ou não alocada
	 */
	public boolean getAlocada() {
		return alocada;
	}

	/**
	 * 
	 * @return Retorna a dificuldade da disciplina
	 */
	public int getDificuldade() {
		return dificuldade;
	}

	/**
	 * Altera o nome da disciplina
	 * 
	 * @param nome
	 *            Nome da disciplina
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * Altera os creditos da disciplina
	 * 
	 * @param creditos
	 *            Creditos da disciplina
	 */
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	/**
	 * Muda se a disciplina está alocada ou nao
	 */
	public void setAlocada() {
		alocada = (alocada == false) ? true : false;
	}

	/**
	 * 
	 * @return Retorna o periodo que a disciplina foi alocado
	 */
	public int getPeriodo() {
		return periodo;
	}

	/**
	 * Altera o periodo que a disciplina será cursada
	 * 
	 * @param periodo
	 */
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}

	/**
	 * Compara duas disciplinas
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Disciplina) {
			Disciplina compara = (Disciplina) obj;
			if (getNome().equals(compara.getNome()))
				return true;
		}
		return false;
	}

}