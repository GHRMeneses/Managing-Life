package dao;

import model.dto.ConnectionFactory;
import model.dto.usuario.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

// Esta classe é como o guardião dessa biblioteca, que cuida de tudo relacionado aos leitores (usuários).

public class UsuarioDAO {

    // As propriedades são como as regras da biblioteca, elas dizem como devemos lidar com as informações.

    private Properties properties;

    // Este é o guardião principal, e ele precisa de instruções específicas (propriedades) para operar.

    public UsuarioDAO(Properties properties) {
        this.properties = properties;
    }

    // Mas se, por algum motivo, esquecermos de dar essas instruções, o guardião ainda pode trabalhar, mas com algumas limitações.

    public UsuarioDAO() {
        this.properties = new Properties();
    }

    // Este método verifica se um leitor específico (usuário) tem uma chave especial (nome e senha) para entrar na biblioteca.

    public Usuario existe(Usuario u) throws Exception {
        try (Connection conexao = new ConnectionFactory(properties).conectar()) {
            String sql = "SELECT * FROM tb_usuario WHERE nome = ? AND senha = ?";
            try (PreparedStatement ps = conexao.prepareStatement(sql)) {
                ps.setString(1, u.getLogin());
                ps.setString(2, u.getSenha());
                try (ResultSet rs = ps.executeQuery()) {
                    return rs.next() ? u : null;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Este método adiciona um novo livro (usuário) à biblioteca, seguindo um conjunto especial de regras (instruções SQL).

    public Usuario cadastrar(Usuario usuario) throws Exception {
        String sql = "INSERT INTO tbusuarios(nome, login, senha, idade, genero, id_tipo_usuario) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conexao = new ConnectionFactory(properties).conectar();
             PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setInt(4, usuario.getIdade());
            ps.setString(5, usuario.getGenero());
            ps.setInt(6, usuario.getTipo());
            ps.execute();
        } catch (SQLException e) {
            // Se algo der errado, o guardião não se preocupa muito e continua sua jornada.
        }
        return usuario;
    }

    // Este método atualiza as informações de um livro (usuário) na biblioteca, seguindo um conjunto especial de regras.

    public void atualizar(Usuario usuario) throws Exception {
        String sql = "UPDATE tbusuarios SET nome = ?, login = ?, senha = ?, tipo = ? WHERE id_usuario = ?";
        try (Connection conexao = new ConnectionFactory(properties).conectar();
             PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setInt(4, usuario.getTipo());
            ps.setInt(5, usuario.getIdUsuario());
            ps.execute();
        } catch (SQLException e) {
            // O guardião não se preocupa muito com erros, ele está sempre pronto para a próxima aventura.
        }
    }

    // Este método remove um livro (usuário) da biblioteca, seguindo um conjunto especial de regras.

    public void deletar(Usuario usuario) throws Exception {
        String sql = "DELETE FROM tbusuarios WHERE id_usuario = ?";
        try (Connection conexao = new ConnectionFactory(properties).conectar();
             PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, usuario.getIdUsuario());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            // O guardião fica atento a qualquer problema, mas sempre continua sua jornada.
        }
    }

    // Este método realiza um ritual especial (autenticação) para permitir que um leitor (usuário) entre na biblioteca.
    // Ele consulta um livro mágico (banco de dados) para verificar se as informações do leitor estão corretas.

    public ResultSet autenticacaoUsuario(Usuario usuario) throws Exception {
        var fabrica = new ConnectionFactory(properties);
        var conexao = fabrica.conectar();

        try {
            String sql = "SELECT * FROM tbusuarios WHERE login = ? AND senha = ?";
            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, usuario.getLogin());
            pstm.setString(2, usuario.getSenha());
            return pstm.executeQuery();
        } catch (SQLException erro) {
            erro.printStackTrace();
            return null;
        }
    }

    // Este método usa um encantamento para descobrir o ID de um leitor (usuário) na biblioteca.
    // Ele consulta o livro mágico para encontrar o ID do leitor com base em suas informações.

    public void selectId(Usuario usuario) throws Exception {
        String sql = "SELECT * FROM tbusuarios WHERE login = ? AND senha = ?";
        try (var conn = new ConnectionFactory(properties).conectar();
             var ps = conn.prepareStatement(sql)) {
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            try (var rs = ps.executeQuery()) {
                rs.next();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
            } catch (SQLException e) {
                // O guardião não se preocupa muito, ele sabe que a magia nem sempre acontece como esperado.
            }
        } catch (SQLException e) {
        }
    }
}
