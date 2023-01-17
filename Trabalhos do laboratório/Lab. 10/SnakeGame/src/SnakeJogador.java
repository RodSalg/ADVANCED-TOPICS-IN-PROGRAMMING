import java.awt.Point;
import java.util.*;

/**
 * Classe de exemplo para a implementação de um Jogador para o Jogo Snake.
 * Nesta implementação, a próxima direção da cobra é escolhida aleatoriamente
 * entre as direções possíveis (que não geram colisões).
 * <p>
 * Use esta classe como base inicial para a sua solução do jogo. Basicamente
 * você precisará reimplementar o método {@code getDirecao}.
 * 
 * @author Horácio
 */

public class SnakeJogador {
    private Snake jogo;
    
    /**
     * Cria um novo jogador para o jogo passado como parâmetro.
     * @param jogo jogo snake.
     */
    public SnakeJogador(Snake jogo) {
        this.jogo = jogo;
    }
    public boolean vaiBater(Snake jogo, char lado) {
    	
    	LinkedList<Point> auxSegmentos;
    	Point auxCabeca = jogo.getSegmentos().getFirst();
    	Point auxPescoco = jogo.getSegmentos().get(1);
    	auxSegmentos = jogo.getSegmentos();
    	
    	for(int i = 0; i < jogo.getSegmentos().size(); i++) {
    		
    		if(lado == 'D') {
    			
        		if( auxCabeca.x + 1 == auxSegmentos.get(i).x && auxCabeca.y == auxSegmentos.get(i).y )  { //direita
        			if(i != 1) {

        				
            			System.out.println( (auxCabeca.x + 1) +"   "+ (auxSegmentos.get(i).x) );
            			System.out.println("vou morrer 1\n");
            			return true;
        			}
        			
        		}
        		
    		}
    		
    		if(lado == 'E') {
        		if( auxCabeca.x - 1 == auxSegmentos.get(i).x && auxCabeca.y == auxSegmentos.get(i).y ) { //esquerda
        			
        			if(i != 1) {

            			System.out.println( (auxCabeca.x - 1 ) +"   "+ (auxSegmentos.get(i).x) );
            			System.out.println("vou morrer 2\n");
            			return true;
        			}

        		}
    		}

    		if(lado == 'B') {
        		if( auxCabeca.x == auxSegmentos.get(i).x && auxCabeca.y + 1 == auxSegmentos.get(i).y ) { //desceu
        			
        			if(i != 1) {

    	    			System.out.println("vou morrer 3\n");
    	    			return true;
        			
        			}

        		} 
    		}

    		if(lado == 'C') {
        		if( auxCabeca.x == auxSegmentos.get(i).x && auxCabeca.y - 1 == auxSegmentos.get(i).y ) { //subiu
        			
        			if(i != 1) {

        			System.out.println("vou morrer 4\n");
        			return true;
        			
        			}

        		}
    		}
    		
    	}
    	
    	return false;
    }
    
    public char ondeNaoBate(Snake jogo) {
    	
    	
    	LinkedList<Point> auxSegmentos;
    	Point auxCabeca = jogo.getSegmentos().getFirst();
    	Point auxPescoco = jogo.getSegmentos().get(1);
    	auxSegmentos = jogo.getSegmentos();
    	System.out.println("atras de possibilidade");
    	
//    	if(lado == 'C') {
    		 if (jogo.isCelulaLivre(auxCabeca.x + 1, auxCabeca.y)) {
    			 return 'D'; // Cima
    		 }
//    	}
//    	if(lado == 'B') {

    		 else if (jogo.isCelulaLivre(auxCabeca.x, auxCabeca.y + 1)) {
            	return 'B';  // Baixo
            	
            }
//    	}
//    	if(lado == 'D') {
    		 else if (jogo.isCelulaLivre(auxCabeca.x - 1, auxCabeca.y)) { 
    			return 'E'; // Direita
    		}
//    	}
//    	if(lado == 'E') {
    		 else if (jogo.isCelulaLivre(auxCabeca.x, auxCabeca.y - 1)) {
            	return 'C';  // Esquerda
            }
//    	}
		
            
            
    	return 'N';
    }
    
    public char acao(Point cabeca, char possibilidade, Point auxComida) {
    	
        System.out.println("posicao cabeca ->" +cabeca.x + "  "+ cabeca.y);
        
        
        //caso x
        
        
        // caso 3: se for maior ele vai para baixo
        
        if(auxComida.y > cabeca.y) { //a comida esta mais abaixo da cabeca
        	
        	if (jogo.isCelulaLivre(cabeca.x, cabeca.y + 1)){ //dei um passo para a baixo
//        		System.out.println("estou livre para ir para a baixo");
        		possibilidade = 'B';
        	}       		
        	
        } 
        //caso 4: se for menor ele vai para cima
        
        if(auxComida.y > cabeca.y) { //a comida esta mais acima da cabeca
        	
        	if (jogo.isCelulaLivre(cabeca.x, cabeca.y - 1)){ //dei um passo para a cima
//        		System.out.println("estou livre para ir para a cima");
        		possibilidade = 'C';
        	}       		
        	
        }
        
        //caso 1: se for maior ele vai para a direita

        
        if(auxComida.x > cabeca.x) { //a comida esta mais a direita da cabeca
        	
        	//if(auxComida.x == cabeca.x) System.out.println("IGUALEI");
        	if (jogo.isCelulaLivre(cabeca.x + 1, cabeca.y)){ //dei um passo para a direita
//        		System.out.println("estou livre para ir para a direita");
        		possibilidade = 'D';
        	}       		
        	
        }
        
        //caso 2: se for menor ele vai para a esquerda
        
        
        if(auxComida.x < cabeca.x) { //a comida esta mais a esquerda da cabeca
        	
        	if (jogo.isCelulaLivre(cabeca.x - 1, cabeca.y)){ //dei um passo para a esquerda
//        		System.out.println("estou livre para ir para a esquerda");
        		possibilidade = 'E';
        	}       	
        	
        }
        
        //caso y

        
        //caso 5: caso ele fique perdido que é no momento em que ele ta com o x certo mas o y errado
        
        if(auxComida.x == cabeca.x && auxComida.y > cabeca.y) { //a comida esta mais acima da cabeca
        	
        	if (jogo.isCelulaLivre(cabeca.x, cabeca.y - 1)){ //dei um passo para a cima
        		System.out.println("CASO DE BAIXO ");
        		possibilidade = 'B';
        	}       		
        	
        } else if(auxComida.x == cabeca.x && auxComida.y < cabeca.y) { //a comida esta mais acima da cabeca
        	
        	if (jogo.isCelulaLivre(cabeca.x, cabeca.y + 1)){ //dei um passo para a cima
        		System.out.println("CASO DE CIMA ");
        		possibilidade = 'C';
        	}       		
        	
        }
        
        /////////////////////////////////////////////////////////////////////
        //casos alternativos
        /////////////////////////////////////////////////////////////////////
        
		if(auxComida.x > cabeca.x && auxComida.y > cabeca.y) { //a comida esta mais acima da cabeca
		        	
        	if (jogo.isCelulaLivre(cabeca.x, cabeca.y + 1)){ //dei um passo para a baixo
//        		System.out.println("estou livre para ir para a baixo");
        		possibilidade = 'B';
        	}else if (jogo.isCelulaLivre(cabeca.x + 1, cabeca.y)){ //dei um passo para a direita
//        		System.out.println("estou livre para ir para a direita");
        		possibilidade = 'D';
        	}   
		        	
		        
		}
		
		else if(auxComida.x < cabeca.x && auxComida.y < cabeca.y) { //a comida esta mais acima da cabeca
        	
        	if (jogo.isCelulaLivre(cabeca.x, cabeca.y - 1)){ //dei um passo para a baixo
//        		System.out.println("estou livre para ir para a baixo");
        		possibilidade = 'C';
        	}else if (jogo.isCelulaLivre(cabeca.x - 1, cabeca.y)){ //dei um passo para a direita
//        		System.out.println("estou livre para ir para a direita");
        		possibilidade = 'E';
        	}   
		        	
		        
		}else if(auxComida.x > cabeca.x && auxComida.y < cabeca.y) { //a comida esta mais acima da cabeca
        	
        	if (jogo.isCelulaLivre(cabeca.x, cabeca.y - 1)){ //dei um passo para a baixo
//        		System.out.println("estou livre para ir para a baixo");
        		possibilidade = 'C';
        	}else if (jogo.isCelulaLivre(cabeca.x + 1, cabeca.y)){ //dei um passo para a direita
//        		System.out.println("estou livre para ir para a direita");
        		possibilidade = 'D';
        	}   
		        	
		        
		}else if(auxComida.x < cabeca.x && auxComida.y > cabeca.y) { //a comida esta mais acima da cabeca
        	
			if (jogo.isCelulaLivre(cabeca.x + 1, cabeca.y)){ //dei um passo para a direita
//        		System.out.println("estou livre para ir para a direita");
        		possibilidade = 'D';  
        	}else if (jogo.isCelulaLivre(cabeca.x - 1, cabeca.y)){ //dei um passo para a direita
//        		System.out.println("estou livre para ir para a direita");
        		possibilidade = 'E';
        	}    
		        	
		        
		}
        
        
        
        if(possibilidade == 'N') {
        	
        	System.out.println("ESTOU PERDIDO ESTOU PERDIDO SOCORRO");

//        	possibilidade = ondeNaoBate(jogo, possibilidade);
        	possibilidade = 'C';
        	System.out.println("achei o " + possibilidade);
    
        }
        
        return possibilidade;
    	
    }

    /**
     * Executado pelo método {@link Snake#inicia()} a cada 'tick' do jogo para
     * perguntar qual a próxima direção da cobra ('C'ima, 'D'ireita, 'B'aixo,
     * 'E'squerda ou 'N'enhum).
     * 
     * @return a próxima direção da cobra.
     */
    public char getDirecao() {
        /*
         * IMPLEMENTE AQUI A SUA SOLUÇÃO PARA O JOGO
         */

    	
    	
    	
    	System.out.println("\n\n\n\nENTREI NOVAMENTE PARA ACHAR A POSICAO");
        Point cabeca = jogo.getSegmentos().getFirst();
        char possibilidade = 'N';
        
        Point auxComida = jogo.getComida();
        System.out.println( auxComida.x +" , " + auxComida.y);
        
        possibilidade = acao(cabeca, possibilidade, auxComida);
        
        //System.out.println(cabeca.x +  " e " + cabeca.y);
        int loop = 0;
        while( vaiBater(jogo, possibilidade)) {
        
//        	possibilidade = acao(cabeca, possibilidade, auxComida);
        	possibilidade = ondeNaoBate(jogo);
        	loop++;
        	
        	if(loop == 6) {
        		break;
        	}
        }	

       
		return possibilidade;
    

    }
    
}
