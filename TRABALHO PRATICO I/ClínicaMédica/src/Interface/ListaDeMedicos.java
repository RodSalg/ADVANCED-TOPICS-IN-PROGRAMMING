package Interface;


import java.awt.EventQueue;
import java.awt.SystemColor;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Acoes.AcoesMedicos;
import classeDeConexao.Conexao;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
/**
 * Neste Jframe sera mostrado a parte de ler, deletar e atualizar do CRUD*/
public class ListaDeMedicos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * painel geral 
	 */
	private JPanel contentPane;
	/**
	 * tabela de dados
	 */
	private JTable tbDados;
	/**
	 * botao utilizado para atualizar tabela
	 */
	private JButton btnAtualizarTabela;
	/**
	 *  botao para fechar a lista e voltar para a tela anterior
	 */
	private JButton btnFecharLista;
	/**
	 * painel para alocar a parte de busca
	 */
	private JPanel panel;
	/**
	 * botao para buscar um nome
	 */
	private JButton btnBuscar;
	/**
	 * campo de texto para busca
	 */
	private JTextField tfNomeBuscado;
	/**
	 * campo para horario de saida do medico
	 */
	private JTextField tfHorarioSaida;
	/**
	 * campo para horario de entrada
	 */
	private JTextField tfHorarioEntrada;
	/**
	 *  botao para excluir medico
	 */
	private JButton btnExcluir;
	/**
	 * botao para atualizar medico
	 */
	private JButton btnAtualizar;
	/**
	 *  campo para obter a especialidade do medico
	 */
	private JTextField tfEspecialidade;
	/**
	 * campo para obter nome do medico
	 */
	private JTextField tfNome;
	/**
	 * label lista de medicos
	 */
	private JLabel lblListaDeMedicos;
	/**
	 * label alterar cadastro
	 */
	private JLabel lblAlterarCadastro;
	/**
	 * label nome
	 */
	private JLabel lblNome;
	/**
	 *  label especialidade
	 */
	private JLabel lblEspecialidade;
	/**
	 * label horario de entrada
	 */
	private JLabel lblHorarioDeEntrada;
	/**
	 * label horario de saida
	 */
	private JLabel lblHorarioDeSaida;
	/**
	 * campo para obter o ID
	 */
	private JTextField tfId;
	private JSeparator separator;
	private JSeparator separator_1;

	/**
	 * Mostraremos nesse main Jframe a propria lista com medicos e aqui tambem podera ser feita alteracoes nos medicos alem de exclui-la.
	 * @param args - argumento do main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaDeMedicos frame = new ListaDeMedicos();
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
	public ListaDeMedicos() {
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
				"Nome Doutor", "Especiliadade", "horario de entrada", "horario de sa\u00EDda"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbDados.getColumnModel().getColumn(0).setResizable(false);
		tbDados.getColumnModel().getColumn(0).setPreferredWidth(140);
		tbDados.getColumnModel().getColumn(1).setPreferredWidth(76);
		tbDados.getColumnModel().getColumn(2).setPreferredWidth(130);
		tbDados.getColumnModel().getColumn(3).setPreferredWidth(88);
//		tbDados.getColumnModel().getColumn(4).setResizable(false);
//		tbDados.getColumnModel().getColumn(4).setPreferredWidth(119);
		scrollPane.setViewportView(tbDados);
		
		btnAtualizarTabela = new JButton("Atualizar Lista");
		btnAtualizarTabela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
//				AcoesMedicos ac = new AcoesMedicos(Integer.parseInt(tfId.getText()) ,tfNome.getText(), tfEspecialidade.getText(), Integer.parseInt(tfHorarioEntrada.getText()),
//						Integer.parseInt(tfHorarioSaida.getText()), Integer.parseInt(tfPacientesCadastrados.getText()), tbDados);
//				
//				ac.preencherTabela();
				
				try {
					
					Connection con = Conexao.fazConexao();
					String sql = "Select *from dados_medicos";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
					
					modelo.setNumRows(0);
					
					while(rs.next())
					{
						modelo.addRow(new Object[] {
								
								rs.getString("nome"),
								rs.getString("especialidade"),
								rs.getString("horaEntrada"),
								rs.getString("horaSaida"),
								//rs.getString("pacientesCadastrados")
								
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
		
		
		
		
		btnAtualizarTabela.setBounds(51, 356, 163, 51);
		contentPane.add(btnAtualizarTabela);
		
		btnFecharLista = new JButton("Voltar");
		btnFecharLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaDeCadastro tc = new TelaDeCadastro();
				tc.setVisible(true);
				setVisible(false);
			}
		});
		btnFecharLista.setBounds(376, 356, 163, 51);
		contentPane.add(btnFecharLista);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Achar M\u00E9dico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(730, 345, 316, 82);
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
						
						String sql = "select *from dados_medicos where nome like ?"; //busca pelo nome //se eu usar o like ele b@ ou outras funcoes
						PreparedStatement stmt = con.prepareStatement(sql);
						
						stmt.setString(1, "%" + tfNomeBuscado.getText());
						
						ResultSet rs = stmt.executeQuery();
						
						//varredura
						
						//enquanto isso for verdade
						
							
						int achei = 0;
							while(rs.next()) {	
								
								tfId.setText(rs.getString("id"));
								tfNome.setText(rs.getString("nome"));
								tfEspecialidade.setText(rs.getString("especialidade"));
								tfHorarioEntrada.setText(rs.getString("horaEntrada"));
								tfHorarioSaida.setText(rs.getString("horaSaida"));
								//tfPacientesCadastrados.setText(rs.getString("pacientesCadastrados"));
								achei = 1; //caso o medico seja encontrado  apenas para testes
								
							}
							
							if(achei == 0) {
								JOptionPane.showMessageDialog(null, "medico nao encontrado");
							}
							
							tfNomeBuscado.setText("");
							
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
		tfNomeBuscado.setBounds(109, 31, 195, 29);
		panel.add(tfNomeBuscado);
		tfNomeBuscado.setColumns(10);
		
		tfHorarioSaida = new JTextField();
		tfHorarioSaida.setColumns(10);
		tfHorarioSaida.setBounds(851, 244, 195, 35);
		contentPane.add(tfHorarioSaida);
		
		tfHorarioEntrada = new JTextField();
		tfHorarioEntrada.setColumns(10);
		tfHorarioEntrada.setBounds(851, 195, 195, 38);
		contentPane.add(tfHorarioEntrada);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if(tfHorarioEntrada.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Faça uma busca do médico que deseja excluir");
				}
				
				
				AcoesMedicos ac = new AcoesMedicos(Integer.parseInt(tfId.getText())) ; //transformando em int a string
				ac.excluir();
				//objeto entra aqui 
				
				tfId.setText("");
				tfNome.setText("");
				tfHorarioSaida.setText("");
//				tfPacientesCadastrados.setText("");
				tfHorarioEntrada.setText("");
				tfEspecialidade.setText("");

				
				
				
				
				
				
				
				
				
				
			}
		});
		btnExcluir.setBounds(957, 311, 89, 23);
		contentPane.add(btnExcluir);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(tfHorarioSaida.getText().equals("") || tfNome.getText().equals(""))
				{
					
					JOptionPane.showMessageDialog(null, "Algum dado nao foi preenchido");
					
				}else
				{
					AcoesMedicos ac = new  AcoesMedicos(Integer.parseInt(tfId.getText()) ,tfNome.getText(), tfEspecialidade.getText(), Integer.parseInt(tfHorarioEntrada.getText()), Integer.parseInt(tfHorarioSaida.getText()));
					ac.atualizar();
					
				}
				
				tfHorarioEntrada.setText("");
				tfHorarioSaida.setText("");
				tfHorarioEntrada.setText("");
				tfNome.setText("");
//				tfPacientesCadastrados.setText("");
				tfEspecialidade.setText("");
				tfId.setText("");
				
				
				
			}
		});
		btnAtualizar.setBounds(852, 311, 89, 23);
		contentPane.add(btnAtualizar);
		
		tfEspecialidade = new JTextField();
		tfEspecialidade.setColumns(10);
		tfEspecialidade.setBounds(851, 151, 195, 33);
		contentPane.add(tfEspecialidade);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(851, 107, 195, 33);
		contentPane.add(tfNome);
		
		lblListaDeMedicos = new JLabel("Lista de Médicos");
		lblListaDeMedicos.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblListaDeMedicos.setBounds(282, 11, 204, 34);
		contentPane.add(lblListaDeMedicos);
		
		lblAlterarCadastro = new JLabel("Alterar Cadastro");
		lblAlterarCadastro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAlterarCadastro.setBounds(830, 11, 178, 34);
		contentPane.add(lblAlterarCadastro);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(717, 110, 46, 14);
		contentPane.add(lblNome);
		
		lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(717, 154, 89, 30);
		contentPane.add(lblEspecialidade);
		
		lblHorarioDeEntrada = new JLabel("Horário de Entrada");
		lblHorarioDeEntrada.setBounds(717, 198, 124, 14);
		contentPane.add(lblHorarioDeEntrada);
		
		lblHorarioDeSaida = new JLabel("Horário de saída");
		lblHorarioDeSaida.setBounds(717, 247, 95, 32);
		contentPane.add(lblHorarioDeSaida);
		
		JLabel lblIdentificacao = new JLabel("Identificação");
		lblIdentificacao.setBounds(717, 59, 76, 14);
		contentPane.add(lblIdentificacao);
		
		tfId = new JTextField();
		tfId.setEnabled(false);
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBounds(851, 56, 46, 33);
		contentPane.add(tfId);
		
		separator = new JSeparator();
		separator.setBounds(282, 43, 184, 2);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(830, 43, 184, 2);
		contentPane.add(separator_1);
		
		JButton btnListarDados = new JButton("Listar todos os médicos");
		btnListarDados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					
					Connection con = Conexao.fazConexao();
					String sql = "Select *from dados_medicos";
					
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
