package controllers;

import java.util.List;

import play.db.ebean.Model.Finder;
import models.Aluno;

public class Sistema {

	private Aluno aluno;

	public static Finder<String, Aluno> finder = new Finder<String, Aluno>(String.class, Aluno.class);

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
		
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
	
	public static List<Aluno> findAll() {
        return finder.all();
    }

    public static Aluno findByEmail(String email) {
        return finder.where().eq("email", email).findUnique();
    }
    
    public static Aluno authenticate(String email, String password) {
        return finder.where()
            .eq("email", email)
            .eq("senha", password)
            .findUnique();
    }

	public static void create(Aluno aluno) {
		aluno.save();
	}


}