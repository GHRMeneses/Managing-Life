package model.dto.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioAdministrador extends Usuario {


    public UsuarioAdministrador() {

    }

//    private void cadastroDeUsuario() {
//        Usuario model.dto.usuario = new Usuario();
//        Scanner sc = new Scanner(System.in);
//        String nome = sc.nextLine();
//        String login = sc.nextLine();
//        String senha = sc.nextLine();
//        int idade = sc.nextInt();
//        String sexo = sc.nextLine();
//        String email = sc.nextLine();
//
//        model.dto.usuario.setNome(nome);
//        model.dto.usuario.setLogin(login);
//        model.dto.usuario.setSenha(senha);
//        model.dto.usuario.setIdade(idade);
//        model.dto.usuario.setSexo(sexo);
//        model.dto.usuario.setEmail(email);
//
//    }

//    public boolean cadastrar () {
//        //Definir o comando SQL - a String
//        String sql = "INSERT INTO tb pessoa (nome, fone, email) VALUES (?, ?, ?)";
//        //Abrir a conexão
//        try (Connection c = ConnectionFactory.obtemConexao()) {
//            //Pré compilar o comando SQL
//            PreparedStatement ps = c.prepareStatement(sql);
//            //Preencher com valores o statment
//            ps.setString(1, nome);
//            ps.setString(2, fone);
//            ps.setString(3, email);
//            //executa o comando
//            ps.execute();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
//        return false;
//    }
//}


}
