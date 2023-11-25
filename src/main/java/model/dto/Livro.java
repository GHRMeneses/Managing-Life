/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import lombok.Data;

@Data

public class Livro {
    
    // Estas são as variáveis que representam as informações sobre o usuário e o gênero preferido.
    private String titulo;
    private String autor;
    private int idLivro, idGenero, idUsuario;
    
    // Este é o construtor da classe, utilizado para criar instâncias de Livro.
    // Ele recebe as informações necessárias para definir a preferência do usuário.

    public Livro() {
    }

    
    public Livro(int idUsuario, int idGenero) {
        this.idUsuario = idUsuario;
        this.idGenero = idGenero;

    }

    public Livro(String titulo, String autor, int idLivro, int idGenero, int idUsuario) {
        this.titulo = titulo;
        this.autor = autor;
        this.idLivro = idLivro;
        this.idGenero = idGenero;
        this.idUsuario = idUsuario;
    }
    
    public int getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    

}
