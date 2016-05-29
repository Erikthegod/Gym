/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym.interfaz;

import com.erikthegod.gym.Ejercicios;
import com.erikthegod.gym.Rutina;
import com.erikthegod.gym.Series;
import com.erikthegod.gym.interfaz.JFVentana;
import static com.erikthegod.gym.interfaz.JPPanelUsarRutina.jcbRutina;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kinton
 */
public class JPPanel2 extends javax.swing.JPanel {

    /**
     * Creates new form JPPanel2
     */
    private JFVentana jfe;
    String nombreRutina;
    String nombreEjercicio;
    int repeticiones;
    int rmSer;
    Rutina rut = new Rutina();
    Ejercicios eje = new Ejercicios();
    Series ser;
    ArrayList <Series> series ;

    public JPPanel2(JFVentana _jfe) {
        this.jfe = _jfe;
        series = new ArrayList();
        initComponents();
        for (int i = 0; i < Ejercicios.ejercicios.size(); i++) {
            jcbEjercicios.addItem(Ejercicios.ejercicios.get(i).getNombre());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbCrearRutina = new javax.swing.JButton();
        jcbEjercicios = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtfRutina = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jbAniadirEjercicio = new javax.swing.JButton();
        jsRepeticiones = new javax.swing.JSpinner();
        jcbRM = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jbAniadirSerie = new javax.swing.JButton();
        jbUsarRutina = new javax.swing.JButton();

        jbCrearRutina.setText("Crear Rutina");
        jbCrearRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearRutinaActionPerformed(evt);
            }
        });

        jLabel1.setText("Repeticiones");

        jLabel3.setText("Ejercicios");

        jLabel4.setText("Rutina");

        jbAniadirEjercicio.setText("Añadir Ejercicio");
        jbAniadirEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAniadirEjercicioActionPerformed(evt);
            }
        });

        jcbRM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "50", "55", "65", "70", "75", "80", "85", "90", "95", "100" }));

        jLabel5.setText("RM");

        jbAniadirSerie.setText("Añadir Serie");
        jbAniadirSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAniadirSerieActionPerformed(evt);
            }
        });

        jbUsarRutina.setText("Usar Rutina");
        jbUsarRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUsarRutinaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(jbCrearRutina))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jbUsarRutina)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbAniadirEjercicio)
                        .addGap(78, 78, 78))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jtfRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(231, 231, 231))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(255, 255, 255))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jcbEjercicios, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(198, 198, 198))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(248, 248, 248))))
            .addGroup(layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jsRepeticiones, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jLabel5)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jcbRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbAniadirSerie)
                        .addGap(42, 42, 42))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jbUsarRutina))
                .addGap(22, 22, 22)
                .addComponent(jcbEjercicios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jsRepeticiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbRM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbAniadirSerie))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jtfRutina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAniadirEjercicio)
                    .addComponent(jbCrearRutina))
                .addGap(43, 43, 43))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbAniadirEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAniadirEjercicioActionPerformed
        // TODO add your handling code here:
        nombreEjercicio = (String) jcbEjercicios.getSelectedItem();        
        eje = new Ejercicios(nombreEjercicio, series);
        rut.ejerciciosRutina.add(eje);
        series = new ArrayList();
    }//GEN-LAST:event_jbAniadirEjercicioActionPerformed

    private void jbCrearRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearRutinaActionPerformed
        try {
            // TODO add your handling code here:
            nombreRutina = jtfRutina.getText();
            rut.crearRutina(jtfRutina.getText());
            rut.ejerciciosRutina.clear();
            
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(JPPanel2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbCrearRutinaActionPerformed

    private void jbAniadirSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAniadirSerieActionPerformed
        // TODO add your handling code here:
        repeticiones = (int) jsRepeticiones.getValue();
        rmSer =  parseInt((String) jcbRM.getSelectedItem());
        System.out.println(rmSer);
        ser = new Series(repeticiones,rmSer);
        series.add(ser);
    }//GEN-LAST:event_jbAniadirSerieActionPerformed

    private void jbUsarRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUsarRutinaActionPerformed
        try {
            // TODO add your handling code here:
            Rutina.nombresRutinas.clear();
            JPPanelUsarRutina.jcbRutina.removeAllItems();
            rut.recogerNombreRutina();
            for (int i = 0; i < Rutina.nombresRutinas.size(); i++) {
                JPPanelUsarRutina.jcbRutina.addItem(Rutina.nombresRutinas.get(i).getNombre());
            }
            this.jfe.cambiaPanel("p3");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JPPanel2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JPPanel2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbUsarRutinaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbAniadirEjercicio;
    private javax.swing.JButton jbAniadirSerie;
    private javax.swing.JButton jbCrearRutina;
    private javax.swing.JButton jbUsarRutina;
    private javax.swing.JComboBox<String> jcbEjercicios;
    private javax.swing.JComboBox<String> jcbRM;
    private javax.swing.JSpinner jsRepeticiones;
    private javax.swing.JTextField jtfRutina;
    // End of variables declaration//GEN-END:variables
}