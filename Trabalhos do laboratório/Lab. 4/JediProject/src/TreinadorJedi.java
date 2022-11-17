public class TreinadorJedi {
    
    String titulacao;
    String nome;

    TreinadorJedi(){

        this(null, null);

    }

    TreinadorJedi(String titulacao, String nome){
        this.nome = nome;
        this.titulacao = titulacao;
    }

    String getDescricao(){

        return this.titulacao +" " + this.nome;

    }
}
