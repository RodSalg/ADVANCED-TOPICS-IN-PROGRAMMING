import java.util.Hashtable;
import java.util.LinkedList;

public class ListaInvertida {
	
	
	private Hashtable<String, LinkedList<String>> tabela;
	
	public ListaInvertida() {
		// TODO Auto-generated constructor stub
		this.tabela = new Hashtable<String, LinkedList<String>>();
	}
	
	public boolean insere(String palavra, String documento){
		
		if (tabela.get(palavra) != null  ) {
			if(tabela.get(palavra).contains(documento)) {
				return false;
			}else {
				tabela.get(palavra).add(documento);
				return true;
			}
		}else {
			LinkedList<String> auxDocumento =  new LinkedList<String>();
			auxDocumento.add(documento);
			tabela.put(palavra, auxDocumento);
			
			return true;
		}
				
	}
	
	public LinkedList<String> busca(String palavra){
		
		return tabela.get(palavra);	
		
	}
	
	public String toString() {
		
		return tabela.toString();

	}

}
