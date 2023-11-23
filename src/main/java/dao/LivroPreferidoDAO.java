package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import model.dto.ConnectionFactory;
import model.dto.LivroPreferido;

public class LivroPreferidoDAO {

    public void registrarLivroPreferido(LivroPreferido livroPreferido, Properties properties) {
        try (ConnectionFactory factory = new ConnectionFactory(properties);
             Connection connection = factory.conectar();
             PreparedStatement ps = connection.prepareStatement("INSERT INTO tabela_livros_preferidos (id_usuario, id_genero) VALUES (?, ?)")) {

            ps.setInt(1, livroPreferido.getIdUsuario());
            ps.setInt(2, livroPreferido.getIdGenero());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Livro preferido registrado com sucesso!");
            } else {
                System.out.println("Nenhuma linha afetada ao registrar livro preferido.");
            }

        } catch (SQLException e) {
            System.out.println("Erro SQL ao registrar livro preferido: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Erro ao registrar livro preferido: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
