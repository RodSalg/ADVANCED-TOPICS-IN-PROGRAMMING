public class Sala {

	int bloco;
	int sala;
	int capacidade;
	boolean acessivel;
	
	Sala(){
		
		this(0, 0, 0, true);
		
	}

	Sala(int bloco, int sala, int capacidade, boolean acessivel) {
		
		this.bloco = bloco;
		this.sala = sala;
		this.capacidade = capacidade;
		this.acessivel = acessivel;
		
	}
	
	String getAcessivel(boolean acessivel){
		
		if(acessivel) {
			return "acessível";
		}else {
			return "Não acessível";
		}
		
	}
	
	
	String getDescricao() {
		//Bloco 6, Sala 101 (50 lugares, acessível)
		return "Bloco"+this.bloco+", Sala"+this.sala+"("+this.capacidade+" lugares, "+ getAcessivel(acessivel)+")";
	}
	
	
}// fim da classe sala




