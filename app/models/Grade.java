package models;

import java.util.ArrayList;
import java.util.List;

public abstract class Grade {


	protected List<Disciplina> todasDisciplinas = new ArrayList<Disciplina>();
	protected List<String[]> periodosDefault = new ArrayList<String[]>();

	protected static final int DOIS_CREDITOS = 2;
	protected static final int QUATRO_CREDITOS = 4;
	protected static final int SEIS_CREDITOS = 6;
	protected static final int FACIL = 1;
	protected static final int MEDIO = 2;
	protected static final int DIFICIL = 3;

	abstract protected void instanciaDisciplinas();
	
	abstract protected void setPeriodosDefault();

	public List<String[]> getPeriodosDefault() {
		return periodosDefault;
	}

	protected List<Disciplina> listaDePreRequisitos(String disciplinas) {
		List<Disciplina> listaDePreRequisitos = new ArrayList<Disciplina>();
		String[] aux = disciplinas.split(", ");
		for (String disciplinaNome : aux) {
			for (Disciplina disciplina : todasDisciplinas){
				if (disciplina.getNome().equals(disciplinaNome)){
					listaDePreRequisitos.add(disciplina);
				}
			}
		}
		return listaDePreRequisitos;
	}

	public int disciplinaIndice(String nome) {
		int result = -1;
		for (int i = 0; i < todasDisciplinas.size(); i++) {
			if (todasDisciplinas.get(i).getNome().equals(nome)) {
				result = i;
			}
		}

		return result;
	}

	public List<Disciplina> getCatalogo() {
		return todasDisciplinas;
	}

	public Disciplina getDisciplina(String nome) {
		for (int i = 0; i < todasDisciplinas.size(); i++) {
			if (todasDisciplinas.get(i).getNome().equals(nome)) {
				return todasDisciplinas.get(i);
			}
		}
		return null;

	}

	public Disciplina getDisciplinaPorIndice(int i) {
		return todasDisciplinas.get(i);
	}
}
