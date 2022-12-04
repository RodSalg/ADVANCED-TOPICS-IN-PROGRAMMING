package br.edu.icomp.ufam.lab_heranca;

public class Retangulo extends FormaGeometrica {
	
	public double largura;
	public double altura;
	
	
	public Retangulo(int posX, int posY, double largura, double altura) {
		
		super(posX, posY);
		this.altura = altura;
		this.largura = largura;
		
	}
	
	public double getArea() {
		
		return (largura * altura);
	}
	
	public double getPerimetro() {
		double total = largura + altura;
		return (2 * total );
	}
	
	public String toString() {
		
        return "Retângulo na " + getPosString() +
                " com largura de " + largura +
                "cm e altura de " + altura +
                "cm (área=" + getArea() +
                "cm2, perímetro=" + getPerimetro() + "cm)";
    }

}
