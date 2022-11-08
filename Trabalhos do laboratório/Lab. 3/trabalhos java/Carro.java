import carromain.Motor;
import carromain.Placa;
import carromain.Proprietario;

public class Carro {
        
        String marca;
        String modelo;
        Proprietario proprietario;
        Placa placa;
        Motor motor; 

        Carro(){
            this.marca = "bmw";
            this.modelo = "qualquer um";
            this.proprietario = new Proprietario();
            this.motor = new Motor();
            this.placa = new Placa();
        }

        Carro(String marca, String modelo, Proprietario proprietario, Placa placa, Motor motor){
            
            this.marca = marca;
            this.modelo = modelo;
            this.proprietario = proprietario;
            this.motor = motor;
            this.placa = placa;
            
        }

        String getDescricao(){

            return "Carro " +this.marca+"/"+this.modelo+"."+ proprietario.getDescricao() + placa.getDescricao() + 
            motor.getDescricao();

        }

    }
