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
		periodo1= new PrimeiroPeriodo();
		periodo2= new PeriodoRegular();

		ArrayList<Disciplina> requisitosProg2 = new ArrayList<Disciplina>();
		requisitosProg2.add(new Disciplina("Programação I",4, "1"));
		requisitosProg2.add(new Disciplina("Laboratório de Programação I",4, "2"));
		requisitosProg2.add(new Disciplina("Introdução à Computação",4,  "3"));
		prog2 = new Disciplina("Programação II", 4,  "4");
		PeriodoRegular periodo = new PeriodoRegular();
		periodo.adicionaDisciplina(prog2);
		//csflow.adicionaPeriodo();



	}

	@Test
	public void DeveExibirTotalDeCreditosInicial() {


		assertEquals((int) 24, csflow.getTotalDeCreditos(1), 0);
	}

	@Test
	public void DeveRetornarDisciplinasCorretamente() throws Exception {

		ArrayList<Disciplina> atuais =  csflow.getDisciplinas(1); // Argumento é o período, no caso, o primeiro.

		ArrayList<Disciplina> preRequisitos = new ArrayList<Disciplina>(); 	
		//Vazio. Sem Pre-requisitos para as disciplinas de primeiro período

		ArrayList<Disciplina> esperadas = new ArrayList<Disciplina>(); 
		esperadas.add(new Disciplina("Cálculo Diferencial e Integral I", 4,"0"));
		esperadas.add(new Disciplina("Álgebra Vetorial e Geometria Analítica", 4,"1"));
		esperadas.add(new Disciplina("Leitura e Produção de Textos", 4, "2"));
		esperadas.add(new Disciplina("Programação I", 4, "3"));
		esperadas.add(new Disciplina("Introdução à Computação", 4,"4"));
		esperadas.add(new Disciplina("Laboratório de Programação I", 4,"5"));
		csflow.adicionaPeriodo();
		for(int i = 0; i < 6; i++) {
			System.out.println(atuais.get(i).getNome());
			for(int j = 0; j < atuais.get(i).getDependentes().size(); j++) {
				System.out.println("-> " + atuais.get(i).getDependentes().get(j).getNome());
				
			}
			for(int j = 0; j < atuais.get(i).getPreRequisitos().size(); j++) {
				
				System.out.println(")))))) " + atuais.get(i).getPreRequisitos().get(j).getNome());
			}
		}
		csflow.adicionaDisciplina("6", 2);
		 csflow.getDisciplinas(2);
		 for(int i = 0; i < csflow.getDisciplinas(2).size(); i++) {
				System.out.println("AAAAAAAAAAAAA" + csflow.getDisciplinas(2).get(i).getNome());
				
			}
		assertTrue(esperadas.get(0).equals(atuais.get(0)));
		//assertTrue(esperadas.get(1).equals(atuais.get(1)));
		assertTrue(esperadas.get(2).equals(atuais.get(2)));
		for(int i = 0; i < 6; i++) {
			System.out.println(atuais.get(i).getNome());
			assertTrue(esperadas.get(i).equals(atuais.get(i)));
		}
	}

	@Test
	public void deveMostrarDisciplinasAlocadasNosDoisPrimeirosPeriodos() throws Exception{
		ArrayList<Disciplina> requisito = new ArrayList<Disciplina>();
		requisito.add((new Disciplina("Programação I", 4,"0")));
		requisito.add((new Disciplina("Laboratório de Programação I", 4,"0")));
		periodo2.adicionaDisciplina((new Disciplina("Programação II", 4,"0")));


		ArrayList<Disciplina> esperadas = new ArrayList<Disciplina>(); 
		esperadas.add((new Disciplina("Programação II", 4,"0")));


		assertEquals(esperadas, periodo2.getDisciplinas());
	}

	@Test
	public void deveVerificarQueONumeroDeCreditosNaoEhSuficiente(){
		assertFalse(csflow.verificaMinimoDeCreditosDoPeriodo(1));

	}
	
	
	@Test
	public void deveAdicionarDisciplina() throws Exception{
		csflow.adicionaPeriodo();
		assertTrue(csflow.getDisciplinas(1).contains(new Disciplina("Cálculo Diferencial e Integral I", 4, "0")));
		csflow.adicionaDisciplina("6", 2);
		assertTrue(csflow.getDisciplinas(2).contains(new Disciplina("Cálculo Diferencial e Integral II", 4, "6")));
		csflow.adicionaPeriodo();
		csflow.adicionaDisciplina("14", 3);
		assertTrue(csflow.getDisciplinas(3).contains(new Disciplina("Probabilidade e Estatística", 4, "14")));
		csflow.removeDisciplina("6", 2);
		assertFalse(csflow.getDisciplinas(2).contains(new Disciplina("Cálculo Diferencial e Integral II", 4, "6")));
		assertFalse(csflow.getDisciplinas(3).contains(new Disciplina("Probabilidade e Estatística", 4, "14")));
		
	}


}
