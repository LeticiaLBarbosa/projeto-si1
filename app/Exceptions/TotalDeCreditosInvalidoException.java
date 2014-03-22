package Exceptions;

@SuppressWarnings("serial")
public class TotalDeCreditosInvalidoException extends Exception {

	public TotalDeCreditosInvalidoException(String mensagem){
		super(mensagem);
	}
}
