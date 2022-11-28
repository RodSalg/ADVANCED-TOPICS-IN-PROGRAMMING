import java.util.ArrayList;
public class SessaoJedi {
    
    String nome;
    TreinadorJedi treinador;
    ArrayList<IniciadoJedi> iniciados = new ArrayList<IniciadoJedi>();;

    SessaoJedi(){
        this(null, null);
    }

    SessaoJedi(String nome, TreinadorJedi treinador){

        this.nome = nome;
        this.treinador = treinador;
        //this.iniciados = iniciados;

    }

    void addIniciado(IniciadoJedi iniciado){

        String aux = null;
        int flag = 0;
        for(int i = 0; i < this.iniciados.size(); i++ ){

            aux = this.iniciados.get(i).nome;
            if(   aux.equals(iniciado.nome)   ){ //comparando nome da posicao atual do vetor com o nome digitado pelo user
                flag = 1;
            }
        }

        if(flag == 0){
            this.iniciados.add(iniciado);

        }

    }


    IniciadoJedi getIniciado(String nome){

        String aux = null;
        for(int i = 0; i < this.iniciados.size(); i++ ){

            aux = this.iniciados.get(i).nome;
            
            if(   aux.equals(nome)   ){ //comparando nome da posicao atual do vetor com o nome digitado pelo user

                return iniciados.get(i);

            }

        }
        
        return null;
    }


    double getMediaAnoNascimento(){
        
        int total = 0;
        for(int i = 0; i < this.iniciados.size(); i++){

            total = total + this.iniciados.get(i).anoNascimento;

        }        

        return (total / this.iniciados.size());
    }

    String getDescricao(){

        String nome = "--> SESSÃO "+this.nome+" (Treinador: " + this.treinador.getDescricao() + ")\n";
        
        for ( int i = 0 ; i < this.iniciados.size(); i++ ){
        	
            nome+= "  - Iniciado "+ ( i + 1 ) +": "+ this.iniciados.get(i).getDescricao() +" \n";
        }

        return nome;
        
    } 

}



