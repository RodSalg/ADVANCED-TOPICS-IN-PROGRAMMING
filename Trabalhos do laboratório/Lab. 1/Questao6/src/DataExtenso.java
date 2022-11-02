import java.util.Scanner;

public class DataExtenso {
	
	public static String MonthExtense(int month) {
		
		String monthExt = null;
		if(month == 01) {
			monthExt = new String("Janeiro");
		}else if(month == 02) {
			monthExt = new String("Fevereiro");
		}else if(month == 03) {
			monthExt = new String("Março");
		}else if(month == 04) {
			monthExt = new String("Abril");
		}else if(month == 05) {
			monthExt = new String("Maio");
		}else if(month == 06) {
			monthExt = new String("Junho");
		}else if(month == 07) {
			monthExt = new String("Julho");
		}else if(month == 8) {
			monthExt = new String("agosto");
		}else if(month == 9) {
			monthExt = new String("Setembro");
		}else if(month == 10) {
			monthExt = new String("Outubro");
		}else if(month == 11) {
			monthExt = new String("Novembro");
		}else if(month == 12) {
			monthExt = new String("Dezembro");
		}
		
		return monthExt;
		
	}

	public static void Extense() {
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		
		int day = number/1000000;
		int month = (number%1000000) / 10000;
		int year = (number%10000);

		
		
		System.out.printf("%d de %s de %d", day, MonthExtense(month), year);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Extense();
	}

}
