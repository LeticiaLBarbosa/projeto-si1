package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;

@Entity
public class Aluno extends Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -778429165364114973L;
	@Id
	public Long id;
	static private List<Periodo> periodos;
	
	public Aluno(){
		periodos = new ArrayList<Periodo>();
	}
	
	public List<Periodo> getPeriodos(){
		return periodos;
	}
	
	public void adicionaDisciplina(Disciplina disciplina, int periodo){
		if(periodos.size() <= periodo){
			periodos.add(new Periodo());
			this.adicionaDisciplina(disciplina, periodo);
		}else{
			periodos.get(periodo).getDisciplinas().add(disciplina);
		}
	}
	
	public void removeDisciplina(String disciplina){
		for (Periodo periodo : periodos) {
			if(periodo.indiceDisciplina(disciplina) != -1){
				periodo.getDisciplinas().remove(periodo.indiceDisciplina(disciplina));
			}
		}
		
		
	}

}
