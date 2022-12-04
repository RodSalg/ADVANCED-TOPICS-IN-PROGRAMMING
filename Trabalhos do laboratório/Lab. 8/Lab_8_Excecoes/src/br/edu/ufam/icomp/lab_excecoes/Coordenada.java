package br.edu.ufam.icomp.lab_excecoes;

public class Coordenada {
	
	private int posX;
	private int posY;
	private int digito;
	
	public Coordenada(int posX, int posY, int digito) throws CoordenadaNegativaException, CoordenadaForaDosLimitesException, DigitoInvalidoException{
		
        if ( posX < 0 || posY < 0 ) throw new CoordenadaNegativaException();

        if ( posX > 30000 || posY > 30000 ) throw new CoordenadaForaDosLimitesException();

        if ( ((posX+posY)%10) != digito) throw new DigitoInvalidoException();
		
		this.posX = posX;
		this.posY = posY;
		this.digito = digito;
		
	}
	
	public int getPosX() {
		
		return this.posX;
		
	}
	
	public int getPosY() {
		
		return this.posY;
		
	}
	
	public double distancia(Coordenada coordenada){

        //double s1 = Math.pow(coordenada.getPosX() - this.posX, 2);	
		//double s2 = Math.pow(coordenada.getPosY() - this.posY, 2);	
	
		double diferencaX = coordenada.getPosX() - this.posX;
		double diferencaY = coordenada.getPosY() - this.posY;
		double coordenadaAtual = diferencaX * diferencaX;
		double argumento = diferencaY * diferencaY;
		
		
		
		return Math.sqrt(coordenadaAtual + argumento);
    }
	
    public String toString(){
    	
    	String Texto = this.posX + ", " + this.posY;
        return Texto;
        
    }

}
