package Interface;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * Tela do menu inicial
 * */
public class MenuPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * painel principal
	 */
	private JPanel contentPane;

	/**
	 * Aqui sera nosso main para rodarmos o frame. Utilizamos o look and fell Nimbus.
	 * Nestela tela teremos tres opcoes:
	 * 1) cadastrar medico
	 * 2) area recepcionista (para cadastrar pacientes)
	 * 3) area medica (relatorio dos pacientes e alteracao de dados dos pacientes)
	 * @param args - args do main
	 */
	public static void main(String[] args) {
		
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            System.err.println(ex);
        } catch (InstantiationException ex) {
        	System.err.println(ex);
        } catch (IllegalAccessException ex) {
        	System.err.println(ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        	System.err.println(ex);
        }
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Classe Jframe do menu principal
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1047, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAreaRecepcionista = new JButton("Area Recepcionista");
		btnAreaRecepcionista.setBackground(Color.LIGHT_GRAY);
		btnAreaRecepcionista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AreaRecepcionista ar = new AreaRecepcionista();
				ar.setVisible(true);
				setVisible(false);
				
			}
		});
		btnAreaRecepcionista.setBounds(405, 217, 166, 60);
		contentPane.add(btnAreaRecepcionista);
		
		JLabel lblNewLabel = new JLabel("Clínica Médica");
		lblNewLabel.setFont(new Font("Comfortaa", Font.PLAIN, 77));
		lblNewLabel.setBounds(188, 11, 679, 92);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(170, 103, 629, 21);
		contentPane.add(separator);
		
		JButton btnCadastrarMedico = new JButton("Cadastrar Médico");
		btnCadastrarMedico.setBackground(Color.LIGHT_GRAY);
		btnCadastrarMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaDeCadastro tela = new TelaDeCadastro();
				tela.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnCadastrarMedico.setBounds(405, 135, 166, 60);
		contentPane.add(btnCadastrarMedico);
		
		JButton btnAreaMedico = new JButton("Area Medico");
		btnAreaMedico.setBackground(Color.LIGHT_GRAY);
		btnAreaMedico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AreaMedico am = new AreaMedico();
				am.setVisible(true);
				setVisible(false);
				
			}
		});
		btnAreaMedico.setBounds(405, 302, 166, 60);
		contentPane.add(btnAreaMedico);
		
		/**
		 * label da versao
		 * */
		JLabel lblversao = new JLabel("V 1.1");
		lblversao.setBounds(933, 383, 46, 14);
		contentPane.add(lblversao);
	}
}
