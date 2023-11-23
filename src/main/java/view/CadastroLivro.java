package view;

import dao.UsuarioDAO;
import model.dto.Usuario;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class CadastroLivro extends javax.swing.JFrame {

    /**
     * Creates new form CadastroComum
     */
    public CadastroLivro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nomeAutor = new javax.swing.JTextField();
        nomeDoLivro2 = new javax.swing.JTextField();
        escolherLivro = new javax.swing.JComboBox<>();
        label1 = new java.awt.Label();
        cadastrarLivroButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nomeAutor.setToolTipText("");
        nomeAutor.setBorder(javax.swing.BorderFactory.createTitledBorder(null));
        nomeAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeAutorActionPerformed(evt);
            }
        });

        nomeDoLivro2.setToolTipText("");
        nomeDoLivro2.setBorder(javax.swing.BorderFactory.createTitledBorder(null));
        nomeDoLivro2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeDoLivro2ActionPerformed(evt);
            }
        });

        escolherLivro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romance", "Ficção", "Ténico" }));
        escolherLivro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                escolherLivroActionPerformed(evt);
            }
        });

        label1.setText("Escolha o Gênero do livro");

        cadastrarLivroButton.setText("Cadastrar");
        cadastrarLivroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarLivroButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(146, 146, 146)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(escolherLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(cadastrarLivroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nomeDoLivro2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(nomeDoLivro2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nomeAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(escolherLivro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cadastrarLivroButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeAutorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeAutorActionPerformed

    private void nomeDoLivro2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeDoLivro2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeDoLivro2ActionPerformed

    private void cadastrarLivroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarLivroButtonActionPerformed
    String nomeLivro = nomeDoLivro2.getText();
    String nomeAutor = nomeAutor.getText();
    String generoSelecionado = (String) escolherLivro.getSelectedItem();

    // Mapear os nomes dos gêneros para seus respectivos IDs no banco de dados
    int idGenero = mapearGeneroParaID(generoSelecionado);

    // Criar um objeto LivroPreferido com as informações coletadas
    LivroPreferido livroPreferido = new LivroPreferido(nomeLivro, nomeAutor, idGenero);

    // Chamar o LivroPreferidoDAO para registrar o livro preferido
    LivroPreferidoDAO livroPreferidoDAO = new LivroPreferidoDAO(properties);
    livroPreferidoDAO.registrarLivroPreferido(livroPreferido);
}

// Função para mapear o nome do gênero para o ID correspondente
    private int mapearGeneroParaID(String generoSelecionado) {
    // Lógica para mapear o nome do gênero para o ID correspondente
    // Use o nome da variável escolherLivro para acessar o item selecionado no JComboBox

    switch (generoSelecionado) {
        case "Romance":
            return 1; // Supondo que 1 seja o ID para Romance no seu banco de dados
        case "Ficção":
            return 2; // Supondo que 2 seja o ID para Ficção no seu banco de dados
        // Adicione outros casos para os outros gêneros, se necessário
        default:
            return 0; // Retorno padrão se o gênero não for encontrado
    }

    }//GEN-LAST:event_cadastrarLivroButtonActionPerformed

    private void escolherLivroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_escolherLivroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_escolherLivroActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarLivroButton;
    private javax.swing.JComboBox<String> escolherLivro;
    private java.awt.Label label1;
    private javax.swing.JTextField nomeAutor;
    private javax.swing.JTextField nomeDoLivro2;
    // End of variables declaration//GEN-END:variables
}
