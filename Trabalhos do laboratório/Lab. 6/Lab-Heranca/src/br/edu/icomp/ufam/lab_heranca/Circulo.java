package br.edu.icomp.ufam.lab_heranca;

public class Circulo extends FormaGeometrica {

	public double raio;
	
	public Circulo(){
		this.raio = 0;
	}
	
	public Circulo(int posX, int posY, double raio){
	
		super(posX, posY); //sempre o super antes;
		this.raio = raio;
		
	}
	
	public double getArea() {
		
		double total =  Math.PI * Math.pow(raio, 2);
		return (total);
		
	}
	
	public double getPerimetro() {
		double total = 2  * Math.PI * raio;
		return (total);
		
	}
	
	public String toString() {
		return "Círculo na " + getPosString() + 
							" com raio de " + raio + 
							"cm (área=" + getArea() +
							"cm2, perímetro=" + getPerimetro() + "cm)";
	}
	
}
