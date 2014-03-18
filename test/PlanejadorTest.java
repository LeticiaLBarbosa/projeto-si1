import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;

import java.util.List;

import models.Aluno;
import models.Disciplina;
import models.Planejador;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import play.db.ebean.Model.Finder;


public class PlanejadorTest {
	
	private Planejador planner;
	private Aluno aluno;
	
	@Before
	public void setUp(){
		aluno = new Aluno("analuiza","Ana Luiza", "bla");
		planner = aluno.getPlanejador();
		start(fakeApplication(inMemoryDatabase()));

	}

	@Test
	public void verificaMudancaDeStatusTest() {
		planner.removeDisciplina("Cálculo I");
		assertFalse(planner.getDisciplinasPeriodo(0).contains(new Disciplina("Cálculo I", 4, 3)));
		
		planner.adicionaDisciplina(new Disciplina("Cálculo I", 4, 3), 7);
		assertTrue(planner.getDisciplinasPeriodo(7).contains(new Disciplina("Cálculo I", 4, 3)));
		
		assertFalse(planner.getDisciplinasPeriodo(0).contains(new Disciplina("Cálculo I", 4, 3)));
		assertFalse(planner.getPeriodos().get(1).getDisciplinaPorNome("Cálculo II").isAlocadaCorretamente());
	}
	
	@Test
	public void bdTest(){
		Finder<Long, Planejador> finder = new Finder<Long, Planejador>(Long.class, Planejador.class);

		List<Planejador> resultado = finder.all();
		Assert.assertTrue(resultado.isEmpty());
		Planejador plano = new Planejador();
		plano.save();
		resultado = finder.all();
		Assert.assertEquals(1, resultado.size());		
	}

}
