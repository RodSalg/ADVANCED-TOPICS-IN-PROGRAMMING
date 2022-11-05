import java.util.Scanner;

public class MediaColecoes {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double number = 0.0;
		double cont = -1.0;
		double sum = 0.0;
		Scanner scan = new Scanner(System.in);
		
		
		while(number != -1) {
			
			while(number != -1) {
				sum = sum + number;
				cont = cont + 1;
				number = scan.nextDouble();
				//System.out.printf("contador: %.2f\n", cont);
			}
			System.out.printf("%.2f", sum/cont);
			sum = 0;
			cont = 0;
			number = scan.nextDouble();
		}
		
	
	}
	
}
