package models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class Aluno extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -778429165364114973L;
	
	@Id
	private String id;
	
	public static Finder<Long,Aluno> find = new Finder<Long,Aluno>(Long.class, Aluno.class);
	
	@OneToOne(cascade=CascadeType.ALL)
	private Planejador planejador;
	
	private String nome, senha;
	
	public Aluno(String login, String nome, String senha){
		planejador = new Planejador();
		id = login;
		this.setNome(nome);
		this.setSenha(senha);
	
	}		

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Planejador getPlanejador() {
		return planejador;
	}

}
