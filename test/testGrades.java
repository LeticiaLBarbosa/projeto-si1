import static org.junit.Assert.*;
import models.*;
import org.junit.*;

import Exceptions.NomeDisciplinaInexistenteException;

public class testGrades {
	
	Grade grade1;
	Grade grade2;
	Grade grade3;
	CatalogoDisciplinas cat;
	
	@Before
	public void setUp(){
		grade1 = GradeAtual.getInstance();
		grade2 = GradeMaisComum.getInstance();
		cat = new CatalogoDisciplinas();		
	}
	
	@Test
	public void testNumeroPeriodos() {
		assertEquals(8,cat.getPeriodosDefault().size());
		assertEquals(8,grade1.getPeriodosDefault().size());
		assertEquals(9,grade2.getPeriodosDefault().size());
	}
	
	@Test
	public void testGradeAtual(){
		grade1 = GradeAtual.getInstance();
		grade1.getPeriodosDefault().size();
		try {
			grade1.getDisciplina("Cálculo II");
		} catch (NomeDisciplinaInexistenteException e) {
			Assert.assertEquals("Não há nenhuma disciplina com esse nome :Cálculo I", e.getMessage());
		}
		try {
			grade1.getDisciplina("Lógica para Computação");
			fail();
		} catch (NomeDisciplinaInexistenteException e) {
			Assert.assertEquals("Não há nenhuma disciplina com esse nome :Lógica para Computação", e.getMessage());
		}
	}
	
	@Test
	public void testGradeNova(){
		grade3 = GradeNova.getInstance();
		grade3.getPeriodosDefault().size();
		try {
			grade3.getDisciplina("Lab. de Programação II");
		} catch (NomeDisciplinaInexistenteException e) {
			Assert.assertEquals("Não há nenhuma disciplina com esse nome :Lab. de Programação II", e.getMessage());
		}
		try {
			grade3.getDisciplina("Leitura e Produção de Textos");
			fail();
		} catch (NomeDisciplinaInexistenteException e) {
			Assert.assertEquals("Não há nenhuma disciplina com esse nome :Leitura e Produção de Textos", e.getMessage());
		}
	}
	
	@Test
	public void testGradeComum(){
		grade2 = GradeMaisComum.getInstance();
		grade2.getPeriodosDefault().size();
		try {
			grade2.getDisciplina("Cálculo I");
		} catch (NomeDisciplinaInexistenteException e) {
			Assert.assertEquals("Não há nenhuma disciplina com esse nome :Cálculo I", e.getMessage());
		}
		try {
			grade2.getDisciplina("Mat. Discreta II");
			Assert.fail();
		} catch (NomeDisciplinaInexistenteException e) {
			Assert.assertEquals("Não há nenhuma disciplina com esse nome :Mat. Discreta II", e.getMessage());
		}
	}
	
}
