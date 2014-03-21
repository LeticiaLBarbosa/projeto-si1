package models;

public class MaximoCreditos implements ValidadorDeAlocacao{

	private final int MAXIMO_CREDITOS = 28;
	
	@Override
	public boolean podeRemover(Periodo periodo, Disciplina disciplina) {		
		return true;
	}

	@Override
	public boolean podeAdicionar(Periodo periodo, Disciplina disciplina){
		return periodo.getTotalCreditos() + disciplina.getCreditos()  <= MAXIMO_CREDITOS;
	}
	
}
