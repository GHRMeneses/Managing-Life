package model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Usuario {

    // Variáveis que armazenam as informações do usuário.
    
    private int idUsuario;
    private String nome;
    private String login;
    private String senha;
    private int idade;
    private String sexo;
    private int id_tipo_usuario;

    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, String login, String senha, int idade, String genero, int id_tipo_usuario){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.id_tipo_usuario = id_tipo_usuario;
    }
}