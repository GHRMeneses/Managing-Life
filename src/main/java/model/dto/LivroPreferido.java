/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dto;

/**
 *
 * @author GUSTAVO
 */
public class LivroPreferido {
    
    // Estas são as variáveis que representam as informações sobre o usuário e o gênero preferido.
    
    private int idUsuario;
    private int idGenero;
    
    // Este é o construtor da classe, utilizado para criar instâncias de LivroPreferido.
    // Ele recebe as informações necessárias para definir a preferência do usuário.

    public LivroPreferido(int idUsuario, int idGenero) {
        this.idUsuario = idUsuario;
        this.idGenero = idGenero;
    }

    // Estes são os métodos de acesso (getters e setters) para as informações da preferência do usuário.
    // Eles permitem que outras partes do código obtenham ou alterem essas informações.

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }
}
