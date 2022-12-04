import java.util.ArrayList;
import java.util.Scanner;

public class OperacoesInteiros {
	
	static ArrayList<Integer> resetaVetor(){
		
		ArrayList<Integer> vetor = new ArrayList<Integer>();
		
		
		return vetor;
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> vetor = resetaVetor() ; //
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		
		
		while(num != -1) {
			vetor = resetaVetor() ;
			
			while(num != -1) {
				vetor.add(num);
				num = scan.nextInt();
			}
			
			System.out.printf("%d\n", vetor.size());
			
			int contP = 0;
			int contI = 0;
			
			for(int i = 0; i < vetor.size(); i++) {

				if(vetor.get(i) % 2 == 0) 
				{
				
					contP = contP + 1;
				
				}else {
					contI = contI + 1;
				}
				
			}
			

			
			
			System.out.printf("%d\n", contP);
			System.out.printf("%d\n", contI);
			
			int total = 0;
			for(int i = 0; i < vetor.size(); i++) {
				
				total = vetor.get(i) + total;

			}
			
			System.out.printf("%d\n", total);
			
			System.out.printf("%.2f\n", (double) total/vetor.size());
			
			int maior = 0;
			
			int auxMaior = vetor.get(0);
			for(int i = 1; i < vetor.size(); i++) {
				
				
				if(auxMaior > vetor.get(i)) {
					auxMaior = auxMaior;
				}else {
					auxMaior = vetor.get(i);
				}
				
				
			}
			
			int auxMenor = vetor.get(0);
			for(int i = 1; i < vetor.size(); i++) {
				
				
				if(auxMenor < vetor.get(i)) {
					auxMenor = auxMenor;
				}else {
					auxMenor = vetor.get(i);
				}
				
				
			}
			
			
			System.out.printf("%d\n", auxMaior);
			System.out.printf("%d\n", auxMenor);
			
			num = scan.nextInt();
		}
		
	} 

}
