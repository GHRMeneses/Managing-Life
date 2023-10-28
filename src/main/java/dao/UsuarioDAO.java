package dao;

import model.dto.ConnectionFactory;
import model.dto.usuario.Usuario;
import model.dto.usuario.UsuarioAdministrador;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    Connection conn;

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
}
