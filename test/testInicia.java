import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import play.db.ebean.Model.Finder;
import static play.test.Helpers.*;
import models.Disciplina;

public class testInicia {
	
	@Test
	 public void deveConseguirRecuperarDoBD() {
		 start(fakeApplication(inMemoryDatabase()));
		 
		 Finder<Long, Disciplina> finder = new Finder<Long, Disciplina>(Long.class, Disciplina.class);
		 
		 List<Disciplina> resultado = finder.all();
		 Assert.assertTrue(resultado.isEmpty());
		 
		 Disciplina umaDisciplina = new Disciplina("SI1", 4, 4);
		 umaDisciplina.save();
		 resultado = finder.all();
		 Assert.assertEquals(1, resultado.size());
	 }
}
