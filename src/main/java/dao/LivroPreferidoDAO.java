/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import model.dto.ConnectionFactory;
import model.dto.LivroPreferido;

/**
 *
 * @author GUSTAVO
 */
public class LivroPreferidoDAO {
    public static void registrar(LivroPreferido p) throws Exception {
        String sql = "INSERT INTO tbusuarios (id_usuario, id_genero) VALUES (?, ?)";
        var fabricaDeConexoes = new ConnectionFactory();
        var conexao = fabricaDeConexoes.conectaBD();
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
    
}