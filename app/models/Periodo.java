package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.db.ebean.Model;

@Entity
public class Periodo extends Model{
	
	private static final long serialVersionUID = -5914811766264214424L;

	@Id
	private Long id;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "dependenciasPeriodo",
			joinColumns = @JoinColumn(name = "periodo"), inverseJoinColumns = @JoinColumn(name = "disciplinas"))
	private List<Disciplina> disciplinas;

	public Periodo() {
		disciplinas = new ArrayList<Disciplina>();
	}
		
	public void addDisciplina(Disciplina disciplina){
		disciplinas.add(disciplina);
	}

	public void removeDisciplina(String disciplina){
		disciplinas.remove(indiceDisciplina(disciplina));
	}
	
	public Disciplina disciplinaIndice(int i){
		return disciplinas.get(i);
	}
	
	public int indiceDisciplina(String nome){
		int result = -1;
		
		for(int i = 0; i < disciplinas.size(); i++){
			if(disciplinas.get(i).getNome().equals(nome)){
				result = i;
			}
		}
		
		return result;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public int numeroDisciplinas() {
		return disciplinas.size();
	}

	public int getDificuldadeTotal() {
		int soma = 0;
		for (int i = 0; i < disciplinas.size(); i++) {
			soma += disciplinas.get(i).getDificuldade();
		}
		return soma;
	}

	public int getTotalCreditos() {
		int totalCreditos = 0;
		for (Disciplina disciplina : disciplinas) {
			totalCreditos += disciplina.getCreditos();
		}
		return totalCreditos;
	}

	public Disciplina getDisciplinaPorNome(String nome){
		for (Disciplina disc: disciplinas){
			if(disc.getNome().equals(nome)){
				return disc;
			}
		}
		return null;
	}

}
