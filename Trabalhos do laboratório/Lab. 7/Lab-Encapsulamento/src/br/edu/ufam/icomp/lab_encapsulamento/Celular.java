package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.*;

public class Celular implements Localizavel {
	
	private int codPais;
	private int codArea;
	private int numero;
	
	public Celular(int codPais, int codArea, int numero){
		
				
		this.codPais = codPais;
		this.codArea = codArea;
		this.numero = numero;
		
		if(!(codPais >= 1 && codPais <= 1999)) {
			this.codPais = -1;
		}
		
		if(!(codArea >= 10 && codArea <= 99)) {
			this.codArea = -1;
		}
		
		if(!(numero >= 10000000 && numero <= 999999999)) {
			this.numero = -1;
		}
		
	}
	
	public final void setCodPais(int codPais) {
		
		this.codPais = codPais;
	}
	
	public int getCodPais(){
		
		return this.codPais;
		
	}
	
	public final void setCodArea(int codArea) {
		
		this.codArea = codArea;
		
	}
	
	public int getCodArea() {
		
		return this.codArea;
		
	}
	
	public final void setNumero(int numero) {
	
		this.numero = numero;
		
	}
	
	public int getNumero() {
		
		return this.numero;
		
	}
	
	
	public Posicao getPosicao() {
		
		Random r = new Random();
		
		double latitude =  -3.160000 + (-2.960000 - (-3.16000)) * r.nextDouble();
		double longitude =  -60.120000 + (-59.820000 - (-60.120000)) * r.nextDouble();
		double altitude =  15.0 + (100.0 - 15.0) * r.nextDouble();
	
		
		return new Posicao(latitude, longitude, altitude	);
	}
	
	public double getErroLocalizacao() {

		return 50.0;
	}
	

	
}
