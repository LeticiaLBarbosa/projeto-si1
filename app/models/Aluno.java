package models;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class Aluno extends Model {

	private static final long serialVersionUID = -778429165364114973L;
	
	@Id
	public Long id;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Planejador planejador;
	
	
	private String login, nome, senha;
	
	public Aluno(String login, String nome, String senha){
	
		this.setPlanejador(new Planejador());
		this.setLogin(login);
		this.setNome(nome);
		this.setSenha(senha);
		
	}

	public void setPlanejador(Planejador planejador) {
		if(planejador != null){
			this.planejador = planejador;
		}
	}

	public String getNome() {
		return nome;
	}

	public String getSenha() {
		return senha;
	}

	public Planejador getPlanejador() {
		return planejador;
	}

	public String getLogin() {
		return login;
	}

	public void setSenha(String senha) {
		if(senha != null){
			this.senha = senha;
		}
	}
	
	public void setNome(String nome) {
		if(nome != null){
			this.nome = nome;
		}
	}
	
	public void setLogin(String login) {
		if(login != null){
			this.login = login;
		}
	}

	public void reiniciaPlanejador(){
		planejador = new Planejador();
	}
}
