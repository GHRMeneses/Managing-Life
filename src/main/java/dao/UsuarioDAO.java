package dao;

import model.dto.ConnectionFactory;
import model.dto.usuario.Usuario;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    Connection conn;

       public static void cadastrar(Usuario usuario) throws Exception {
        String sql = "INSERT INTO tbusuarios(nome, login, senha, idade, genero, id_tipo_usuario) VALUES (?, ?, ?, ?, ?, ?)";
        var conne = new ConnectionFactory();
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
        try(
            var conexao = new ConnectionFactory().conectaBD();
            var ps = conexao.prepareStatement(sql);
        ){
            ps.setInt(1, usuario.getIdUsuario());
            ps.execute();
        }
    }

    public ResultSet autenticacaoUsuario(Usuario usuario) {
        String tipoUsuario = ""; // admin ou com comum
        boolean autenticado = false;

        conn = new ConnectionFactory().conectaBD();

        try {
            String sql = "SELECT * from tbusuarios WHERE login = ? and senha = ? ";

            PreparedStatement pstm = conn.prepareStatement(sql);
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
