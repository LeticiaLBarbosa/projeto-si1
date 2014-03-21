package controllers;

import models.Aluno;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	static Sistema sistema  = new Sistema();

	private static String erro = "";
	
	public static class Login {

		public String email;
		public String password;
	}

	public static Result login() {
		return ok(login.render(Form.form(Login.class)));
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {
			
			Aluno aluno = Sistema.authenticate(loginForm.get().email,loginForm.get().password);
			
			if(aluno != null){
				session().clear();
				session("email", loginForm.get().email);
				
				sistema.setAluno(Sistema.findByEmail(loginForm.get().email));
				
				return redirect(routes.Application.index());
			}else{
				
				flash("erro", "Usuário ou senha inválidos");
				return badRequest(login.render(loginForm));
				
			}
		}
	}

	public static Result logout() {
		session().clear();
		flash("success", "Deslogado com sucesso!");
		return redirect(routes.Application.login());
	}
	
	@Security.Authenticated(Secured.class)
	public static Result index() {

		if(session().get("email") == null){
			return login();
		}
		
		return ok(index.render(sistema.getAluno().getPlanejador().getPeriodos(),
				sistema.getAluno().getPlanejador().getDisciplinasDisponiveis(),erro));
	}

	@Security.Authenticated(Secured.class)
	public static Result reiniciar(){
		sistema.reset();
		return redirect(routes.Application.index());
	}

	@Security.Authenticated(Secured.class)
	public static Result alocaDisciplina(Integer periodo, String nomeDisciplina)
			throws Exception {
		sistema.alocaDisciplina(periodo - 1, nomeDisciplina);

		String aux = "";

		return ok(index.render(
				sistema.getAluno().getPlanejador().getPeriodos(),
				sistema.getAluno().getPlanejador().getDisciplinasDisponiveis(),
				aux));

	}

	@Security.Authenticated(Secured.class)
	public static Result removeDisciplina(String nomeDisciplina){

		sistema.removeDisciplina(nomeDisciplina);

		return index();
	}

}
