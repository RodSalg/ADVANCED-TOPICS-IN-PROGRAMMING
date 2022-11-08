
    public class Proprietario {

        String nome;
        int cnh;
        int anoNascimento;

        Proprietario() {
            // this(nome: "Antonio", cnh: 123456, anoNascimento: 20 );
            this.nome = "Rodrigo Salgado";
            this.cnh = 666;
            this.anoNascimento = 2000;
        }

        Proprietario(String proprietario, int CNH, int AnoNascimento) {
            this.nome = proprietario;
            this.cnh = CNH;
            this.anoNascimento = AnoNascimento;
        }

        int getIdade(int anoReferencia) {

            return (anoReferencia - this.anoNascimento);
        }

        String getDescricao() {
            return "Proprietario: nome=" + this.nome + ", cnh=" + this.cnh
                    + ", anoNascimento=" + this.anoNascimento + ".";
        }

    }

    public class Motor {

        int tipo;
        double capacidade;
        int potencia;

        Motor() {
            this.tipo = 1;
            this.capacidade = 2.5;
            this.potencia = 3;
        }

        Motor(int tipo, double capacidade, int potencia) {
            this.tipo = tipo;
            this.capacidade = capacidade;
            this.potencia = potencia;
        }

        String getTipoString() {

            String tipo;
            switch (this.tipo) {
                case 1:
                    tipo = "Gasolina";
                    break;
                case 2:
                    tipo = "Alcool";
                    break;
                case 3:
                    tipo = "Flex";
                    break;
                case 4:
                    tipo = "Diesel";
                    break;
                case 5:
                    tipo = "Eletrico";
                    break;
                default:
                    tipo = "Outros";
                    break;
            }

            return tipo;

        }

        String getDescricao() {
            return "Motor: tipo=" + getTipoString() + ", capacidade=" + this.capacidade +
                    "L, potencia=" + this.potencia + "CV.";
        }

    }// fim principal

    public class Placa {
        String placa;
        int tipo;

        Placa() {

            this.placa = "tchau";
            this.tipo = 2;

        }

        Placa(String placa, int tipo) {

            this.placa = placa;
            this.tipo = tipo;
        }

        String getTipoString() {

            /*
             * if(this.tipo == 1){
             * return "Normal";
             * }else if(this.tipo == 2){
             * return "Servico";
             * } else if (this.tipo == 3) {
             * return "Oficial";
             * } else if (this.tipo == 4) {
             * return "Auto Escola";
             * } else if (this.tipo == 5) {
             * return "Prototipo";
             * } else if (this.tipo == 6) {
             * return "Colecionador";
             * }else{
             * return "Outros";
             * }
             */

            String tipo;
            switch (this.tipo) {
                case 1:
                    tipo = "Normal";
                    break;
                case 2:
                    tipo = "Servico";
                    break;
                case 3:
                    tipo = "Oficial";
                    break;
                case 4:
                    tipo = "Auto Escola";
                    break;
                case 5:
                    tipo = "Prototipo";
                    break;
                case 6:
                    tipo = "Colecionador";
                    break;
                default:
                    tipo = "Outros";
                    break;
            }

            return tipo;

        }

        boolean temEstacionamentoLivre() {

            if (this.tipo == 2 || this.tipo == 3) {
                return true;
            } else {
                return false;
            }

        }

        String getDescricao() {

            return "Placa: placa=" + this.placa + ", tipo=" + getTipoString() +
                    ", estacionamentoLivre=" + temEstacionamentoLivre() + ".";

        }

    }   


    public class Carro {

        String marca;
        String modelo;
        Proprietario proprietario;
        Placa placa;
        Motor motor;

        Carro() {
            this.marca = "bmw";
            this.modelo = "qualquer um";
            this.proprietario = new Proprietario();
            this.motor = new Motor();
            this.placa = new Placa();
        }

        Carro(String marca, String modelo, Proprietario proprietario, Placa placa, Motor motor) {

            this.marca = marca;
            this.modelo = modelo;
            this.proprietario = proprietario;
            this.motor = motor;
            this.placa = placa;

        }

        String getDescricao() {

            return "Carro " + this.marca + "/" + this.modelo + "." + proprietario.getDescricao() + placa.getDescricao()
                    + motor.getDescricao();

        }

    }
  
    public class CarroMain {   
        public static void main(String[] Args) {
            Proprietario proprietario = new Proprietario();
            Motor motor = new Motor();
            Placa placa = new placa();
            Carro carro = new carro();
        }
}
