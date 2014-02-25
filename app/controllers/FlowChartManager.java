package controllers;

import java.util.ArrayList;
import java.util.List;

import models.Catalogo;
import models.Disciplina;
import models.FaltaPreRequisitoException;
import models.NaoPodeAdicionarDisciplinaException;
import models.Periodo;
import models.PeriodoRegular;
import models.PrimeiroPeriodo;

/**
 * 
 * Classe responsável por ser o sistema da aplicação.
 * 
 * @author Ana Luiza Motta Gomes, Fellype Cavalcante e João Pedro Ferreira
 *
 */
public class FlowChartManager {

	
	private Catalogo catalogo;
	private ArrayList<Periodo> periodos;
	/**
	 * Construtor do controller
	 */

	public FlowChartManager() {
		//INICIALIZANDO O FLOWCHART
		catalogo = new Catalogo(); //CREATOR: o Manager é quem mais usa o Catalogo
		periodos = new ArrayList<Periodo>(); // CREATOR: o Manager é feito de periodos
		adicionaPeriodo();
	}

	/**
	 * Recupera o total de créditos de um determinado período
	 * @param periodo Período
	 * @return Quantidade de créditos
	 */
	public int getTotalDeCreditos(int periodo) {
		//INFORMATION EXPERT: O periodo deve responder isso, ele possui disciplinas
		return periodos.get(periodo - 1).getTotalDeCreditos(); 
	}
	/**
	 * Recupera a lista de Disciplinas de um determinado período
	 * @param periodo Período
	 * @return Lista de disciplinas
	 */

	public ArrayList<Disciplina> getDisciplinas(int periodo) {
		//INFORMATION EXPERT: O periodo deve responder isso, ele possui disciplinas
		return periodos.get(periodo - 1).getDisciplinas(); 
	}
	/**
	 * Recupera a quantidade de períodos alocados
	 * @return número de períodos
	 */
	public int getTotalDePeriodos(){ return periodos.size(); } 
	/**
	 * 
	 * @param periodo
	 * @return
	 */
	public int getCreditos(int periodo) {
		return periodos.get(periodo -1).getTotalDeCreditos();
	}
	/**
	 * Adiciona um novo período;
	 */
	
	public void adicionaPeriodo(){
		//CREATOR: O Manager é feito de disciplinas e as usa.
		if(getTotalDePeriodos() > 0)
			periodos.add(new PeriodoRegular());
		else 
			periodos.add(new PrimeiroPeriodo());
	}
	
	/**
	 * Adiciona disciplina a um período
	 * @param id 
	 * @param periodo
	 * @throws Exception se a os pré-requisitos da disciplina ainda não foram cursados
	 */
	public void adicionaDisciplina(String id, int periodo) throws Exception {
		Disciplina aAdicionar = catalogo.get(id);
		if(verificaPreRequisitos(aAdicionar, periodo)) 
			periodos.get(periodo - 1).adicionaDisciplina(aAdicionar);
		else throw new FaltaPreRequisitoException();
	}
	/**
	 * Remove determinada disciplina de um período
	 * @param id
	 * @param periodo
	 * @throws Exception se não existir tal disciplina no período
	 */
	public void removeDisciplina(String id, int periodo) throws Exception {
		Disciplina aRemover = catalogo.get(id);
		periodos.get(periodo - 1).removeDisciplina(aRemover);
		removePreRequisitos(aRemover, periodo);
	}
	/**
	 * Verifica se o mínimo de créditos necessários já foi atingido.
	 * @param periodo
	 * @return número de créditos
	 */
	
	public boolean verificaMinimoDeCreditosDoPeriodo(int periodo){
		//INFORMATION EXPERT: O Manager é o unico que conhece todos os periodos
		return !periodos.get(periodo - 1).hasMinimoDeCredito();
	}
	/**
	 * Verifica quantos créditos falta para atingir o minimo
	 * @param periodo
	 * @return número de créditos 
	 */
	public int verificaQuantosCreditosFaltaNoPeriodo(int periodo){
		//INFORMATION EXPERT: O Manager é o unico que conhece todos os periodos
		return periodos.get(periodo - 1).getQuantoFaltaParaMinimo();
			
	}
	/**
	 * Verifica se ao alocar uma disciplina, todos os seus pré-requisitos foram cursados 
	 * @param disciplina
	 * @param periodo
	 * @return true se os pré-requisitos foram cumpridos e false se não
	 */
	public boolean verificaPreRequisitos(Disciplina disciplina, int periodo){
		//INFORMATION EXPERT: O Manager é o unico que conhece todos os periodos
		boolean resu = true;
		for(Disciplina preRequisito: disciplina.getPreRequisitos())
			if(!jaExisteNosPeriodosAnteriores(preRequisito,periodo)) return false;
		return disciplina.getPreRequisitos().size() == 0? true: resu;
	}
	/**
	 * Verifica se uma determinada disciplina já foi cursada em determinado período
	 * @param disciplina
	 * @param periodo
	 * @return true se já foi cursada e false se ainda não foi
	 */
	public boolean jaExisteNosPeriodosAnteriores(Disciplina disciplina, int periodo){
		//INFORMATION EXPERT: O Manager é o unico que conhece todos os periodos
		for(int i = 0; i < periodo -1; i++){
			if(periodos.get(i).exists(disciplina)) return true;
		}
		return false;
	}
	/**
	 * Remove os pré requisitos de uma disciplina
	 * @param disciplina
	 * @param periodo
	 * @throws Exception
	 */
	public void removePreRequisitos(Disciplina disciplina, int periodo) throws Exception {
			ArrayList<Disciplina> removidas = new ArrayList<Disciplina>();
			for(int i = periodo -1 ; i < periodos.size(); i++){
				removidas.addAll(periodos.get(i).removeDisciplinaSemRequisito(disciplina));
			}
			for(Disciplina removida: removidas) removePreRequisitos(removida, periodo);
	}
	
	/**
	 * Retorna a lista de disciplinas disponíveis, ou seja, as do catálogo menos as que já foram alocadas
	 * @return lista de disciplinas disponíveis
	 */
	
	public ArrayList<Disciplina> getDisciplinasDisponiveis(){
		//INFORMATION EXPERT: O Manager é o unico que o catalogo e as alocadas ao mesmo tempo
		ArrayList<Disciplina> disciplinasDisponiveis = new ArrayList<Disciplina>();
 
		for (Disciplina disciplina : catalogo.getDisciplinas()) {
			if (!getDisciplinasAlocadas().contains(disciplina)){
				disciplinasDisponiveis.add(disciplina);
			}
		}
		return disciplinasDisponiveis;
 
	}
	/**
	 * Recupera a lista de disciplinas que já foram alocadas 
	 * @return lista de disciplinas alocadas
	 */
 
	private ArrayList<Disciplina> getDisciplinasAlocadas() {
		//INFORMATION EXPERT: O Manager é o unico que conhece todos os periodos
		ArrayList<Disciplina> disciplinasAlocadas = new ArrayList<Disciplina>();
		for (Periodo periodo : periodos ) {
			for (Disciplina disciplina : periodo.getDisciplinas()) {
				disciplinasAlocadas.add(disciplina);
		}
	}
		return disciplinasAlocadas;
	}

}
