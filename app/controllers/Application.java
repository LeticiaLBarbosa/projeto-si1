package controllers;

import java.util.ArrayList;
import java.util.List;

import Exceptions.TotalDeCreditosInvalidoException;
import models.Aluno;
import models.Planejador;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	static Sistema sistema = new Sistema();
	
	public static CadastroAlunos cadastro = new CadastroAlunos();

	static Form<Planejador> planejadorForm = Form.form(Planejador.class);

	public static class Login {

		public String email;
		public String password;
	}

	@SuppressWarnings("static-access")
	public static Result login() {
		sistema.criaUsuarios();
		return ok(login.render(Form.form(Login.class)));
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {

			Aluno aluno = Sistema.authenticate(loginForm.get().email,
					loginForm.get().password);

			if (aluno != null) {
				session().clear();
				session("email", loginForm.get().email);

				sistema.setAluno(Sistema.findByEmail(loginForm.get().email));

				return redirect(routes.Application.index());
			} else {

				flash("erro", "Usuário ou senha inválidos");
				return badRequest(login.render(loginForm));

			}
		}
	}

	public static Result logout() {
		session().clear();
		flash("success", "Deslogado com sucesso!");
		return redirect("/");
	}

	@Security.Authenticated(Secured.class)
	public static Result index() {

		if (session().get("email") == null) {
			return login();
		}

		return ok(index.render(sistema.getAluno().getPlanejador(), sistema.getAluno()));
	}

	@Security.Authenticated(Secured.class)
	public static Result reiniciar() {
		sistema.reset();
		return redirect(routes.Application.index());
	}

	@Security.Authenticated(Secured.class)
	public static Result alocaDisciplina(Integer periodo, String nomeDisciplina) {

		try {
			sistema.alocaDisciplina(periodo - 1, nomeDisciplina);

		} catch (TotalDeCreditosInvalidoException e) {
			flash("erro", e.getMessage());
		}

		return index();

	}
	
	@Security.Authenticated(Secured.class)
	public static Result alteraGrade(String tipo) {

		sistema.alteraGrade(tipo);

		return index();

	}
	

	public static Result periodoAtual(){
		
		DynamicForm formPeriodo = new DynamicForm();
		
		DynamicForm form = formPeriodo.bindFromRequest();
		
		int periodoInt = Integer.parseInt(form.get("periodo"));
		
		sistema.alteraPeriodoAtual(periodoInt);
		
		return index();
	}

	@Security.Authenticated(Secured.class)
	public static Result removeDisciplina(String nomeDisciplina) {

		try {
			sistema.removeDisciplina(nomeDisciplina);
		} catch (TotalDeCreditosInvalidoException e) {

			flash("erro", e.getMessage());
		}

		return index();
	}
	
	@Security.Authenticated(Secured.class)
	public static Result buscaUsuarios() {
		
    	return ok(redesocial.render(sistema.findAll()));
    }
	
	
	@Security.Authenticated(Secured.class)
	public static Result getPerfil(String email){
		Aluno aluno = sistema.findByEmail(email);
    	
    	if(aluno != null)
    		return ok(perfil.render(aluno.getPlanejador(), aluno));
    	else
    		return ok();
	}
	
	
	   public static Result buscaUsuario() {
	    	String query = request().queryString().get("query")[0];
	    	return ok(views.html.busca.render(query, cadastro.getUsuarioPorNome(query)));
	    }

}
