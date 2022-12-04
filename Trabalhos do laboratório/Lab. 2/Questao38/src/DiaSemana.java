import java.util.Scanner;

public class DiaSemana {
	
    public static void main(String[] args) {
    	
    	int[] auxMaior = new int [7];
        Scanner scan = new Scanner(System.in);
        int[][] tabela = new int[50][7];

        int col = 0;
        
        int linha = 0;
        
        int entrada = scan.nextInt();
        
        while(entrada != -1 ){
        	
            if( col == 7 ){
            	col = 0;
                linha = linha + 1  ;
            }
            
            tabela[linha][col] = entrada;
            col = col + 1;
            
            
            entrada = scan.nextInt(); //lendo novamente
            
        }

      

        for( int j = 0; j < col; j++ ){
            for( int i = 0; i <= linha; i++){
                auxMaior[j] = auxMaior[j] + tabela[i][j];
            }
        }

        int semanaMaior = auxMaior[0];

        for( int i=1;i<7;i++ ){
            if( auxMaior[i] > semanaMaior ){
            	semanaMaior = auxMaior[i];
            }
        }

        for( int i = 0;i < 7; i++ ){
            if( auxMaior[i] == semanaMaior ){
                System.out.println(i+1);
            }
        }

    }
}
