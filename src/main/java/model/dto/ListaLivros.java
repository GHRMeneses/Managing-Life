package model.dto;

import dao.AvaliacaoDAO;
import dao.LivroDAO;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

public class ListaLivros {

    private Properties properties;

    public void listar(JList jList){

        try{
            ArrayList<Livro> listaDeLivros = new ArrayList<Livro>();

            LivroDAO livroDAO = new LivroDAO(properties);
            livroDAO.listarTodos(listaDeLivros);

            for(Livro livro : listaDeLivros){
                livroDAO.receberAvaliacao(livro);
            }

            // ordena a lista:
            Collections.sort(listaDeLivros);

            // isso passa os elementos do nosso ArrayList para o DefaultListModel:
            DefaultListModel model = new DefaultListModel();
            for(Livro livro : listaDeLivros){
                model.addElement("Titulo: " + livro.getTitulo());
                model.addElement("Autor: " + livro.getAutor());
                switch(livro.getIdGenero()){
                    case 1:
                        model.addElement("Genero: Romance");
                        break;
                    case 2:
                        model.addElement("Genero: Ficção");
                        break;
                    case 3:
                        model.addElement("Genero: Técnico");
                        break;
                }
                model.addElement("Nota: " + livro.getNota());
                model.addElement("Avaliações: " + livro.getNumAvaliacoes());
                model.addElement("-----");
            }

            // isso passa os elementos do nosso DefaultListModel para o jList:
            jList.setModel(model);

        } catch(Exception e) {
            System.out.print(e);
        }
    }
}

