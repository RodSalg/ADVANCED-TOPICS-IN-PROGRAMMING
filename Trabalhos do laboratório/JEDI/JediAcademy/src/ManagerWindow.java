import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagerWindow extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public ManagerWindow() {
    super("Jedi Initiates Management");
    this.setLayout(null); this.setSize(260, 180);
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JLabel lTitulo = new JLabel("Jedi Academy v1.0");
    lTitulo.setBounds(0, 10, 260, 20);
    lTitulo.setHorizontalAlignment(SwingConstants.CENTER);
    this.add(lTitulo);
    
    JLabel lDesc = new JLabel("Gerenciamento de Jedi Initiates");
    lDesc.setBounds(0, 25, 260, 20);
    lDesc.setHorizontalAlignment(SwingConstants.CENTER);
    lDesc.setFont(new Font("Dialog", Font.ITALIC, 8));
    this.add(lDesc);
    
    JButton bGer = new JButton("Adicionar");
    bGer.setBounds(20, 55, 220, 25);
    this.add(bGer);
    
    JButton bGer2 = new JButton("Modificar");
    bGer.setBounds(20, 55, 220, 25);
    this.add(bGer);
    
    JButton bGer3 = new JButton("Remover");
    bGer.setBounds(20, 55, 220, 25);
    this.add(bGer);

    // Outros botões ..
    

    bGer.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        ManagerWindow managerWindow = new ManagerWindow();
        managerWindow.setVisible(true);
      }

    });
    
  
  }
  
}

