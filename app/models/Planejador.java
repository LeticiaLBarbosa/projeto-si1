package models;

import java.util.ArrayList;
import java.util.List;

public class Planejador {
	
	private CatalogoDisciplinas catalogo = new CatalogoDisciplinas();
	private static final int MAX_CREDITOS = 28;
	private static final int MIN_CREDITOS = 14;
	
	private String erro = "";
	
	public int getCreditosDisciplina(String nomeDisciplina){
		return catalogo.getDisciplina(nomeDisciplina).getCreditos();
	}
	
	public boolean verificaPreRequisitos(Aluno aluno, Disciplina disciplina){
		int numeroPreRequisitos = disciplina.getNumPreRequisitos();
		for (int i = 0; i < aluno.getPeriodos().size(); i++) {
			for (int j = 0; j < aluno.getPeriodos().get(i).numeroDisciplinas(); j++) {
				if (disciplina.getPreRequisitos().contains(
						aluno.getPeriodos().get(i).indiceDisciplina(j).getNome())) {
					numeroPreRequisitos--;
				}
			}
		}

		if (numeroPreRequisitos == 0) {
			return true;
		}
		return false;
	}
	
	public void adicionaDisciplina(Aluno aluno, Disciplina disciplina, int periodo){
		
		aluno.adicionaDisciplina(disciplina, periodo);
	}
	
	public boolean verificaPeriodoDiferentePreRequisitos(Aluno aluno, Disciplina disciplina, int periodo){
		for (int i = 0; i < aluno.getPeriodos().size(); i++) {
			for (Disciplina disciplinaAnalisada : aluno.getPeriodos().get(i).getDisciplinas()){
				if(disciplina.getPreRequisitos().contains(disciplinaAnalisada.getNome()) && i >= periodo){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean verificaMaximoCreditos(Aluno aluno, int periodo){
		return aluno.getPeriodos().get(periodo).getTotalCreditos() <= MAX_CREDITOS;
	}
	
	public boolean verificaMinimoCreditos(Aluno aluno, int periodo){
		return aluno.getPeriodos().get(periodo).getTotalCreditos() >= MIN_CREDITOS;
	}
	
	public CatalogoDisciplinas getCatalogo(){
		return catalogo;
	}
	
	public List<Disciplina> getDisciplinasAluno(Aluno aluno){
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		for (Periodo periodo : aluno.getPeriodos()) {
			disciplinas.addAll(periodo.getDisciplinas());
		}
		return disciplinas;
	}
	
	public void removeDisciplina(Aluno aluno, String disciplina){
			aluno.removeDisciplina(disciplina);
	}	
	
	public List<Disciplina> getDisciplinasPeriodo(Aluno aluno, int periodo){
		return aluno.getPeriodos().get(periodo).getDisciplinas();
	}
	
	public Disciplina getDisciplina(String nomeDisciplina){
		return catalogo.getDisciplina(nomeDisciplina);
	}
	
	public String getErro(){
		return erro;
	}
	
	public void setErro(String erro){
		this.erro = erro;
	}

}