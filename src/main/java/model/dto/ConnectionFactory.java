package model.dto;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
    private static String usuario = "root";
    private static String senha = "anima123";
    private static String host = "localhost";
    private static String porta = "3306";
    private static String bd = "db_managing_life";

    public static Connection conectaBD (){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); /* Aqui registra */
            String url = "jdbc:mysql://" + host + ":" + porta + "/" + bd + "?user=" + usuario + "&password=" + senha + "&serverTimezone=UTC";
            Connection conn = DriverManager.getConnection(url);
            return conn;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
