
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

    public void registrar(LivroPreferido p) throws Exception {
        var fabrica = new ConnectionFactory(properties);
        String sql = "INSERT INTO tb_preferidos (idUsuario, id_genero) VALUES (?, ?)";
        try (var conexao = fabrica.conectar()) {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, p.getIdUsuario());
            ps.setInt(2, p.getIdGenero());
            ps.execute();
            ps.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }
}

// Este é um construtor adicional que pode ou não ser necessário.
// Se precisar dele, pode adicionar as instruções apropriadas aqui.

//    public LivroPreferidoDAO(int idUsuario, int i) {
// Não tenho certeza sobre o propósito deste construtor.
// Se precisar dele, adicione a lógica apropriada aqui.
//    }