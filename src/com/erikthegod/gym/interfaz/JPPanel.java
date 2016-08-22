package com.erikthegod.gym.interfaz;

import com.erikthegod.gym.modelo.Calculator;
import com.erikthegod.gym.modelo.Ejercicios;
import com.erikthegod.gym.modelo.Personas;
import com.erikthegod.gym.persistencia.GestorBBDD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author ErikTheGod
 */
public class JPPanel extends javax.swing.JPanel {

    private JFVentana jfe;
    private double pesoDeseado;
    private Calculator cal = new Calculator();
    private GestorBBDD gest = new GestorBBDD();
    private ArrayList<Ejercicios> ejercicios = new ArrayList();
    

    public JPPanel(JFVentana _jfe) {
        try {
            initComponents();
            this.jfe = _jfe;
            ejercicios = gest.recogerEjercicios();
            for (int i = 0; i < ejercicios.size(); i++) {
                jcbEjercicios.addItem(ejercicios.get(i).getNombre());
            }          
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error conectar");
        }
    }

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
        jbEstadisticas = new javax.swing.JButton();
        jlPesoDeseado = new javax.swing.JLabel();
        jlPeso = new javax.swing.JLabel();

        jcbEjercicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEjerciciosActionPerformed(evt);
            }
        });

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

        jcbNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbNombreActionPerformed(evt);
            }
        });

        jlSegundos.setText("Segundos");

        jlPesoUsado.setText("Peso Usado");

        jLabel1.setText("Porcentaje RM deseado");

        jbCrearRut.setText("Crear Rutina");
        jbCrearRut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCrearRutActionPerformed(evt);
            }
        });

        jbUsarRutina.setText("Usar Rutina");
        jbUsarRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbUsarRutinaActionPerformed(evt);
            }
        });

        jbEstadisticas.setText("Estadisticas");
        jbEstadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEstadisticasActionPerformed(evt);
            }
        });

        jlPesoDeseado.setText("Peso Deseado");

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
                    .addComponent(jlPesoDeseado)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jbUsarRutina)
                            .addGap(38, 38, 38)
                            .addComponent(jbEstadisticas)
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
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jlPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGap(21, 21, 21)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCrearRut)
                    .addComponent(jbUsarRutina)
                    .addComponent(jbEstadisticas))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPesoDeseado)
                    .addComponent(jlPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbObtenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbObtenerActionPerformed
        try {
            if (gest.usuario.getNombre().compareTo("Entrenador") == 0 && gest.usuario.getPass().compareTo("Entrenador") == 0) {
                gest.insertarDato((String) jcbEjercicios.getSelectedItem(), (String) jcbNombre.getSelectedItem(), jtfPeso.getText(), jtfSegundos.getText());
                pesoDeseado = cal.calculoTotal((String) jcbEjercicios.getSelectedItem(), jtfSegundos.getText(), jtfPeso.getText(), (int) jsRM.getValue(), (String) jcbNombre.getSelectedItem());
                jlPeso.setText(Double.toString(pesoDeseado));
            } else {
                gest.insertarDato((String) jcbEjercicios.getSelectedItem(), gest.usuario.getNombre(), jtfPeso.getText(), jtfSegundos.getText());
                pesoDeseado = cal.calculoTotal((String) jcbEjercicios.getSelectedItem(), jtfSegundos.getText(), jtfPeso.getText(), (int) jsRM.getValue(), gest.usuario.getNombre());
                jlPeso.setText(Double.toString(pesoDeseado));
            }
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, " Error");
        } catch (SQLException ex) {
            Logger.getLogger(JPPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbObtenerActionPerformed

    private void jtfPesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesoActionPerformed

    }//GEN-LAST:event_jtfPesoActionPerformed

    private void jbCrearRutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCrearRutActionPerformed

        this.jfe.cambiaPanel("p2");
    }//GEN-LAST:event_jbCrearRutActionPerformed

    private void jbUsarRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbUsarRutinaActionPerformed

        this.jfe.cambiaPanel("p3");
    }//GEN-LAST:event_jbUsarRutinaActionPerformed

    private void jbEstadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEstadisticasActionPerformed

        this.jfe.cambiaPanel("p4");
    }//GEN-LAST:event_jbEstadisticasActionPerformed

    private void jcbNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbNombreActionPerformed

    }//GEN-LAST:event_jcbNombreActionPerformed

    private void jcbEjerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEjerciciosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbEjerciciosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbCrearRut;
    private javax.swing.JButton jbEstadisticas;
    private javax.swing.JButton jbObtener;
    private javax.swing.JButton jbUsarRutina;
    private javax.swing.JComboBox<String> jcbEjercicios;
    protected static javax.swing.JComboBox<String> jcbNombre;
    private javax.swing.JLabel jlPeso;
    private javax.swing.JLabel jlPesoDeseado;
    private javax.swing.JLabel jlPesoUsado;
    private javax.swing.JLabel jlSegundos;
    private javax.swing.JSpinner jsRM;
    private javax.swing.JTextField jtfPeso;
    private javax.swing.JTextField jtfSegundos;
    // End of variables declaration//GEN-END:variables
}
