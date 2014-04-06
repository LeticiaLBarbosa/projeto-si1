package models;

public class FactoryGrade {

	private static FactoryGrade instance;

	private FactoryGrade(){}

	public static FactoryGrade getInstance(){
		if(instance == null){
			instance = new FactoryGrade();
		}

		return instance;		
	}

	public Grade getGrade(String tipo){
		if(tipo.equals("comum")){
			return GradeMaisComum.getInstance();
		}else if(tipo.equals("nova")){
			return GradeNova.getInstance();
		}else{
			return GradeAtual.getInstance();
		}
	}

}
