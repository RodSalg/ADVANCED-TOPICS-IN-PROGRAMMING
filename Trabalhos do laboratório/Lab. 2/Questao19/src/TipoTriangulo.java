import java.util.Scanner;

public class TipoTriangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		double a = scan.nextDouble();
		double b = scan.nextDouble();
		double c = scan.nextDouble();
		
		if( ( a <= 0 || b <= 0 || c <= 0 )          ||         (a + b <= c || a + c <= b || c + b <= a) )  {
			System.out.printf("invalido");
		}else if( a == b && b == c) {
			
			System.out.printf("equilatero");
			
		}else if((a == b && b != c) || (a == c && c != b) || ( b == c &&  c != a)) {
			System.out.printf("isosceles");
		}else if( a != b && b != a && c != a ) {
			System.out.printf("escaleno");
		}
		//double H = 90;

	}

}
