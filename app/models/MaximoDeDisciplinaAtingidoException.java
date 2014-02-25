package models;

public class MaximoDeDisciplinaAtingidoException extends Exception {

	
	@Override
	public String getMessage(){
		return "Não é possivel adicionar disciplina, pois atinge mais que 28 créditos";
	}
}
