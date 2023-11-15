/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package model.dto;

/**
 *
 * @author rodrigo
 */
import view.LoginTela;

import java.io.FileInputStream;
import java.io.File;
import java.util.Properties;
public class App {

    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("conf.properties")));
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginTela(properties).setVisible(true);
            }
        });
    }
}
