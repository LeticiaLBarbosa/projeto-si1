import static org.junit.Assert.*;
import models.Aluno;
import models.CatalogoDisciplinas;
import models.Disciplina;
import models.Planejador;

import org.junit.Before;
import org.junit.Test;

import controllers.Sistema;


public class AdicionarRemoverTest {

	Sistema sistema;
	CatalogoDisciplinas catalogo;
	Aluno aluno;
	Planejador planejador;

	@Before
	public void setUp(){
		sistema = new Sistema();
		aluno = sistema.getAluno();
		planejador = sistema.getPlanejador();
		catalogo = new CatalogoDisciplinas();
		
		
	}

	@Test
	public void deveAcharDisciplinas() {
		
		assertTrue(catalogo.getDisciplina("Programação I") != null); 
		
		assertTrue(catalogo.getDisciplina("Cálculo I") != null);
	}

	
	@Test
	public void deveAdicionarDisciplinas() {

		try{
			planejador.adicionaDisciplina(aluno, new Disciplina("test",4,0), 1);
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}

		assertEquals(aluno.getPeriodos().get(1).getTotalCreditos(), 4);


		try{
			planejador.adicionaDisciplina(aluno, new Disciplina("test",4,0), 4);
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}

		assertEquals(aluno.getPeriodos().get(4).getTotalCreditos(), 4);
		
		try{
			planejador.adicionaDisciplina(aluno, catalogo.getDisciplina("Programação I"), 4);
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		assertEquals(aluno.getPeriodos().get(4).getTotalCreditos(), 8);
		
		try{
			planejador.adicionaDisciplina(aluno, catalogo.getDisciplina("Teoria dos Grafos"), 4);
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		assertEquals(aluno.getPeriodos().get(4).getTotalCreditos(), 10);
		
	}

	@Test
	public void removeDisciplina(){
		
			
		try{
			planejador.adicionaDisciplina(aluno, catalogo.getDisciplina("Cálculo II"), 2);
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		try{
			planejador.adicionaDisciplina(aluno, catalogo.getDisciplina("Probabilidade e Estatística"), 3);
		}catch(Exception e){			
			System.out.println(e.getMessage());
		}
		
		
		assertEquals(aluno.getPeriodos().get(3).getTotalCreditos(), 4);
		
		planejador.removeDisciplina(aluno, "Cálculo II");
		
		assertEquals(aluno.getPeriodos().get(3).getTotalCreditos(), 0);
	}
	
//	@Test
//	public void naoDeveAdiconarDisciplina(){
//		try{
//			for(int i = 0; i < 9; i++){
//				sistema.addDisciplinasPeriodo(1, new Disciplina("test",4,0));
//			}			
//		}catch(Exception e){
//			assertEquals(e.getMessage(), "Limite de créditos, no periodo, excedido!");
//		}
//	}
}
