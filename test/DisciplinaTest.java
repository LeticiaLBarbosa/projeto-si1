import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import models.CatalogoDisciplinas;
import models.Disciplina;

import org.junit.Before;
import org.junit.Test;

public class DisciplinaTest {
	CatalogoDisciplinas catalogo;
	Disciplina d1, d2, d3, d4, d5;
	List<String> list = new ArrayList<String>();
	
	@Before
	public void setUp(){
		catalogo = new CatalogoDisciplinas();
		d1 = catalogo.getDisciplina("Cálculo II");
		d2 = catalogo.getDisciplina("Lab. de Programação II");
		d3 = catalogo.getDisciplina("Álgebra Linear");
		d4 = catalogo.getDisciplina("Matemática Discreta");
	}
	
	@Test
	public void Prerequisito(){
		assertTrue(d1.getPreRequisitos().contains("Cálculo I"));

		list.clear();
		list.add("Programação I");
		list.add("Lab. de Programação I");
		list.add("Introdução a Computação");
		assertEquals(list,d2.getPreRequisitos());
		
		list.clear();
		list.add("Álgebra Vetorial e Geometria Analítica");
		assertEquals(list,d3.getPreRequisitos());
		
		list.clear();
		assertEquals(list,d4.getPreRequisitos());

	}
	
	@Test
	public void NumPreRequisitos(){
		assertEquals(1, d1.getNumPreRequisitos());
		assertEquals(3, d2.getNumPreRequisitos());
		assertEquals(1, d3.getNumPreRequisitos());
		assertEquals(0, d4.getNumPreRequisitos());
	}

	
	@Test
	public void Alocação(){
		d1.setAlocada();
		assertTrue(d1.getAlocada());
		assertFalse(d2.getAlocada());
		d3.setAlocada();
		d3.setAlocada();
		assertFalse(d3.getAlocada());
	}
}
