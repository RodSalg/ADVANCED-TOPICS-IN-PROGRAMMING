/**
 * 
 */
package Acoes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import classeDeConexao.Conexao;

/**
 * Nesta classe, assim como em AcoesMedicos,
 * vamos ter acoes para cadastrar, excluir e atualizar os PACIENTES
 */
public class AcoesPacientes {
	
	private int id;
	private String nome;
	private int idade;
	private String tipoSanguineo;
	private String especialista;
	private int HorarioAtendimento;
	private String sintomas;
	
	
	
	/**
	 * Construtor da classe AcoesPacientes
	 * @param id_p - ip do paciente
	 */
	public AcoesPacientes(int id_p) {
		// TODO Auto-generated constructor stub
		this.id = id_p; //fazer conversao parseInt quando eu for utilizar
		
	}
	
	/**
	 * Construtor da classe AcoesPacientes
	 * @param nomeParametro - nome do paciente
	 * @param idadeParametro - idade do paciente
	 * @param tipoSanguineoP - tipo sanguineo do paciente
	 * @param horaAtendimentoP - horario que o paciente deseja ser atendido
	 * @param especialistaP - Especialidade que o paciente precisa
	 * @param sintomasP - sintomas dos pacientes
	 */
	public AcoesPacientes(String nomeParametro, int idadeParametro, String tipoSanguineoP, int horaAtendimentoP, String especialistaP, String sintomasP) {
		// TODO Auto-generated constructor stub
		this.nome = nomeParametro;
		this.idade = idadeParametro;
		this.tipoSanguineo = tipoSanguineoP;
		this.especialista =   especialistaP;
		this.HorarioAtendimento = horaAtendimentoP;
		this.sintomas = sintomasP;
		
		
	}
	
	/**
	 * Construtor da classe AcoesPacientes
	 * @param id_p - identificacao do paciente
	 * @param nomeParametro - nome do paciente
	 * @param idadeParametro - idade do paciente
	 * @param tipoSanguineoP - tipo sanguineo do paciente
	 * @param horaAtendimentoP - horario que o paciente deseja ser atendido
	 * @param especialistaP - Especialidade que o paciente precisa
	 * @param sintomasP - sintomas dos pacientes
	 */
	public AcoesPacientes(int id_p, String nomeParametro, int idadeParametro, String tipoSanguineoP, int horaAtendimentoP, String especialistaP, String sintomasP) {
		// TODO Auto-generated constructor stub
		this.id = id_p;
		this.nome = nomeParametro;
		this.idade = idadeParametro;
		this.tipoSanguineo = tipoSanguineoP;
		this.especialista =   especialistaP;
		this.HorarioAtendimento = horaAtendimentoP;
		this.sintomas = sintomasP;
		
	}
	
	/**
	 * Construtor da classe AcoesPacientes --> objeto desta é a para o medico atualizar os sintomas
	 * @param id_p - identificacao do paciente
	 * @param nomeParametro - nome do paciente
	 * @param sintomasP - sintomas dos pacientes
	 */
	public AcoesPacientes(int id_p, String nomeParametro, String sintomasP) {
		// TODO Auto-generated constructor stub
		this.id = id_p;
		this.nome = nomeParametro;
		this.sintomas = sintomasP;
		
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
	 * Cadastra um paciente
	 * @throws SQLException - eu uso para fazer  a conexao
	 * */

	public void salvar() throws SQLException //vou usar o objeto acao para salvar entao vou colocar somente o que eu for usar de paramentro aqui
	{
		
		Connection con = Conexao.fazConexao();
		int possoMarcarConsulta = 0;
		
		/*
		 * 
		 * fazer uma pesquisa se existe o mesmo tipo de medico e o horario que ele deseja marcar
		 * 
		 * */
		
		String sql = "select *from dados_medicos";

		String aux = null;
		PreparedStatement stmtProcura = con.prepareStatement(sql);
		PreparedStatement stmtProcuraHorarioEntrada = con.prepareStatement(sql);
		PreparedStatement stmtProcuraHorarioSaida = con.prepareStatement(sql);
//		stmtProcura.setString(1, especialista);
//		aux = stmtProcura.getst (1, especialista);
		
		ResultSet rs = stmtProcura.executeQuery();
		ResultSet rsHorarioEntrada = stmtProcuraHorarioEntrada.executeQuery();
		ResultSet rsHorarioSaida = stmtProcuraHorarioSaida.executeQuery();
		int stop = 0;
		while(rs.next())
		{
			aux = rs.getString("especialidade");
			
			if(aux.equals(especialista))
			{
//				JOptionPane.showMessageDialog(null, "Achamos um " + especialista + ", vamos confirmar o horario agora");
				possoMarcarConsulta = 1;
				while(rsHorarioEntrada.next() && rsHorarioSaida.next())
				{
					sql = "select *from dados_medicos";
					int a =  Integer.parseInt(rsHorarioEntrada.getString("horaEntrada"));
					int b = Integer.parseInt(rsHorarioSaida.getString("horaSaida"));
					
					if(HorarioAtendimento >= a && HorarioAtendimento < b  )
					{
						possoMarcarConsulta = 2;
						JOptionPane.showMessageDialog(null, "Temos um horário disponível, o usuário será cadastrado.");
						stop = 1;
						break;
					}
				}

				
				if(stop == 1)
				{
					break;
				}
//				JOptionPane.showMessageDialog(null, "O medico anterior não estava disponiível no horário que você indicou. Procurando outro " + especialista);
				
			}
		}
		
		
		
		if(possoMarcarConsulta == 2)
		{
			
			try {

				
				
				
				/*
				 * 
				 * Aqui tudo foi aprovado e irei fazer o cadastro
				 * 
				 * */
				
				String sqlCadastro = "insert into dados_pacientes(nome, idade, tipoSanguineo, especialista, horaAtendimento, sintomas) value (?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sqlCadastro);
				
				
				stmt.setString(1, nome);
				stmt.setLong(2, idade);
				stmt.setString(3, tipoSanguineo);
				stmt.setString(4, especialista);
				stmt.setLong(5, HorarioAtendimento);
				stmt.setString(6, sintomas);
				
				
				stmt.execute(); //so estou executando uma ação
				
				stmt.close(); //para caso outro usuario queira se cadastrar preciso fechar tudo 
				con.close();
				
				JOptionPane.showMessageDialog(null, "Consulta Marcada");
				/*
				 * Deletando o que já estava Escrito
				 * */
//				tfUsuario.setText("");
//				tfSenha.setText("");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(possoMarcarConsulta == 0)
		{
			JOptionPane.showMessageDialog(null, "Não há médico com a especialidade disponível no momento");
		}else
		{
			JOptionPane.showMessageDialog(null, "Não há horário disponível no momento");
		}
		
		
	
	}
	
	
	/**
	 * metodo que atualiza o cadastro do paciente
	 * */
	public void atualizar()
	{
		

		try {
			Connection con = Conexao.fazConexao();
			String sql = "update dados_pacientes set nome=?, idade=?, tipoSanguineo=?, especialista=?, horaAtendimento=?, sintomas=? where id=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(7, id);
			stmt.setString(1, nome);
			stmt.setLong(2, idade);
			stmt.setString(3, tipoSanguineo);
			stmt.setString(4, especialista);
			stmt.setLong(5, HorarioAtendimento);
			stmt.setString(6, sintomas);
			
			
			
			stmt.execute();
			
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "os dados do paciente foram atualizados com sucesso");
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	
	/**
	 *Metodo para atualizarmos apenas os sintomas e os nomes dos pacientes. Esse metodo eh acessado somente pelos medicos na area medica */
	public void atualizarAreaMedicos()
	{
		

		try {
			Connection con = Conexao.fazConexao();
			String sql = "update dados_pacientes set nome=?, sintomas=? where id=?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(3, id);
			stmt.setString(1, nome);
			stmt.setString(2, sintomas);
			
			
			
			stmt.execute();
			
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "os dados do paciente foram atualizados com sucesso");
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	/**
	 * usado para excluir algum paciente da minha tabela mySql
	 * */
	public void excluir()
	{
		try {
			Connection con;
			con = Conexao.fazConexao();
			
			String sql = "delete from dados_pacientes where id=?"; //função do SQL
			
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setLong(1, id);
			
			stmt.execute(); //se for consulta eu faço execute query
			
			stmt.close();
			con.close();
			
			JOptionPane.showMessageDialog(null, "Paciente Excluido do sistema");

			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}

	
	

	

}
