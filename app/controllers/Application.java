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
			if (Aluno.authenticate(email, password) == null) {
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

	public static Result logout() {
		session().clear();
		flash("success", "You've been logged out");
		return redirect(routes.Application.login());
	}

	static Sistema sistema = new Sistema();

	private static String erro = "";

	public static Result index() {

		return ok(index.render(
				sistema.getAluno().getPlanejador().getPeriodos(),
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

	// public class Cadastro {
	// private String email;
	// private String password;
	// private String repassword;
	// private String nome;
	//
	// public void setEmail(String email) {
	// this.email = email;
	// }
	//
	// public void setPassword(String password) {
	// this.password = password;
	// }
	//
	// public void setRepassword(String repassword) {
	// this.repassword = repassword;
	// }
	//
	// public void setNome(String nome) {
	// this.nome = nome;
	// }
	//
	// public String getEmail(){
	// return this.email;
	// }
	//
	// public String getPassword(){
	// return this.password;
	// }
	//
	// public String getRepassword(){
	// return this.repassword;
	// }
	//
	// public String getNome(){
	// return this.nome;
	// }
	//
	// /**
	// * Validação dos dados inseridos para o cadastro.
	// *
	// * @return Null se o cadastro foi concluído com sucesso ou string de
	// * erro caso contrário.
	// */
	// public String validate() {
	// String erro = null;
	// if (!getPassword().equals(getRepassword())) {
	// erro = "Confirmação de senha incorreta!";
	// }
	// if (getPassword().length() < 8) {
	// erro = "Senha deve ter no mínimo 8 caracteres";
	// }
	// if (getEmail() == null || getEmail().trim().equals("")) {
	// return "Insira um email";
	// } else if (Aluno.find.where().eq("email", getEmail()).findUnique() !=
	// null) {
	// erro = "Usuario já cadastrado";
	// }
	// if (erro != null) {
	// flash("erro", erro);
	// }
	// return erro;
	// }
	// }
	//
	// public Result cadastro() {
	// return ok(cadastro.render(Form.form(Cadastro.class)));
	// }
	//
	// public static Result efetuaCadastro(){
	// Form<Cadastro> cadastroForm =
	// Form.form(Cadastro.class).bindFromRequest();
	// if (cadastroForm.hasErrors()) {
	// return badRequest(cadastro.render(cadastroForm));
	// } else if(cadastroForm.get().validate() == null) {
	// Cadastro novoC = cadastroForm.get();
	// Aluno.create(new Aluno(novoC.getEmail(), novoC.getNome(),
	// novoC.getPassword()));
	// }else{
	// return redirect(routes.Application.cadastro());
	// }
	// return redirect(routes.Application.login());
	// }
}
