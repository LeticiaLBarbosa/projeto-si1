import static play.test.Helpers.*;

import java.util.List;
import models.*;
import org.junit.*;

import Exceptions.TotalDeCreditosInvalidoException;
import play.db.ebean.Model.Finder;

public class testaPeriodo {

	Periodo periodo;

	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
		periodo = new Periodo();
	}

	@Test
	public void deveConseguirRecuperarDoBD() {

		Finder<Long, Periodo> finder = new Finder<Long, Periodo>(Long.class,
				Periodo.class);

		List<Periodo> resultado = finder.all();
		Assert.assertTrue(resultado.isEmpty());

		periodo.save();

		resultado = finder.all();
	}

	@Test
	public void testaGetsPeriodo() {
		Disciplina d = new Disciplina("SI", 4, 2);
		Disciplina d2= new Disciplina("SI2", 2, 2);
		d.save();
		d2.save();
		
		//Total de Creditos
		
		Assert.assertEquals(periodo.getTotalCreditos(), 0);
		
		periodo.addDisciplina(d);
		
		Assert.assertEquals(periodo.getTotalCreditos(), 4);
		
		periodo.addDisciplina(d2);
		
		Assert.assertEquals(periodo.getTotalCreditos(), 6);
		
		//Get disciplina por nome
		
		Assert.assertEquals(periodo.getDisciplinaPorNome("SI").getNome(), "SI");
		Assert.assertEquals(periodo.getDisciplinaPorNome("SI3"), null);
		Assert.assertEquals(periodo.getDisciplinaPorNome("SI2").getNome(), "SI2");
		
		//Get dificuldade total
		
		Assert.assertEquals(periodo.getDificuldadeTotal(), 4);
		
		try {
			periodo.removeDisciplina("SI");
		} catch (TotalDeCreditosInvalidoException e) {
			Assert.assertEquals("Número de créditos insuficientes", e.getMessage());
		}
		
		Assert.assertEquals(periodo.getDificuldadeTotal(), 4);
		
	}
}
