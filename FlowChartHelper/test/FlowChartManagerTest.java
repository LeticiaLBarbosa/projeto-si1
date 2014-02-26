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

	Disciplina prog2,calc2;



	@Before
	public void setUp() throws Exception{
		csflow = new FlowChartManager();
		periodo1=new PrimeiroPeriodo();
		periodo2= new PeriodoRegular();

		ArrayList<Disciplina> requisitosProg2 = new ArrayList<Disciplina>();
		requisitosProg2.add(new Disciplina("ProgramaÃ§Ã£o I",4, "1"));
		requisitosProg2.add(new Disciplina("LaboratÃ³rio de ProgramaÃ§Ã£o I",4, "2"));
		requisitosProg2.add(new Disciplina("IntroduÃ§Ã£o Ã  ComputaÃ§Ã£o",4,  "3"));
		prog2 = new Disciplina("ProgramaÃ§Ã£o II", 4,  "4");
		PeriodoRegular periodo = new PeriodoRegular();
		calc2 = new Disciplina("CÃ¡lculo 2", 4, "5");
		periodo.adicionaDisciplina(prog2);

		periodo.adicionaDisciplina(calc2);
		csflow.adicionaPeriodo();


		//csflow.adicionaPeriodo();


	}

	@Test
	public void DeveExibirTotalDeCreditosInicial() {


		assertEquals((int) 24, csflow.getTotalDeCreditos(1), 0);
	}

	@Test
	public void DeveRetornarDisciplinasCorretamente() throws Exception {

		ArrayList<Disciplina> atuais =  csflow.getDisciplinas(1); // Argumento Ã© o perÃ­odo, no caso, o primeiro.

		ArrayList<Disciplina> preRequisitos = new ArrayList<Disciplina>(); 	
		//Vazio. Sem Pre-requisitos para as disciplinas de primeiro perÃ­odo

		ArrayList<Disciplina> esperadas = new ArrayList<Disciplina>(); 
		esperadas.add(new Disciplina("CÃ¡lculo Diferencial e Integral I", 4,"0"));
		esperadas.add(new Disciplina("Ãlgebra Vetorial e Geometria AnalÃ­tica", 4,"1"));
		esperadas.add(new Disciplina("Leitura e ProduÃ§Ã£o de Textos", 4, "2"));
		esperadas.add(new Disciplina("ProgramaÃ§Ã£o I", 4, "3"));
		esperadas.add(new Disciplina("IntroduÃ§Ã£o Ã  ComputaÃ§Ã£o", 4,"4"));
		esperadas.add(new Disciplina("LaboratÃ³rio de ProgramaÃ§Ã£o I", 4,"5"));
		
		
		for(int i = 0; i < 6; i++) {
			
			assertTrue(esperadas.get(i).equals(atuais.get(i)));
		}
	}

	@Test
	public void deveMostrarDisciplinasAlocadasNosDoisPrimeirosPeriodos() throws Exception{
		ArrayList<Disciplina> requisito = new ArrayList<Disciplina>();
		requisito.add((new Disciplina("ProgramaÃ§Ã£o I", 4,"0")));
		requisito.add((new Disciplina("LaboratÃ³rio de ProgramaÃ§Ã£o I", 4,"0")));
		periodo2.adicionaDisciplina((new Disciplina("ProgramaÃ§Ã£o II", 4,"0")));


		ArrayList<Disciplina> esperadas = new ArrayList<Disciplina>(); 
		esperadas.add((new Disciplina("ProgramaÃ§Ã£o II", 4,"0")));


		assertEquals(esperadas, periodo2.getDisciplinas());
	}

	@Test
	public void deveVerificarQueONumeroDeCreditosNaoEhSuficiente(){

		assertFalse(csflow.verificaMinimoDeCreditosDoPeriodo(1));

	}

	@Test
	public void deveAdicionarPeriodo() throws Exception{
		csflow.adicionaPeriodo();
		assertEquals(3, csflow.getTotalDePeriodos());
	}

	@Test
	public void testaAdicionaDisciplinas() throws Exception{

		assertTrue(csflow.getDisciplinas(1).contains(new Disciplina("IntroduÃ§Ã£o Ã  ComputaÃ§Ã£o",4,"4")));
		assertTrue(csflow.getDisciplinas(1).contains(new Disciplina("IntroduÃ§Ã£o Ã  ComputaÃ§Ã£o",4,"4")));
		assertTrue(csflow.getDisciplinas(1).contains(new Disciplina("LaboratÃ³rio de ProgramaÃ§Ã£o I",4,"5")));
		csflow.adicionaDisciplina("7", 2);
		csflow.adicionaDisciplina("8", 2);
		assertTrue(csflow.getDisciplinas(2).contains(new Disciplina("ProgramaÃ§Ã£o II", 4, "7")));
		assertTrue(csflow.getDisciplinas(2).contains(new Disciplina("LaboratÃ³rio de ProgramaÃ§Ã£o II", 4, "7")));


	}


	@Test
	public void testaRemoveDisciplinas() throws Exception{
		csflow.adicionaPeriodo();
		csflow.adicionaPeriodo();
		csflow.adicionaDisciplina("6", 2);
		assertTrue(csflow.getDisciplinas(2).contains(new Disciplina("CÃ¡lculo II", 4, "6")));
		csflow.removeDisciplina("6", 2);
		assertFalse(csflow.getDisciplinas(2).contains(new Disciplina("CÃ¡lculo II", 4, "6")));


		csflow.adicionaDisciplina("6", 2);  // CÃ¡lculo 2
		csflow.adicionaDisciplina("14", 3); // Probabilidade
		csflow.adicionaDisciplina("13", 3); // Linear
		csflow.adicionaDisciplina("20", 4); // MÃ©todos

		csflow.removeDisciplina("6", 2);

		assertFalse(csflow.getDisciplinas(3).contains(new Disciplina("Probabilidade e EstatÃ­stica", 4, "14")));
		assertFalse(csflow.getDisciplinas(4).contains(new Disciplina("Metodos EstatÃ­sticos", 4, "20")));



	}


	@Test
	public void verificaSePeriodoTemMinimoDeCreditos() throws Exception{
		assertEquals(2, csflow.getTotalDePeriodos());
		assertTrue(csflow.verificaMinimoDeCreditosDoPeriodo(2));

	}
}