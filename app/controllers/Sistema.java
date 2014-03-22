package controllers;

import java.util.List;
import Exceptions.TotalDeCreditosInvalidoException;
import play.db.ebean.Model.Finder;
import models.*;

public class Sistema {

	private Aluno aluno;
	private Planejador plano;

	public static Finder<String, Aluno> finder = new Finder<String, Aluno>(
			String.class, Aluno.class);

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
		plano = aluno.getPlanejador();
	}

	public Aluno getAluno() {
		return aluno;
	}
	
	public Planejador getPlano(){
		return plano;
	}

	public void alocaDisciplina(int periodo, String nomeDisciplina)
			throws TotalDeCreditosInvalidoException {
		plano.alocaDisciplinaPeriodo(nomeDisciplina, periodo);
		aluno.save();
	}

	public void removeDisciplina(String nomeDisciplina)
			throws TotalDeCreditosInvalidoException {
		plano.removeDisciplinaEDependentes(nomeDisciplina);
		aluno.save();
	}

	public void reset() {
		aluno.reiniciaPlanejador();
		aluno.save();
	}

	public static List<Aluno> findAll() {
		return finder.all();
	}

	public static Aluno findByEmail(String email) {
		return finder.where().eq("email", email).findUnique();
	}

	public static Aluno authenticate(String email, String password) {
		return finder.where().eq("email", email).eq("senha", password)
				.findUnique();
	}

	public static void create(Aluno aluno) {
		aluno.save();
	}

	protected static void criaUsuarios() {
		if (findAll().isEmpty()) {
			int num = 0;

			while (num < 30) {
				String email = "aluno" + num + "@email.com";
				String nome = "Aluno " + num;
				String password = "aluno" + num;

				Sistema.create(new Aluno(email, nome, password));
				num++;
			}
		}
	}
}