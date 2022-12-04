import java.util.Scanner;

public class DistanciaAviao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        Scanner scan = new Scanner(System.in);

        int tabelaAviao[][] =
    		{
    		{0,2,11,6,15,11,1},
    		{2,0,7,12,4,2,15},
    		{11,7,0,11,8,3,13},
    		{6,12,11,0,10,2,1},
    		{15,4,8,10,0,5,13},
    		{11,2,3,2,5,0,14},
    		{1,15,13,1,13,14,0}
    		};

        int soma = 0 ;

        int auxAviao = scan.nextInt();
        int auxAviao2 = 0;
        
        while(auxAviao!=-1){
            
        	auxAviao2 = scan.nextInt();
        	
            if(auxAviao2 == -1) break;


        
            soma = soma + tabelaAviao[((auxAviao/111)-1)][((auxAviao2/111)-1)];
            
            auxAviao = auxAviao2;
            
        }
            
     
        System.out.printf("%d",soma);
        
    }
}

/*            int linha =  ((auxAviao/111)-1);
            int coluna = ((auxAviao2/111)-1);
            soma = soma + tabelaAviao[linha][coluna];
            auxAviao = auxAviao2;*/


