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

    public Usuario(String nome, String login, String senha, int idade, String sexo, int id_tipo_usuario){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.idade = idade;
        this.sexo = sexo;
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public int getIdUsuario(){
        return idUsuario;
    }

    public void setIdUsuario(int id){
        this.idUsuario = id;
    }

    public int getId_tipo_usuario(){
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(int id_tipo_usuario){
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}