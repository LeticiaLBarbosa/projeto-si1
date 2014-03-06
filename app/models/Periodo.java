package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que representa os períodos que o aluno irá alocar disciplinas
 * 
 */
public class Periodo {

	private List<Disciplina> disciplinas;

	/**
	 * Construtor
	 */
	public Periodo() {
		disciplinas = new ArrayList<Disciplina>();
	}

	/**
	 * Retorna a disciplina da lista de disciplinas
	 * 
	 * @param i
	 *            Disciplina a ser retornada
	 */	
	public Disciplina indiceDisciplina(int i){
		return disciplinas.get(i);
	}
	
	public int indiceDisciplina(String nome){
		int result = -1;
		
		for(int i = 0; i < disciplinas.size(); i++){
			if(disciplinas.get(i).getNome().equals(nome)){
				result = i;
			}
		}
		
		return result;
	}

	/**
	 * @return Retorna a lista de disciplinas do período
	 */

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	/**
	 * INFORMATION EXPERT: Periodo deve saber quantas disciplinas ele tem.
	 * 
	 * @return
	 */

	public int numeroDisciplinas() {
		return disciplinas.size();
	}

	// INFORMATION EXPERT: Periodo tem todas as disciplinas, logo ele pode
	// calcular a dificuldade total
	/**
	 * 
	 * @return Retorna a soma de dificuldades do periodo
	 */
	public int getDificuldadeTotal() {
		int soma = 0;
		for (int i = 0; i < disciplinas.size(); i++) {
			soma += disciplinas.get(i).getDificuldade();
		}
		return soma;
	}

	// INFORMATION EXPERT: Periodo tem todas as disciplinas, logo ele pode
	// calcular o total de creditos
	/**
	 * 
	 * @return Retorna o total de creditos ja alocados do periodo
	 */

	public int getTotalCreditos() {
		int totalCreditos = 0;
		for (Disciplina disciplina : disciplinas) {
			totalCreditos += disciplina.getCreditos();
		}
		return totalCreditos;
	}
}
