import java.util.Scanner;

public class CaixaEletronico {
	
	public static int validation (int value) {
		int flag = -1;
	
		if( ((value % 2) == 0) && value >= 0  ) {
			
			flag = 1;
			
		}else {
			flag = 0;
		}
		
		return flag;
		
	}
	
	
	public static void MoneyCounter(int value) {
		// here we can consider it's valid
		
		int hun = (value / 50);
		value = value - (hun * 50);
		int ten = (value / 10);
		value = value - (ten * 10);
		int two = (value / 2);
		
		System.out.printf("%d notas de R$50, %d notas de R$10 e %d notas de R$2", hun, ten, two);
		
	}
	
	
	public static void PrintMoney () {
		Scanner scan = new Scanner(System.in);
		
		int value = scan.nextInt();
		
		if( (validation(value)) == 1 ) {
			//means it's valid 
			
			MoneyCounter(value);
			
			
		}else {
			System.out.printf("Valor Invalido");
		}
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrintMoney();
		

	}

}
