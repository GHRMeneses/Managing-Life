/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

/**
 *
 * @author Emers
 */
public class Livro {

    // Estas são as variáveis que representam as características do livro.
    
    private String titulo;
    private String autor;
    private String tipo;
    private int nota;

    // Este é o construtor da classe, utilizado para criar instâncias de Livro.
    // Ele recebe todas as informações necessárias para definir as características do livro.
    
    public Livro(String titulo, String autor, String tipo, int nota) {
        this.titulo = titulo;
        this.autor = autor;
        this.tipo = tipo;
        this.nota = nota;
    }

    // Estes são os métodos de acesso (getters e setters) para as características do livro.
    // Eles permitem que outras partes do código obtenham ou alterem essas características.

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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
}
