import static org.junit.Assert.assertEquals;
import models.CatalogoDisciplinas;
import models.Grade;
import models.GradeAtual;
import models.GradeMaisComum;

import org.junit.Before;
import org.junit.Test;

public class testGrades {
	
	Grade grade1;
	Grade grade2;
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
}