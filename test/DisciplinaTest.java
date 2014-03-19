import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;

import java.util.ArrayList;
import java.util.List;

import models.Aluno;
import models.CatalogoDisciplinas;
import models.Disciplina;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import play.db.ebean.Model.Finder;

public class DisciplinaTest {
	CatalogoDisciplinas catalogo;
	Disciplina d1, d2, d3, d4, d5;
	List<Disciplina> list = new ArrayList<Disciplina>();

	@Before
	public void setUp() {

		start(fakeApplication(inMemoryDatabase()));

		catalogo = new CatalogoDisciplinas();
		d1 = catalogo.getDisciplina("Cálculo II");
		d2 = catalogo.getDisciplina("Lab. de Programação II");
		d3 = catalogo.getDisciplina("Álgebra Linear");
		d4 = catalogo.getDisciplina("Matemática Discreta");
	}

	@Test
	public void deveConseguirRecuperarDoBD() {

		Finder<Long, Disciplina> finder = new Finder<Long, Disciplina>(
				Long.class, Disciplina.class);

		List<Disciplina> resultado = finder.all();
		Assert.assertTrue(resultado.isEmpty());

		Disciplina disciplina = new Disciplina("SI 1", 4, 3);
		disciplina.save();

		resultado = finder.all();
		Assert.assertEquals(1, resultado.size());
		
		Assert.assertEquals(resultado.get(0).getNome(), "SI 1");
		
	}

	@Test
	public void configuraDisciplina() {
		Assert.assertEquals(d1.getNome(), "Cálculo II");
		Assert.assertEquals(d1.getCreditos(), 4);
		Assert.assertEquals(d1.getNumPreRequisitos(), 1);
		Assert.assertEquals(d1.getDificuldade(), 3);

		d1.setNome("muda");
		d1.setCreditos(2);
		d1.setDificuladade(2);

		Assert.assertEquals(d1.getNome(), "muda");
		Assert.assertEquals(d1.getCreditos(), 2);
		Assert.assertEquals(d1.getDificuldade(), 2);
		
		//Tenta configurar errado
		
		d1.setNome("");
		d1.setCreditos(-1);
		d1.setDificuladade(-1);

		Assert.assertFalse(d1.getNome().equals(""));
		Assert.assertFalse(d1.getCreditos() == -1);
		Assert.assertFalse(d1.getDificuldade() == -1);

		Assert.assertEquals(d1.getNome(), "muda");
		Assert.assertEquals(d1.getCreditos(), 2);
		Assert.assertEquals(d1.getDificuldade(), 2);
	}
	

	@Test
	public void Prerequisito() {
		Disciplina d6 = catalogo.getDisciplina("Cálculo I");
		assertTrue(d1.getPreRequisitos().contains(d6));

		list.clear();
		list.add(catalogo.getDisciplina("Programação I"));
		list.add(catalogo.getDisciplina("Lab. de Programação I"));
		list.add(catalogo.getDisciplina("Introdução a Computação"));
		assertEquals(list, d2.getPreRequisitos());

		list.clear();
		list.add(catalogo.getDisciplina("Álgebra Vetorial e Geometria Analítica"));
		assertEquals(list, d3.getPreRequisitos());

		list.clear();
		assertEquals(list, d4.getPreRequisitos());

	}

	@Test
	public void NumPreRequisitos() {
		assertEquals(1, d1.getNumPreRequisitos());
		assertEquals(3, d2.getNumPreRequisitos());
		assertEquals(1, d3.getNumPreRequisitos());
		assertEquals(0, d4.getNumPreRequisitos());
	}

}
