package models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Exceptions.LimitesExcedidosException;

/**
 * Classe que representa os períodos que o aluno irá alocar disciplinas
 * 
 */
public class Periodo {

	private List<Disciplina> disciplinas;
	private int totalCreditos = 0;

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


	/**
	 * Adiciona disciplinas no período
	 * 
	 * @param disc
	 *            Disciplina a ser adicionada
	 * @throws Exception
	 *             Excessão caso o limite de disciplinas ultrapasse o máximo
	 *             permitido (28 creditos)
	 */

	public void addDisciplina(Disciplina disc) throws Exception {
		if (totalCreditos + disc.getCreditos() <= 28) {
			disciplinas.add(disc);
			totalCreditos += disc.getCreditos();
		} else {
			throw new LimitesExcedidosException();
		}
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

	// INFORMATION EXPERT: Periodo e formado por disciplinas
	/**
	 * Remove a disciplina do período
	 * 
	 * @param disc
	 *            Disciplina a ser removida
	 * 
	 */

	public void rmDisciplina(String disc) {
		@SuppressWarnings("rawtypes")
		Iterator it = disciplinas.iterator();

		Disciplina temp;
		while (it.hasNext()) {
			temp = (Disciplina) it.next();

			if (temp.getNome().equals(disc)) {
				totalCreditos -= temp.getCreditos();
				it.remove();
				break;
			}
		}
	}

	// INFORMATION EXPERT: Periodo tem todas as disciplinas, logo ele pode
	// calcular o total de creditos
	/**
	 * 
	 * @return Retorna o total de creditos ja alocados do periodo
	 */

	public int getTotalCreditos() {
		return totalCreditos;
	}

}
