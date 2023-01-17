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

import Acoes.AcoesPacientes;
import classeDeConexao.Conexao;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

/** 
 * area do recepcionista somente ele pode acessar
 * 
 * */
public class AreaRecepcionista extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Painel contendo toda as coisas
	 * */
	private JPanel contentPane;
	/**
	 * 	botao para fechar a lista (voltar para a tela de menu) 
	 * */
	private JButton btnFecharLista;
	/**
	 * novo painel usado ao canto para buscar paciente
	 * */
	private JPanel panel;
	/**
	 *  botao para buscar um paciente
	 * */
	private JButton btnBuscar;
	/**
	 *  campo para pegar o nome que desejo achar na lista
	 * */
	private JTextField tfNomeBuscado;
	/**
	 *  campo para pegar a hora de atendimento que o paciente deseja
	 * */
	private JTextField tfHoraAtendimento;
	
	/**
	 *  campo para pegar o tipo sanguineo do paciente
	 * */
	private JTextField tfTipoSanguineo;
	/**
	 *  botao para excluir um paciente
	 * */
	private JButton btnExcluir;
	/**
	 * botao para atualizar o paciente
	 * */
	private JButton btnAtualizar;
	/**
	 * campo para pegar a idade
	 * */ 
	private JTextField tfIdade;
	/**
	 *  campo para pegar o nome
	 * */
	private JTextField tfNome;
	/**
	 * label alterar o cadastro
	 * */
	private JLabel lblAlterarCadastro;
	/**
	 * label nome
	 * */
	private JLabel lblNome;
	/**
	 * label idade
	 * */
	private JLabel lblIdade;
	/**
	 * label tipo sanguineo
	 * */
	private JLabel lblTipoSanguineo;
	/**
	 * label hora de atendimento
	 * */
	private JLabel lblHoraAtendimento;
	/**
	 *  label sintomas
	 * */
	private JLabel lblSintomas;
	/**
	 * label ID
	 * */
	private JTextField tfId;

	/**
	 *  campo para ID
	 * */
	private JTextField tfEspecialista;
	/**
	 *  campo para Especialista
	 * */
	private JLabel lblEspecialista;
	private JTextField tfSintomas;

	/**
	 * Area onde realizaremos o cadastro de pacientes com algumas condicoes - o paciente sera cadastrado
	 * se e somente se houver o especialista que ele precisa e se ele estiver dentro do horario de trabalho daquele paciente.
	 * @param args - do meu main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AreaRecepcionista frame = new AreaRecepcionista();
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
	public AreaRecepcionista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnFecharLista = new JButton("Voltar");
		btnFecharLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuPrincipal mp =  new MenuPrincipal();
				mp.setVisible(true);
				setVisible(false);
			}
		});
		btnFecharLista.setBounds(488, 391, 150, 114);
		contentPane.add(btnFecharLista);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Achar Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBackground(new Color(255, 128, 128));
		panel.setBounds(28, 423, 316, 82);
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
								tfIdade.setText(rs.getString("idade"));
								tfTipoSanguineo.setText(rs.getString("tipoSanguineo"));
								tfEspecialista.setText(rs.getString("especialista"));
								tfHoraAtendimento.setText(rs.getString("horaAtendimento"));
								tfSintomas.setText(rs.getString("sintomas"));
								achei = 1; //caso o medico seja encontrado  apenas para testes
								
							}
							
							if(achei == 0) {
								JOptionPane.showMessageDialog(null, "Paciente nao encontrado");
							}
							
							rs.close();
							con.close(); /*fechando conexao*/
							
							tfNomeBuscado.setText("");
									
						
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
		
		tfHoraAtendimento = new JTextField();
		tfHoraAtendimento.setColumns(10);
		tfHoraAtendimento.setBounds(162, 238, 195, 34);
		contentPane.add(tfHoraAtendimento);
		
		tfTipoSanguineo = new JTextField();
		tfTipoSanguineo.setColumns(10);
		tfTipoSanguineo.setBounds(162, 189, 195, 34);
		contentPane.add(tfTipoSanguineo);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				if(tfTipoSanguineo.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Faça uma busca do Paciente que deseja excluir");
				}
				
				
				AcoesPacientes ac = new AcoesPacientes(Integer.parseInt(tfId.getText())) ; //transformando em int a string
				ac.excluir();
				//objeto entra aqui 
				
				tfId.setText("");
				tfNome.setText("");
				tfHoraAtendimento.setText("");
				tfSintomas.setText("");
				tfTipoSanguineo.setText("");
				tfIdade.setText("");
				tfEspecialista.setText("");

				
				
				
				
				
				
				
				
				
				
			}
		});
		btnExcluir.setBounds(339, 352, 89, 23);
		contentPane.add(btnExcluir);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				
				if(tfHoraAtendimento.getText().equals("") || tfSintomas.getText().equals(""))
				{
					
					JOptionPane.showMessageDialog(null, "Preencha todos os dados");
					
				}else
				{
					AcoesPacientes ac = new  AcoesPacientes(Integer.parseInt(tfId.getText()),tfNome.getText(), Integer.parseInt(tfIdade.getText()), tfTipoSanguineo.getText(),
							Integer.parseInt(tfHoraAtendimento.getText()), tfEspecialista.getText(), tfSintomas.getText());
					ac.atualizar();
					
				}
				
				tfTipoSanguineo.setText("");
				tfHoraAtendimento.setText("");
				tfTipoSanguineo.setText("");
				tfNome.setText("");
				tfSintomas.setText("");
				tfIdade.setText("");
				tfEspecialista.setText("");
				
				
			}
		});
		btnAtualizar.setBounds(206, 352, 89, 23);
		contentPane.add(btnAtualizar);
		
		tfIdade = new JTextField();
		tfIdade.setColumns(10);
		tfIdade.setBounds(162, 143, 195, 30);
		contentPane.add(tfIdade);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(162, 102, 195, 30);
		contentPane.add(tfNome);
		
		lblAlterarCadastro = new JLabel("Marcar Consulta");
		lblAlterarCadastro.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAlterarCadastro.setBounds(162, 26, 182, 34);
		contentPane.add(lblAlterarCadastro);
		
		lblNome = new JLabel("Nome");
		lblNome.setBounds(28, 110, 46, 14);
		contentPane.add(lblNome);
		
		lblIdade = new JLabel("Idade");
		lblIdade.setBounds(28, 152, 89, 14);
		contentPane.add(lblIdade);
		
		lblTipoSanguineo = new JLabel("tipo Sanguineo");
		lblTipoSanguineo.setBounds(28, 199, 124, 14);
		contentPane.add(lblTipoSanguineo);
		
		lblHoraAtendimento = new JLabel("Hora de Atendimento");
		lblHoraAtendimento.setBounds(28, 248, 124, 14);
		contentPane.add(lblHoraAtendimento);
		
		lblSintomas = new JLabel("Sintomas");
		lblSintomas.setBounds(415, 163, 59, 14);
		contentPane.add(lblSintomas);
		
		JLabel lblNewLabel_1_1 = new JLabel("Identificação");
		lblNewLabel_1_1.setBounds(28, 74, 76, 14);
		contentPane.add(lblNewLabel_1_1);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfId.setBackground(new Color(192, 192, 192));
		tfId.setForeground(new Color(0, 0, 0));
		tfId.setEnabled(false);
		tfId.setColumns(10);
		tfId.setBounds(162, 71, 46, 20);
		contentPane.add(tfId);
		
		JButton btnMarcarConsulta = new JButton("Marcar Consulta");
		btnMarcarConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexao.fazConexao();
					
					String sql = "select *from dados_pacientes where nome like ?"; //busca pelo nome //se eu usar o like ele b@ ou outras funcoes
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, "%" + tfNomeBuscado.getText());
					
					ResultSet rs = stmt.executeQuery();
					
					//varredura
					
					//enquanto isso for verdade
					
						
					int naoTemPaciente = 1;
						while(rs.next()) {	
							
//							tfId.setText(rs.getString("id"));
//							tfNome.setText(rs.getString("nome"));
//							tfIdade.setText(rs.getString("idade"));
//							tfTipoSanguineo.setText(rs.getString("tipoSanguineo"));
//							tfHoraAtendimento.setText(rs.getString("horaAtendimento"));
//							tfSintomas.setText(rs.getString("sintomas"));
							naoTemPaciente = 0; //caso o medico seja encontrado  apenas para testes
							
						}
						
						rs.close();
						con.close(); /*fechando conexao*/
						
						if(naoTemPaciente == 1) {
							JOptionPane.showMessageDialog(null, " Este paciente já está cadastrado no sistema");
						}else
							
						{
							
							if(tfNome.getText().isBlank() || tfIdade.getText().isBlank() || tfTipoSanguineo.getText().isBlank() 
									|| tfHoraAtendimento.getText().isBlank() || tfSintomas.getText().isBlank())
							{
								
								JOptionPane.showMessageDialog(null, "Preencha todos os dados do paciente para marcar a consulta");
								
							}else
												
								
							{
								
								AcoesPacientes ac = new AcoesPacientes(tfNome.getText(), Integer.parseInt(tfIdade.getText()), tfTipoSanguineo.getText(),
													Integer.parseInt(tfHoraAtendimento.getText()), tfEspecialista.getText(), tfSintomas.getText()) ;
								ac.salvar();
										
								
								tfTipoSanguineo.setText("");
								tfHoraAtendimento.setText("");
								tfTipoSanguineo.setText("");
								tfNome.setText("");
								tfSintomas.setText("");
								tfIdade.setText("");
								tfEspecialista.setText("");
									
							}
							
						}


						
								
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block

					e1.printStackTrace();
				}
				

				
				
			}
		});
		btnMarcarConsulta.setBounds(28, 352, 141, 23);
		contentPane.add(btnMarcarConsulta);
		
		tfEspecialista = new JTextField();
		tfEspecialista.setColumns(10);
		tfEspecialista.setBounds(162, 288, 195, 34);
		contentPane.add(tfEspecialista);
		
		lblEspecialista = new JLabel("Especialista");
		lblEspecialista.setBounds(28, 297, 124, 14);
		contentPane.add(lblEspecialista);
		
		tfSintomas = new JTextField();
		tfSintomas.setBounds(476, 119, 220, 143);
		contentPane.add(tfSintomas);
		tfSintomas.setColumns(10);
		
		
		
	}
}