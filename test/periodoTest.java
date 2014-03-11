import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.Disciplina;
import models.Periodo;

import org.junit.Before;
import org.junit.Test;

import controllers.Sistema;


public class periodoTest {
	Sistema sistema;
	Periodo periodo1, periodo2;
	Disciplina d1, d2, d3, d4, d5;
	List<String> list = new ArrayList<String>();
	List<Periodo> listPeriodo = new ArrayList<Periodo>();;
	
	@Before
	public void setUp(){
		sistema = new Sistema();
		periodo1 = new Periodo();
		periodo2 = new Periodo();
		sistema.getAluno().getPeriodos().add(periodo1);
		sistema.getAluno().getPeriodos().add(periodo2);
		listPeriodo.add(periodo1);
		listPeriodo.add(periodo2);
		d1 = sistema.getPlanejador().getCatalogo().getDisciplina("Cálculo II");
		d2 = sistema.getPlanejador().getCatalogo().getDisciplina("Lab. de Programação II");
		d3 = sistema.getPlanejador().getCatalogo().getDisciplina("Álgebra Linear");
		d4 = sistema.getPlanejador().getCatalogo().getDisciplina("Matemática Discreta");
	}
	
	@Test
	public void adicionandoDisciplinas(){
		try {
			sistema.alocaDisciplina(0, d1.getNome());
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Limite de créditos, no periodo, excedido!");
		}
		
		try {
			sistema.alocaDisciplina(0,d3.getNome());
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Limite de créditos, no periodo, excedido!");
		}
		
		try {
			sistema.alocaDisciplina(0,d4.getNome());
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Limite de créditos, no periodo, excedido!");
		}
		
		try {
			sistema.alocaDisciplina(1,d2.getNome());
		} catch (Exception e) {
			assertEquals(e.getMessage(), "Limite de créditos, no periodo, excedido!");
		}
	}
	
	@Test
	public void removendoDisciplinas(){
		sistema.getPlanejador().removeDisciplina(sistema.getAluno(), "Matemática Discreta");
		assertFalse(periodo1.getDisciplinas().contains("Matemática Discreta"));
		sistema.getPlanejador().removeDisciplina(sistema.getAluno(), "Lab. de Programação II");
		assertEquals(0, periodo2.getDisciplinas().size());
	}
}
