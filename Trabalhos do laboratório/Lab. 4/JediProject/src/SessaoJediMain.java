public class SessaoJediMain{

    public static void main(String[] args){

        IniciadoJedi jedi = new IniciadoJedi(); //criando objeto
        
        TreinadorJedi treinador = new TreinadorJedi(); // objeto treinador

        SessaoJedi sessao = new SessaoJedi("Instruções de Uso da Força", treinador);

        sessao.addIniciado(jedi);
        
        sessao.getDescricao();
    } 



}

/*        IniciadoJedi jedi = new IniciadoJedi(); //criando objeto
        
        TreinadorJedi treinador = new TreinadorJedi(); // objeto treinador

        SessaoJedi sessao = new SessaoJedi("Instruções de Uso da Força", treinador);

        sessao.addIniciado(jedi);
        
        sessao.getDescricao();  */