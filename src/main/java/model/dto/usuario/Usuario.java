package model.dto.usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Usuario {

    private int idUsuario;
    private String nome;
    private String login;
    private String senha;
    private int idade;
    private String sexo;
    private int tipo;
    private String genero;

   public Usuario(){
    };
    
    public Usuario(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }
    
    public Usuario(String nome, String login, String senha){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public Usuario(String nome, String login, String senha, int idade, String genero, int tipo){
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.idade = idade;
        this.genero = genero;
        this.tipo = tipo;
    }

    
    public int getIdUsuario(){
        return idUsuario;
    }
    
    public void setIdUsuario(int id){
        this.idUsuario = id;
    }
    
    public int getTipo(){
        return tipo;
    }
    
    public void setTipo(int tipo){
        this.tipo = tipo;
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
    
    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}