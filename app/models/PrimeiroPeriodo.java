package models;

import java.util.ArrayList;

public class PrimeiroPeriodo extends Periodo {
	
	public PrimeiroPeriodo() {
		ArrayList<Disciplina> preRequisitos = new ArrayList<Disciplina>(); 	
		//Vazio. Sem Pre-requisitos para as disciplinas de primeiro período
		

		disciplinas.add(new Disciplina("Cálculo Diferencial e Integral I", 4, preRequisitos,"41"));
		disciplinas.add(new Disciplina("Álgebra Vetorial e Geometria Analítica", 4, preRequisitos,"42"));
		disciplinas.add(new Disciplina("Leitura e Produção de Textos", 4, preRequisitos,"0"));
		disciplinas.add(new Disciplina("Programação I", 4, preRequisitos,"39"));
		disciplinas.add(new Disciplina("Introdução à Computação", 4, preRequisitos,"41"));
		disciplinas.add(new Disciplina("Laboratório de Programação I", 4, preRequisitos,"40"));
	}


	@Override
	public void adicionaDisciplina(Disciplina disciplina) throws Exception {
		throw new NaoPodeAdicionarDisciplinaException(); //PERIODO IMUTAVEL
	}
	@Override
	public void removeDisciplina(Disciplina disciplina) throws Exception {
		throw new NaoPodeRemoverDisciplinaException(); //PERIODO IMUTAVEL
	}


	
}
