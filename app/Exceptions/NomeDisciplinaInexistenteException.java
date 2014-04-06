package Exceptions;

@SuppressWarnings("serial")
public class NomeDisciplinaInexistenteException extends Exception{
	
	public NomeDisciplinaInexistenteException(String mensagem){
		super(mensagem);
	}

}
