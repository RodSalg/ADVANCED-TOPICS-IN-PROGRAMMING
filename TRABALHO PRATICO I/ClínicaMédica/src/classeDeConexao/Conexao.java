package classeDeConexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * o Objetivo dessa classe eh conectar com o banco de dados MySQL
 * 
 * */
public class Conexao {
	
	
	  private static String url = "jdbc:mysql://localhost:3306/db_clinica";
	  private static String user = "root";
	  private static String pass = "5689";
	  protected static Connection conexao = null;

	//private String caminho = "jdbc:mysql://localhos/db_senhas";
	//private String user = "root";
	//private String password = "5689";
	
	//faz a conexao do banco de dados
	  
	/**
	 * responsavel pela conexao com o banco de dados. Metodo que eu posso sempre logar e fazer essa conexao
	 * @throws SQLException - exception para o banco de dados MySQL
	 * @return DriverManager.getConnection(url, user, pass)
	 *  */
	public static Connection fazConexao() throws SQLException {
		
		/**
		 * destinada a fazer a conexao com o banco de dados
		 * */
		
		//Class.forName("com.mysql.jdbc.Driver");
		//caminho do banco de dados, usuario e senha
		return DriverManager.getConnection(url, user, pass);
		
		
	}

}
