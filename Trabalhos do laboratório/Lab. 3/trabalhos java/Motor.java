    public class Motor {
        
        int tipo;
        double capacidade;
        int potencia;

        Motor(){
            this.tipo = 1;
            this.capacidade = 2.5;
            this.potencia = 3;
        }
        
        Motor(int tipo, double capacidade, int potencia){
            this.tipo = tipo;
            this.capacidade = capacidade;
            this.potencia = potencia;
        }

        String getTipoString(){

            String tipo;
            switch (this.tipo) {
                case 1:  tipo = "Gasolina";
                        break;
                case 2:  tipo = "Alcool";
                        break;
                case 3:  tipo = "Flex";
                        break;
                case 4:  tipo = "Diesel";
                        break;
                case 5:  tipo = "Eletrico";
                        break;
                default: tipo = "Outros";
                        break;
            }

            return tipo;

        }

        String getDescricao(){
            return "Motor: tipo="+getTipoString()+", capacidade="+this.capacidade+
            "L, potencia="+this.potencia+"CV.";
        }


    }//fim principal
