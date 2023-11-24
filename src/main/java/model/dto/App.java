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

    public static void main(String[] args) throws Exception {

        // Aqui estamos criando uma chave especial (properties) que contém as informações necessárias para abrir a porta.
        // Essas informações são como o mapa que guiará nossos passos no mundo mágico.

        Properties properties = new Properties();

        // Agora, estamos lendo as instruções mágicas contidas em um pergaminho (conf.properties) para saber como proceder.

        properties.load(new FileInputStream(new File("conf.properties")));

        // Preparamos um portal (interface gráfica) para entrar no mundo grafico.

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                // Estamos usando a chave especial (properties) para abrir o portal (LoginTela) e tornar visível a entrada.

                new LoginTela(properties).setVisible(true);
            }
        });
    }
}
