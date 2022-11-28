import java.util.ArrayList;

public class Turma {

	
	String nome;
	String professor;
	int numAlunos;
	boolean acessivel;
	ArrayList<Integer> horarios = new ArrayList<Integer>();	
	ArrayList<String> semana = new ArrayList<String>();
	ArrayList<Integer> tempo = new ArrayList<Integer>();

	
	Turma(){
		this(null, null, 0, true);
	}


	Turma(String nome, String professor, int numAlunos, boolean acessivel){
		
		this.nome = nome;
		this.professor = professor;
		this.numAlunos = numAlunos;
		this.acessivel = acessivel;
		
	}

	void addHorario(int horario) {
		
		horarios.add(horario);
		
	}
	
	String getHorariosString() {
		
		int indicePrimitivo;
		int indLinha = -1; 
		int indColuna = -1;
		String horaTotal ="";
		
		semana.add("segunda");
		semana.add("terça");
		semana.add("quarta");
		semana.add("quinta");
		semana.add("sexta");
		
		tempo.add(8);
		tempo.add(10);
		tempo.add(12);
		tempo.add(14);
		tempo.add(16);
		tempo.add(18);
		tempo.add(20);
		
		for(int i = 0; i < this.horarios.size(); i++) {
			
			indicePrimitivo = this.horarios.get(i) - 1;
			
			indLinha = indicePrimitivo % 7;  //horario
			indColuna = indicePrimitivo / 7; // dia da semana
			
            if( i ==  (this.horarios.size()) - 1 ){
                horaTotal += this.semana.get(indColuna)+" "+this.tempo.get(indLinha)+"hs";
            
            }else{
            	horaTotal += this.semana.get(indColuna)+" "+this.tempo.get(indLinha)+"hs, ";
            
            }   		
			
		}
				
		return horaTotal;
	}
	
	String getAcessivel() {
		
		
        if (this.acessivel){
            return "sim\n";
        }else{
            return "não\n";
        }
		
	}
	
	
	String getDescricao(){
	
		String descricao = 
				
				"Turma: "+ this.nome +
		        "\nProfessor: " + this.professor +
		        "\nNúmero de Alunos: " + this.numAlunos +
		        "\n"+"Horário: " + this.getHorariosString() +
		        "\n" + "Acessível: ";
				
				descricao = descricao + getAcessivel();


		        return descricao;
		        
	}
		
	
/*	public static void main(String args[]) {
	

			
		Turma t1 = new Turma("Sistemas Operacionais", "Andrew S. Tanenbaum", 65, true);
		t1.addHorario(5);
		t1.addHorario(19);
		t1.addHorario(33);
		System.out.println(t1.getDescricao());


		
			
		
	}*/
	
	
} //fim da classe turma
