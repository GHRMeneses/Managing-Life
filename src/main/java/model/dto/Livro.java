/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

import dao.AvaliacaoDAO;
import dao.LivroDAO;
import lombok.Data;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

@Data

public class Livro implements Comparable <Livro>{
    
    private String titulo;
    private String autor;
    private int idLivro;
    private int idGenero;
    private int idUsuario;

    private int numAvaliacoes;

    private double nota;


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


    @Override
    public int compareTo(Livro livro){

        if(this.getNota() == livro.getNota()){

            if(this.getNumAvaliacoes() == livro.getNumAvaliacoes()){

                // desempata de novo por titulo
                return this.getTitulo().compareTo(livro.getTitulo());

            }
            else if(this.getNumAvaliacoes() > livro.getNumAvaliacoes()) return 1;

            else return -1;

        }

        else if(this.getNota() < livro.getNota()) return 1;

        else return -1;
    }

}
