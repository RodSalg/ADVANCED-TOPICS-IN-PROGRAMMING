import java.util.Scanner;

public class NumeroNeperiano {
	
	public static double fatorial(int n) {
		double total = 1;
		for(int i = n; i > 0; i--) {
			total = total * i;
		}
		
		//System.out.printf("total: %f", total);
		return total;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int numero = scan.nextInt();
        //fatorial(numero);
        double total = 0;
        for(int i = 0; i < numero; i++) {
        
        	total = total + (1 / (fatorial(i)) );
        
        }
        
        System.out.printf("%f", total);
        
	}

}
