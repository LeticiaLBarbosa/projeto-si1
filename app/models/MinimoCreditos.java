package models;

public class MinimoCreditos implements ValidadorDeAlocacao{
	
	private final int MINIMO_CREDITOS = 14;

	@Override
	public boolean podeRemover(Periodo periodo, Disciplina disciplina) {
		return periodo.getTotalCreditos() - disciplina.getCreditos() >= MINIMO_CREDITOS;
	}

	@Override
	public boolean podeAdicionar(Periodo periodo, Disciplina disciplina) {
		return true;
	}
	
	

}
