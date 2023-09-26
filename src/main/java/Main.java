import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        // componente JFrame
        JFrame miJFrame = new JFrame("Gerenciador de livros");
        miJFrame.setSize(500,300);

        // componente JPanel
        JPanel miJPanel = new JPanel();
        miJPanel.setSize(300, 300);

        // usamos este diseño para centrar los componentes de JPanel
        miJPanel.setLayout(new GridBagLayout());

        // componente JTextField
        JLabel miJLabel = new JLabel();
        miJLabel.setText("Testando:   ");

        // componente JTextArea
        JTextArea miJTextArea = new JTextArea(5,20);

        // conecta los componentes JLabel y JTextField en JPanel
        miJPanel.add(miJLabel);
        miJPanel.add(miJTextArea);

        // conectar Jpanel a JFrame
        miJFrame.add(miJPanel);

        // hacer visible JFrame
        miJFrame.setVisible(true);
    }
}
