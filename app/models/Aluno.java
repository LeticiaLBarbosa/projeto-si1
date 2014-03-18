package models;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.data.validation.Constraints.Email;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Aluno extends Model {

	private static final long serialVersionUID = -778429165364114973L;
	@Id @Required @Email
	private static String login;
	@Required
	private String nome;
	@Required
	private static String senha;
	@OneToOne(cascade=CascadeType.ALL)
	private Planejador planejador;
	
	public static Model.Finder<String,Aluno> find = new Model.Finder<String,Aluno>(String.class, Aluno.class);
	
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

	public void reiniciaPlanejador(){
		planejador = new Planejador();
	}

	public boolean autenticar(String senha) {
		boolean autenticado = false;

		if (getSenha().equals(senha)) {
			autenticado = true;
		}

		return autenticado;
	}
    
    public static List<Aluno> findAll() {
        return find.all();
    }

    public static Aluno findByEmail(String email) {
        return find.where().eq("email", email).findUnique();
    }
    
    public static Aluno authenticate(String email, String password) {
        return find.where()
            .eq("email", email)
            .eq("password", password)
            .findUnique();
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
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;

		return true;
	}

}
