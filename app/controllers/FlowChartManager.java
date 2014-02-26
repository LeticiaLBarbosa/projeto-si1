package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Catalogo;
import models.Disciplina;
import models.FaltaPreRequisitoException;
import models.Periodo;
import models.PeriodoRegular;
import models.Plano;
import models.PrimeiroPeriodo;

/**
 * 
 * Classe responsável por ser o sistema da aplicação.
 * 
 * @author Ana Luiza Motta Gomes, Fellype Cavalcante e João Pedro Ferreira
 *
 */
public class FlowChartManager {

	private Plano plano;
	/**
	 * Construtor do controller
	 * @throws Exception 
	 * @throws IOException 
	 */

	public FlowChartManager() {
		//INICIALIZANDO O FLOWCHART
		plano = new Plano();
		
	}

	/**
	 * Recupera o total de créditos de um determinado período
	 * @param periodo Período
	 * @return Quantidade de créditos
	 */
	public int getTotalDeCreditos(int periodo) {
		return plano.getTotalDeCreditos(periodo);
	}
	/**
	 * Recupera a lista de Disciplinas de um determinado período
	 * @param periodo Período
	 * @return Lista de disciplinas
	 */
	

	public ArrayList<Disciplina> getDisciplinas(int periodo) {
		return plano.getDisciplinas(periodo);
	}
	/**
	 * Recupera a quantidade de períodos alocados
	 * @return número de períodos
	 */
	public int getTotalDePeriodos(){ 
		return plano.getTotalDePeriodos(); } 
	/**
	 * 
	 * @param periodo
	 * @return
	 */
	
	public int getCreditos(int periodo) {
		return plano.getCreditos(periodo);
	}
	/**
	 * Adiciona um novo período;
	 */
	
	public void adicionaPeriodo(){
		plano.adicionaPeriodo();
	}
	
	/**
	 * Adiciona disciplina a um período
	 * @param id 
	 * @param periodo
	 * @throws Exception se a os pré-requisitos da disciplina ainda não foram cursados
	 */
	public void adicionaDisciplina(String id, int periodo) throws Exception {
		plano.adicionaDisciplina(id, periodo);
	}
	/**
	 * Remove determinada disciplina de um período
	 * @param id
	 * @param periodo
	 * @throws Exception se não existir tal disciplina no período
	 */
	public void removeDisciplina(String id, int periodo) throws Exception {
		plano.removeDisciplina(id, periodo);
	}
	/**
	 * Verifica se o mínimo de créditos necessários já foi atingido.
	 * @param periodo
	 * @return número de créditos
	 */
	
	public boolean verificaMinimoDeCreditosDoPeriodo(int periodo){
		return plano.verificaMinimoDeCreditosDoPeriodo(periodo);
	}
	/**
	 * Verifica quantos créditos falta para atingir o minimo
	 * @param periodo
	 * @return número de créditos 
	 */
	public int verificaQuantosCreditosFaltaNoPeriodo(int periodo){
		return plano.verificaQuantosCreditosFaltaNoPeriodo(periodo);
			
	}
	
	
	
	/**
	 * Retorna a lista de disciplinas disponíveis, ou seja, as do catálogo menos as que já foram alocadas
	 * @return lista de disciplinas disponíveis
	 */
	
	public ArrayList<Disciplina> getDisciplinasDisponiveis(){
		return plano.getDisciplinasDisponiveis();
 
	}
 

}
