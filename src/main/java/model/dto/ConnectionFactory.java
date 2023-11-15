<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    
    // Aqui, definimos as variáveis que serão utilizadas para construir a conexão.
    
    private String host, port, db, user, password;
    
    // Este é o construtor principal, que recebe um conjunto de propriedades para criar a conexão.
    
    public ConnectionFactory(java.util.Properties properties){
        this(
            properties.getProperty("DB_HOST"),
            properties.getProperty("DB_PORT"),
            properties.getProperty("DB_NAME"),
            properties.getProperty("DB_USER"),
            properties.getProperty("DB_PASSWORD")
        );
    }
    
    // Este é o construtor que será chamado pelo construtor principal, para criar a conexão.
    
    public ConnectionFactory(
        String host,
        String port,
        String db,
        String user,
        String password
    ){
      this.host = host;
      this.port = port;
      this.db = db;
      this.user = user;
      this.password = password;
    }
    
    // Este método cria e retorna a conexão com o banco de dados.
    
    public Connection conectar() throws Exception{
        return DriverManager.getConnection(
            String.format(
                "jdbc:mysql://%s:%s/%s",
                host,
                port,
                db
            ),
            user,
            password
        );
    }
    
    // O método main é como o ponto de entrada para testar nossa fábrica de conexões.
    
    public static void main(String[] args) throws Exception {
        
        // Aqui, criamos um conjunto de propriedades a partir de um arquivo chamado "conf.properties".
        
        var properties = new Properties();
        properties.load(
            new FileInputStream(new File("conf.properties"))
        );
        
        // Em seguida, extraímos informações específicas do conjunto de propriedades.
        
        final String DB_HOST = properties.getProperty("DB_HOST");
        final String DB_PORT = properties.getProperty("DB_PORT");
        final String DB_NAME = properties.getProperty("DB_NAME");
        final String DB_USER = properties.getProperty("DB_USER");
        final String DB_PASSWORD = properties.getProperty("DB_PASSWORD");
        
        // Agora, usamos essas informações para criar uma instância da nossa fábrica de conexões.
        
        var fabrica = new ConnectionFactory(
            DB_HOST, 
            DB_PORT, 
            DB_NAME, 
            DB_USER, 
            DB_PASSWORD
        );
        
        // Por fim, imprimimos a conexão no console para verificar se tudo está funcionando corretamente.
        
        System.out.println(fabrica.conectar());
    }
}
=======
package model.dto;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 *
 * @author rodrigo
 */
public class ConnectionFactory {
    private static String host;
    private static String port;
    private static String db;
    private static String user;
    private static String password;
    
    public ConnectionFactory (java.util.Properties properties){
        this(
            properties.getProperty("DB_HOST"),
            properties.getProperty("DB_PORT"),
            properties.getProperty("DB_NAME"),
            properties.getProperty("DB_USER"),
            properties.getProperty("DB_PASSWORD")
        );
    }
    public ConnectionFactory(
        String host,
        String port,
        String db,
        String user,
        String password
    ){
      this.host = host;
      this.port = port;
      this.db = db;
      this.user = user;
      this.password = password;
    }



    public static Connection conectaBD() throws Exception{
        return DriverManager.getConnection(
            String.format(
                "jdbc:mysql://%s:%s/%s",
                host,
                port,
                db
            ),
            user,
            password
        );
    }
    
    public static void main(String[] args) throws Exception {
        var properties = new Properties();
        properties.load(
            new FileInputStream(new File("conf.properties"))
        );
        final String DB_HOST = properties.getProperty("DB_HOST");
        final String DB_PORT = properties.getProperty("DB_PORT");
        final String DB_NAME = properties.getProperty("DB_NAME");
        final String DB_USER = properties.getProperty("DB_USER");
        final String DB_PASSWORD = properties.getProperty("DB_PASSWORD");
        var fabrica = new ConnectionFactory(
            DB_HOST, 
            DB_PORT, 
            DB_NAME, 
            DB_USER, 
            DB_PASSWORD
        );
        System.out.println(fabrica.conectaBD());
    }
}

>>>>>>> 0456081231b5a02436b2931e93a9b0d911a310b0
