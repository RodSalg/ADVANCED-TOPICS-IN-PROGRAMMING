import java.util.Scanner;

public class AproximacaoPi {
	
	
    public static void main(String[] args){
       
    	Scanner scan = new Scanner(System.in);
        int nmr = scan.nextInt();
        
        double PI = 3;
        double saida = 0;
        int a = 2;
        int b = 3;
        int c = 4;

        if ( nmr == 1 ){
        	
            System.out.printf("%.6f\n", PI);
            
        }else if ( nmr >= 1){ 
        	
            System.out.printf("%.6f\n", PI);
            
            for( int i = 1; i < nmr; i++ ){
            	
                if( i % 2 != 0 ){
                	
                    saida = 4.0 /( a * b * c );
                    saida = saida + PI;
                    PI = saida;
                    System.out.printf("%.6f\n", saida);
                    
                }else{
                	
                    saida = 4.0 /( a * b * c );
                    saida= PI - saida;
                    PI = saida;
                    System.out.printf("%.6f\n", saida);
                }
                a = a + 2;
                b = b + 2;
                c = c + 2;
            }
        }

    }
}
