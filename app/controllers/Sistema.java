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
		aluno.getPlanejador().removeDisciplina(nomeDisciplina);

		aluno.getPlanejador().adicionaDisciplina(aluno.getPlanejador().getDisciplina(nomeDisciplina), periodo);

		aluno.update();
	}

	public void reset() {
		aluno.reiniciaPlanejador();
	}


}