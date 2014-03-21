package controllers;

import models.Aluno;
import play.data.Form;
import play.data.validation.Constraints.Required;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class CadastroAlunos extends Controller{
	@Required
	private String email;
	@Required
	private String password;
	@Required
	private String repassword;
	@Required
	private String nome;
	
	 public void setEmail(String email) {
		 this.email = email;
	 }
	
	 public void setPassword(String password) {
		 this.password = password;
	 }
	
	 public void setRepassword(String repassword) {
		 this.repassword = repassword;
	 }
	
	 public void setNome(String nome) {
		 this.nome = nome;
	 }
	
	 public String getEmail(){
		 return this.email;
	 }
	
	 public String getPassword(){
		 return this.password;
	 }
	
	 public String getRepassword(){
		 return this.repassword;
	 }
	
	 public String getNome(){
		 return this.nome;
	 }
	
	 public String validate() {
		 String erro = null;

		 if (!getPassword().equals(getRepassword())) {
			 erro = "Confirmação de senha incorreta!";
		 }
		 if (getPassword().length() < 6) {
			 erro = "Senha deve ter no mínimo 6 caracteres";
		 }
		 if (getEmail() == null || getEmail().trim().equals("")) {
			 return "Insira um email";

		 } else if (Sistema.finder.where().eq("email", getEmail()).findUnique() != null) {
			 erro = "Usuario já cadastrado";
		 }
		 if (erro != null) {
			 flash("erro", erro);
		 }
		 return erro;
	 }
	
	 public static Result cadastro() {
		 return ok(cadastro.render(Form.form(CadastroAlunos.class)));
	 }
	
	 public static Result efetuaCadastroAlunos(){
		 Form<CadastroAlunos> cadastroForm = Form.form(CadastroAlunos.class).bindFromRequest();
		 
		 if (cadastroForm.hasErrors()) {
			 return badRequest(cadastro.render(cadastroForm));
		 } else if(cadastroForm.get().validate() == null) {
			 CadastroAlunos novoCadastro = cadastroForm.get();
			 Sistema.create(new Aluno(novoCadastro.getEmail(), novoCadastro.getNome(),novoCadastro.getPassword()));
		 }else{
			 return redirect(routes.CadastroAlunos.cadastro());
		 }
		 return redirect(routes.Application.login());
	 }
}