package models;

public class MaximoMinimoCreditos implements ValidadorDeAlocacao{

	private final int MAXIMO_CREDITOS = 28;
	
	private final int MINIMO_CREDITOS = 14;

	@Override
	public boolean podeRemover(Periodo periodo, Disciplina disciplina) {
		return periodo.getTotalCreditos() - disciplina.getCreditos() >= MINIMO_CREDITOS;
	}

	@Override
	public boolean podeAdicionar(Periodo periodo, Disciplina disciplina){
		return periodo.getTotalCreditos() + disciplina.getCreditos()  <= MAXIMO_CREDITOS;
	}

}
