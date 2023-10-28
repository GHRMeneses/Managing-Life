package model.dto.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {


    private String nome;
    private String login;
    private String senha;
    private int idade;
    private String sexo;
    private String email;

    public Usuario() {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.email = email;
    }
}
