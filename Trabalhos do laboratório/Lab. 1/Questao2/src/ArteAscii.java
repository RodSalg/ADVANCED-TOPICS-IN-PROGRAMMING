import java.util.Iterator;
import java.util.Scanner;

public class ArteAscii {
	
	public static void repeat(int tam) {
		
		do {
			System.out.printf("*");
			tam--;
		}while(tam > 0);
		System.out.printf("\n");
		
	}
	
	public static void program() {
		
		Scanner scan = new Scanner(System.in);
		
		int tam = scan.nextInt();
		for (int i = tam; i > 0; i--) {
			repeat(i);
		}
		for (int i = 1; i <= tam; i++) {
			repeat(i);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		program();			
	}

}