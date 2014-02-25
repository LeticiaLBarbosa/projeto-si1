package models;
 
import java.util.ArrayList;

/**
 * Classe responsável pela criação do catálogo de disciplinas do curso
 * @author Ana Luiza, Fellype e João Pedro
 *
 */
 public class Catalogo {
 
    private ArrayList<Disciplina> disciplinas;
    private ArrayList<Disciplina> requisitosP2;
    private ArrayList<Disciplina> requisitosLP2;
    private ArrayList<Disciplina> requisitosGrafos;
    private ArrayList<Disciplina> requisitosCalc2;
    private ArrayList<Disciplina> requisitosFisClassica;
    private ArrayList<Disciplina> requisitosEda;
    private ArrayList<Disciplina> requisitosLeda;
    private ArrayList<Disciplina> requisitosLinear;
    private ArrayList<Disciplina> requisitosProb;
    private ArrayList<Disciplina> requisitosTc;
    private ArrayList<Disciplina> requisitosModerna;
    private ArrayList<Disciplina> requisitosME;
    private ArrayList<Disciplina> requisitosLogica;
    private ArrayList<Disciplina> requisitosSI;
    private ArrayList<Disciplina> requisitosES;
    private ArrayList<Disciplina> requisitosPLP;
    private ArrayList<Disciplina> requisitosOAC;
    private ArrayList<Disciplina> requisitosLOAC;
    private ArrayList<Disciplina> requisitosAtal;
    private ArrayList<Disciplina> requisitosCOMP;
    private ArrayList<Disciplina> requisitosRedes;
    private ArrayList<Disciplina> requisitosSI2;
    private ArrayList<Disciplina> requisitosLES;
    private ArrayList<Disciplina> requisitosBDI;
    private ArrayList<Disciplina> requisitosSO;
    private ArrayList<Disciplina> requisitosIRC;
    private ArrayList<Disciplina> requisitosLIRC;
    private ArrayList<Disciplina> requisitosIA;
    private ArrayList<Disciplina> requisitosBDII;
    private ArrayList<Disciplina> requisitosProjI;
    private ArrayList<Disciplina> requisitosProjII;
    private ArrayList<Disciplina> requisitosMSN;
    private ArrayList<Disciplina> requisitosADSD;
 
	public Catalogo(){
		  disciplinas = new ArrayList<Disciplina>();
			preenchePreRequisitos();
			preencheDisciplinas();
          
	}

	private void preencheDisciplinas() {
		disciplinas.add(new Disciplina("Cálculo Diferencial e Integral I", 4, new ArrayList<Disciplina>(),"41"));
		disciplinas.add(new Disciplina("Álgebra Vetorial e Geometria Analítica", 4, new ArrayList<Disciplina>(),"42"));
		disciplinas.add(new Disciplina("Leitura e Produção de Textos", 4, new ArrayList<Disciplina>(),"0"));
		disciplinas.add(new Disciplina("Programação I", 4, new ArrayList<Disciplina>(),"39"));
		disciplinas.add(new Disciplina("Introdução à Computação", 4, new ArrayList<Disciplina>(),"41"));
		disciplinas.add(new Disciplina("Laboratório de Programação I", 4, new ArrayList<Disciplina>(),"40"));
		
		  disciplinas.add(new Disciplina("Cálculo Diferencial e Integral II", 4, requisitosCalc2, "1"));
          disciplinas.add(new Disciplina("Matemática Discreta", 4, new ArrayList<Disciplina>(), "2"));
          disciplinas.add(new Disciplina("Fundamentos de Física Clássica", 4, requisitosFisClassica, "3"));
          disciplinas.add(new Disciplina("Programação II", 4, requisitosP2, "4"));
          disciplinas.add(new Disciplina("Teoria dos Grafos", 2, requisitosGrafos, "5"));
          disciplinas.add(new Disciplina("Laboratório de Programação II", 4, requisitosLP2, "6"));
          
          disciplinas.add(new Disciplina("Álgebra Linear", 4, requisitosLinear, "7"));
          disciplinas.add(new Disciplina("Probabilidade e Estatística", 4, requisitosProb, "8"));
          disciplinas.add(new Disciplina("Fundamentos de Física Moderna", 4, requisitosModerna, "9"));
          disciplinas.add(new Disciplina("Estruturas de Dados e Algoritmos", 4, requisitosEda, "10"));
          disciplinas.add(new Disciplina("Teoria da Computação", 2, requisitosTc, "11"));
          disciplinas.add(new Disciplina("Laboratório de Estruturas de Dados e Algoritmos", 4, requisitosLeda, "12"));
          disciplinas.add(new Disciplina("Gerência da Informação", 4, new ArrayList<Disciplina>(), "13"));
          
          disciplinas.add(new Disciplina("Métodos Estatísticos", 4, requisitosME, "14"));
          disciplinas.add(new Disciplina("Lógica Matemática", 4, requisitosLogica, "15"));
          disciplinas.add(new Disciplina("Engenharia de Software I", 4, requisitosES, "16"));
          disciplinas.add(new Disciplina("Sistemas de Informação I", 4, requisitosSI, "17"));
          disciplinas.add(new Disciplina("Paradigmas de Linguagens de Programação", 2, requisitosPLP, "18"));
          disciplinas.add(new Disciplina("Organização e Arquitetura de Computadores I", 4, requisitosOAC, "19"));
          disciplinas.add(new Disciplina("Laboratório de Organização e Arquitetura de Computadores", 4, requisitosLOAC, "20"));
          
          disciplinas.add(new Disciplina("Informática e Sociedade", 2, new ArrayList<Disciplina>(), "21"));
          disciplinas.add(new Disciplina("Análise e Técnicas de Algoritmos", 4, requisitosAtal, "22"));
          disciplinas.add(new Disciplina("Compiladores", 4, requisitosCOMP, "23"));
          disciplinas.add(new Disciplina("Redes de Computadores", 4, requisitosRedes, "24"));
          disciplinas.add(new Disciplina("Bancos de Dados I", 4, requisitosBDI, "25"));
          disciplinas.add(new Disciplina("Sistemas de Informação II", 4, requisitosSI2, "26"));
          disciplinas.add(new Disciplina("Laboratório de Engenharia de Software", 2, requisitosLES, "27"));
          
          disciplinas.add(new Disciplina("Optativa 1", 4, new ArrayList<Disciplina>(), "28"));
          disciplinas.add(new Disciplina("Optativa 2", 4, new ArrayList<Disciplina>(), "29"));
          disciplinas.add(new Disciplina("Optativa 3", 4, new ArrayList<Disciplina>(), "30"));
          disciplinas.add(new Disciplina("Optativa 4", 4, new ArrayList<Disciplina>(), "31"));
          disciplinas.add(new Disciplina("Optativa 5", 4, new ArrayList<Disciplina>(), "32"));
          disciplinas.add(new Disciplina("Optativa 6", 4, new ArrayList<Disciplina>(), "33"));
          disciplinas.add(new Disciplina("Optativa 7", 4, new ArrayList<Disciplina>(), "34"));
          disciplinas.add(new Disciplina("Optativa 8", 4, new ArrayList<Disciplina>(), "35"));
          disciplinas.add(new Disciplina("Optativa 9", 4, new ArrayList<Disciplina>(), "36"));
          disciplinas.add(new Disciplina("Optativa 10", 4, new ArrayList<Disciplina>(), "37"));
          disciplinas.add(new Disciplina("Optativa 11", 2, new ArrayList<Disciplina>(), "38"));
          
          disciplinas.add(new Disciplina("TECC(TECNOLOGIAS DE COMUNICACAO SEM FIO)", 4, new ArrayList<Disciplina>(), "53"));
          disciplinas.add(new Disciplina("TECC(MINERAÇÃO DE DADOS)", 2, new ArrayList<Disciplina>(), "54"));
          disciplinas.add(new Disciplina("TECC(JOGOS DIGITAIS)", 4, new ArrayList<Disciplina>(), "55"));
          disciplinas.add(new Disciplina("TECC(ALGORITMOS AVANÇADOS I )", 4, new ArrayList<Disciplina>(), "56"));
          disciplinas.add(new Disciplina("TECC(INTRODUÇÃO À COMPUTAÇÃO QUÂNTICA)", 4, new ArrayList<Disciplina>(), "57"));
          disciplinas.add(new Disciplina("TECC (ANÁLISE DE DADOS I)", 4, new ArrayList<Disciplina>(), "58"));
          
          disciplinas.add(new Disciplina("Sistemas Operacionais", 4, requisitosSO, "59"));
          disciplinas.add(new Disciplina("Interconexão de Redes de Computadores", 4, requisitosIRC, "43"));
          disciplinas.add(new Disciplina("Laboratório de Interconexão de Redes de Computadores", 4, requisitosLIRC, "44"));
          disciplinas.add(new Disciplina("Inteligência Artificial I", 4, requisitosIA, "45"));
          disciplinas.add(new Disciplina("Banco de Dados II", 4, requisitosBDII, "46"));
          disciplinas.add(new Disciplina("Direito e Cidadania", 4, new ArrayList<Disciplina>(), "47"));
          
          disciplinas.add(new Disciplina("Projeto em Computação  I", 4, requisitosProjI, "48"));
          disciplinas.add(new Disciplina("Projeto em Computação II", 4, requisitosProjII, "49"));
          disciplinas.add(new Disciplina("Métodos e Software Númericos", 4, requisitosMSN, "50"));
          disciplinas.add(new Disciplina("Avaliação de Desempenho de Sistemas Discretos", 4, requisitosADSD, "51"));

          disciplinas.add(new Disciplina("Metodologia Científica",4, new ArrayList<Disciplina>(), "52"));
	}
 
 

 
 
 
	private void preenchePreRequisitos(){
		requisitosP2 = new ArrayList<Disciplina>();
		requisitosP2.add(new Disciplina("Programação I",4, new ArrayList<Disciplina>() , "39"));
		requisitosP2.add(new Disciplina("Laboratório de Programação I",4, new ArrayList<Disciplina>() , "40"));
		requisitosP2.add(new Disciplina("Introdução à Computação",4, new ArrayList<Disciplina>() , "41"));
 
		requisitosLP2 = new ArrayList<Disciplina>();
		requisitosLP2.add(new Disciplina("Programação I",4, new ArrayList<Disciplina>() , "39"));
		requisitosLP2.add(new Disciplina("Laboratório de Programação I",4, new ArrayList<Disciplina>() , "40"));
		requisitosLP2.add(new Disciplina("Introdução à Computação",4, new ArrayList<Disciplina>() , "41"));
 
		requisitosGrafos = new ArrayList<Disciplina>();
		requisitosGrafos.add(new Disciplina("Programação I",4, new ArrayList<Disciplina>() , "39"));
		requisitosGrafos.add(new Disciplina("Laboratório de Programação I",4, new ArrayList<Disciplina>() , "40"));
 
		requisitosCalc2 = new ArrayList<Disciplina>();
		requisitosCalc2.add(new Disciplina("Cálculo Diferencial e Integral I",4, new ArrayList<Disciplina>() , "42"));
 
		requisitosFisClassica = new ArrayList<Disciplina>();
		requisitosFisClassica.add(new Disciplina("Cálculo Diferencial e Integral I",4, new ArrayList<Disciplina>() , "42"));
		requisitosFisClassica.add(new Disciplina("Álgebra Vetorial e Geometria Analítica",4, new ArrayList<Disciplina>() , "42"));
 
		requisitosEda = new ArrayList<Disciplina>();
		requisitosEda.add(new Disciplina("Programação II",4, requisitosP2 , "4"));
		requisitosEda.add(new Disciplina("Laboratório de Programação II",4, requisitosLP2 , "6"));
		requisitosEda.add(new Disciplina("Teoria dos Grafos",4, requisitosGrafos , "5"));
 
		requisitosLeda = new ArrayList<Disciplina>();
		requisitosLeda.add(new Disciplina("Programação II",4, requisitosP2 , "4"));
		requisitosLeda.add(new Disciplina("Laboratório de Programação II",4, requisitosLP2 , "6"));
		requisitosLeda.add(new Disciplina("Teoria dos Grafos",4, requisitosGrafos , "5"));
 
 
		requisitosLinear = new ArrayList<Disciplina>();
		requisitosLinear.add(new Disciplina("Álgebra Vetorial e Geometria Analítica",4, new ArrayList<Disciplina>() , "42"));
 
		requisitosProb = new ArrayList<Disciplina>();
		requisitosProb.add(new Disciplina("Cálculo Diferencial e Integral II", 4, requisitosCalc2, "1"));
 
		requisitosTc = new ArrayList<Disciplina>();
		requisitosTc.add(new Disciplina("Matemática Discreta", 4, new ArrayList<Disciplina>(),"2" ));
		requisitosTc.add(new Disciplina("Introdução à Computação", 4, new ArrayList<Disciplina>(),"41"));
		requisitosTc.add(new Disciplina("Teoria dos Grafos",4, requisitosGrafos , "5"));
 
		requisitosModerna = new ArrayList<Disciplina>();
		requisitosModerna.add(new Disciplina("Cálculo Diferencial e Integral II", 4, requisitosCalc2, "1"));
		requisitosModerna.add(new Disciplina("Fundamentos de Física Clássica", 4, requisitosFisClassica, "3"));
 

		requisitosME = new ArrayList<Disciplina>();
		requisitosME.add(new Disciplina("Probabilidade e Estatística", 4, requisitosProb, "8"));
		requisitosME.add(new Disciplina("Álgebra Linear", 4, new ArrayList<Disciplina>(), "7"));

		requisitosLogica = new ArrayList<Disciplina>();
		requisitosLogica.add(new Disciplina("Teoria da Computação", 4, requisitosTc, "11"));
 
		requisitosES = new ArrayList<Disciplina>();
		requisitosES.add(new Disciplina("Programação II",4, requisitosP2 , "4"));
		requisitosES.add(new Disciplina("Laboratório de Programação II",4, requisitosLP2 , "6"));
		requisitosES.add(new Disciplina("Probabilidade e Estatística", 4, requisitosProb, "8"));
		
		requisitosSI = new ArrayList<Disciplina>();
		requisitosSI.add(new Disciplina("Gerência da Informação", 4, new ArrayList<Disciplina>(), "13"));
		
		requisitosPLP = new ArrayList<Disciplina>();
		requisitosPLP.add(new Disciplina("Teoria da Computação", 4, requisitosTc, "11"));
		requisitosPLP.add(new Disciplina("Estruturas de Dados e Algoritmos", 4, requisitosEda, "10"));
		

		requisitosOAC = new ArrayList<Disciplina>();
		requisitosOAC.add(new Disciplina("Fundamentos de Física Moderna", 4, requisitosModerna, "9"));
		requisitosOAC.add(new Disciplina("Estruturas de Dados e Algoritmos", 4, requisitosEda, "10"));
		requisitosOAC.add(new Disciplina("Estruturas de Dados e Algoritmos", 4, requisitosLeda, "12"));
		
		requisitosLOAC = new ArrayList<Disciplina>();
		requisitosLOAC.add(new Disciplina("Fundamentos de Física Moderna", 4, requisitosModerna, "9"));
		requisitosLOAC.add(new Disciplina("Estruturas de Dados e Algoritmos", 4, requisitosEda, "10"));
		requisitosLOAC.add(new Disciplina("Laboratório Estruturas de Dados e Algoritmos", 4, requisitosLeda, "12"));
		
		requisitosAtal = new ArrayList<Disciplina>();
		requisitosAtal.add(new Disciplina("Cálculo Diferencial e Integral II", 4, requisitosCalc2, "1"));
		requisitosAtal.add(new Disciplina("Estruturas de Dados e Algoritmos", 4, requisitosEda, "10"));
		requisitosAtal.add(new Disciplina("Laboratório Estruturas de Dados e Algoritmos", 4, requisitosLeda, "12"));
		requisitosAtal.add(new Disciplina("Lógica Matemática", 4, requisitosLogica, "15"));
		
		requisitosCOMP = new ArrayList<Disciplina>();
		requisitosCOMP.add(new Disciplina("Organização e Arquitetura de Computadores I", 4, requisitosOAC, "19"));
		requisitosCOMP.add(new Disciplina("Laboratório de Organização e Arquitetura de Computadores I", 4, requisitosLOAC, "20"));
		requisitosCOMP.add(new Disciplina("Paradigmas de Linguagens de Programação", 2, requisitosPLP, "18"));
		

		requisitosRedes = new ArrayList<Disciplina>();
		requisitosRedes.add(new Disciplina("Organização e Arquitetura de Computadores I", 4, requisitosOAC, "19"));
		requisitosRedes.add(new Disciplina("Laboratório de Organização e Arquitetura de Computadores I", 4, requisitosLOAC, "20"));
	

		requisitosBDI = new ArrayList<Disciplina>();
		requisitosBDI.add(new Disciplina("Sistemas de Informação I", 4, requisitosSI, "17"));
		
		requisitosSI2 = new ArrayList<Disciplina>();
		requisitosSI2.add(new Disciplina("Sistemas de Informação I", 4, requisitosSI, "17"));
		
		requisitosLES = new ArrayList<Disciplina>();
		requisitosLES.add(new Disciplina("Engenharia de Software I", 4, requisitosES, "16"));
		
		requisitosSO = new ArrayList<Disciplina>();
		requisitosSO.add(new Disciplina("Organização e Arquitetura de Computadores I", 4, requisitosOAC, "19"));
		requisitosSO.add(new Disciplina("Laboratório de Organização e Arquitetura de Computadores I", 4, requisitosLOAC, "20"));
	
		requisitosIRC = new ArrayList<Disciplina>();
		requisitosIRC.add(new Disciplina("Redes de Computadores", 4, requisitosRedes, "24"));
		
		requisitosLIRC = new ArrayList<Disciplina>();
		requisitosLIRC.add(new Disciplina("Redes de Computadores", 4, requisitosRedes, "24"));
		
		requisitosIA = new ArrayList<Disciplina>();
		requisitosIA.add(new Disciplina("Métodos Estatísticos", 4, requisitosME, "14"));
		requisitosIA.add(new Disciplina("Análise e Técnicas de Algoritmos", 4, requisitosAtal, "22"));
		requisitosIA.add(new Disciplina("Paradigmas de Linguagens de Programação", 2, requisitosPLP, "18"));

		requisitosBDII = new ArrayList<Disciplina>();
		requisitosBDII.add(new Disciplina("Bancos de Dados I", 4, requisitosBDI, "25"));
		requisitosBDII.add(new Disciplina("Sistemas de Informação II", 4, requisitosSI2, "26"));
	
		requisitosProjI = new ArrayList<Disciplina>();
		requisitosProjI.add(new Disciplina("Metodologia Científica",4, new ArrayList<Disciplina>(), "52"));
		requisitosProjI.add(new Disciplina("Laboratório de Engenharia de Software", 2, requisitosLES, "27"));
	
		requisitosMSN = new ArrayList<Disciplina>();
		requisitosMSN.add(new Disciplina("Álgebra Linear", 4, new ArrayList<Disciplina>(), "7"));
		requisitosMSN.add(new Disciplina("Análise e Técnicas de Algoritmos", 4, requisitosAtal, "22"));
		
		requisitosADSD = new ArrayList<Disciplina>();
		requisitosADSD.add(new Disciplina("Probabilidade e Estatística", 4, requisitosProb, "8"));
		
		
		
		
	}
 
 
	public ArrayList<Disciplina>  getDisciplinas(){

		return disciplinas;
 
	}

	public Disciplina get(String id) {
	     for(Disciplina disciplina: disciplinas) if(disciplina.getId().equals(id)) return disciplina;
	     return null;
	}
 
}
