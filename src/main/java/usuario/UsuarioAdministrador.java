package usuario;

import lombok.Getter;
import lombok.Setter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

@Getter
@Setter
public class UsuarioAdministrador extends Usuario {


    public UsuarioAdministrador(String nome, String login, String senha, int idade, String sexo, String email) {
    }

    private void cadastroDeUsuario() {
        Usuario usuario = new Usuario();
        Scanner sc = new Scanner(System.in);
        String nome = sc.nextLine();
        String login = sc.nextLine();
        String senha = sc.nextLine();
        int idade = sc.nextInt();
        String sexo = sc.nextLine();
        String email = sc.nextLine();

        usuario.setNome(nome);
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setIdade(idade);
        usuario.setSexo(sexo);
        usuario.setEmail(email);

    }

    public boolean cadastrar () {
        //Definir o comando SQL - a String
        String sql = "INSERT INTO tb pessoa (nome, fone, email) VALUES (?, ?, ?)";
        //Abrir a conexão
        try (Connection c = ConnectionFactory.obtemConexao()) {
            //Pré compilar o comando SQL
            PreparedStatement ps = c.prepareStatement(sql);
            //Preencher com valores o statment
            ps.setString(1, nome);
            ps.setString(2, fone);
            ps.setString(3, email);
            //executa o comando
            ps.execute();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}


}
