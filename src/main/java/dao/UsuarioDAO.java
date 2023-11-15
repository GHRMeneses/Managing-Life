package dao;

import model.dto.ConnectionFactory;
import model.dto.usuario.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UsuarioDAO {

    private static Properties properties;

    public UsuarioDAO(){
        this.properties = properties;
    }

    public Usuario existe(Usuario u) throws Exception {
        //1. Construir uma fábrica de conexões
        var fabrica = new ConnectionFactory(properties);
        //2. Estabelecer uma conexão com o banco
        try (var conexao = fabrica.conectaBD()) {
            //3. Especificar o comando SQL
            String sql = "SELECT * FROM tb_usuario WHERE nome = ? AND senha = ?";
            try (var ps = conexao.prepareStatement(sql)) {
                //4. Substituir os eventuais placeholders
                ps.setString(1, u.getLogin());
                ps.setString(2, u.getSenha());
                //5. Executar o comando
                try (var rs = ps.executeQuery()) {
                    //6. Mover o cursor, verificando se o usuário existe
                    //7. Devolver um objeto usuário, null
                    return rs.next() ? u : null;
                }
            }
        }
    }
    public static Usuario cadastrar(Usuario usuario) throws Exception {
        String sql = "INSERT INTO tbusuarios(nome, login, senha, idade, genero, id_tipo_usuario) VALUES (?, ?, ?, ?, ?, ?)";
        var fabrica = new ConnectionFactory(properties);
        var conexao = ConnectionFactory.conectaBD();
        PreparedStatement ps = conexao.prepareStatement(sql);
        ps.setString(1, usuario.getNome());
        ps.setString(2, usuario.getLogin());
        ps.setString(3, usuario.getSenha());
        ps.setInt(4, usuario.getIdade());
        ps.setString(5, usuario.getGenero());
        ps.setInt(6, usuario.getTipo());
        ps.execute();
        ps.close();
        conexao.close();

        return null;
    }
    
    public void atualizar(Usuario usuario) throws Exception{
        String sql = 
        "UPDATE tbusuarios SET nome = ?, login = ?, senha = ?, tipo = ? WHERE id_usuario = ?;";
        try(
            var conexao = ConnectionFactory.conectaBD();
            var ps = conexao.prepareStatement(sql);
        ){
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setInt(4, usuario.getTipo());
            ps.setInt(5, usuario.getIdUsuario());
            ps.execute();
        }
    }
    
    public void deletar(Usuario usuario) throws Exception{
        String sql = "DELETE FROM tbusuarios WHERE id_usuario = ?";
        try(var conexao = new ConnectionFactory(properties).conectaBD();
            var ps = conexao.prepareStatement(sql);
        ){
            ps.setInt(1, usuario.getIdUsuario());
            ps.execute();
        }
    }

    public ResultSet autenticacaoUsuario(Usuario usuario) throws Exception {
        String tipoUsuario = ""; // admin ou com comum
        boolean autenticado = false;

        var fabrica = new ConnectionFactory(properties);
        var conexao = fabrica.conectaBD();

        try {
            String sql = "SELECT * from tbusuarios WHERE login = ? and senha = ? ";

            PreparedStatement pstm = conexao.prepareStatement(sql);
            pstm.setString(1, usuario.getLogin());
            pstm.setString(2, usuario.getSenha());

            ResultSet resultado = pstm.executeQuery();

            return resultado;

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "UsuarioDAO: " + erro);
            return null;
        }
    }
    
    public static void selectId(Usuario usuario)  throws Exception{
        String sql = "SELECT * FROM tbusuarios WHERE login = ? AND senha = ?";
        try (var conn = ConnectionFactory.conectaBD();
            PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            try(ResultSet rs = ps.executeQuery()) {
                rs.next();
                usuario.setIdUsuario(rs.getInt("id_usuario")); 
            }
        }
    }
}
