/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym.interfaz;

import com.erikthegod.gym.modelo.Ejercicios;
import com.erikthegod.gym.modelo.Rutina;
import com.erikthegod.gym.modelo.Series;
import com.erikthegod.gym.persistencia.GestorBBDD;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;

/**
 *
 * @author ErikTheGod
 */
public class JPPanelCrearRutina extends javax.swing.JPanel {

    private JFVentana jfe;
    private String nombreRutina;
    private String nombreEjercicio;
    private int repeticiones;
    private int rmSer;

    private Rutina rut = new Rutina();
    private Ejercicios eje = new Ejercicios();
    private Series ser;
    private ArrayList<Series> series;
    private ArrayList<Ejercicios> ejerciciosRutina = new ArrayList();
    private ArrayList<Ejercicios> ejercicios = new ArrayList();
    private GestorBBDD gest = new GestorBBDD();
    private ArrayList<Rutina> nombresRutinas = new ArrayList();

    public JPPanelCrearRutina(JFVentana _jfe) {
        try {
            this.jfe = _jfe;
            series = new ArrayList();
            initComponents();
            ejercicios = gest.recogerEjercicios();
            for (int i = 0; i < ejercicios.size(); i++) {
                jcbEjercicios.addItem(ejercicios.get(i).getNombre());
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JPPanelCrearRutina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
        jbSalir = new javax.swing.JButton();

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

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jcbEjercicios, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(198, 198, 198))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(248, 248, 248))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jtfRutina, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbAniadirEjercicio)
                            .addComponent(jbAniadirSerie))
                        .addGap(28, 28, 28))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(158, 158, 158))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jbSalir)
                        .addContainerGap())))
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
                .addGap(18, 18, 18)
                .addComponent(jbAniadirEjercicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrearRutina)
                    .addComponent(jtfRutina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSalir)
                .addGap(9, 9, 9))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbAniadirEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAniadirEjercicioActionPerformed
        if (series.size() == 0) {
            JOptionPane.showMessageDialog(null, "No es posible crear un ejercicio sin haber añadido ninguna serie");
        } else {
            nombreEjercicio = (String) jcbEjercicios.getSelectedItem();
            eje = new Ejercicios(nombreEjercicio, series);
            ejerciciosRutina.add(eje);
            JOptionPane.showMessageDialog(null, "Ejercicio añadido");
            series = new ArrayList();
        }
    }//GEN-LAST:event_jbAniadirEjercicioActionPerformed

    private void jbCrearRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearRutinaActionPerformed
        try {
            if (ejerciciosRutina.size() == 0) {
                JOptionPane.showMessageDialog(null, "No es posible crear una rutina sin haber añadido ningun ejercicio");
            } else if (jtfRutina.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Debe introducir un nombre a la rutina");
            } else {
                nombreRutina = jtfRutina.getText();
                gest.crearRutina(ejerciciosRutina, nombreRutina);
                ejerciciosRutina.clear();
                series = new ArrayList();
                JOptionPane.showMessageDialog(null, "Rutina creada");
                jtfRutina.setText("");
            }

        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(JPPanelCrearRutina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbCrearRutinaActionPerformed

    private void jbAniadirSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAniadirSerieActionPerformed
        // TODO add your handling code here:
        repeticiones = (int) jsRepeticiones.getValue();
        rmSer = parseInt((String) jcbRM.getSelectedItem());
        ser = new Series(repeticiones, rmSer);
        series.add(ser);
        JOptionPane.showMessageDialog(null, "Serie añadida");
    }//GEN-LAST:event_jbAniadirSerieActionPerformed

    private void jbUsarRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUsarRutinaActionPerformed
        try {
            // TODO add your handling code here:
            nombresRutinas.clear();
            JPPanelUsarRutina.jcbRutina.removeAllItems();
            nombresRutinas = gest.recogerNombreRutina();
            for (int i = 0; i < nombresRutinas.size(); i++) {
                JPPanelUsarRutina.jcbRutina.addItem(nombresRutinas.get(i).getNombre());
            }
            this.jfe.cambiaPanel("p3");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JPPanelCrearRutina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbUsarRutinaActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        this.jfe.cambiaPanel("p1");
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbAniadirEjercicio;
    private javax.swing.JButton jbAniadirSerie;
    private javax.swing.JButton jbCrearRutina;
    private javax.swing.JButton jbSalir;
    private javax.swing.JButton jbUsarRutina;
    private javax.swing.JComboBox<String> jcbEjercicios;
    private javax.swing.JComboBox<String> jcbRM;
    private javax.swing.JSpinner jsRepeticiones;
    private javax.swing.JTextField jtfRutina;
    // End of variables declaration//GEN-END:variables
}
