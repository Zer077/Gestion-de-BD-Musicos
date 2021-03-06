/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista.Inicio;

import Controlador.Controlador;
import Vista.Generos;
import Vista.Grupos;
import Vista.Musicos;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author jose_
 */
public class Inicio extends javax.swing.JFrame {

    Controlador c;
    Grupos grupos;
    Generos generos;
    Musicos musicos;

    /**
     * Creates new form Inicio
     *
     * @param controlador
     */
    public Inicio(Controlador controlador) {
        initComponents();
        c = controlador;
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/img/violin.png"));
        setIconImage(icon);
        musicos = new Musicos(this, false, c);
        grupos = new Grupos(this, false, c);
        generos = new Generos(this, false, c);
        this.setLocation(500, 250);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btn_musicos = new javax.swing.JButton();
        btn_grupo = new javax.swing.JButton();
        btn_genero = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btn_cerrar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menú Principal");
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(153, 386));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(153, 386));

        btn_musicos.setBackground(new java.awt.Color(255, 255, 255));
        btn_musicos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_musicos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Musico.png"))); // NOI18N
        btn_musicos.setText("Músicos");
        btn_musicos.setBorder(null);
        btn_musicos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_musicosActionPerformed(evt);
            }
        });

        btn_grupo.setBackground(new java.awt.Color(255, 255, 255));
        btn_grupo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_grupo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Grupo.png"))); // NOI18N
        btn_grupo.setText("Grupos");
        btn_grupo.setBorder(null);
        btn_grupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_grupoActionPerformed(evt);
            }
        });

        btn_genero.setBackground(new java.awt.Color(255, 255, 255));
        btn_genero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_genero.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Genero.png"))); // NOI18N
        btn_genero.setText("Género");
        btn_genero.setBorder(null);
        btn_genero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_generoActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(102, 204, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(153, 55));

        btn_cerrar.setBackground(new java.awt.Color(0, 51, 255));
        btn_cerrar.setFont(btn_cerrar.getFont().deriveFont(btn_cerrar.getFont().getSize()+7f));
        btn_cerrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cerrar.setText("CERRAR");
        btn_cerrar.setBorder(null);
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_cerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_grupo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_genero, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btn_musicos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btn_musicos, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_grupo)
                        .addGap(18, 18, 18)
                        .addComponent(btn_genero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
                    .addComponent(jSeparator1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 396, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
       private void btn_musicosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_musicosActionPerformed
        new Musicos(this, rootPaneCheckingEnabled, c);    }//GEN-LAST:event_btn_musicosActionPerformed
*
     */
    private void btn_musicosActionPerformed(java.awt.event.ActionEvent evt) {
        musicos.setVisible(true);
        grupos.setVisible(false);
        generos.setVisible(false);

    }

    private void btn_grupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_grupoActionPerformed
        grupos.setVisible(true);
        musicos.setVisible(false);
        generos.setVisible(false);

    }//GEN-LAST:event_btn_grupoActionPerformed

    private void btn_generoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_generoActionPerformed
        generos.setVisible(true);
        grupos.setVisible(false);
        musicos.setVisible(false);

    }//GEN-LAST:event_btn_generoActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btn_cerrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_genero;
    private javax.swing.JButton btn_grupo;
    private javax.swing.JButton btn_musicos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    // End of variables declaration//GEN-END:variables
}
