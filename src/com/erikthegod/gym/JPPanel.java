/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kinton
 */
public class JPPanel extends javax.swing.JPanel {

    /**
     * Creates new form JPPanel
     */
    public JPPanel() {
        try {
            initComponents();
            per.recogerPersonas();
            ejer.recogerEjercicios();
            for (int i = 0; i < Ejercicios.ejercicios.size(); i++) {
                jcbEjercicios.addItem(Ejercicios.ejercicios.get(i).getNombre());
            }
            for (int i = 0; i < Personas.personas.size(); i++) {
                jcbNombre.addItem(Personas.personas.get(i).getNombre());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error conectar");
        }
    }
    Calculator cal = new Calculator();
    Personas per = new Personas();
    Ejercicios ejer = new Ejercicios();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbEjercicios = new javax.swing.JComboBox<>();
        jbObtener = new javax.swing.JButton();
        jtfSegundos = new javax.swing.JTextField();
        jtfPeso = new javax.swing.JTextField();
        jsRM = new javax.swing.JSpinner();
        jcbNombre = new javax.swing.JComboBox<>();
        jlSegundos = new javax.swing.JLabel();
        jlPesoUsado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jbCrearRut = new javax.swing.JButton();
        jbUsarRutina = new javax.swing.JButton();

        jbObtener.setText("Obtener");
        jbObtener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbObtenerActionPerformed(evt);
            }
        });

        jtfPeso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesoActionPerformed(evt);
            }
        });

        jlSegundos.setText("Segundos");

        jlPesoUsado.setText("Peso Usado");

        jLabel1.setText("Porcentaje RM deseado");

        jbCrearRut.setText("Crear Rutina");

        jbUsarRutina.setText("Usar Rutina");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbObtener)
                            .addGap(58, 58, 58))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jcbEjercicios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCrearRut)
                        .addGap(38, 38, 38)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbUsarRutina)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jcbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlSegundos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlPesoUsado)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jsRM, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(21, 21, 21))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(21, 21, 21))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrearRut)
                    .addComponent(jbUsarRutina))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbEjercicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbObtener)
                    .addComponent(jtfSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlSegundos))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPesoUsado)
                    .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbObtenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbObtenerActionPerformed
        try {
            // TODO add your handling code here:
            cal.insertarDato((String) jcbEjercicios.getSelectedItem(), (String) jcbNombre.getSelectedItem(), jtfPeso.getText(),jtfSegundos.getText());
            cal.calculoTotal((String) jcbEjercicios.getSelectedItem(), jtfSegundos.getText(), jtfPeso.getText(), (int) jsRM.getValue(), (String) jcbNombre.getSelectedItem());
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, " Error");
        } catch (SQLException ex) {
            Logger.getLogger(JPPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbObtenerActionPerformed

    private void jtfPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPesoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbCrearRut;
    private javax.swing.JButton jbObtener;
    private javax.swing.JButton jbUsarRutina;
    private javax.swing.JComboBox<String> jcbEjercicios;
    private javax.swing.JComboBox<String> jcbNombre;
    private javax.swing.JLabel jlPesoUsado;
    private javax.swing.JLabel jlSegundos;
    private javax.swing.JSpinner jsRM;
    private javax.swing.JTextField jtfPeso;
    private javax.swing.JTextField jtfSegundos;
    // End of variables declaration//GEN-END:variables
}
