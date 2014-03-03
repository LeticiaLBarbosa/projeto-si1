import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.CatalogoDisciplinas;
import models.Disciplina;
import models.Periodo;

import org.junit.Before;
import org.junit.Test;


public class periodoTest {
	Periodo periodo1, periodo2;
	CatalogoDisciplinas catalogo;
	Disciplina d1, d2, d3, d4, d5;
	List<String> list = new ArrayList<String>();
	List<Periodo> listPeriodo = new ArrayList<Periodo>();;
	
	@Before
	public void setUp(){
		periodo1 = new Periodo();
		periodo2 = new Periodo();
		listPeriodo.add(periodo1);
		listPeriodo.add(periodo2);
		catalogo = new CatalogoDisciplinas();
		d1 = catalogo.getDisciplina("Cálculo II");
		d2 = catalogo.getDisciplina("Lab. de Programação II");
		d3 = catalogo.getDisciplina("Álgebra Linear");
		d4 = catalogo.getDisciplina("Matemática Discreta");
	}
	
	@Test
	public void adicionandoDisciplinas(){
		try {
			periodo1.addDisciplina(d1);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Limite de créditos, no periodo, excedido!");
		}
		
		try {
			periodo1.addDisciplina(d3);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Limite de créditos, no periodo, excedido!");
		}
		
		try {
			periodo1.addDisciplina(d4);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Limite de créditos, no periodo, excedido!");
		}
		
		try {
			periodo2.addDisciplina(d2);
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Limite de créditos, no periodo, excedido!");
		}
	}
	
	@Test
	public void removendoDisciplinas(){
		periodo1.rmDisciplina("Matemática Discreta");
		assertFalse(periodo1.getDisciplinas().contains("Matemática Discreta"));
		periodo2.rmDisciplina("Lab. de Programação II");
		assertEquals(0, periodo2.getDisciplinas().size());
	}
}
