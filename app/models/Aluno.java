package models;

import javax.persistence.*;

import play.data.validation.Constraints.*;
import play.db.ebean.Model;

@Entity
public class Aluno extends Model {

	private static final long serialVersionUID = -778429165364114973L;
	
	@Id
	@Required
	@Email
	private String email;
	@Required
	private String nome;

	@Required
	private String senha;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Planejador planejador;

	public Aluno(String email, String nome, String senha){

		this.setPlanejador(new Planejador());
		this.setEmail(email);
		this.setNome(nome);
		this.setSenha(senha);

	}

	public void setPlanejador(Planejador planejador) {
		if (planejador != null) {
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

	public String getEmail() {
		return email;
	}

	public void setSenha(String senha) {
		if (senha != null) {
			this.senha = senha;
		}
	}

	public void setNome(String nome) {
		if (nome != null) {
			this.nome = nome;
		}
	}

	public void setEmail(String email) {
		if (email != null) {
			this.email = email;
		}
	}

	public void reiniciaPlanejador(){
		planejador.reiniciaPlanejador();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;

		return true;
	}

}
