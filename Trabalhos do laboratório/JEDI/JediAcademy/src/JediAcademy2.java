import javax.swing.*;

public class JediAcademy2 {

  private JFrame frame;

  public JediAcademy2() {
    frame = new JFrame("Jedi Academy  v1.0");
    frame.setSize(260, 180);
    frame.setLayout(null);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  public static void main(String args[]) {
    JediAcademy2 mainWindow = new JediAcademy2();
    mainWindow.frame.setVisible(true);
  }
}
