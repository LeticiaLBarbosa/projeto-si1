package controllers;

//import Exceptions.LimitesExcedidosException;
//import Exceptions.PreRequisitosInsuficientesException;
//import models.*;
//import play.data.DynamicForm;
//import play.data.Form;
import play.mvc.*;
import views.html.*;

//CREATOR: a classe Periodo guarda objetos do tipo Disciplina
public class Application extends Controller {

	// CONTROLER: Sistema eh a classe responsavel por controlar o sistema

	static Sistema sistema = new Sistema();

	private static String erro = "";

	public static Result index() {
		
		return ok(index.render(sistema.getAluno().getPeriodos(), erro));
	}

	public static Result reiniciar(){
		return redirect(routes.Application.index());
	}
	
	public static Result alocaDisciplina(Integer periodo, String nomeDisciplina) throws Exception {
		sistema.alocaDisciplina(periodo - 1, nomeDisciplina);
		
		String aux = "";
		
		return ok(index.render(sistema.getAluno().getPeriodos(),aux));
    	
    }
}

