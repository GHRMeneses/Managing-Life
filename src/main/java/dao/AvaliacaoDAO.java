package dao;

import model.dto.Avaliacao;
import model.dto.ConnectionFactory;
import model.dto.Usuario;

import java.sql.PreparedStatement;
import java.util.Properties;

public class AvaliacaoDAO {

    private Properties properties;

    Usuario logado;


    public AvaliacaoDAO() {
    }

    public AvaliacaoDAO(Properties properties) {
        this.properties = properties;
    }

    public void cadastrar(Avaliacao a) throws Exception {
        var fabrica = new ConnectionFactory(properties);
        String sql = "INSERT INTO tb_avaliacao(nota, idUsuario, id_livro) VALUES (?, ?, ?)";
        try (var conexao = fabrica.conectar()) {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setDouble(1, a.getNota());
            ps.setInt(2, a.getIdUsuario());
            ps.setInt(3, a.getIdLivro());
            ps.execute();
            ps.close();
        }
    }
}