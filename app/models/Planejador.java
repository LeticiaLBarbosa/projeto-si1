package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import Exceptions.NomeDisciplinaInexistenteException;
import Exceptions.TotalDeCreditosInvalidoException;
import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

@Entity
public class Planejador extends Model {

	private static final long serialVersionUID = -4109330281933663818L;

	@Required
	private int periodoAtual;

	@Id
	public Long id;

	private Grade catalogo = GradeNova.getInstance();

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Periodo> periodos;

	@ManyToMany(cascade = CascadeType.ALL)
	private List<Disciplina> disciplinasDisponiveis;

	public Planejador() {
		periodos = new ArrayList<Periodo>();
		disciplinasDisponiveis = new ArrayList<Disciplina>();
		setPeriodosInicial();
	}

	public int getTotalCreditosCursados() {
		int total = 0;
		for (int i = 0; i < periodoAtual; i++) {
			total += periodos.get(i).getTotalCreditos();
		}

		return total;
	}

	public int getTotalDificuldadeCursada() {
		int total = 0;
		for (int i = 0; i < periodoAtual; i++) {
			total += periodos.get(i).getDificuldadeTotal();
		}

		return total;
	}

	private void setPeriodosInicial() {
		List<String[]> periodosDefault = catalogo.getPeriodosDefault();

		for (int i = 0; i < 14; i++) {
			Periodo periodo = new Periodo();

			periodos.add(periodo);

		}

		for (int i = 0; i < periodosDefault.size(); i++) {
			String[] setPeriodo = periodosDefault.get(i);

			for (String disciplina : setPeriodo) {
				adicionaDisciplina(getDisciplina(disciplina), i);
			}
		}

		// Inicia o primeiro como default
		setPeriodoAtual(0);

	}

	public void setPeriodoAtual(int periodoAtual) {
		this.periodoAtual = periodoAtual;

		// Set para os que estao antes do periodo atual
		for (int i = 0; i < periodoAtual; i++) {
			periodos.get(i).setValidador(new MaximoCreditos());
		}

		// Set para os que estao depois do periodo atual
		for (int j = periodoAtual; j < periodos.size(); j++) {
			periodos.get(j).setValidador(new MaximoMinimoCreditos());
		}

		// Set ultimo periodo
		for (int h = 0; h < periodos.size(); h++) {
			if (periodos.size() == 0) {
				periodos.get(h - 1).setValidador(new MinimoCreditos());
				break;
			}
		}
	}

	public int getPeriodoAtual() {
		return periodoAtual;
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
				if (disciplina.getPreRequisitos().contains(disciplinaAnalisada)
						&& i >= periodo) {
					return true;
				}
			}
		}

		return false;
	}

	private void adicionaDisciplina(Disciplina disciplina, int periodo) {
		periodos.get(periodo).addDisciplina(disciplina);
		verificaTodasDisciplinas();
	}

	public void alocaDisciplinaPeriodo(String nomeDisciplina, int periodoFuturo)
			throws TotalDeCreditosInvalidoException {
		int periodoAtual = procuraDisciplinaPeriodo(nomeDisciplina);

		if (procuraDisciplinaEmDisponiveis(nomeDisciplina)) {

			if (periodos.get(periodoFuturo).podeAdicionar(
					getDisciplina(nomeDisciplina))) {
				removeDisciplina(nomeDisciplina);
				adicionaDisciplina(getDisciplina(nomeDisciplina), periodoFuturo);
			} else {
				throw new TotalDeCreditosInvalidoException(
						"Não foi possível alocar essa disciplina"
								+ " pois o número de créditos foi excedido.");
			}

		} else if (periodos.get(periodoAtual).podeRemover(nomeDisciplina)) {
			if (periodos.get(periodoFuturo).podeAdicionar(
					getDisciplina(nomeDisciplina))) {
				removeDisciplina(nomeDisciplina);
				adicionaDisciplina(getDisciplina(nomeDisciplina), periodoFuturo);
			} else {
				throw new TotalDeCreditosInvalidoException(
						"Não foi possível alocar essa disciplina"
								+ " pois o número de créditos foi excedido.");
			}

		} else {
			throw new TotalDeCreditosInvalidoException(
					"Não foi possível mover essa disciplina"
							+ " pois o número de créditos é insuficiente no seu periodo atual.");
		}
	}

	private boolean procuraDisciplinaEmDisponiveis(String nomeDisciplina) {
		boolean result = false;

		for (Disciplina disciplina : disciplinasDisponiveis) {
			if (disciplina.getNome().equals(nomeDisciplina)) {
				result = true;
				break;
			}
		}

		return result;
	}

	private int procuraDisciplinaPeriodo(String nomeDisciplina) {
		int i = 0;
		for (Periodo periodo : periodos) {
			if (periodo.indiceDisciplina(nomeDisciplina) != -1) {
				return i;
			}

			i++;
		}

		return -1;
	}

	private void addDisciplinaEmDisponivel(String nomeDisciplina) {
		disciplinasDisponiveis.add(getDisciplina(nomeDisciplina));
	}

	private void removeDisciplina(String disciplina) {
		for (Periodo periodo : periodos) {
			if (periodo.indiceDisciplina(disciplina) != -1) {
				periodo.removeSemVerificar(disciplina);
				break;
			}
		}

		for (int i = 0; i < disciplinasDisponiveis.size(); i++) {
			if (disciplinasDisponiveis.get(i).getNome().equals(disciplina)) {
				disciplinasDisponiveis.remove(i);
				break;
			}
		}

		verificaTodasDisciplinas();
	}

	private void auxRemoveDependentes(String nomeDisciplina) {
		for (Periodo periodo : periodos) {
			if (periodo.indiceDisciplina(nomeDisciplina) != -1) {
				addDisciplinaEmDisponivel(nomeDisciplina);
				periodo.removeSemVerificar(nomeDisciplina);
				break;
			}
		}

		String temp;
		for (Periodo periodo : periodos) {
			for (int i = periodo.getDisciplinas().size() - 1; i >= 0; i--) {
				if (periodo.getDisciplinas().get(i)
						.verificaPreRequisitos(nomeDisciplina)) {
					temp = periodo.getDisciplinas().get(i).getNome();
					auxRemoveDependentes(temp);
				}
			}
		}
	}

	public void removeDisciplinaEDependentes(String nomeDisciplina)
			throws TotalDeCreditosInvalidoException {
		for (Periodo periodo : periodos) {
			if (periodo.indiceDisciplina(nomeDisciplina) != -1) {
				periodo.removeDisciplina(nomeDisciplina);
				addDisciplinaEmDisponivel(nomeDisciplina);
				break;
			}
		}

		String temp;
		for (Periodo periodo : periodos) {
			for (int i = periodo.getDisciplinas().size() - 1; i >= 0; i--) {
				if (periodo.getDisciplinas().get(i)
						.verificaPreRequisitos(nomeDisciplina)) {
					temp = periodo.getDisciplinas().get(i).getNome();
					auxRemoveDependentes(temp);
				}
			}
		}
	}

	public List<Disciplina> getDisciplinasDisponiveis() {
		return disciplinasDisponiveis;
	}

	public List<Disciplina> getDisciplinasPeriodo(int periodo) {
		return periodos.get(periodo).getDisciplinas();
	}

	public Disciplina getDisciplina(String nomeDisciplina) {
		try {
			return catalogo.getDisciplina(nomeDisciplina);
		} catch (NomeDisciplinaInexistenteException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void reiniciaPlanejador() {
		periodos.clear();
		disciplinasDisponiveis.clear();

		setPeriodosInicial();
	}

	public boolean minimoRespeitado(int indicePeriodo) {

		Periodo periodo = periodos.get(indicePeriodo);

		if (periodo.getTotalCreditos() < 14) {
			return false;
		}
		return true;

	}

	public int creditosParaCompletar14(int indicePeriodo) {
		return 14 - (periodos.get(indicePeriodo).getTotalCreditos());
	}
}