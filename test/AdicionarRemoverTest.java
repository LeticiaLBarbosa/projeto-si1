import static org.junit.Assert.*;

import models.CatalogoDisciplinas;
import models.Disciplina;

import org.junit.Before;
import org.junit.Test;

import controllers.Sistema;


public class AdicionarRemoverTest {

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

		assertEquals(sistema.getPeriodos().get(1).getTotalCreditos(), 4);


		try{
			sistema.addDisciplinasPeriodo(4, new Disciplina("test",4,0));
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}

		assertEquals(sistema.getPeriodos().get(4).getTotalCreditos(), 4);
		
		try{
			sistema.addDisciplinasPeriodo(4, "Programação I");
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		assertEquals(sistema.getPeriodos().get(4).getTotalCreditos(), 8);
		
		try{
			sistema.addDisciplinasPeriodo(4, "Teoria dos Grafos");
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		assertEquals(sistema.getPeriodos().get(4).getTotalCreditos(), 10);
		
	}

	@Test
	public void removeDisciplina(){
		
			
		try{
			sistema.addDisciplinasPeriodo(2, "Cálculo II");
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		try{
			sistema.addDisciplinasPeriodo(3, "Probabilidade e Estatística");
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		
		assertEquals(sistema.getPeriodos().get(3).getTotalCreditos(), 4);
		
		sistema.removeDisciplinaPeriodo("Cálculo II");
		
		assertEquals(sistema.getPeriodos().get(3).getTotalCreditos(), 0);
	}
	
	@Test
	public void naoDeveAdiconarDisciplina(){
		try{
			for(int i = 0; i < 9; i++){
				sistema.addDisciplinasPeriodo(1, new Disciplina("test",4,0));
			}			
		}catch(Exception e){
			assertEquals(e.getMessage(), "Limite de créditos, no periodo, excedido!");
		}
	}
}
