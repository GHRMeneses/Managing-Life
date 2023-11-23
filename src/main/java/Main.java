import view.LoginTela;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crie uma instância de Properties e passe-a para o construtor de LoginTela.
                Properties properties = new Properties();
                try {
                    properties.load(new FileInputStream(new File("conf.properties")));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                new LoginTela(properties).setVisible(true);
            }
        });
    }
}
