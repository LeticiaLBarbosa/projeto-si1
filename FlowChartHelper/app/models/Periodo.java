package models;

import java.util.ArrayList;
/**
 * Super classe abstrata de um período. Simula os métodos básicos que as classes que a implementam devem obrigatoriamente ter
 * @author Ana Luiza, Fellype e João Pedro
 *
 */

public abstract class Periodo {

	ArrayList<Disciplina> disciplinas; 
	/**
	 * Construtor do Período
	 */
	
	public Periodo(){
		disciplinas = new ArrayList<Disciplina>();
	}
	/**
	 * Recupera o total de créditos de um período
	 * @return Quantidade de créditos
	 */
	
	public int getTotalDeCreditos(){
		int soma = 0;
		for(Disciplina disciplina: disciplinas) soma +=  disciplina.getCreditos();
		return soma;
	}
	/**
	 *Recupera as disciplinas de um período 
	 * @return Disciplina
	 */
	
	public ArrayList<Disciplina> getDisciplinas() {
		//INFORMATION EXPERT: o periodo conhece suas disciplinas e pode externa-las
		return disciplinas;
	}

	public abstract void adicionaDisciplina(Disciplina disciplina) throws Exception;

	public abstract void removeDisciplina(Disciplina disciplina) throws Exception;
	/**
	 * Verifica se determinada disciplina está alocada no período
	 * @param disciplina
	 * @return true se o período contêm a disciplina e false se não tiver
	 */
	public boolean exists(Disciplina disciplina) {
		//INFORMATION EXPERT: Somente o periodo pode determinar se possui uma disciplina
		return disciplinas.contains(disciplina);
	}
	/**
	 * Recupera a quantidade de créditos que faltam para completar o mínimo de um período
	 * @return Número de créditos para completar o mínimo
	 */

	public int getQuantoFaltaParaMinimo() {
		//INFORMATION EXPERT: O periodo tem a informacao para determinar quanto falta
		return hasMinimoDeCredito()? 0: 14 - getTotalDeCreditos();
	}
	/**
	 * Verifica se o período tem o minimo de créditos 
	 * @return true se tiver o mínimo de créditos e false se não for suficiente.
	 */

	public boolean hasMinimoDeCredito() {
		//INFORMATION EXPERT: O periodo tem a informacao para determinar se tem o minimo
		if (getTotalDeCreditos() >= 14){
			return true;
		} 
		return false;
	}
	
	
	
	}
