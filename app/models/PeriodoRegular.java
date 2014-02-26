package models;


public class PeriodoRegular extends Periodo {

	
	private static final int MAXIMO_DE_CREDITOS = 28;


	@Override
	public void adicionaDisciplina(Disciplina disciplina) throws Exception {
		if(getTotalDeCreditos() + disciplina.getCreditos() > MAXIMO_DE_CREDITOS) throw new MaximoDeDisciplinaAtingidoException();
		disciplinas.add(disciplina);
		
	}
	
	
	@Override
	public void removeDisciplina(Disciplina disciplina) throws Exception {
		disciplinas.remove(disciplina);
	}

}
