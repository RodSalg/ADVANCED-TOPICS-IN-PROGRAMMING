package br.edu.ufam.icomp.lab_excecoes;

public class Caminho {
	
	private Coordenada[] caminho;
	private int tamanho;
	private int contador;
	
	public Caminho(int maxTam) {
		
        this.tamanho = maxTam;
        this.caminho = new Coordenada[maxTam];
        this.contador = 0; //vai nos ajudar depois
        
        
	}
	
	public void addCoordenada(Coordenada coordenada) throws TamanhoMaximoExcedidoException, DistanciaEntrePontosExcedidaException{
		
        if ( this.caminho.length == this.contador ) {
        	throw new TamanhoMaximoExcedidoException();
        }
        
        if( contador > 0 ){
            if( this.caminho[contador - 1].distancia(coordenada) > 15 ) {
            	throw new DistanciaEntrePontosExcedidaException();
            }
        }

        this.caminho[this.contador] = coordenada;
        this.contador = contador + 1;
		
	}
	
	public int tamanho() {
		
		return this.contador;
	}
	
	public void reset() {
		
    	for( int i = 0; i < this.caminho.length ; i++ ) {
    		
    		this.caminho[i] = null;
    	
    	}
		
	}
	
    public String toString(){
    	
        String Texto = "Dados do caminho:\n  - Quantidade de pontos: "+this.tamanho()+"\n  - Pontos:\n";
        
        for( int i = 0; i < this.contador; i++){
        	
        	Texto = Texto + "    ->" + this.caminho[i].toString()+"\n";
        }
        
        return Texto;
    }

}
