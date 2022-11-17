public class IniciadoJedi{ 

    String nome;
    String especie;
    int anoNascimento;

    IniciadoJedi(){ //serve para inicializar as variáveis

        this(null, null, 0);

    }

    IniciadoJedi(String nome, String especie, int anoNascimento){

        this.anoNascimento = anoNascimento;
        this.especie = especie;
        this.nome = nome;
        
    }

    String getAnoNascimento(){
        
        //ha dois nascimentos: antes e depois da batalha de yarvim
        // ABY antes | DBY depois

        if(this.anoNascimento < 0){
            return -1 * this.anoNascimento+" ABY";
        }else{
            return this.anoNascimento+" DBY";
        }

    }

    String getDescricao(){ 

        return this.nome + " (especie="+this.especie+", nascimento="+getAnoNascimento()+")";

    }


}