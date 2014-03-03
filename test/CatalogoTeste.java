import static org.junit.Assert.*;

import models.CatalogoDisciplinas;

import org.junit.Before;
import org.junit.Test;

public class CatalogoTeste {
	CatalogoDisciplinas catalogo;
	
	@Before
	public void setUp(){
		catalogo = new CatalogoDisciplinas();

	}
	
	@Test
	public void encontrandoDisciplinas(){
		assertEquals(6,catalogo.disciplinaIndice("Cálculo II"));
		assertEquals(11,catalogo.disciplinaIndice("Lab. de Programação II"));
		assertEquals(-1,catalogo.disciplinaIndice("Didatica"));
		assertEquals(52,catalogo.disciplinaIndice("Optativa 9"));
		assertEquals(42,catalogo.disciplinaIndice("Métodos e Software Numéricos"));	
	}
	
	@Test
	public void encontrandoDisciplinasPeloIndice(){
		assertEquals("Cálculo II",catalogo.getDisciplinaPorIndice(6).getNome());
		assertEquals("Optativa 10",catalogo.getDisciplinaPorIndice(53).getNome());
		assertEquals("Projeto em Computação II",catalogo.getDisciplinaPorIndice(49).getNome());
		assertEquals("Organização e Arquitetura de Computadores I",catalogo.getDisciplinaPorIndice(22).getNome());
		assertEquals("Estruturas de Dados e Algoritmos",catalogo.getDisciplinaPorIndice(15).getNome());

	}

}
