package br.edu.ufam.icomp.lab_excecoes;

import java.util.Random;

public class RoverMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random aleatorio = new Random();
		Caminho caminhoVet = new Caminho(6);
		
		int posX = 0;
		int posY = 0;
		int digito = 0;
		int tamCaminho = 0;
		int cont =0;	
		while ( cont < 5 ) { //o tamanho no caso
			
			posX = aleatorio.nextInt(52);
			posY = aleatorio.nextInt(63);
			digito = aleatorio.nextInt(10);
			tamCaminho = caminhoVet.tamanho();
			
			try {
				Coordenada c1 = new Coordenada(posX,posY,digito);
				caminhoVet.addCoordenada(c1);
			}
			catch(CoordenadaNegativaException err) {	
				System.out.println(err.getMessage());
			}
			catch(CoordenadaForaDosLimitesException err){
				System.out.println(err.getMessage());
			}
			catch( DigitoInvalidoException err ){
				System.out.println(err.getMessage());
			}
			catch( DistanciaEntrePontosExcedidaException err){
				System.out.println(err.getMessage());
			}
			catch( TamanhoMaximoExcedidoException err ){
				System.out.println(err.getMessage());
			}
			if( caminhoVet.tamanho() == tamCaminho + 1 ) {
				cont = cont + 1;
			}
		}
		
		
		System.out.println(caminhoVet.toString());

	}

}
