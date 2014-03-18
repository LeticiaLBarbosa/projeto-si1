import static org.junit.Assert.*;
import static play.test.Helpers.fakeApplication;
import static play.test.Helpers.inMemoryDatabase;
import static play.test.Helpers.start;

import java.util.List;

import models.Disciplina;
import models.Periodo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import play.db.ebean.Model.Finder;

public class testaPeriodo {

	Periodo p;

	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
		p = new Periodo();
	}

	@Test
	public void deveConseguirRecuperarDoBD() {

		Finder<Long, Periodo> finder = new Finder<Long, Periodo>(Long.class,
				Periodo.class);

		List<Periodo> resultado = finder.all();
		Assert.assertTrue(resultado.isEmpty());

		p.save();

		resultado = finder.all();
	}

	@Test
	public void testaGetsPeriodo() {
		Disciplina d = new Disciplina("SI", 4, 2);
		Disciplina d2= new Disciplina("SI2", 2, 2);
		d.save();
		d2.save();
		
		//Total de Creditos
		
		Assert.assertEquals(p.getTotalCreditos(), 0);
		
		p.addDisciplina(d);
		
		Assert.assertEquals(p.getTotalCreditos(), 4);
		
		p.addDisciplina(d2);
		
		Assert.assertEquals(p.getTotalCreditos(), 6);
		
		//Get disciplina por nome
		
		Assert.assertEquals(p.getDisciplinaPorNome("SI").getNome(), "SI");
		Assert.assertEquals(p.getDisciplinaPorNome("SI3"), null);
		Assert.assertEquals(p.getDisciplinaPorNome("SI2").getNome(), "SI2");
		
		//Get dificuldade total
		
		Assert.assertEquals(p.getDificuldadeTotal(), 4);
		
		p.removeDisciplina("SI");
		
		Assert.assertEquals(p.getDificuldadeTotal(), 2);
		
	}
}
