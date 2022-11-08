import java.util.Calendar;

    public class Proprietario
    {

        String nome;
        int cnh;
        int anoNascimento;
        
        Proprietario(){
            //this(nome: "Antonio", cnh: 123456,  anoNascimento: 20 );
            this.nome = "Rodrigo Salgado";
            this.cnh = 666;
            this.anoNascimento = 2000;
        }

        Proprietario(String proprietario, int CNH, int AnoNascimento){
            this.nome = proprietario;
            this.cnh = CNH;
            this.anoNascimento = AnoNascimento;
        }

        int getIdade (int anoReferencia){

            return(anoReferencia - this.anoNascimento);
        }

        String getDescricao(){
            return "Proprietario: nome="+this.nome + ", cnh="+this.cnh 
                                + ", anoNascimento="+this.anoNascimento+".";
        }

        

    }