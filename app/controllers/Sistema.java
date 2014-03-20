package controllers;

import play.db.ebean.Model.Finder;
import models.Aluno;

public class Sistema {

	private Aluno aluno;

	private Finder<Long, Aluno> finder = new Finder<Long, Aluno>(Long.class, Aluno.class);

	public Sistema() {
		if (finder.all().isEmpty()) {
			aluno = new Aluno("login","nome", "senha");
			aluno.save();

		} else {
			aluno = finder.all().get(0);
		}
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void alocaDisciplina(int periodo, String nomeDisciplina){
		aluno.getPlanejador().alocaDisciplinaPeriodo(nomeDisciplina, periodo);
		
		aluno.save();
	}
	
	public void alocaDisciplinaDisponivel(String nomeDisciplina){
		aluno.getPlanejador().alocaDisciplinaEmDisponivel(nomeDisciplina);
		
		aluno.save();
	}

	public void reset() {
		aluno.reiniciaPlanejador();
		
		aluno.save();
	}


}