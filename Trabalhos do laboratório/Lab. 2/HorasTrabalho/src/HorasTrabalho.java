import java.util.Scanner;

public class HorasTrabalho {
	
    public static void main(String[] args) {
    	
        Scanner scan = new Scanner(System.in);
        
        int numero = scan.nextInt();
        
        int total;
        
        
        while(numero!=-1){
        	
            total = numero;
            for(int i = 0; i < 6; i++) total = total + scan.nextInt();
            System.out.println(total);
            numero = scan.nextInt();
        
        }
        
    }
    
}