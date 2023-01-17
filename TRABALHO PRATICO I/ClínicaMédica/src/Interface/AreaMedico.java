package Interface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Acoes.AcoesPacientes;
import classeDeConexao.Conexao;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * Area Medico: Aqui eh a area onde o medico vai conseguir acessar todos os seus pacientes, ver seu relatorio e alterar os sintomas que ele esta sentindo.
 * 
 *
 * */
public class AreaMedico extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  Painel onde temos a area medico inteiro 
	 *  
	 *  */
	private JPanel contentPane; 
	/**
	 * tabela com os meus dados sobre os pacientes
	 */
	private JTable tbDados;
	/**
	 * botao utilizado para atualizar a tabela
	 * */
	private JButton btnAtualizarLista;
	/**
	 * botao para fechar a lista e voltar para a aba de cadastro
	 * 
	 * */
	private JButton btnFecharLista;
	/**
	 * novo painel
	 */
	private JPanel panel;
	
	/**
	 * botao para buscar o paicente
	 * */
	private JButton btnBuscar; 

	/**
	 * Campo para escrever o nome que esta sendo procurado
	 */
	private JTextField tfNomeBuscado;
	
	/**
	 * botao para buscar o paciente
	 * */
	private JButton btnExcluir;
	/**
	 * botao para atualizar o paciente
	 * */
	private JButton btnAtualizar;
	/**
	 * Campo para escrever sobre sintomas
	 */
	private JTextField tfSintomas;
	/**
	 * Campo para escrever nome
	 */
	private JTextField tfNome;
	/**
	 * texto lista de pacientes
	 */
	private JLabel lblListaDePacientes;
	/**
	 * texto alterar cadastro
	 */
	private JLabel lblAlterarCadastro;
	/**
	 * texto escrito nome
	 * */
	private JLabel lblNome;
	/**
	 * texto escrito sintomas
	 * */
	private JLabel lblSintomas;
	/**
	 * campo para pegarmos o ID
	 * */
	private JTextField tfId;
	/**
	 * 
	 */
	/**
	 * Area Medico: Aqui eh a area onde o medico vai conseguir acessar todos os seus pacientes, ver seu relatorio e alterar os sintomas que ele esta sentindo.
	 * @param args - meu args do main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaMedico frame = new AreaMedico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AreaMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 663, 258);
		contentPane.add(scrollPane);
		
		tbDados = new JTable();
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome", "Idade", "Tipo Sanguineo", "Especialista", "Horar de atendimento", "Sintomas"
			}
		));
		tbDados.getColumnModel().getColumn(0).setPreferredWidth(100);
		tbDados.getColumnModel().getColumn(1).setPreferredWidth(80);
		tbDados.getColumnModel().getColumn(2).setPreferredWidth(86);
		tbDados.getColumnModel().getColumn(4).setPreferredWidth(118);
		scrollPane.setViewportView(tbDados);
		
		btnAtualizarLista = new JButton("Atualizar Lista");
		btnAtualizarLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
//				AcoesMedicos ac = new AcoesMedicos(Integer.parseInt(tfId.getText()) ,tfNome.getText(), tfEspecialidade.getText(), Integer.parseInt(tfHorarioEntrada.getText()),
//						Integer.parseInt(tfHorarioSaida.getText()), Integer.parseInt(tfPacientesCadastrados.getText()), tbDados);
//				
//				ac.preencherTabela();
				
				try {
					
					Connection con = Conexao.fazConexao();
					String sql = "Select *from dados_pacientes";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
					
					modelo.setNumRows(0);
					
					while(rs.next())
					{
						modelo.addRow(new Object[] {
								
								rs.getString("nome"),
								rs.getString("idade"),
								rs.getString("tipoSanguineo"),
								rs.getString("especialista"),
								rs.getString("horaAtendimento"),
								rs.getString("sintomas")
								
						});
					}
					
					rs.close();
					con.close();
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			}
			
			
		});
		
		
		
		
		btnAtualizarLista.setBounds(51, 356, 163, 51);
		contentPane.add(btnAtualizarLista);
		
		btnFecharLista = new JButton("Voltar");
		btnFecharLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
				setVisible(false);
			}
		});
		btnFecharLista.setBounds(376, 356, 163, 51);
		contentPane.add(btnFecharLista);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Achar Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(128, 128, 192));
		panel.setBounds(730, 313, 316, 82);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnBuscar = new JButton("Buscar"); //alterar
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfNomeBuscado.getText().isBlank())
				{
					JOptionPane.showMessageDialog(null, "Nada foi inserido, sr");
				}else
				{
					try {
						Connection con = Conexao.fazConexao();
						
						String sql = "select *from dados_pacientes where nome like ?"; //busca pelo nome //se eu usar o like ele b@ ou outras funcoes
						PreparedStatement stmt = con.prepareStatement(sql);
						
						stmt.setString(1, "%" + tfNomeBuscado.getText());
						
						ResultSet rs = stmt.executeQuery();
						
						//varredura
						
						//enquanto isso for verdade
						
							
						int achei = 0;
							while(rs.next()) {	
								
								tfId.setText(rs.getString("id"));
								tfNome.setText(rs.getString("nome"));
								tfSintomas.setText(rs.getString("sintomas"));
//								tfHorarioEntrada.setText(rs.getString("horaEntrada"));
//								tfHorarioSaida.setText(rs.getString("horaSaida"));
//								tfPacientesCadastrados.setText(rs.getString("pacientesCadastrados"));
								achei = 1; //caso o medico seja encontrado  apenas para testes
								
								tfNomeBuscado.setText("");
								
							}
							
							if(achei == 0) {
								JOptionPane.showMessageDialog(null, "Paciente não encontrado");
							}
							
							rs.close();
							con.close(); /*fechando conexao*/
							
									
						
					} catch (SQLException e1) {
						// TODO Auto-generated catch block

						e1.printStackTrace();
					}
					
					
				}
				
			}
		});
		btnBuscar.setBounds(10, 31, 89, 23);
		panel.add(btnBuscar);
		
		tfNomeBuscado = new JTextField();
		tfNomeBuscado.setBounds(109, 23, 195, 39);
		panel.add(tfNomeBuscado);
		tfNomeBuscado.setColumns(10);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if(tfNome.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Faça uma busca do médico que deseja excluir");
				}
				
				
				AcoesPacientes ac = new AcoesPacientes(Integer.parseInt(tfId.getText())) ; //transformando em int a string
				ac.excluir();
				//objeto entra aqui 
				
				tfId.setText("");
				tfNome.setText("");
				tfSintomas.setText("");

				
				
				
				
				
				
				
				
				
				
			}
		});
		btnExcluir.setBounds(851, 229, 89, 23);
		contentPane.add(btnExcluir);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(tfNome.getText().equals("") || tfSintomas.getText().equals(""))
				{
					
					JOptionPane.showMessageDialog(null, "Usuario / Senha em branco");
					
				}else
				{
					AcoesPacientes ac = new  AcoesPacientes(Integer.parseInt(tfId.getText()) ,tfNome.getText(), tfSintomas.getText()); //objeto para mudar somente
					//mudar somente o que o médico pode mudar: sintomas e nome
					ac.atualizarAreaMedicos();
					
				}


				tfNome.setText("");
				tfSintomas.setText("");
				tfSintomas.setText("");
				tfId.setText("");
				
				
				
			}
		});
		btnAtualizar.setBounds(957, 229, 89, 23);
		contentPane.add(btnAtualizar);
		
		tfSintomas = new JTextField();
		tfSintomas.setColumns(10);
		tfSintomas.setBounds(851, 128, 195, 70);
		contentPane.add(tfSintomas);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(851, 84, 195, 33);
		contentPane.add(tfNome);
		
		lblListaDePacientes = new JLabel("Lista de Pacientes");
		lblListaDePacientes.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblListaDePacientes.setBounds(282, 11, 204, 34);
		contentPane.add(lblListaDePacientes);
		
		lblAlterarCadastro = new JLabel("Alterar Cadastro");
		lblAlterarCadastro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAlterarCadastro.setBounds(830, 11, 178, 34);
		contentPane.add(lblAlterarCadastro);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(717, 87, 46, 14);
		contentPane.add(lblNome);
		
		lblSintomas = new JLabel("Sintomas");
		lblSintomas.setBounds(717, 131, 89, 30);
		contentPane.add(lblSintomas);
		
		JLabel lblIdentificacao = new JLabel("Identificação");
		lblIdentificacao.setBounds(717, 59, 76, 14);
		contentPane.add(lblIdentificacao);
		
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBounds(851, 56, 46, 20);
		contentPane.add(tfId);
		
		JButton btnListarDados = new JButton("Listar todos os médicos");
		btnListarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					Connection con = Conexao.fazConexao();
					String sql = "Select *from dados_senhas";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
					
					modelo.setNumRows(0);
					
					while(rs.next())
					{
						modelo.addRow(new Object[] {
								
								rs.getString("id"),
								rs.getString("Usuario"),
								rs.getString("Senha")
								
						});
					}
					
					rs.close();
					con.close();
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			}
			
			
		});
		
//		JButton btnListarDados = new JButton("Listar todos os médicos");
		
		btnListarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					Connection con = Conexao.fazConexao();
					String sql = "Select *from dados_senhas";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
					
					modelo.setNumRows(0);
					
					while(rs.next())
					{
						modelo.addRow(new Object[] {
								
								rs.getString("id"),
								rs.getString("Usuario"),
								rs.getString("Senha")
								
						});
					}
					
					rs.close();
					con.close();
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			}
			
			
		});
		
		
	}
}/*

buscar:

					try {
						Connection con = Conexao.fazConexao();
						
						String sql = "select *from dados_senhas where usuario like ?"; //busca pelo nome //se eu usar o like ele b@ ou outras funcoes
						PreparedStatement stmt = con.prepareStatement(sql);
						
						stmt.setString(1, "%" + tfBusca.getText());
						
						ResultSet rs = stmt.executeQuery();
						
						//varredura
						
						//enquanto isso for verdade
						
//						if(rs.next() == false) {
//							JOptionPane.showMessageDialog(null, "Este médico não está registrado no nosso banco de dados");
//						}else {
							
						int achei = 0;
							while(rs.next()) {	
								
								tfId.setText(rs.getString("id"));
								tfUsuario.setText(rs.getString("usuario"));
								tfSenha.setText(rs.getString("senha"));
								achei = 1; //caso o medico seja encontrado 
								
							}
							
							if(achei == 0) {
								JOptionPane.showMessageDialog(null, "medico nao encontrado");
							}
							
							rs.close();
							con.close(); /*fechando conexao*/
							
//						}
						

						
						
				//	} catch (SQLException e1) {
						// TODO Auto-generated catch block

					//	e1.printStackTrace();
					//}
//*/
