package models;

public class NaoPodeAdicionarDisciplinaException extends Exception {

	@Override
	public String getMessage(){
		return "Não é possivel adicionar disciplina ao primeiro período";
	}
	
}
