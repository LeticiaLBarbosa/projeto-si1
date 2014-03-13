package controllers;

import play.mvc.*;
import views.html.*;

public class Application extends Controller {

	static Sistema sistema = new Sistema();

	private static String erro = "";

	public static Result index() {
		
		return ok(index.render(sistema.getAluno().getPlanejador().getPeriodos(), erro));
	}

	public static Result reiniciar(){
		return redirect(routes.Application.index());
	}
	
	public static Result alocaDisciplina(Integer periodo, String nomeDisciplina) throws Exception {
		sistema.alocaDisciplina(periodo - 1, nomeDisciplina);
		
		String aux = "";
		
		return ok(index.render(sistema.getAluno().getPlanejador().getPeriodos(),aux));
    	
    }
}

