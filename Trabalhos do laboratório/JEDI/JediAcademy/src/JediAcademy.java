import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JediAcademy extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JediAcademy() {
	    super("Jedi Academy  v1.0");
	    getContentPane().setLayout(null);
	    this.setSize(268, 192);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	    JLabel lTitulo = new JLabel("Jedi Academy v1.0");
	    lTitulo.setBounds(0, 10, 260, 20);
	    lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
	    getContentPane().add(lTitulo);

	    JLabel lDesc = new JLabel("Sistema de Controle e Gerenciamento");
	    lDesc.setBounds(0, 25, 260, 20);
	    lDesc.setHorizontalAlignment(SwingConstants.CENTER);
	    lDesc.setFont(new Font("Dialog", Font.ITALIC, 8));
	    getContentPane().add(lDesc);
	    
	    JButton bGer = new JButton("Gerenciar Jedi Initiates");
	      bGer.addActionListener(new ActionListener() {

	          public void actionPerformed(ActionEvent e) {
	        	JediAcademy teste = new JediAcademy();
		        teste.setVisible(false);
	            ManagerWindow managerWindow = new ManagerWindow();
	            managerWindow.setVisible(true);

	            
	            
	          }

	        });

	    bGer.setBounds(20, 55, 220, 25);
	    getContentPane().add(bGer);

	    JButton bRel = new JButton("Relatórios de Controle");
	    bRel.setBounds(20, 85, 220, 25);
	    getContentPane().add(bRel);

	    JButton bSobre = new JButton("Sobre o Sistema");
	    bSobre.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		JOptionPane.showMessageDialog(null, "Jedi Academy v1.0 !!");
	    	}
	    });
	    bSobre.setBounds(20, 115, 220, 25);
	    getContentPane().add(bSobre);

	}
	
	

	public static void main(String args[]) {
		
		
		JediAcademy mainWindow = new JediAcademy();
		
		// Preencha aqui os dados da janela ..
		mainWindow.setVisible(true);
	}
}
