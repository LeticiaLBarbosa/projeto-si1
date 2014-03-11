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
			sistema.getPlanejador().adicionaDisciplina(sistema.getAluno(), new Disciplina("test",4,0), 1);
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}

		assertEquals(sistema.getAluno().getPeriodos().get(1).getTotalCreditos(), 4);


		try{
			sistema.getPlanejador().adicionaDisciplina(sistema.getAluno(), new Disciplina("test",4,0), 4);
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}

		assertEquals(sistema.getAluno().getPeriodos().get(4).getTotalCreditos(), 4);
		
		try{
			sistema.getPlanejador().adicionaDisciplina(sistema.getAluno(), sistema.getPlanejador().getCatalogo().getDisciplina("Programação I"), 4);
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		assertEquals(sistema.getAluno().getPeriodos().get(4).getTotalCreditos(), 8);
		
		try{
			sistema.getPlanejador().adicionaDisciplina(sistema.getAluno(), sistema.getPlanejador().getCatalogo().getDisciplina("Teoria dos Grafos"), 4);
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		assertEquals(sistema.getAluno().getPeriodos().get(4).getTotalCreditos(), 10);
		
	}

	@Test
	public void removeDisciplina(){
		try{
			sistema.getPlanejador().adicionaDisciplina(sistema.getAluno(), sistema.getPlanejador().getCatalogo().getDisciplina("Teoria dos Grafos"), 4);
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		assertEquals(sistema.getAluno().getPeriodos().get(4).getTotalCreditos(), 2);

		sistema.getPlanejador().removeDisciplina(sistema.getAluno(), "Teoria dos Grafos");
		
		assertEquals(sistema.getAluno().getPeriodos().get(4).getTotalCreditos(), 0);
	}
	
//	@Test
//	public void naoDeveAdiconarDisciplina(){
//		try{
//			for(int i = 0; i < 9; i++){
//				sistema.addDisciplinasPeriodo(1, new Disciplina("test",4 , 0));
//			}			
//		}catch(Exception e){
//			assertEquals(e.getMessage(), "Limite de créditos, no periodo, excedido!");
//		}
//	}
}
