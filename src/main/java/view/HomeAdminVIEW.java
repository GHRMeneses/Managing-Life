/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import model.dto.Usuario;

import java.util.Properties;

/**
 *
 * @author GUSTAVO
 */
public class HomeAdminVIEW extends javax.swing.JFrame {

    private Properties properties;

    Usuario logado;

    public HomeAdminVIEW() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public HomeAdminVIEW(Properties properties, Usuario logado) {
        this();
        this.properties = properties;
        this.logado = logado;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cadastrarLivroButton = new javax.swing.JButton();
        cadastrarUsuarioButton1 = new javax.swing.JButton();
        managinglife = new javax.swing.JLabel();
        managinglife1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        vizualizarLivroButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cadastrarLivroButton.setLabel("Cadastrar Livro");
        cadastrarLivroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarLivroButtonActionPerformed(evt);
            }
        });

        cadastrarUsuarioButton1.setText("Cadastrar usuário");
        cadastrarUsuarioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarUsuarioButton1ActionPerformed(evt);
            }
        });

        managinglife.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        managinglife.setText("Seja bem vindo Administrador.");

        managinglife1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        managinglife1.setText("Painel Admin");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Screenshot_1.png"))); // NOI18N

        vizualizarLivroButton2.setText("Vizualizar Livros");
        vizualizarLivroButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vizualizarLivroButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(cadastrarUsuarioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cadastrarLivroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(managinglife1)
                        .addGap(61, 61, 61))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(managinglife)
                        .addGap(88, 88, 88))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(vizualizarLivroButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(managinglife1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(managinglife, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cadastrarUsuarioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarLivroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vizualizarLivroButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarLivroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarLivroButtonActionPerformed
        var cadastroLivro = new CadastroLivro(properties, logado);
        cadastroLivro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cadastrarLivroButtonActionPerformed

    private void cadastrarUsuarioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarUsuarioButton1ActionPerformed
        // TODO add your handling code here:
//        if(logado.getId_tipo_usuario() == 1) {
            var cut = new CadastroUsuarioVIEW(properties, logado);
            cut.setVisible(true);
            this.dispose();
//        } else {
//            JOptionPane.showMessageDialog(null, "Só administradores podem cadastrar usuários");
//
//        }
    }//GEN-LAST:event_cadastrarUsuarioButton1ActionPerformed

    private void vizualizarLivroButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vizualizarLivroButton2ActionPerformed
        var vizualizarLivro = new VizualizacaoLivros();
        vizualizarLivro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vizualizarLivroButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarLivroButton;
    private javax.swing.JButton cadastrarUsuarioButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel managinglife;
    private javax.swing.JLabel managinglife1;
    private javax.swing.JButton vizualizarLivroButton2;
    // End of variables declaration//GEN-END:variables
}