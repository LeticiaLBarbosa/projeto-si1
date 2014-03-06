package models;

import java.util.*;

import javax.persistence.*;

import play.db.ebean.*;
import play.data.format.*;
import play.data.validation.*;

import com.avaje.ebean.*;

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

}
