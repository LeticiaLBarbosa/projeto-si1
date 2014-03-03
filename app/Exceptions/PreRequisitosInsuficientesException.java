package Exceptions;

/**
 * 
 * Excessao caso os prerequisitos necessarios nao sejam atendidos.
 * 
 */

public class PreRequisitosInsuficientesException extends Exception{
		
	private static final long serialVersionUID = 1L;

	public PreRequisitosInsuficientesException(){
		super("Você não tem os prerequisitos necessários.");
	}
}
