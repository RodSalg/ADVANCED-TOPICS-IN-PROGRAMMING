import java.util.Scanner;

public class RaizDois {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner scan = new Scanner(System.in);
        double raizAproximacao = 0.0;
        int aux = scan.nextInt();
        
        double root = 1;
        int cont = 0;
        while( cont < aux) {
        	
        	root = 2 + (1/root);
        	raizAproximacao = 1 + (1/root);
        	System.out.printf("%.14f\n", raizAproximacao);
        	cont = cont + 1;
        }

	}

}
