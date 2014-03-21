import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import play.db.ebean.Model.Finder;
import static play.test.Helpers.*;
import models.Aluno;

public class testaAluno {

	@Before
	public void setUp() {
		start(fakeApplication(inMemoryDatabase()));
	}

	@Test
	public void deveConseguirRecuperarDoBD() {

		Finder<Long, Aluno> finder = new Finder<Long, Aluno>(Long.class,
				Aluno.class);

		List<Aluno> resultado = finder.all();
		Assert.assertTrue(resultado.isEmpty());

		Aluno umAluno = new Aluno("leticia", "leticia", "senha");
		umAluno.save();

		resultado = finder.all();
		Assert.assertEquals(1, resultado.size());

	}

	@Test
	public void configuraAluno() {
		Aluno umAluno = new Aluno("leticia", "leticia", "senha");

		Assert.assertEquals("leticia", umAluno.getNome());
		Assert.assertEquals("leticia", umAluno.getEmail());
		Assert.assertEquals("senha", umAluno.getSenha());

		umAluno.setNome("FelipeNome");
		umAluno.setEmail("FelipeEmail");
		umAluno.setSenha("Senha");

		Assert.assertEquals("FelipeNome", umAluno.getNome());
		Assert.assertEquals("FelipeEmail", umAluno.getEmail());
		Assert.assertEquals("Senha", umAluno.getSenha());

		// Testa configura com null

		umAluno.setNome(null);
		umAluno.setEmail(null);
		umAluno.setSenha(null);

		Assert.assertEquals("FelipeNome", umAluno.getNome());
		Assert.assertEquals("FelipeEmail", umAluno.getEmail());
		Assert.assertEquals("Senha", umAluno.getSenha());

	}

}
