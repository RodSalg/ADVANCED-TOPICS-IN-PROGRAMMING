import java.util.Scanner;

class FaltasTrabalho{
	
    public static void main(String[] args){
    	
        Scanner scan = new Scanner(System.in);
        
        int vet[] = new int[6];
        
        double soma=0;

        int aux = scan.nextInt();
        
        while(aux!=-1){
        	
            vet[aux-2]++;
            aux = scan.nextInt();
            
        }

        for(int i=0; i<6; i++) soma+=vet[i];
        for(int i=0; i<6; i++) System.out.printf("%.1f ", 100*((double)vet[i])/soma);


    }
    
}