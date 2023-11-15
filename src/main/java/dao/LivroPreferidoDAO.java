<<<<<<< HEAD
package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.Properties;

import model.dto.ConnectionFactory;
import model.dto.LivroPreferido;

// Aqui estamos criando uma classe chamada LivroPreferidoDAO, que é como um assistente especializado em salvar informações sobre livros favoritos.

public class LivroPreferidoDAO {

    // Properties são como as instruções que o assistente segue para fazer o trabalho. Aqui, ele precisa saber como se conectar ao banco de dados.
    
    private Properties properties;

    // Este é o método construtor da classe. Ele é como as instruções que você dá ao assistente quando o chama para ajudar com os livros favoritos.

    public LivroPreferidoDAO(Properties properties) {
        this.properties = properties;
    }

    // Este método registra um livro favorito no caderno (banco de dados).
    // Recebemos um LivroPreferido (p) e algumas instruções adicionais (properties) sobre como fazer o trabalho.

    public static void registrar(LivroPreferido p, Properties properties) throws Exception {
        // Aqui estamos criando a instrução sobre o que escrever no caderno.
        // Seria como dizer ao assistente para anotar o nome do livro (id_usuario) e o tipo de livro (id_genero).
        
        String sql = "INSERT INTO tbusuarios (id_usuario, id_genero) VALUES (?, ?)";
        
        // Criamos uma fábrica especializada em fazer conexões (conectar ao banco de dados).
        // A fábrica é como a empresa que fabrica o caderno onde os livros favoritos são anotados.

        var fabrica = new ConnectionFactory(properties);
        
        // Agora, estamos dizendo ao assistente para começar a trabalhar.
        // Ele pega o caderno (conexão) da fábrica e começa a escrever as informações sobre o livro favorito.

        try (var conexao = fabrica.conectar()) {
            try (var ps = conexao.prepareStatement(sql)) {
                // Aqui, o assistente está preenchendo o nome do livro (id_usuario) e o tipo de livro (id_genero) no caderno.
                // Ele então fecha o caderno, indicando que o trabalho está feito.
                
                ps.setInt(1, p.getIdUsuario());
                ps.setInt(2, p.getIdGenero());
                ps.execute();
            }
        } catch (SQLException e) {
            // Se algo der errado, o assistente nos mostra o que aconteceu (exibe na tela).
            // Ele não desiste facilmente e tenta encontrar uma solução para o problema.
            
            e.printStackTrace();
        }
    }

    // Este é um construtor adicional que pode ou não ser necessário.
    // Se precisar dele, pode adicionar as instruções apropriadas aqui.
    
    public LivroPreferidoDAO(int idUsuario, int i) {
        // Não tenho certeza sobre o propósito deste construtor.
        // Se precisar dele, adicione a lógica apropriada aqui.
    }
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.util.Properties;

import model.dto.ConnectionFactory;
import model.dto.LivroPreferido;

/**
 *
 * @author GUSTAVO
 */
public class LivroPreferidoDAO {

    private static Properties properties;

    public LivroPreferidoDAO(){
        this.properties = properties;
    }
    public static void registrar(LivroPreferido p) throws Exception {
        String sql = "INSERT INTO tbusuarios (id_usuario, id_genero) VALUES (?, ?)";
        var fabrica = new ConnectionFactory(properties);
        var conexao = fabrica.conectaBD();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setInt(1, p.getIdUsuario());
        ps.setInt(2, p.getIdGenero());
        ps.execute();
        ps.close();
        conexao.close();
    }

    public LivroPreferidoDAO(int idUsuario, int i) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
>>>>>>> 0456081231b5a02436b2931e93a9b0d911a310b0
}