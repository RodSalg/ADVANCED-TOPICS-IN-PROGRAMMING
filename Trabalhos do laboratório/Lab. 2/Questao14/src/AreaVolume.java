import java.util.Scanner;

public class AreaVolume {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		double raio = scan.nextDouble();
		
		double A = Math.PI * (raio * raio);
		double V = (4.0/3.0 ) * Math.PI * (raio * raio * raio);
		
		System.out.printf("Um circulo com raio de %.2f centimetros tem uma area de %.2f centimetros quadrados.\n", raio, A);
		System.out.printf("Uma esfera com raio de %.2f centimetros tem um volume de %.2f centimetros cubicos.\n", raio,  V);
	}

}
