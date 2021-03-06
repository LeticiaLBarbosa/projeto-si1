package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import play.data.validation.Constraints.Required;
import play.db.ebean.Model;

/**
 * Classe que representa as disciplinas a serem alocadas
 * 
 */
@Entity
public class Disciplina extends Model{

	private static final long serialVersionUID = 871291622882752052L;
	
	@Id
	public Long id;
	
	@Required
	private String nome;
	
	@Required
	private int creditos;
	
	private boolean alocadaCorretamente = true;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "dependencias",
	joinColumns = @JoinColumn(name = "disciplina"), inverseJoinColumns = @JoinColumn(name = "preRequisito"))
	private List<Disciplina> preRequisitos;
	
	private int dificuldade;
	
	public static Model.Finder<String, Disciplina> find = new Model.Finder<String, Disciplina>(
			String.class, Disciplina.class);
	
	public Disciplina(String nome, int creditos, int dificuldade) {
		setNome(nome);
		setCreditos(creditos);
		setDificuladade(dificuldade);
		
		preRequisitos = new ArrayList<Disciplina>();
	}

	public Disciplina(String nome, int creditos, List<Disciplina> list,
			int dificuldade) {
		setNome(nome);
		setCreditos(creditos);
		setDificuladade(dificuldade);
		setPreRequisitos(list);
	}
	
	public boolean isAlocadaCorretamente() {
		return alocadaCorretamente;
	}

	public void setAlocadaCorretamente(boolean alocadaCorretamente) {
		this.alocadaCorretamente = alocadaCorretamente;
		
	}
	
	public void setPreRequisitos(List<Disciplina> list){
		if(list != null){
			this.preRequisitos = list;
		}
	}

	public String getNome() {
		return nome;
	}

	public int getCreditos() {
		return creditos;
	}

	public List<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}
	
	public int getNumPreRequisitos(){
		return preRequisitos.size();
	}

	public int getDificuldade() {
		return dificuldade;
	}
	
	public void setNome(String nome) {
		if(nome != null && !nome.equals("")){
			this.nome = nome;			
		}
	}

	public void setCreditos(int creditos) {
		if(creditos >= 0){
			this.creditos = creditos;
		}
	}

	public void setDificuladade(int dificuldade){
		if(dificuldade > 0 && dificuldade < 4 ){
			this.dificuldade = dificuldade;
		}
	}

	public boolean verificaPreRequisitos(String nomeDisciplina){
		boolean result =  false;
		
		for (Disciplina disciplina : preRequisitos) {
			if(disciplina.getNome().equals(nomeDisciplina)){
				result = true;
				break;
			}
		}
			
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Disciplina) {
			Disciplina compara = (Disciplina) obj;
			if (getNome().equals(compara.getNome()))
				return true;
		}
		return false;
	}

}