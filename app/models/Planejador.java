package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import play.db.ebean.Model;

@Entity
public class Planejador extends Model{

	private static final long serialVersionUID = -4109330281933663818L;

	@Id
	public Long id;

	private CatalogoDisciplinas catalogo = new CatalogoDisciplinas();

	private static final int MAX_CREDITOS = 28;
	private static final int MIN_CREDITOS = 14;

	@OneToOne(cascade = CascadeType.ALL)
	static private List<Periodo> periodos;

	public  Planejador(){
		periodos = new ArrayList<Periodo>();
		setPeriodosInicial();
	}

	private void setPeriodosInicial() {
		for (int i = 0; i < 14; i++){
			Periodo periodo = new Periodo();
			periodos.add(periodo);
		}
		setPrimeiroPeriodo();
		setSegundoPeriodo();
		setTerceiroPeriodo();
		setQuartoPeriodo();
		setQuintoPeriodo();
		setSextoPeriodo();
		setSetimoPeriodo();
		setOitavoPeriodo();

	}

	private void setPrimeiroPeriodo() {

		String[] primeiro = { "Programação I", "Lab. de Programação I",
				"Cálculo I", "Álgebra Vetorial e Geometria Analítica",
				"Introdução a Computação", "Leitura e Produção de Textos" };

		for (String disciplina : primeiro) {
			adicionaDisciplina(getDisciplina(disciplina), 0);
		}
	}

	private void setSegundoPeriodo(){

		String[] segundo = { "Cálculo II", "Matemática Discreta",
				"Programação II", "Teoria dos Grafos",
				"Fund. de Física Clássica", "Lab. de Programação II",
				"Metodologia Científica" };

		for (String disciplina : segundo) {
			adicionaDisciplina(getDisciplina(disciplina),1);
		}
	}

	private void setTerceiroPeriodo(){

		String[] terceiro = { "Álgebra Linear", "Probabilidade e Estatística",
				"Teoria da Computação", "Estruturas de Dados e Algoritmos",
				"Fund. de Física Moderna", "Gerência da Informação",
				"Lab. de Estruturas de Dados e Algoritmos" };

		for (String disciplina : terceiro) {
			adicionaDisciplina(getDisciplina(disciplina), 2);
		}
	}

	private void setQuartoPeriodo(){

		String[] quarto = { "Métodos Estatísticos",
				"Paradigmas de Linguagem de Programação", "Lógica Matemática",
				"Organização e Arquitetura de Computadores I",
				"Lab. de Organização e Arquitetura de Computadores I",
				"Engenharia de Software I", "Sistemas de Informação I" };

		for (String disciplina : quarto) {
			adicionaDisciplina(getDisciplina(disciplina), 3);
		}
	}

	private void setQuintoPeriodo(){

		String[] quinto = { "Informática e Sociedade",
				"Analises e Tecnicas de Algoritmos", "Compiladores",
				"Redes de Computadores", "Banco de Dados I",
				"Sistemas de Informação II", "Lab. de Engenharia de Software" };

		for (String disciplina : quinto) {
			adicionaDisciplina(getDisciplina(disciplina), 4);
		}
	}

	private void setSextoPeriodo(){

		String[] sexto = { "Sistemas Operacionais",
				"Interconexão de Redes de Computadores",
				"Lab. de Interconexão de Redes de Computadores",
				"Inteligencia Artificial I", "Banco de Dados II",
				"Direito e Cidadania", "Optativa 1", "Optativa 2" };

		for (String disciplina : sexto) {
			adicionaDisciplina(getDisciplina(disciplina), 5);
		}
	}

	private void setSetimoPeriodo(){

		String[] setimo = { "Métodos e Software Numéricos",
				"Avaliação de Desempenho de Sistemas Discretos",
				"Projeto em Computação I", "Optativa 3", "Optativa 4",
				"Optativa 5", "Optativa 6" };

		for (String disciplina : setimo) {
			adicionaDisciplina(getDisciplina(disciplina), 6);
		}
	}

	private void setOitavoPeriodo(){

		String[] oitavo = { "Projeto em Computação II", "Optativa 7",
				"Optativa 8", "Optativa 9", "Optativa 10", "Optativa 11" };

		for (String disciplina : oitavo) {
			adicionaDisciplina(getDisciplina(disciplina), 7);
		}
	}

	private void verificaTodasDisciplinas(){
		int i = 0;
		for (Periodo periodoAnalisado : periodos) {
			for(Disciplina disciplinaAnalisada : periodoAnalisado.getDisciplinas()){
				if(!verificaPreRequisitos(disciplinaAnalisada, i	) ||
						verificaPeriodoDiferentePreRequisitos(disciplinaAnalisada, i)){
					disciplinaAnalisada.setAlocadaCorretamente(false);
				}else{
					disciplinaAnalisada.setAlocadaCorretamente(true);
				}

			}

			i++;
		}
	}

	private boolean verificaPreRequisitos(Disciplina disciplina, int periodo){
		int numeroPreRequisitos = disciplina.getNumPreRequisitos();

		for (int i = 0; i < periodo; i++) {
			for (int j = 0; j < periodos.get(i).numeroDisciplinas(); j++) {
				if (disciplina.getPreRequisitos().contains(
					periodos.get(i).disciplinaIndice(j).getNome())) {
					if(periodos.get(i).disciplinaIndice(j).isAlocadaCorretamente()){
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

	private boolean verificaPeriodoDiferentePreRequisitos(Disciplina disciplina, int periodo){
		for (int i = 0; i < periodos.size(); i++) {
			for (Disciplina disciplinaAnalisada : periodos.get(i).getDisciplinas()){
				if(disciplina.getPreRequisitos().contains(disciplinaAnalisada.getNome()) && i >= periodo){
					return true;
				}
			}
		}

		return false;
	}

	public void adicionaDisciplina(Disciplina disciplina, int periodo){
			periodos.get(periodo).addDisciplina(disciplina);
			verificaTodasDisciplinas();
	}

	public void removeDisciplina(String disciplina){
		for (Periodo periodo : periodos) {
			if(periodo.indiceDisciplina(disciplina) != -1){
				periodo.removeDisciplina(disciplina);
			}
		}
		verificaTodasDisciplinas();
	}

	public boolean verificaMaximoCreditos(int periodo){
		return periodos.get(periodo).getTotalCreditos() <= MAX_CREDITOS;
	}

	public boolean verificaMinimoCreditos(int periodo){
		return periodos.get(periodo).getTotalCreditos() >= MIN_CREDITOS;
	}

	public CatalogoDisciplinas getCatalogo(){
		return catalogo;
	}

	public List<Disciplina> getDisciplinasAluno(Aluno aluno){
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		for (Periodo periodo : periodos) {
			disciplinas.addAll(periodo.getDisciplinas());
		}
		return disciplinas;
	}

	public List<Disciplina> getDisciplinasPeriodo(int periodo){
		return periodos.get(periodo).getDisciplinas();
	}

	public Disciplina getDisciplina(String nomeDisciplina){
		return catalogo.getDisciplina(nomeDisciplina);
	}
	
	public List<Periodo> getPeriodos(){
		return periodos;
	}
}