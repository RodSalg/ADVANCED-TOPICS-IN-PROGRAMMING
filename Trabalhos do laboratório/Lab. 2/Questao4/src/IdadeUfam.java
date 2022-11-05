import java.util.Scanner;

public class IdadeUfam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int idadeUfam = scan.nextInt();
		
		idadeUfam = idadeUfam - 1909;
		
		System.out.printf("A UFAM tem %d anos de fundacao", idadeUfam);

	}

}
