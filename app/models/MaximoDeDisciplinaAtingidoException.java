package models;

public class MaximoDeDisciplinaAtingidoException extends Exception {

	public MaximoDeDisciplinaAtingidoException() {
		super("Não é possivel adicionar disciplina, pois atinge mais que 28 créditos");
	}
	
}
