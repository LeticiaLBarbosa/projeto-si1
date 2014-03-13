package controllers;

import play.db.ebean.Model.Finder;
import models.Aluno;
import models.Periodo;
import models.Planejador;


public class Sistema {
	
	private Aluno aluno;
	private Finder<Long, Aluno> finder = new Finder<Long, Aluno>(Long.class, Aluno.class);

	public Sistema() {
		
		if (finder.all().isEmpty()) {
			this.aluno = new Aluno("login","nome", "senha");
			this.aluno.save();
		} else {
			this.aluno = finder.all().get(0);
		}
		setPeriodosInicial();
		aluno.update();

	}

	private void setPeriodosInicial() {
		for (int i = 0; i < 14; i++){
			Periodo periodo = new Periodo();
			aluno.getPlanejador().getPeriodos().add(periodo);
		}
		setPrimeiroPeriodo();
		setSegundoPeriodo();
		setTerceiroPeriodo();
		setQuartoPeriodo();
		setQuintoPeriodo();
		setSextoPeriodo();
		setSetimoPeriodo();
		setOitavoPeriodo();
		

	}

	private void setPrimeiroPeriodo() {

		String[] primeiro = { "Programação I", "Lab. de Programação I",
				"Cálculo I", "Álgebra Vetorial e Geometria Analítica",
				"Introdução a Computação", "Leitura e Produção de Textos" };

		for (String disciplina : primeiro) {
			aluno.getPlanejador().adicionaDisciplina(aluno.getPlanejador().getDisciplina(disciplina), 0);
		}
	}

	private void setSegundoPeriodo(){

		String[] segundo = { "Cálculo II", "Matemática Discreta",
				"Programação II", "Teoria dos Grafos",
				"Fund. de Física Clássica", "Lab. de Programação II",
				"Metodologia Científica" };

		for (String disciplina : segundo) {
			aluno.getPlanejador().adicionaDisciplina(aluno.getPlanejador().getDisciplina(disciplina),1);
		}
	}

	private void setTerceiroPeriodo(){

		String[] terceiro = { "Álgebra Linear", "Probabilidade e Estatística",
				"Teoria da Computação", "Estruturas de Dados e Algoritmos",
				"Fund. de Física Moderna", "Gerência da Informação",
				"Lab. de Estruturas de Dados e Algoritmos" };

		for (String disciplina : terceiro) {
			aluno.getPlanejador().adicionaDisciplina(aluno.getPlanejador().getDisciplina(disciplina),2);
		}
	}

	private void setQuartoPeriodo(){

		String[] quarto = { "Métodos Estatísticos",
				"Paradigmas de Linguagem de Programação", "Lógica Matemática",
				"Organização e Arquitetura de Computadores I",
				"Lab. de Organização e Arquitetura de Computadores I",
				"Engenharia de Software I", "Sistemas de Informação I" };

		for (String disciplina : quarto) {
			aluno.getPlanejador().adicionaDisciplina(aluno.getPlanejador().getDisciplina(disciplina),3);
		}
	}

	private void setQuintoPeriodo(){

		String[] quinto = { "Informática e Sociedade",
				"Analises e Tecnicas de Algoritmos", "Compiladores",
				"Redes de Computadores", "Banco de Dados I",
				"Sistemas de Informação II", "Lab. de Engenharia de Software" };

		for (String disciplina : quinto) {
			aluno.getPlanejador().adicionaDisciplina(aluno.getPlanejador().getDisciplina(disciplina),4);
		}
	}

	private void setSextoPeriodo(){

		String[] sexto = { "Sistemas Operacionais",
				"Interconexão de Redes de Computadores",
				"Lab. de Interconexão de Redes de Computadores",
				"Inteligencia Artificial I", "Banco de Dados II",
				"Direito e Cidadania", "Optativa 1", "Optativa 2" };

		for (String disciplina : sexto) {
			aluno.getPlanejador().adicionaDisciplina(aluno.getPlanejador().getDisciplina(disciplina),5);
		}
	}

	private void setSetimoPeriodo(){

		String[] setimo = { "Métodos e Software Numéricos",
				"Avaliação de Desempenho de Sistemas Discretos",
				"Projeto em Computação I", "Optativa 3", "Optativa 4",
				"Optativa 5", "Optativa 6" };

		for (String disciplina : setimo) {
			aluno.getPlanejador().adicionaDisciplina(aluno.getPlanejador().getDisciplina(disciplina),6);
		}
	}

	private void setOitavoPeriodo(){
		
		String[] oitavo = { "Projeto em Computação II", "Optativa 7",
				"Optativa 8", "Optativa 9", "Optativa 10", "Optativa 11" };

		for (String disciplina : oitavo) {
			aluno.getPlanejador().adicionaDisciplina(aluno.getPlanejador().getDisciplina(disciplina),7);
		}
	}
	
	public Aluno getAluno() {
		return aluno;
	}
	
	public void alocaDisciplina(int periodo, String nomeDisciplina){
		aluno.getPlanejador().removeDisciplina(nomeDisciplina);
		aluno.getPlanejador().adicionaDisciplina(aluno.getPlanejador().getDisciplina(nomeDisciplina), periodo);
		aluno.getPlanejador().verificaTodasDisciplinas();
		aluno.update();
	}

}
