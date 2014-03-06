import static org.junit.Assert.*;

import models.CatalogoDisciplinas;
import models.Disciplina;

import org.junit.Before;
import org.junit.Test;

import controllers.Sistema;


public class US2test {

	Sistema sistema;
	CatalogoDisciplinas catalogo;

	@Before
	public void setUp(){
		sistema = new Sistema();
		catalogo = new CatalogoDisciplinas();
		
		
	}

	@Test
	public void deveAcharDisciplinas() {
		
		assertEquals(catalogo.disciplinaIndice("Programação I"), 0); 
		
		assertEquals(catalogo.disciplinaIndice("Cálculo I"), 4);
	}

	
	@Test
	public void deveAdicionarDisciplinas() {

		try{
			sistema.addDisciplinasPeriodo(1, new Disciplina("test",4,0));
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}

		assertEquals(sistema.getAluno().getPeriodos().get(1).getTotalCreditos(), 4);


		try{
			sistema.addDisciplinasPeriodo(4, new Disciplina("test",4 , 0));
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}

		assertEquals(sistema.getAluno().getPeriodos().get(4).getTotalCreditos(), 4);
		
		try{
			sistema.addDisciplinasPeriodo(4, "Programação I");
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		assertEquals(sistema.getAluno().getPeriodos().get(4).getTotalCreditos(), 8);
		
		try{
			sistema.addDisciplinasPeriodo(4, "Teoria dos Grafos");
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		assertEquals(sistema.getAluno().getPeriodos().get(4).getTotalCreditos(), 10);
		
	}

	@Test
	public void removeDisciplina(){
		try{
			sistema.addDisciplinasPeriodo(4, "Teoria dos Grafos");
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		assertEquals(sistema.getAluno().getPeriodos().get(4).getTotalCreditos(), 2);

		sistema.removeDisciplinaPeriodo("Teoria dos Grafos");
		
		assertEquals(sistema.getAluno().getPeriodos().get(4).getTotalCreditos(), 0);
	}
	
	@Test
	public void naoDeveAdiconarDisciplina(){
		try{
			for(int i = 0; i < 9; i++){
				sistema.addDisciplinasPeriodo(1, new Disciplina("test",4 , 0));
			}			
		}catch(Exception e){
			assertEquals(e.getMessage(), "Limite de créditos, no periodo, excedido!");
		}
	}
}
