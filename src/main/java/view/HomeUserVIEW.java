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
public class HomeUserVIEW extends javax.swing.JFrame {

    private Properties properties;

    Usuario logado;

    /**
     * Creates new form PrincipalAdmVIEW
     */
    public HomeUserVIEW() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public HomeUserVIEW(Properties properties, Usuario logado) {
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

        vizualizarLivroButton = new javax.swing.JButton();
        cadastrarLivrosButton = new javax.swing.JButton();
        managinglife = new javax.swing.JLabel();
        managinglife1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        vizualizarLivroButton.setText("Vizualizar Livros");
        vizualizarLivroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vizualizarLivroButtonActionPerformed(evt);
            }
        });

        cadastrarLivrosButton.setText("Cadastrar Livros");
        cadastrarLivrosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarLivrosButtonActionPerformed(evt);
            }
        });

        managinglife.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
        managinglife.setText("Seja bem vindo novamente.");

        managinglife1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        managinglife1.setText("Managing-Life ");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Screenshot_1.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(cadastrarLivrosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vizualizarLivroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(managinglife1)
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(managinglife)
                        .addGap(103, 103, 103))))
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
                    .addComponent(cadastrarLivrosButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(vizualizarLivroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vizualizarLivroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vizualizarLivroButtonActionPerformed
        var cadastroLivro = new CadastroLivro();
        cadastroLivro.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_vizualizarLivroButtonActionPerformed

    private void cadastrarLivrosButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarLivrosButtonActionPerformed
        // TODO add your handling code here:
        var cut = new CadastroUsuarioVIEW(properties, logado);
        cut.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cadastrarLivrosButtonActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cadastrarLivrosButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel managinglife;
    private javax.swing.JLabel managinglife1;
    private javax.swing.JButton vizualizarLivroButton;
    // End of variables declaration//GEN-END:variables
}
