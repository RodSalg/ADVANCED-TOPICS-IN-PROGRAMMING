import java.util.ArrayList;
import java.util.Scanner;

public class TimeFutebol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int vitorias = 0;
        int derrotas = 0;
        int empates = 0;
        int numero = scan.nextInt();
        
        ArrayList<Integer> vet1 = new ArrayList<Integer>();
        ArrayList<Integer> vet2 = new ArrayList<Integer>();
        
        
        vet1.add(numero);
        while ( numero != -1 ){
            numero = scan.nextInt();
            vet1.add(numero);
        }
        
        
        numero = scan.nextInt();
        while ( numero != -1 ){
            vet2.add(numero);
            numero = scan.nextInt();
        }
        
        for(int i = 0; i < (vet1.size() -1 ); i++) {
        	
        	if(     (vet1.get(i)) > (vet2.get(i))      ) {
        		vitorias = vitorias + 1;
        		//System.out.printf("caso 1: %d e %d\n", (vet1.get(i)), (vet2.get(i)));
        		//System.out.println("ganhei no " + i);
        	}else if( (vet1.get(i)) < (vet2.get(i))   ) {
        		derrotas = derrotas + 1;
        		//System.out.printf("caso 2: %d e %d\n", (vet1.get(i)), (vet2.get(i)));
        		//System.out.println("perdi no " + i);
        	}else if((vet1.get(i)) == (vet2.get(i))) {
        		//System.out.printf("caso 3: %d e %d\n", (vet1.get(i)), (vet2.get(i)));
        		//System.out.println("empatei no " + i);
        		empates= empates + 1;
        	}
        	
        }
        
        
        System.out.printf("%d %d %d", vitorias,empates, derrotas);

	}

}
