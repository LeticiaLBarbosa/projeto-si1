package controllers;

import models.Aluno;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class Application extends Controller {

	public static class Login {

		public String email;
		public String password;

		public String validate() {
			if (Sistema.authenticate(email, password) == null) {
				return "Invalid user or password";
			}
			return null;
		}

	}

	public static Result login() {
		return ok(login.render(Form.form(Login.class)));
	}

	public static Result authenticate() {
		Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
		if (loginForm.hasErrors()) {
			return badRequest(login.render(loginForm));
		} else {
			session().clear();
			session("email", loginForm.get().email);
			return redirect(routes.Application.index());
		}
	}

//	public static Result logout() {
//		session().clear();
//		flash("success", "You've been logged out");
//		return redirect(routes.Application.login());
//	}

	static Sistema sistema  = new Sistema();

	private static String erro = "";

	public static Result index() {

		if(!session().get("email").equals(null)){
			return login();
		}
		sistema.setAluno(Sistema.finder.byId(request().username()));
		
		return ok(index.render(sistema.getAluno().getPlanejador().getPeriodos(),
				sistema.getAluno().getPlanejador().getDisciplinasDisponiveis(),
				erro));
	}

	public static Result reiniciar() {
		sistema.reset();
		return redirect(routes.Application.index());
	}

	public static Result alocaDisciplina(Integer periodo, String nomeDisciplina)
			throws Exception {
		sistema.alocaDisciplina(periodo - 1, nomeDisciplina);

		String aux = "";

		return ok(index.render(
				sistema.getAluno().getPlanejador().getPeriodos(),
				sistema.getAluno().getPlanejador().getDisciplinasDisponiveis(),
				aux));

	}

	public static Result alocaDisciplinaDisponivel(String nomeDisciplina) {

		sistema.alocaDisciplinaDisponivel(nomeDisciplina);

		return index();
	}

}
