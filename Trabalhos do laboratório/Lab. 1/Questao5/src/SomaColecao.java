import java.util.Scanner;

public class SomaColecao {
	
	public static void collection() {
		int number;
		int sum = 0;
		Scanner scan = new Scanner(System.in);
		number = scan.nextInt();
		
		while(number != -1) {
			sum = sum + number;
			number = scan.nextInt();
		}
		
		System.out.printf("%d", sum);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		collection();

	}

}
