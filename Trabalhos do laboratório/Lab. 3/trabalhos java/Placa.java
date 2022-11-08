
    public class Placa
    {
        String placa;
        int tipo;

        Placa() {

            this.placa =  "tchau";
            this.tipo = 2;
            
        }

        Placa(String placa, int tipo){
            
            this.placa = placa;
            this.tipo = tipo;
        }

        String getTipoString(){

            /*if(this.tipo == 1){
                return "Normal";
            }else if(this.tipo == 2){
                return "Servico";
            } else if (this.tipo == 3) {
                return "Oficial";
            } else if (this.tipo == 4) {
                return "Auto Escola";
            } else if (this.tipo == 5) {
                return "Prototipo";
            } else if (this.tipo == 6) {
                return "Colecionador";
            }else{
                return "Outros";
            }*/

            String tipo;
            switch (this.tipo) {
                case 1:  tipo = "Normal";
                        break;
                case 2:  tipo = "Servico";
                        break;
                case 3:  tipo = "Oficial";
                        break;
                case 4:  tipo = "Auto Escola";
                        break;
                case 5:  tipo = "Prototipo";
                        break;
                case 6:  tipo = "Colecionador";
                        break;
                default :  tipo = "Outros";
                        break;
            }

            return tipo;
            
        }

        boolean temEstacionamentoLivre(){
            
            if(this.tipo ==  2 || this.tipo == 3){
                return true;
            }else{
                return false;
            }

        }

        String getDescricao(){

            return "Placa: placa="+this.placa+", tipo=" + getTipoString() +
            ", estacionamentoLivre="+ temEstacionamentoLivre() +".";

        }



    }