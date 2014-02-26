package controllers;

import play.*;
import play.data.Form;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
	
	static FlowChartManager manager = new FlowChartManager();

    public static Result index() {
    	return redirect(routes.Application.planejando(""));
    }
    public static Result planejando(String msg) {
        return ok(index.render(manager, msg));
    }
    public static Result adicionaPeriodo() {
    	manager.adicionaPeriodo();
    	return redirect(routes.Application.planejando(""));
    }
    public static Result adicionaDisciplina(String id, int periodo) {
    	try {
    	manager.adicionaDisciplina(id, periodo);
    	} catch (Exception e){
    		return redirect(routes.Application.planejando(e.getMessage()));
    	}
    	return redirect(routes.Application.planejando(""));
    }
    public static Result removeDisciplina(String id, int periodo) {
    	try {
    	manager.removeDisciplina(id, periodo);
    	} catch (Exception e){
    		return redirect(routes.Application.planejando(e.getMessage()));
        
    	}
    	return redirect(routes.Application.planejando(""));
    }

}
