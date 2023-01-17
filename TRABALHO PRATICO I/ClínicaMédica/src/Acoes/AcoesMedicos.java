/**
 * 
 */
package Acoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeDeConexao.Conexao;

/**
 * 
 * Esta classe possui os metodos que sao acoes dentro da tela do usuario como:
 * salvar, atualizar dados da tabela, entre outros. E uma forma mais facil de criar um objeto
 * dessa classe e chamar a funcao ao inves de estar sempre escrevendo o mesmo codigo.
 * Basicamente vamos conectar ao banco de dados e fazer buscas, inserir elementos novos na tabela e excluir elementos.
 *
 */
public class AcoesMedicos {
	
	private int id;
	private String nome;
	private String especialidade;
	private int horarioEntrada;
	private int horarioSaida;
	
	/**
	 * Construtor da classe AcoesMedicos
	 * @param id_p - Identificacao na tabela Mysql
	 */
	public AcoesMedicos(int id_p) {
		
		this.id = id_p; //fazer conversao parseInt quando eu for utilizar
		
	}
	
	
	/**
	 * Construtor da classe AcoesMedicos
	 * @param nomeParametro - nome do medico
	 * @param especialidadeParametro - especialidade do medico
	 * @param horarioEntradaP - hora que o medico comeca a trabalhar na clinica
	 * @param horarioSaidaP - hora que o medico sai da clinica
	 * @param pacientesCadastradosP - Pacientes que ele vai atender ao longo do dia
	 */
	public AcoesMedicos(String nomeParametro, String especialidadeParametro, int horarioEntradaP, int horarioSaidaP) {
		this.nome = nomeParametro;
		this.especialidade = especialidadeParametro;
		this.horarioEntrada = horarioEntradaP;
		this.horarioSaida = horarioSaidaP;
//		this.pacientesCadastrados =  pacientesCadastradosP;
		
	}
	
	
	/**
	 * Construtor da classe AcoesMedicos
	 * @param id_p - Identificacao na tabela Mysql
	 * @param nomeParametro - nome do medico
	 * @param especialidadeParametro - especialidade do medico
	 * @param horarioEntradaP - hora que o medico comeca a trabalhar na clinica
	 * @param horarioSaidaP - hora que o medico sai da clinica
	 * @param pacientesCadastradosP - Pacientes que ele vai atender ao longo do dia
	 */
	public AcoesMedicos(int id_p, String nomeParametro, String especialidadeParametro, int horarioEntradaP, int horarioSaidaP) {
		
		this.id = id_p;
		this.nome = nomeParametro;
		this.especialidade = especialidadeParametro;
		this.horarioEntrada = horarioEntradaP;
		this.horarioSaida = horarioSaidaP;
//		this.pacientesCadastrados =  pacientesCadastradosP;
		
	}
	
//	public AcoesMedicos(int id_p, String nomeParametro, String especialidadeParametro, int horarioEntradaP, int horarioSaidaP, int pacientesCadastradosP, JTable tbDadosParametro) {
//		// TODO Auto-generated constructor stub
//		this.id = id_p;
//		this.nome = nomeParametro;
//		this.especialidade = especialidadeParametro;
//		this.horarioEntrada = horarioEntradaP;
//		this.horarioSaida = horarioSaidaP;
//		this.pacientesCadastrados =  pacientesCadastradosP;
//		this.tbDados = tbDadosParametro;
//		
//	}
	
	
	

	
	
 /**
  * 
  * Funcao feita para cadastrar um medico na minha tabela MySql
  * 
  * 
  * */
	public void salvar() //vou usar o objeto acao para salvar entao vou colocar somente o que eu for usar de paramentro aqui
	{
		//metodo salvar eu cadastro um usuario no banco de dados, mais precisamente um medico
		try {
			Connection con = Conexao.fazConexao();
			
			String sql = "insert into dados_medicos(nome, especialidade, horaEntrada, horaSaida) value (?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, nome);
			stmt.setString(2, especialidade);
			stmt.setLong(3, horarioEntrada);
			stmt.setLong(4, horarioSaida);
//			stmt.setLong(5, pacientesCadastrados);
			
			
			stmt.execute(); //so estou executando uma ação
			
			stmt.close(); //para caso outro usuario queira se cadastrar preciso fechar tudo 
			con.close();
			
			JOptionPane.showMessageDialog(null, "Médico Cadastrado");
			/**
			 * Deletando o que já estava Escrito
			 * */
//			tfUsuario.setText("");
//			tfSenha.setText("");
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Parece que você digitou o nome de um médico já cadastrado no sistema");
			e1.printStackTrace();
		}
		
	
	}
	
	
	/**
	 * Metodo que uso para atualizar alguns dos dados do medico que estao na tabela
	 * voce so precisa atualizar e enviar o que voce deseja atualizar
	 * 
	 * */
	public void atualizar()
	{
		

		try {
			Connection con = Conexao.fazConexao();
			String sql = "update dados_medicos set nome=?, especialidade=?, horaEntrada=?, horaSaida=? where id=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(5, id);
			stmt.setString(1, nome);
			stmt.setString(2, especialidade);
			stmt.setLong(3, horarioEntrada);
			stmt.setLong(4, horarioSaida);
//			stmt.setLong(5, pacientesCadastrados);
			
			
			
			stmt.execute();
			
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null,"Parece que você digitou o nome de um médico já cadastrado no sistema");
			e1.printStackTrace();
		}
		
	}
	
	
	/**
	 * exclui  um medico da tabela
	 * 
	 * */
	public void excluir()
	{
		try {
			Connection con;
			con = Conexao.fazConexao();
			
			String sql = "delete from dados_medicos where id=?"; //funcao do SQL
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1, id);
			
			stmt.execute(); //se for consulta eu faço execute query
			
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Medico Excluido");

			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
//	tentei fazer um objeto para preencher a tabela
//	public void preencherTabela()
//	{
//		
//		
//		try {
//			
//			Connection con = Conexao.fazConexao();
//			String sql = "Select *from dados_medicos";
//			
//			PreparedStatement stmt = con.prepareStatement(sql);
//			
//			ResultSet rs = stmt.executeQuery();
//			
//			DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
//			
//			modelo.setNumRows(0);
//			
//			while(rs.next())
//			{
//				modelo.addRow(new Object[] {
//						
//						rs.getString("nome"),
//						rs.getString("especialidade"),
//						rs.getString("horaEntrada"),
//						rs.getString("horaSaida"),
//						rs.getString("pacientesCadastrados")
//						
//				});
//			}
//			
//			rs.close();
//			con.close();
//			
//			
//			
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//	}
	
	
	

	

}
