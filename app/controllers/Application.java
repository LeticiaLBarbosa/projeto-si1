package controllers;

import models.Aluno;
import play.data.Form;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	static Sistema sistema = new Sistema();

	private static String erro = "";

	public static Result index() {

		return ok(index.render(
				sistema.getAluno().getPlanejador().getPeriodos(), erro));
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
				sistema.getAluno().getPlanejador().getPeriodos(), aux));

	}

	public static Result login() {
		return ok(login.render(Form.form(Login.class)));
	}

	public static class Login {

		public String email;
		public String password;

		public String validate() {
			if (Aluno.authenticate(email, password) == null) {
				return "Invalid user or password";
			}
			return null;
		}

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
}
