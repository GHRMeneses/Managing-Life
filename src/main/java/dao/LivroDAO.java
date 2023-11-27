
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import model.dto.ConnectionFactory;
import model.dto.Livro;

// Aqui estamos criando uma classe chamada LivroPreferidoDAO, que é como um assistente especializado em salvar informações sobre livros favoritos.

public class LivroDAO {

    // Properties são como as instruções que o assistente segue para fazer o trabalho. Aqui, ele precisa saber como se conectar ao banco de dados.

    private Properties properties;

    // Este é o método construtor da classe. Ele é como as instruções que você dá ao assistente quando o chama para ajudar com os livros favoritos.

    public LivroDAO(Properties properties) {
        this.properties = properties;
    }

    // Este método registra um livro favorito no caderno (banco de dados).
    // Recebemos um Livro (p) e algumas instruções adicionais (properties) sobre como fazer o trabalho.

    public void registrar(Livro p) throws Exception {
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

    public void cadastrar(Livro livro) throws Exception {
        var fabrica = new ConnectionFactory(properties);
        String sql = "INSERT INTO tb_livro(titulo, autor, id_genero, idUsuario) VALUES (?, ?, ?, ?)";
        try (var conexao = fabrica.conectar()) {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setString(1, livro.getTitulo());
            ps.setString(2, livro.getAutor());
            ps.setInt(3, livro.getIdGenero());
            ps.setInt(4, livro.getIdUsuario());
            ps.execute();
            ps.close();
        } catch (SQLException erro) {
            erro.printStackTrace();
        }
    }

    public void listarTodos(ArrayList<Livro> listaDeLivros) throws Exception {
        var fabrica = new ConnectionFactory(properties);
        String sql = "SELECT * FROM tb_livro";
        try (var conexao = fabrica.conectar()) {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Livro l = new Livro();
                l.setIdLivro(rs.getInt("id_livro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setIdGenero(rs.getInt("id_genero"));
                l.setIdUsuario(rs.getInt("idUsuario"));
                listaDeLivros.add(l);
            }
        }
    }

    public  void receberAvaliacao(Livro livro)  throws Exception{
        var fabrica = new ConnectionFactory(properties);
        String sql = "SELECT * FROM tb_avaliacao WHERE id_livro = ?";
        try (var conexao = fabrica.conectar()) {
            var ps = conexao.prepareStatement(sql);

            ps.setInt(1, livro.getIdLivro());
            ResultSet rs = ps.executeQuery();

            double notasSomadas = 0;
            int numAvaliacoes = 0;

            while (rs.next()){

                notasSomadas += rs.getDouble("nota");
                System.out.print(rs.getDouble("nota"));
                numAvaliacoes++;

            }

            livro.setNota( notasSomadas / numAvaliacoes );
            livro.setNumAvaliacoes(numAvaliacoes);

        }
    }

    public void receberDados(Livro l)  throws Exception{
        var fabrica = new ConnectionFactory(properties);
        String sql = "SELECT * FROM tb_livro WHERE titulo = ? AND idUsuario = ?";
        try (var conexao = fabrica.conectar()) {
            var ps = conexao.prepareStatement(sql);
            ps.setString(1, l.getTitulo());
            ps.setInt(2, l.getIdUsuario());
            try(ResultSet rs = ps.executeQuery()) {
                rs.next();
                l.setIdLivro(rs.getInt("id_livro"));
                l.setTitulo(rs.getString("titulo"));
                l.setAutor(rs.getString("autor"));
                l.setIdGenero(rs.getInt("id_genero"));
                l.setIdUsuario(rs.getInt("idUsuario"));
            }
        }
    }
}
