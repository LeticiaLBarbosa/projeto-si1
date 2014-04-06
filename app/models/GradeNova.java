package models;

import Exceptions.PreRequisitoInvalidoException;

public class GradeNova extends Grade{

	private static GradeNova instance;

	private GradeNova(){
		instanciaDisciplinas();
	}

	public static GradeNova getInstance(){
		if(instance == null){
			instance = new GradeNova();
		}

		return instance;		
	}

	@Override
	protected void instanciaDisciplinas() {

		// Primeiro

		todasDisciplinas.add(new Disciplina("Programação I", QUATRO_CREDITOS,
				MEDIO));

		todasDisciplinas.add(new Disciplina("Lab. de Programação I", QUATRO_CREDITOS,
				MEDIO));

		todasDisciplinas.add(new Disciplina("Mat. Discreta I", QUATRO_CREDITOS,
				MEDIO));

		todasDisciplinas.add(new Disciplina("Introdução à Computação", QUATRO_CREDITOS,
				MEDIO));

		todasDisciplinas.add(new Disciplina("Optativa Geral 1", QUATRO_CREDITOS,
				FACIL));



		try{
			
			//Segundo
			
			todasDisciplinas.add(new Disciplina("Mat. Discreta II", QUATRO_CREDITOS,
					listaDePreRequisitos("Mat. Discreta I"),MEDIO));

			todasDisciplinas.add(new Disciplina("Cálculo I", QUATRO_CREDITOS,MEDIO));

			todasDisciplinas.add(new Disciplina("Programação II", QUATRO_CREDITOS,
					listaDePreRequisitos("Programação I, Lab. de Programação I"),FACIL));

			todasDisciplinas.add(new Disciplina("Lab. de Programação II", QUATRO_CREDITOS,
					listaDePreRequisitos("Programação I, Lab. de Programação I"),FACIL));

			todasDisciplinas.add(new Disciplina("Optativa Geral 2", QUATRO_CREDITOS,
					FACIL));

			//Terceiro

			todasDisciplinas.add(new Disciplina("Álgebra Linear", QUATRO_CREDITOS,
					listaDePreRequisitos("Mat. Discreta I"),DIFICIL));

			todasDisciplinas.add(new Disciplina("Teoria dos Grafos", QUATRO_CREDITOS,MEDIO));

			todasDisciplinas.add(new Disciplina("Cálculo II", QUATRO_CREDITOS,
					listaDePreRequisitos("Cálculo I"),DIFICIL));

			todasDisciplinas.add(new Disciplina("Estrutura de Dados", QUATRO_CREDITOS,
					listaDePreRequisitos("Programação II, Lab. de Programação II"),DIFICIL));

			todasDisciplinas.add(new Disciplina("Lab. de Estrutura de Dados", QUATRO_CREDITOS,
					listaDePreRequisitos("Programação II, Lab. de Programação II"),MEDIO));

			todasDisciplinas.add(new Disciplina("Lógica para Computação", QUATRO_CREDITOS,
					listaDePreRequisitos("Mat. Discreta I"),MEDIO));

			//Quarto

			todasDisciplinas.add(new Disciplina("Introdução à Probabilidade", QUATRO_CREDITOS,
					listaDePreRequisitos("Cálculo I, Mat. Discreta II"),MEDIO));

			todasDisciplinas.add(new Disciplina("Projeto de Software", QUATRO_CREDITOS,MEDIO));

			todasDisciplinas.add(new Disciplina("Paradigmas de Linguagens de Prog.", QUATRO_CREDITOS,MEDIO));

			todasDisciplinas.add(new Disciplina("Banco de Dados I", QUATRO_CREDITOS, listaDePreRequisitos("Estrutura de Dados") ,MEDIO));

			todasDisciplinas.add(new Disciplina("Organização e Arquitetura de Computadores", QUATRO_CREDITOS,
					DIFICIL));

			todasDisciplinas.add(new Disciplina("Lab. de Organização e Arquitetura de Computadores",
					QUATRO_CREDITOS,DIFICIL));

			//Quinto

			todasDisciplinas.add(new Disciplina("Estatística Aplicada", QUATRO_CREDITOS,
					listaDePreRequisitos("Introdução à Probabilidade"),DIFICIL));

			todasDisciplinas.add(new Disciplina("Análise de Sistemas", QUATRO_CREDITOS,MEDIO));

			todasDisciplinas.add(new Disciplina("Eng. de Software", QUATRO_CREDITOS,MEDIO));

			todasDisciplinas.add(new Disciplina("Redes de Computadores", QUATRO_CREDITOS,MEDIO));

			todasDisciplinas.add(new Disciplina("Sistemas Operacionais", QUATRO_CREDITOS,MEDIO));

			todasDisciplinas.add(new Disciplina("Teoria da Computação", QUATRO_CREDITOS,
					listaDePreRequisitos("Paradigmas de Linguagens de Prog."),MEDIO));

			//Sexto

			todasDisciplinas.add(new Disciplina("Metodologia Científica", QUATRO_CREDITOS,MEDIO));

			todasDisciplinas.add(new Disciplina("Programação Concorrente", QUATRO_CREDITOS,
					listaDePreRequisitos("Sistemas Operacionais"),MEDIO));

			todasDisciplinas.add(new Disciplina("Inteligência Artificial", QUATRO_CREDITOS,
					listaDePreRequisitos("Teoria da Computação"),MEDIO));

			todasDisciplinas.add(new Disciplina("Optativa Específica 1", QUATRO_CREDITOS,
					FACIL));

			todasDisciplinas.add(new Disciplina("Optativa Específica 2", QUATRO_CREDITOS,
					FACIL));

			//Setimo

			todasDisciplinas.add(new Disciplina("Análise e Técnicas de Algoritmos", QUATRO_CREDITOS,DIFICIL));

			todasDisciplinas.add(new Disciplina("Compiladores", QUATRO_CREDITOS,DIFICIL));

			todasDisciplinas.add(new Disciplina("Optativa Específica 3", QUATRO_CREDITOS,FACIL));

			todasDisciplinas.add(new Disciplina("Optativa Específica 4", QUATRO_CREDITOS,FACIL));

			todasDisciplinas.add(new Disciplina("Optativa Geral 3", QUATRO_CREDITOS,FACIL));

			//Oitavo

			todasDisciplinas.add(new Disciplina("Projeto em Computação I", QUATRO_CREDITOS,
					listaDePreRequisitos("Eng. de Software"),MEDIO));

			todasDisciplinas.add(new Disciplina("Optativa Específica 5", QUATRO_CREDITOS,
					FACIL));

			todasDisciplinas.add(new Disciplina("Optativa Específica 6", QUATRO_CREDITOS,
					FACIL));

			todasDisciplinas.add(new Disciplina("Optativa Geral 4", QUATRO_CREDITOS,
					FACIL));

			todasDisciplinas.add(new Disciplina("Trabalho de Conclusão de Curso I", QUATRO_CREDITOS,
					MEDIO));

			//Nono

			todasDisciplinas.add(new Disciplina("Projeto em Computação II", QUATRO_CREDITOS,
					listaDePreRequisitos("Projeto em Computação I"),MEDIO));

			todasDisciplinas.add(new Disciplina("Optativa Específica 7", QUATRO_CREDITOS,
					FACIL));

			todasDisciplinas.add(new Disciplina("Optativa Específica 8", QUATRO_CREDITOS,
					FACIL));

			todasDisciplinas.add(new Disciplina("Optativa Específica 9", QUATRO_CREDITOS,
					FACIL));

			todasDisciplinas.add(new Disciplina("Optativa Específica 10", QUATRO_CREDITOS,
					FACIL));


			todasDisciplinas.add(new Disciplina("Trabalho de Conclusão de Curso II", QUATRO_CREDITOS,
					listaDePreRequisitos("Trabalho de Conclusão de Curso I"),MEDIO));

		} catch (PreRequisitoInvalidoException e) {
			e.printStackTrace();
		}

		setPeriodosDefault();

	}

	@Override
	protected void setPeriodosDefault() {

		String[] primeiro = { "Programação I", "Lab. de Programação I",
				"Mat. Discreta I", "Introdução à Computação", "Optativa Geral 1" };

		String[] segundo = { "Cálculo I", "Mat. Discreta II", "Programação II"
				, "Lab. de Programação II",	"Optativa Geral 2" };

		String[] terceiro = { "Álgebra Linear", "Teoria dos Grafos",
				"Cálculo II", "Estrutura de Dados", "Lab. de Estrutura de Dados",
		"Lógica para Computação"};

		String[] quarto = { "Introdução à Probabilidade","Projeto de Software",
				"Paradigmas de Linguagens de Prog.", "Organização e Arquitetura de Computadores",
				"Lab. de Organização e Arquitetura de Computadores", "Banco de Dados I"};

		String[] quinto = { "Estatística Aplicada",	"Análise de Sistemas", "Eng. de Software",
				"Redes de Computadores", "Sistemas Operacionais", "Teoria da Computação"};

		String[] sexto = { "Metodologia Científica",
				"Programação Concorrente","Inteligência Artificial","Optativa Específica 1","Optativa Específica 2"};

		String[] setimo = { "Análise e Técnicas de Algoritmos",
				"Compiladores",	"Optativa Específica 3", "Optativa Específica 4", "Optativa Geral 3"};

		String[] oitavo = { "Projeto em Computação I", "Optativa Específica 5",
				"Optativa Específica 6", "Optativa Geral 4", "Trabalho de Conclusão de Curso I"};

		String[] nono = { "Projeto em Computação II", "Optativa Específica 7",
				"Optativa Específica 8", "Optativa Específica 9", "Optativa Específica 10", "Trabalho de Conclusão de Curso II"};

		periodosDefault.add(primeiro);
		periodosDefault.add(segundo);
		periodosDefault.add(terceiro);
		periodosDefault.add(quarto);
		periodosDefault.add(quinto);
		periodosDefault.add(sexto);
		periodosDefault.add(setimo);
		periodosDefault.add(oitavo);
		periodosDefault.add(nono);


	}

}
