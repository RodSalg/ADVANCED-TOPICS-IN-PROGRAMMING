import java.util.Scanner;


class OperacoesString{ 
	
    public static boolean isVogal(char c){
        if(c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' ||  c=='u' || c=='U'){    
            return true;
        }    
        else{
            return false;
        }    
    }  
	
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String entrada = scan.nextLine(); int vogal=0;

        System.out.println(entrada.length());
        
        System.out.println(entrada.charAt(0));
        
        System.out.println(entrada.charAt(entrada.length()-1));
        
        System.out.println(entrada.toUpperCase());
        
        System.out.println(entrada.toLowerCase());
        
        System.out.println(entrada.replace('a','e'));
        
        for(int i=0; i<entrada.length(); i++) {
        	if(i%2==0) System.out.printf("%c", entrada.charAt(i));
        }
        
        for(int i=0; i<entrada.length(); i++) {
        	if(isVogal(entrada.charAt(i))) vogal++;
        }
        
        System.out.print("\n"+vogal);

    }

}


/*import java.util.Scanner;

public class OperacoesString {
    private static int vogais (String texto){
        int contarVogais = 0;
        
        texto.toLowerCase();
        
        for (int i = 0; i < texto.length(); i++){
            char c = texto.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                contarVogais++;
        }
        
        return contarVogais;
    }
    
    public static void imprimePar(String texto) {
		
		for (int i = 0; i < texto.length(); i++) {
		    if (i % 2 == 0) {
		        System.out.print(texto.charAt(i));
		    }
		}
		
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
		String texto =  scan.nextLine();
		int vogais = 0;
		
		System.out.printf("%d\n", texto.length() );
		System.out.printf("%s\n", texto.charAt(0) );
		System.out.printf("%s\n", texto.charAt(texto.length()-1) );
		System.out.printf("%s\n", texto.toUpperCase() );
		System.out.printf("%s\n", texto.toLowerCase() );
		String texto2 = texto;
		System.out.printf("%s\n", texto2.replace('a', 'e') );
		texto2 = texto;
		imprimePar(texto);
		vogais = vogais(texto);
		System.out.printf("\n%d", vogais );
		//Jebediah Kerman

	}

}*/
