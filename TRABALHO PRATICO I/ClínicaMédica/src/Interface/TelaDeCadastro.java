package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import Acoes.AcoesMedicos;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;

/**
 * JFrame da nossa tela de cadastro medico
 * */
public class TelaDeCadastro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *  painel principal
	 */
	private JPanel contentPane;
	/**
	 * campo para pegar  o nome
	 */
	private JTextField tfNome;
	/**
	 * campo para pegar a especialidade
	 */
	private JTextField tfEspecialidade;
	/**
	 * campo para pegar o horario de saida do medico
	 */
	private JTextField tfHorarioSaida;
	/**
	 *  campo para pegar o horario de entrada do medico
	 */
	private JTextField tfHorarioEntrada;

	/**
	 * Tela para cadastro de um novo medico.
	 * @param args - argumento da main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDeCadastro frame = new TelaDeCadastro();
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
	public TelaDeCadastro() {
		setResizable(false);
		setTitle("Cadastro Médico");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsurio = new JLabel("Nome do Médico");
		lblUsurio.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblUsurio.setBounds(21, 115, 157, 21);
		contentPane.add(lblUsurio);
		
		JLabel lblSenha = new JLabel("Especialidade");
		lblSenha.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblSenha.setBounds(21, 157, 130, 21);
		contentPane.add(lblSenha);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(188, 114, 367, 32);
		contentPane.add(tfNome);
		
		tfEspecialidade = new JTextField();
		tfEspecialidade.setColumns(10);
		tfEspecialidade.setBounds(188, 157, 367, 31);
		contentPane.add(tfEspecialidade);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1065, 22);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Ações");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Menu");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
					
					MenuPrincipal mp = new MenuPrincipal();
					mp.setVisible(true);
					setVisible(false);
					
					
					
					
				
				
			}
		});
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_DOWN_MASK));
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("");
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JButton btnListaMedicos = new JButton("Exibir / Alterar / Deletar Médicos");
		btnListaMedicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ListaDeMedicos lm = new ListaDeMedicos();
				lm.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnListaMedicos.setBounds(38, 314, 288, 86);
		contentPane.add(btnListaMedicos);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBounds(410, 291, 145, 47);
		contentPane.add(btnNewButton);
		
		tfHorarioSaida = new JTextField();
		tfHorarioSaida.setColumns(10);
		tfHorarioSaida.setBounds(188, 242, 367, 32);
		contentPane.add(tfHorarioSaida);
		
		tfHorarioEntrada = new JTextField();
		tfHorarioEntrada.setColumns(10);
		tfHorarioEntrada.setBounds(188, 199, 367, 32);
		contentPane.add(tfHorarioEntrada);
		
		JLabel lblHorarioDeSada = new JLabel("Horário de Saída");
		lblHorarioDeSada.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblHorarioDeSada.setBounds(21, 241, 130, 21);
		contentPane.add(lblHorarioDeSada);
		
		JLabel lblHorarioDeEntrada = new JLabel("Horário de Entrada");
		lblHorarioDeEntrada.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblHorarioDeEntrada.setBounds(21, 199, 157, 21);
		contentPane.add(lblHorarioDeEntrada);
		
		JLabel lblCadastrarMdico = new JLabel("CADASTRAR MÉDICO");
		lblCadastrarMdico.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		lblCadastrarMdico.setBounds(203, 71, 167, 21);
		contentPane.add(lblCadastrarMdico);
		
		JButton btnNewButton_1 = new JButton("MENU");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MenuPrincipal mp = new MenuPrincipal();
				mp.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton_1.setBounds(21, 33, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(203, 90, 157, 2);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(21, 67, 101, 2);
		contentPane.add(separator_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tfNome.getText().isBlank() || tfEspecialidade.getText().isBlank())
				{
					
					JOptionPane.showMessageDialog(null, "Usuario / Senha em branco");
					
				}else
									
					
				{
					
					AcoesMedicos ac = new AcoesMedicos(tfNome.getText(), tfEspecialidade.getText(), Integer.parseInt(tfHorarioEntrada.getText()), Integer.parseInt(tfHorarioSaida.getText())) ;
					ac.salvar();
							
					
						
				}
					
			
				tfEspecialidade.setText("");
				tfHorarioEntrada.setText("");
				tfHorarioSaida.setText("");
				tfNome.setText("");
			}
			
			
				
				
				
		});
	}
}
