import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import play.db.ebean.Model.Finder;
import static play.test.Helpers.*;
import models.Aluno;

public class testaAluno {
	
	@Before
	
	public void setUp(){
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void deveConseguirRecuperarDoBD() {
		
		Finder<Long, Aluno> finder = new Finder<Long, Aluno>(Long.class, Aluno.class);

		List<Aluno> resultado = finder.all();
		Assert.assertTrue(resultado.isEmpty());
		Aluno umAluno = new Aluno("leticia", "leticia", "senha");
		umAluno.save();
		resultado = finder.all();
		Assert.assertEquals(1, resultado.size());
	
	
	}
	
}
