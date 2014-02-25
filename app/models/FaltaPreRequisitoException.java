package models;

public class FaltaPreRequisitoException extends Exception {

	@Override
	public String getMessage(){
		return "Não é possivel adicionar por falta de pré-requisito";
	}
	
}
