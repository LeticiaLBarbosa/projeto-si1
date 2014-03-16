package models;

import java.util.*;

public class CatalogoDisciplinas{
	
	private List<Disciplina> todasDisciplinas = new ArrayList<Disciplina>();
	private static final int DOIS_CREDITOS = 2;
	private static final int QUATRO_CREDITOS = 4;
	private static final int SEIS_CREDITOS = 6;
	private static final int FACIL = 1;
	private static final int MEDIO = 2;
	private static final int DIFICIL = 3;

	public CatalogoDisciplinas() {
		todasDisciplinas.add(new Disciplina("Programação I", QUATRO_CREDITOS, MEDIO));
		todasDisciplinas.add(new Disciplina("Lab. de Programação I", QUATRO_CREDITOS, FACIL));
		todasDisciplinas.add(new Disciplina("Introdução a Computação", QUATRO_CREDITOS, MEDIO));
		todasDisciplinas.add(new Disciplina("Leitura e Produção de Textos", QUATRO_CREDITOS,FACIL));
		todasDisciplinas.add(new Disciplina("Cálculo I", QUATRO_CREDITOS, MEDIO));
		todasDisciplinas.add(new Disciplina("Álgebra Vetorial e Geometria Analítica", QUATRO_CREDITOS, MEDIO));

		// 2periodo
		todasDisciplinas.add(new Disciplina("Cálculo II", QUATRO_CREDITOS, listaDePreRequisitos("Cálculo I"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Matemática Discreta", QUATRO_CREDITOS, MEDIO));
		todasDisciplinas.add(new Disciplina("Programação II", QUATRO_CREDITOS, listaDePreRequisitos("Programação I, Lab. de Programação I, Introdução a Computação"), MEDIO));
		todasDisciplinas.add(new Disciplina("Teoria dos Grafos", DOIS_CREDITOS, listaDePreRequisitos("Programação I, Lab. de Programação I"), MEDIO));
		todasDisciplinas.add(new Disciplina("Fund. de Física Clássica", QUATRO_CREDITOS, listaDePreRequisitos("Cálculo I, Álgebra Vetorial e Geometria Analítica"), MEDIO));
		todasDisciplinas.add(new Disciplina("Lab. de Programação II", QUATRO_CREDITOS, listaDePreRequisitos("Programação I, Lab. de Programação I, Introdução a Computação"), MEDIO));

		// 3periodo
		todasDisciplinas.add(new Disciplina("Álgebra Linear", QUATRO_CREDITOS, listaDePreRequisitos("Álgebra Vetorial e Geometria Analítica"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Probabilidade e Estatística", QUATRO_CREDITOS, listaDePreRequisitos("Cálculo II"), MEDIO));
		todasDisciplinas.add(new Disciplina("Teoria da Computação", QUATRO_CREDITOS, listaDePreRequisitos("Teoria dos Grafos, Introdução a Computação, Matemática Discreta"), MEDIO));
		todasDisciplinas.add(new Disciplina("Estruturas de Dados e Algoritmos", QUATRO_CREDITOS, listaDePreRequisitos("Teoria dos Grafos, Programação II, Lab. de Programação II"), MEDIO));
		todasDisciplinas.add(new Disciplina("Fund. de Física Moderna", QUATRO_CREDITOS, listaDePreRequisitos("Cálculo II, Fund. de Física Clássica"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Gerência da Informação", QUATRO_CREDITOS, FACIL));
		todasDisciplinas.add(new Disciplina("Lab. de Estruturas de Dados e Algoritmos", QUATRO_CREDITOS, listaDePreRequisitos("Teoria dos Grafos, Programação II, Lab. de Programação II"),MEDIO));

		// 4periodo
		todasDisciplinas.add(new Disciplina("Métodos Estatísticos", QUATRO_CREDITOS, listaDePreRequisitos("Álgebra Linear, Probabilidade e Estatística"), MEDIO));
		todasDisciplinas.add(new Disciplina("Paradigmas de Linguagem de Programação", DOIS_CREDITOS, listaDePreRequisitos("Teoria da Computação, Estruturas de Dados e Algoritmos, Lab. de Estruturas de Dados e Algoritmos"), MEDIO));
		todasDisciplinas.add(new Disciplina("Lógica Matemática", QUATRO_CREDITOS, listaDePreRequisitos("Teoria da Computação"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Organização e Arquitetura de Computadores I", QUATRO_CREDITOS, listaDePreRequisitos("Estruturas de Dados e Algoritmos, Lab. de Estruturas de Dados e Algoritmos, Fund. de Física Moderna"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Lab. de Organização e Arquitetura de Computadores I", QUATRO_CREDITOS, listaDePreRequisitos("Estruturas de Dados e Algoritmos, Lab. de Estruturas de Dados e Algoritmos, Fund. de Física Moderna"),DIFICIL));
		todasDisciplinas.add(new Disciplina("Engenharia de Software I", QUATRO_CREDITOS, listaDePreRequisitos("Programação II, Lab. de Programação II, Probabilidade e Estatística"),DIFICIL));
		todasDisciplinas.add(new Disciplina("Sistemas de Informação I", QUATRO_CREDITOS, listaDePreRequisitos("Gerência da Informação"), MEDIO));

		// 5periodo
		todasDisciplinas.add(new Disciplina("Informática e Sociedade", DOIS_CREDITOS, FACIL));
		todasDisciplinas.add(new Disciplina("Metodologia Científica", QUATRO_CREDITOS, MEDIO));
		todasDisciplinas.add(new Disciplina("Analises e Tecnicas de Algoritmos", QUATRO_CREDITOS, listaDePreRequisitos("Estruturas de Dados e Algoritmos, Lab. de Estruturas de Dados e Algoritmos, Cálculo II, Lógica Matemática"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Compiladores", QUATRO_CREDITOS, listaDePreRequisitos("Paradigmas de Linguagem de Programação, Organização e Arquitetura de Computadores I, Lab. de Organização e Arquitetura de Computadores I"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Redes de Computadores", QUATRO_CREDITOS, listaDePreRequisitos("Organização e Arquitetura de Computadores I, Lab. de Organização e Arquitetura de Computadores I"), MEDIO));
		todasDisciplinas.add(new Disciplina("Banco de Dados I", QUATRO_CREDITOS, listaDePreRequisitos("Sistemas de Informação I"), MEDIO));
		todasDisciplinas.add(new Disciplina("Sistemas de Informação II", QUATRO_CREDITOS, listaDePreRequisitos("Sistemas de Informação I"), FACIL));
		todasDisciplinas.add(new Disciplina("Lab. de Engenharia de Software", DOIS_CREDITOS, listaDePreRequisitos("Engenharia de Software I"), MEDIO));

		// 6periodo
		todasDisciplinas.add(new Disciplina("Sistemas Operacionais", QUATRO_CREDITOS, listaDePreRequisitos("Organização e Arquitetura de Computadores I, Lab. de Organização e Arquitetura de Computadores I"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Interconexão de Redes de Computadores", DOIS_CREDITOS, listaDePreRequisitos("Redes de Computadores"), MEDIO));
		todasDisciplinas.add(new Disciplina("Lab. de Interconexão de Redes de Computadores", DOIS_CREDITOS, listaDePreRequisitos("Redes de Computadores"), MEDIO));
		todasDisciplinas.add(new Disciplina("Inteligencia Artificial I", QUATRO_CREDITOS, listaDePreRequisitos("Analises e Tecnicas de Algoritmos, Paradigmas de Linguagem de Programação, Métodos Estatísticos"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Banco de Dados II", QUATRO_CREDITOS, listaDePreRequisitos("Banco de Dados I, Sistemas de Informação II"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Direito e Cidadania", QUATRO_CREDITOS, FACIL));
		todasDisciplinas.add(new Disciplina("Optativa 1", QUATRO_CREDITOS, FACIL));
		todasDisciplinas.add(new Disciplina("Optativa 2", QUATRO_CREDITOS, FACIL));

		// 7periodo
		todasDisciplinas.add(new Disciplina("Métodos e Software Numéricos",QUATRO_CREDITOS, listaDePreRequisitos("Álgebra Linear, Analises e Tecnicas de Algoritmos"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Avaliação de Desempenho de Sistemas Discretos", QUATRO_CREDITOS, listaDePreRequisitos("Probabilidade e Estatística"), MEDIO));
		todasDisciplinas.add(new Disciplina("Projeto em Computação I", QUATRO_CREDITOS, listaDePreRequisitos("Lab. de Engenharia de Software, Metodologia Científica"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Optativa 3", QUATRO_CREDITOS, FACIL));
		todasDisciplinas.add(new Disciplina("Optativa 4", QUATRO_CREDITOS, FACIL));
		todasDisciplinas.add(new Disciplina("Optativa 5", QUATRO_CREDITOS, FACIL));
		todasDisciplinas.add(new Disciplina("Optativa 6", QUATRO_CREDITOS, FACIL));
		
		// 8periodo
		todasDisciplinas.add(new Disciplina("Projeto em Computação II", SEIS_CREDITOS, listaDePreRequisitos("Projeto em Computação I"), DIFICIL));
		todasDisciplinas.add(new Disciplina("Optativa 7", QUATRO_CREDITOS, FACIL));
		todasDisciplinas.add(new Disciplina("Optativa 8", QUATRO_CREDITOS, FACIL));
		todasDisciplinas.add(new Disciplina("Optativa 9", QUATRO_CREDITOS, FACIL));
		todasDisciplinas.add(new Disciplina("Optativa 10", QUATRO_CREDITOS, FACIL));
		todasDisciplinas.add(new Disciplina("Optativa 11", QUATRO_CREDITOS, FACIL));

	}

	private List<String> listaDePreRequisitos(String disciplinas) {
		List<String> listaDePreRequisitos = new ArrayList<String>();
		String[] aux = disciplinas.split(", ");
		for (String disciplina : aux) {
			listaDePreRequisitos.add(disciplina);
		}
		return listaDePreRequisitos;
	}

	public int disciplinaIndice(String nome) {
		int result = -1;
		for (int i = 0; i < todasDisciplinas.size(); i++) {
			if (todasDisciplinas.get(i).getNome().equals(nome)) {
				result = i;
			}
		}

		return result;
	}

	public List<Disciplina> getCatalogo() {
		return todasDisciplinas;
	}


	public Disciplina getDisciplina(String nome) {
		for (int i = 0; i < todasDisciplinas.size(); i++) {
			if (todasDisciplinas.get(i).getNome().equals(nome)) {
				return todasDisciplinas.get(i);
			}
		}
		return null;

	}

	public Disciplina getDisciplinaPorIndice(int i) {
		return todasDisciplinas.get(i);
	}

}