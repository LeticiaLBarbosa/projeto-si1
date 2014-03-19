package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;

@Entity
public class Planejador extends Model {

	private static final long serialVersionUID = -4109330281933663818L;

	@Id
	public Long id;

	private CatalogoDisciplinas catalogo = new CatalogoDisciplinas();

	private static final int MAX_CREDITOS = 28;
	private static final int MIN_CREDITOS = 14;

	@ManyToMany
	static private List<Periodo> periodos;

	public Planejador() {
		periodos = new ArrayList<Periodo>();
		setPeriodosInicial();
	}

	private void setPeriodosInicial() {
		List<String[]> periodosDefault = catalogo.getPeriodosDefault();

		for (int i = 0; i < 14; i++) {
			Periodo periodo = new Periodo();
			periodos.add(periodo);
		}

		for (int i = 0; i < 8; i++) {
			String[] setPeriodo = periodosDefault.get(i);

			for (String disciplina : setPeriodo) {
				adicionaDisciplina(getDisciplina(disciplina), i);
			}
		}

	}

	private void verificaTodasDisciplinas() {
		int i = 0;
		for (Periodo periodoAnalisado : periodos) {
			for (Disciplina disciplinaAnalisada : periodoAnalisado
					.getDisciplinas()) {
				if (!verificaPreRequisitos(disciplinaAnalisada, i)
						|| verificaPeriodoDiferentePreRequisitos(
								disciplinaAnalisada, i)) {
					disciplinaAnalisada.setAlocadaCorretamente(false);
				} else {
					disciplinaAnalisada.setAlocadaCorretamente(true);
				}

			}

			i++;
		}
	}

	private boolean verificaPreRequisitos(Disciplina disciplina, int periodo) {
		int numeroPreRequisitos = disciplina.getNumPreRequisitos();

		for (int i = 0; i < periodo; i++) {
			for (int j = 0; j < periodos.get(i).numeroDisciplinas(); j++) {
				if (disciplina.getPreRequisitos().contains(
						periodos.get(i).disciplinaIndice(j))) {
					if (periodos.get(i).disciplinaIndice(j)
							.isAlocadaCorretamente()) {
						numeroPreRequisitos--;
					}
				}
			}
		}

		if (numeroPreRequisitos == 0) {
			return true;
		}

		return false;
	}

	private boolean verificaPeriodoDiferentePreRequisitos(
			Disciplina disciplina, int periodo) {
		for (int i = 0; i < periodos.size(); i++) {
			for (Disciplina disciplinaAnalisada : periodos.get(i)
					.getDisciplinas()) {
				if (disciplina.getPreRequisitos().contains(
						disciplinaAnalisada)
						&& i >= periodo) {
					return true;
				}
			}
		}

		return false;
	}

	public void adicionaDisciplina(Disciplina disciplina, int periodo) {
		periodos.get(periodo).addDisciplina(disciplina);
		verificaTodasDisciplinas();
	}

	public void removeDisciplina(String disciplina) {
		for (Periodo periodo : periodos) {
			if (periodo.indiceDisciplina(disciplina) != -1) {
				periodo.removeDisciplina(disciplina);
			}
		}
		verificaTodasDisciplinas();
	}

	public boolean verificaMaximoCreditos(int periodo) {
		return periodos.get(periodo).getTotalCreditos() <= MAX_CREDITOS;
	}

	public boolean verificaMinimoCreditos(int periodo) {
		return periodos.get(periodo).getTotalCreditos() >= MIN_CREDITOS;
	}

	public CatalogoDisciplinas getCatalogo() {
		return catalogo;
	}

	public List<Disciplina> getDisciplinasAluno(Aluno aluno) {
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		for (Periodo periodo : periodos) {
			disciplinas.addAll(periodo.getDisciplinas());
		}
		return disciplinas;
	}

	public List<Disciplina> getDisciplinasPeriodo(int periodo) {
		return periodos.get(periodo).getDisciplinas();
	}

	public Disciplina getDisciplina(String nomeDisciplina) {
		return catalogo.getDisciplina(nomeDisciplina);
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}
}