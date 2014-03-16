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
	public Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Planejador planejador;
	
	
	private String login, nome, senha;
	
	public Aluno(String login, String nome, String senha){
		planejador = new Planejador();
		this.setLogin(login);
		this.setNome(nome);
		this.setSenha(senha);
	
	}

	public void setPlanejador(Planejador planejador) {
		this.planejador = planejador;
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

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
