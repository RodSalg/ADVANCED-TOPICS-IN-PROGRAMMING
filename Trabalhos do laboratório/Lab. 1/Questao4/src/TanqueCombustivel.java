import java.util.Scanner;

public class TanqueCombustivel {
	
	public static double SphereVolume(double r) {
		double total;
		double a = (4);
		double b = Math.PI;
		double c = (r*r*r);
		total = (4 * b* c)/3;
		//System.out.printf("%.4f", total);
		return total;
	}
	
	public static double sphericalCapVol(double r, double x) {
		double total2;
		double a = (Math.PI/3);
		double b = (x*x);
		double c = (3*r - x);
		
		total2 = a * b * c;
		
		return total2;
	}
	
	public static double airVol(double r, double x) {
		
		double total3 = (SphereVolume(r) - sphericalCapVol(r, x));
		
		
		return total3;
	}
	
	public static void program (){
		Scanner scan = new Scanner(System.in);
		
		double r = scan.nextDouble();
		double x = scan.nextDouble();
		int choice = scan.nextInt();
		
		if(choice == 1) {
			//SphereVolume(r);
			System.out.printf("%.4f", sphericalCapVol(r, x) ); //ok
		}else if(choice == 2){
			
			System.out.printf("%.4f", airVol(r, x));
			
		}

		//System.out.printf("\n volume do combustivel: %f", fim);		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		program();

	}

}
