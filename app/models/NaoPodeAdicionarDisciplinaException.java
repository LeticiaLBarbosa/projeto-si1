package models;

public class NaoPodeAdicionarDisciplinaException extends Exception {

	public NaoPodeAdicionarDisciplinaException() {
		super("Não é possivel adicionar disciplina ao primeiro período");
	}
	

}
