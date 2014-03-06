import static org.junit.Assert.*;

import models.Disciplina;

import org.junit.Test;
import org.junit.Before;

import controllers.Sistema;

public class US1test {

	Sistema sistema;
	
	@Before
	public void setUp(){
		sistema = new Sistema();
	}
			
	@Test
	public void deveTerOprimeiroPeriodo() {
		assert(this.sistema.getAluno().getPeriodos().size() >= 1);
		assertTrue(sistema.getAluno().getPeriodos().get(0).getDisciplinas().contains(new Disciplina("Programação I", 4,0)));
		assertTrue(sistema.getAluno().getPeriodos().get(0).getDisciplinas().contains(new Disciplina("Álgebra Vetorial e Geometria Analítica", 4, 0)));
		assertTrue(sistema.getAluno().getPeriodos().get(0).getDisciplinas().contains(new Disciplina("Cálculo I", 4 , 0)));
		assertTrue(sistema.getAluno().getPeriodos().get(0).getDisciplinas().contains(new Disciplina("Leitura e Produção de Textos", 4 , 0)));
		assertTrue(sistema.getAluno().getPeriodos().get(0).getDisciplinas().contains(new Disciplina("Introdução a Computação", 4 , 0)));
		assertTrue(sistema.getAluno().getPeriodos().get(0).getDisciplinas().contains(new Disciplina("Lab. de Programação I", 4 , 0)));
	}	
	
	@Test
	public void deveCalcularOtotalDeCréditosDoPeriodo(){
		assertEquals(24, sistema.getAluno().getPeriodos().get(0).getTotalCreditos());
	}
	
}
