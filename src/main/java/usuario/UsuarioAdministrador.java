package usuario;

import lombok.Getter;
import lombok.Setter;

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


}
