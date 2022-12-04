package br.edu.ufam.icomp.lab_encapsulamento;
import java.util.*;

public class GISMain {
    public static void main(String[] args) {
    	
        ArrayList<Localizavel> vetorLocalizaveis = new ArrayList<Localizavel> ();
        Localizavel localizaveis[] = new Localizavel[99]; //?
		Celular celularAux = new Celular(55, 72, 5323633);
		CarroLuxuoso carroAux = new CarroLuxuoso("KCT-666");
		
		vetorLocalizaveis.add(celularAux);
		vetorLocalizaveis.add(carroAux);

        for(int i = 0; i < vetorLocalizaveis.size(); i++) {
        	
        	System.out.println(vetorLocalizaveis.get(i).getPosicao());
	    }

    }
}
