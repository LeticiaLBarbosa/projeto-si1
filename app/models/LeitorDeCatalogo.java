package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class LeitorDeCatalogo {


	public static void preencheCatalogo(List<Disciplina> disciplinas) throws IOException {
		
		String caminho = new File("resources/catalogo.txt").getCanonicalPath();
		BufferedReader reader = new BufferedReader(new FileReader(new File(caminho)));

		while (reader.ready()) {
			String[] info = reader.readLine().split("->");
			
			String nome = info[0].trim();
			String creditos = info[2].trim();
			String id = info[3].trim();

			disciplinas.add(new Disciplina(nome, Integer.parseInt(creditos), id));
		}
		reader.close();
		
		preencheDependentes(disciplinas);
	}

	private static Disciplina buscaDisciplina(List<Disciplina> disciplinas, String nome) {
		for(Disciplina disciplina: disciplinas) {
			if (disciplina.getNome().trim().equals(nome.trim()))
				return disciplina;
		}
		return null;
	}
	
	private static void preencheDependentes(List<Disciplina> disciplinas) throws IOException {
		String caminho = new File("resources/catalogo.txt").getCanonicalPath();
		BufferedReader reader = new BufferedReader(new FileReader(new File(caminho)));

		while (reader.ready()) {
			String[] info = reader.readLine().split("->");
			String[] dependentes = info[1].split(",");
			String nome = info[0].trim();
			Disciplina disciplinaAtual = buscaDisciplina(disciplinas, nome);
			
			for (String dependente: dependentes) {
				if (dependente.trim().equals("null")) {
					break;
				}
				
				Disciplina dependencia = buscaDisciplina(disciplinas, dependente.trim());
				if(dependencia != null){
					disciplinaAtual.addDependente(dependencia);
				}
					
				
			}
			
		}
		reader.close();
	}
}
