import static org.junit.Assert.*;

import java.util.ArrayList;

import models.*;

import org.junit.Before;
import org.junit.Test;
import controllers.FlowChartManager;

public class FlowChartManagerTest {

	FlowChartManager csflow;
	PrimeiroPeriodo periodo1;
	PeriodoRegular periodo2;
	Disciplina prog2;
	
	@Before
	public void setUp() throws Exception{
		csflow = new FlowChartManager();
		periodo1=new PrimeiroPeriodo();
		periodo2= new PeriodoRegular();
		
		ArrayList<Disciplina> requisitosProg2 = new ArrayList<Disciplina>();
		requisitosProg2.add(new Disciplina("Programação I",4, new ArrayList<Disciplina>() , "1"));
		requisitosProg2.add(new Disciplina("Laboratório de Programação I",4, new ArrayList<Disciplina>() , "2"));
		requisitosProg2.add(new Disciplina("Introdução à Computação",4, new ArrayList<Disciplina>() , "3"));
		prog2 = new Disciplina("Programação II", 4, requisitosProg2, "4");
		PeriodoRegular periodo = new PeriodoRegular();
		periodo.adicionaDisciplina(prog2);
		csflow.adicionaPeriodo();
		
		
		
	}
	
	@Test
	public void DeveExibirTotalDeCreditosInicial() {
		
		
		assertEquals((int) 24, csflow.getTotalDeCreditos(1), 0);
	}
	
	@Test
	public void DeveRetornarDisciplinasCorretamente() {
		
		ArrayList<Disciplina> atuais =  csflow.getDisciplinas(1); // Argumento é o período, no caso, o primeiro.
		
		ArrayList<Disciplina> preRequisitos = new ArrayList<Disciplina>(); 	
		//Vazio. Sem Pre-requisitos para as disciplinas de primeiro período
		
		ArrayList<Disciplina> esperadas = new ArrayList<Disciplina>(); 
		esperadas.add(new Disciplina("Cálculo Diferencial e Integral I", 4, preRequisitos,"0"));
		esperadas.add(new Disciplina("Álgebra Vetorial e Geometria Analítica", 4, preRequisitos,"0"));
		esperadas.add(new Disciplina("Leitura e Produção de Textos", 4, preRequisitos,"0"));
		esperadas.add(new Disciplina("Programação I", 4, preRequisitos,"0"));
		esperadas.add(new Disciplina("Introdução à Computação", 4, preRequisitos,"0"));
		esperadas.add(new Disciplina("Laboratório de Programação I", 4, preRequisitos,"0"));
		
		for(int i = 0; i < 6; i++) assertTrue(esperadas.get(i).equals(atuais.get(i)));
	}
	
	@Test
	public void deveMostrarDisciplinasAlocadasNosDoisPrimeirosPeriodos() throws Exception{
		ArrayList<Disciplina> requisito = new ArrayList<Disciplina>();
		requisito.add((new Disciplina("Programação I", 4, (new ArrayList<Disciplina>()),"0")));
		requisito.add((new Disciplina("Laboratório de Programação I", 4, (new ArrayList<Disciplina>()),"0")));
		periodo2.adicionaDisciplina((new Disciplina("Programação II", 4,requisito,"0")));
		
		
		ArrayList<Disciplina> esperadas = new ArrayList<Disciplina>(); 
		esperadas.add((new Disciplina("Programação II", 4,requisito,"0")));
		
		
		assertEquals(esperadas, periodo2.getDisciplinas());
	}
	
	@Test
	public void deveVerificarQueONumeroDeCreditosNaoEhSuficiente(){

		assertFalse(csflow.verificaMinimoDeCreditosDoPeriodo(1));
		
	}
	
	
}


