package controllers;

import Exceptions.LimitesExcedidosException;
import Exceptions.PreRequisitosInsuficientesException;
import models.*;
import play.data.DynamicForm;
import play.data.Form;
import play.mvc.*;
import views.html.*;

//CREATOR: a classe Periodo guarda objetos do tipo Disciplina
public class Application extends Controller {

	// CONTROLER: Sistema eh a classe responsavel por controlar o sistema

	static Sistema sistema;

	private static String erro = "";

	static Form<Disciplina> disciplinaForm = Form.form(Disciplina.class);

	public static Result index() {
		sistema = new Sistema();
		
		return ok(index.render(sistema.getAluno().getPeriodos(),
				sistema.getCatalogoDisc(), erro));
	}

	public static Result reiniciar(){
		return redirect(routes.Application.index());
	}
	
	public static Result alocaDisciplina(Integer periodo, String nomeDaDisciplina) throws Exception {
		sistema.removeDisciplinaPeriodo(nomeDaDisciplina);
		sistema.addDisciplinasPeriodo(periodo - 1, nomeDaDisciplina);
		
		String aux = "";
		
		return badRequest(index.render(sistema.getAluno().getPeriodos(),sistema.getCatalogoDisc(),aux));
    	
    	//return redirect("/");
    }
	/*
	public static Result disciplinaPeriodo() throws Exception {

		try {

			DynamicForm formDisciplina = new DynamicForm();
			
			final DynamicForm form = formDisciplina.bindFromRequest();
			final String nome = form.get("nome");
			final int periodo = Integer.parseInt(form.get("periodo")) - 1;

			sistema.addDisciplinasPeriodo(periodo, nome);
			
			String aux = "";
			for(int i = 0; i < sistema.getPeriodos().size(); i++){
				if(sistema.getPeriodos().get(i).getTotalCreditos() <= 14 ){
					if( aux.equals("")){
						aux += "Quantidade de créditos insuficientes no: ";
					}
					if(i != sistema.getPeriodos().size() -1){
						aux += (i + 1) + "º,";
					}else{
						aux += (i + 1) + "º.";
					}
				}
			}
			
			return badRequest(index.render(sistema.getPeriodos(),sistema.getCatalogoDisc(),aux));
			

		} catch (LimitesExcedidosException e) {
			return badRequest(index.render(sistema.getPeriodos(),sistema.getCatalogoDisc(), e.getMessage()));
		} catch (PreRequisitosInsuficientesException e) {
			return badRequest(index.render(sistema.getPeriodos(), sistema.getCatalogoDisc(), e.getMessage()));
		}
	}
	*/
	public static Result removeDisciplinaPeriodo(){

		DynamicForm formDisciplina = new DynamicForm();

		final DynamicForm form = formDisciplina.bindFromRequest();
		final String nome = form.get("nome");
		
		sistema.removeDisciplinaPeriodo(nome);
		
		
		String aux = "";
		for(int i = 0; i < sistema.getAluno().getPeriodos().size(); i++){
			if(sistema.getAluno().getPeriodos().get(i).getTotalCreditos() <= 14 ){
				if( aux.equals("")){
					aux += "Quantidade de créditos insuficientes no: ";
				}
				if(i != sistema.getAluno().getPeriodos().size() -1){
					aux += (i + 1) + "º,";
				}else{
					aux += (i + 1) + "º.";
				}
			}
		}
		
		return badRequest(index.render(sistema.getAluno().getPeriodos(),sistema.getCatalogoDisc(),aux));
	}
}

