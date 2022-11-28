import java.util.ArrayList;

public class Ensalamento {

	ArrayList<Sala> salas = new ArrayList<Sala>(); 
	ArrayList<Turma> turmas = new ArrayList<Turma>();
	ArrayList<TurmaEmSala> ensalamento = new ArrayList<TurmaEmSala>();
	
	Ensalamento(){
	
	}
	
	void addSala(Sala sala) {
		salas.add(sala);
	}
	
	void addTurma(Turma turma) {
		turmas.add(turma);
	}
	
	Sala getSala(Turma turma) {
		
		TurmaEmSala turmaBuscada = null;
		
		for(int i = 0; i < this.ensalamento.size(); i++) {
			
			turmaBuscada = this.ensalamento.get(i);
			if(turmaBuscada.turma == turma) {
				
				return turmaBuscada.sala;
			}	
			
		}
		
		return null;
	}
	
	
	boolean salaDisponivel(Sala sala, int horario) {
		
		TurmaEmSala ensalaAux;
		
		for(int i = 0; i < this.ensalamento.size(); i++ ) {
			
			ensalaAux = this.ensalamento.get(i);
			
			if(ensalaAux.sala == sala) {
				
				
				
				for(int j = 0; j < ensalaAux.turma.horarios.size(); j++) {
					
					if(ensalaAux.turma.horarios.get(j) == horario) {
						return false; //nao disponivel
					
					}		
				}
				
			} //condicao
			
		} //for principal
		
		return true;
	}
	
	
	boolean salaDisponivel(Sala sala, ArrayList<Integer> horarios) { //o problema do código está aqui 
		
		//boolean temSala = true;
		
		for(int i = 0; i < horarios.size(); i++) {
			
			boolean auxBool = salaDisponivel(sala, horarios.get(i));
			
			if(  auxBool == false ) {
				return false;
			}
		}
		
		return true;

	}
	
    public boolean alocar(Turma turma, Sala sala) {
        TurmaEmSala turmaEmSala = new TurmaEmSala(turma, sala);
        if (((turma.acessivel == sala.acessivel) || (sala.acessivel)) && (turma.numAlunos <= sala.capacidade) && (salaDisponivel(sala, turma.horarios))){
            this.ensalamento.add(turmaEmSala);
            
            return true;
        }
        return false;
    }

    public void alocarTodas() {
        for (Turma turma : turmas) {
            for (Sala sala : salas) {
                if (alocar(turma, sala)) { break; }
            }
        }
    }
	
    int getTotalTurmasAlocadas(){
        return (this.ensalamento.size());
    }
    
    ////
    int getTotalEspacoLivre(){
    	
    	int cont = 0;
    	TurmaEmSala turmaAux = null;
    	
    	for(int i = 0; i < this.ensalamento.size(); i++) {
    		turmaAux = this.ensalamento.get(i);
    		int capacidade = turmaAux.sala.capacidade;
    		int totalAlunos = turmaAux.turma.numAlunos;
    		
            cont = cont + ( capacidade - totalAlunos);
    	}
    	
    	return cont;
    	

    }
    
    
    
    
    String relatorioResumoEnsalamento(){
    	
        String textoColab = "Total de Salas: " +  this.salas.size() + "\n"
        +"Total de Turmas: " + this.turmas.size() + "\n"
        +"Turmas Alocadas: " + this.getTotalTurmasAlocadas() + "\n"
        +"Espaços Livres: " + this.getTotalEspacoLivre() + "\n";

        return textoColab;
    }

    String relatorioTurmasPorSala(){
        String textoColab = this.relatorioResumoEnsalamento()+"\n";
        
        

        for( int i = 0 ; i < this.salas.size() ;i++ ){
        	Sala salaAux = null;
        	salaAux = this.salas.get(i);
        	
            textoColab = textoColab + "--- " + salaAux.getDescricao() + " ---\n";
            
            
            for(int j = 0 ; j < this.ensalamento.size() ; j++) {
            	TurmaEmSala EnsalaAux = null;
            	EnsalaAux = this.ensalamento.get(j);
            	
                if ( EnsalaAux.sala == salaAux ){
                
                	textoColab = textoColab + EnsalaAux.turma.getDescricao();
                }
                
            }
            
            
        }

        return textoColab;
    }

    String relatorioSalasPorTurma(){
    	
        String textoColab = this.relatorioResumoEnsalamento() + "\n";
        
        Sala salaAux = null;
        Turma turmaAux = null; //auxiliar
        

        for(int i = 0 ; i < this.turmas.size(); i++ ){ //percorrer as uturmas para resumir cada uma
        	turmaAux = this.turmas.get(i);
            textoColab = textoColab + turmaAux.getDescricao();
            salaAux = this.getSala(turmaAux);
            
            if ( salaAux != null ){
            	textoColab = textoColab + "Sala: "+salaAux.getDescricao()+"\n";
            }else{
            	textoColab = textoColab + "Sala: SEM SALA\n";
            }
            
            salaAux = null;
        }

        return textoColab;
    }
	
	
	
	
	
	
}
