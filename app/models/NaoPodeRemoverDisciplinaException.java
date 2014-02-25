package models;

public class NaoPodeRemoverDisciplinaException extends Exception {

	@Override
	public String getMessage(){
		return "Não é possivel remover disciplina do primeiro período";
	}
}
