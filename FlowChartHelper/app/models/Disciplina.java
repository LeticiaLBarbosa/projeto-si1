package models;

import java.util.ArrayList;

public class Disciplina {
	
	private String nome;
	private int creditos;
	private ArrayList<Disciplina> preRequisitos;
	private ArrayList<Disciplina> dependentes;
	private String id;
	
	/**
	 * Recupera o nome da Disciplina
	 * @return Nome da Disciplina
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Define o nome da Disciplina
	 * @param nome Nome da Disciplina
	 */

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Recupera o ID da Disciplina
	 * @return ID da Disciplina
	 */

	public String getId() {
		return id;
	}
	
	/**
	 * Define o ID da Disciplina
	 * @param id ID da Disciplina
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Recupera a quantidade de créditos da Disciplina
	 * @return Quantidade de crédtitos
	 */
	
	public int getCreditos() {
		return creditos;
	}

	/**
	 * Define a quantidade de créditos da Disciplina
	 * @param creditos Quantidade de créditos
	 */


	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	/**
	 * Lista de pré-requisitos da Disciplina
	 * @return pré-requisitos da Disciplina
	 */
	
	public ArrayList<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}
	
	/**
	 * Define os pré-requisitos da Disciplina
	 * @param preRequisitos pré-requisios da Disciplina
	 */
	
	public void addPreRequisito(Disciplina preRequisito) {
		this.preRequisitos.add(preRequisito);
	}
/**
 * Construtor da Disciplina
 * @param nome Nome da Disciplina
 * @param creditos Número de créditos da Disciplina
 * @param id 
 */
	public Disciplina(String nome, int creditos, String id) {
		this.nome = nome;
		this.creditos = creditos;
		this.preRequisitos = new ArrayList<Disciplina>();
		this.dependentes = new ArrayList<Disciplina>();
		this.id = id;
	}
	
	/**
	 * Compara se duas Disciplinas são iguais
	 */
	
	@Override
	public boolean equals(Object outra) {
		if(outra instanceof Disciplina){
			return id.equals(((Disciplina) outra).getId());} 
		else {
				return false;
			}
	}

	public ArrayList<Disciplina> getDependentes() {
		return dependentes;
	}

	public void addDependente(Disciplina dependente) {
		this.dependentes.add(dependente);
		dependente.addPreRequisito(this);
	}

}
