package br.edu.ufam.icomp.lab_excecoes;

public class RoverException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RoverException() {
		
		this("Exceção geral do Rover");
		
	}

    public RoverException(String message){
    	
        super(message);
    }
    
    
	
	

}
