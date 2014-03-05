package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import Exceptions.PreRequisitosInsuficientesException;
import models.CatalogoDisciplinas;
import models.Disciplina;
import models.Periodo;

/**
 * Classe responsável pelo controle do sistema
 * 
 */

// Controller: classe principal do sistema, pois ela quem dá as coordenadas para
// as outras.
public class Sistema {

	// CREATOR: Ele eh formado por periodos
	static private List<Periodo> periodos;
	static private CatalogoDisciplinas catalogo;

	/**
	 * Construtor
	 */
	public Sistema() {
		periodos = new ArrayList<Periodo>();
		catalogo = new CatalogoDisciplinas();
		try {
			setPeriodosInicial();
		} catch (Exception e) {
			//Default;
		}

	}

	// Nao trata a excessao pq o primeiro periodo eh sempre default
	private void setPeriodosInicial() throws Exception {
		setPrimeiroPeriodo();
		setSegundoPeriodo();
		setTerceiroPeriodo();
		setQuartoPeriodo();
		setQuintoPeriodo();
		setSextoPeriodo();
		setSetimoPeriodo();
		setOitavoPeriodo();
		for (int i = 0; i < 6; i++){
			Periodo periodo = new Periodo();
			periodos.add(periodo);
		}

	}

	private void setPrimeiroPeriodo() throws Exception {

		String[] primeiro = { "Programação I", "Lab. de Programação I",
				"Cálculo I", "Álgebra Vetorial e Geometria Analítica",
				"Introdução a Computação", "Leitura e Produção de Textos" };

		for (String disciplina : primeiro) {
			this.addDisciplinasPeriodo(0, disciplina);
		}
	}

	private void setSegundoPeriodo() throws Exception {

		String[] segundo = { "Cálculo II", "Matemática Discreta",
				"Programação II", "Teoria dos Grafos",
				"Fund. de Física Clássica", "Lab. de Programação II",
				"Metodologia Científica" };

		for (String disciplina : segundo) {
			this.addDisciplinasPeriodo(1, disciplina);
		}
	}

	private void setTerceiroPeriodo() throws Exception {

		String[] terceiro = { "Álgebra Linear", "Probabilidade e Estatística",
				"Teoria da Computação", "Estruturas de Dados e Algoritmos",
				"Fund. de Física Moderna", "Gerência da Informação",
				"Lab. de Estruturas de Dados e Algoritmos" };

		for (String disciplina : terceiro) {
			this.addDisciplinasPeriodo(2, disciplina);
		}
	}

	private void setQuartoPeriodo() throws Exception {

		String[] quarto = { "Métodos Estatísticos",
				"Paradigmas de Linguagem de Programação", "Lógica Matemática",
				"Organização e Arquitetura de Computadores I",
				"Lab. de Organização e Arquitetura de Computadores I",
				"Engenharia de Software I", "Sistemas de Informação I" };

		for (String disciplina : quarto) {
			this.addDisciplinasPeriodo(3, disciplina);
		}
	}

	private void setQuintoPeriodo() throws Exception {

		String[] quinto = { "Informática e Sociedade",
				"Analises e Tecnicas de Algoritmos", "Compiladores",
				"Redes de Computadores", "Banco de Dados I",
				"Sistemas de Informação II", "Lab. de Engenharia de Software" };

		for (String disciplina : quinto) {
			this.addDisciplinasPeriodo(4, disciplina);
		}
	}

	private void setSextoPeriodo() throws Exception {

		String[] sexto = { "Sistemas Operacionais",
				"Interconexão de Redes de Computadores",
				"Lab. de Interconexão de Redes de Computadores",
				"Inteligencia Artificial I", "Banco de Dados II",
				"Direito e Cidadania", "Optativa 1", "Optativa 2" };

		for (String disciplina : sexto) {
			this.addDisciplinasPeriodo(5, disciplina);
		}
	}

	private void setSetimoPeriodo() throws Exception {

		String[] setimo = { "Métodos e Software Numéricos",
				"Avaliação de Desempenho de Sistemas Discretos",
				"Projeto em Computação I", "Optativa 3", "Optativa 4",
				"Optativa 5", "Optativa 6" };

		for (String disciplina : setimo) {
			this.addDisciplinasPeriodo(6, disciplina);
		}
	}

	private void setOitavoPeriodo() throws Exception {
		
		String[] oitavo = { "Projeto em Computação II", "Optativa 7",
				"Optativa 8", "Optativa 9", "Optativa 10", "Optativa 11" };

		for (String disciplina : oitavo) {
			this.addDisciplinasPeriodo(7, disciplina);
		}
	}

	/**
	 * 
	 * @return Retorna os períodos ja criados do sistema
	 */
	public List<Periodo> getPeriodos() {
		return periodos;
	}

	/**
	 * 
	 * @return Retorna a lista de disciplinas do curso
	 */
	public List<Disciplina> getCatalogoDisc() {
		return catalogo.getCatalogo();
	}

	// INFORMATION EXPERT: Sistema possui a lista de periodos e conhece o
	// catalogo
	/**
	 * Adiciona uma disciplina em um periodo pelo nome
	 * 
	 * @param periodo
	 *            Numero do periodo
	 * @param nome
	 *            Nome da disciplina
	 * @throws Exception
	 * 
	 */
	public void addDisciplinasPeriodo(int periodo, String nome)
			throws Exception {
		int i = catalogo.disciplinaIndice(nome);

		addDisciplinasPeriodo(periodo, catalogo.getDisciplinaPorIndice(i));
	}

	/**
	 * Adiciona uma disciplina em um periodo pelo disciplina já criada
	 * 
	 * @param periodo
	 *            Numero do periodo
	 * @param nome
	 *            Nome da disciplina
	 * @throws Exception
	 * 
	 */
	public void addDisciplinasPeriodo(int periodo, Disciplina disc)
			throws Exception {
		if (periodos.size() <= periodo) {
			Periodo novoPerido = new Periodo();
			periodos.add(novoPerido);
			addDisciplinasPeriodo(periodo, disc);
		} else {
			int numPr = disc.getNumPreRequisitos(); // numpr significa o numero
													// de pre-requisitos de cada
													// disciplina
			for (int i = 0; i < periodo; i++) {
				for (int j = 0; j < periodos.get(i).numeroDisciplinas(); j++) {
					if (disc.getPreRequisitos().contains(
							periodos.get(i).indiceDisciplina(j).getNome())) {
						numPr--;
					}
				}
			}

			if (numPr == 0) {
				periodos.get(periodo).addDisciplina(disc);
				disc.setAlocada();
			} else {
				throw new PreRequisitosInsuficientesException();
			}
		}
	}

	// INFORMATION EXPERT: Sistema possui a lista de periodos e conhece o
	// catalogo
	/**
	 * Remove disciplina e seus preRequisitos
	 * 
	 * @param nome
	 *            Nome da disciplina a ser removida
	 */
	public void removeDisciplinaPeriodo(String nome) {
		int i = catalogo.disciplinaIndice(nome);

		if (catalogo.getDisciplina(nome).getAlocada()) {

			catalogo.getCatalogo().get(i).setAlocada();

			Disciplina disc;
			Periodo periodo;

			for (int j = 0; j < periodos.size(); j++) {
				periodo = periodos.get(j);

				for (int k = 0; k < periodo.numeroDisciplinas(); k++) {

					disc = periodo.indiceDisciplina(k);

					if (disc.getNome().equals(nome)) {
						periodo.rmDisciplina(nome);

						// Zera o contador ao remover uma disciplina.
						j = 0;
						k = 0;
						rmDisciplinaPreRequisitos(nome);
					}
				}

			}
		}
	}

	/**
	 * Verifica se a disciplina e prerequisito de alguma, se sim a remove usando
	 * o metodo removeDisciplinaPeriodo
	 * 
	 * @param nome
	 *            Nome da disciplina
	 */
	private void rmDisciplinaPreRequisitos(String nome) {
		Periodo periodo;
		Disciplina disc;

		for (int j = 0; j < periodos.size(); j++) {
			periodo = periodos.get(j);

			for (int i = 0; i < periodo.numeroDisciplinas(); i++) {

				disc = periodo.indiceDisciplina(i);

				if (disc.getPreRequisitos().contains(nome)) {
					j = 0;
					i = 0;
					removeDisciplinaPeriodo(disc.getNome());

				}
			}
		}
	}

}
