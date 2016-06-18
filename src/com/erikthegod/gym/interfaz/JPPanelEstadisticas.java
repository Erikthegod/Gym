package com.erikthegod.gym.interfaz;

import com.erikthegod.gym.modelo.Datos;
import com.erikthegod.gym.modelo.Ejercicios;
import com.erikthegod.gym.modelo.Personas;
import com.erikthegod.gym.interfaz.JFVentana;
import com.erikthegod.gym.persistencia.GestorBBDD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author kinton
 */
public class JPPanelEstadisticas extends javax.swing.JPanel {

    private JFVentana jfe;
    Personas per = new Personas();
    Ejercicios ejer = new Ejercicios();
    Datos dat = new Datos();
    GestorBBDD gest = new GestorBBDD();
    ArrayList<Datos> datos = new ArrayList();
    ArrayList<Datos> pesos = new ArrayList();
    private ArrayList<Ejercicios> ejercicios = new ArrayList();
    private ArrayList<Personas> personas = new ArrayList();

    public JPPanelEstadisticas(JFVentana _jfe) {
        try {
            initComponents();
            this.jfe = _jfe;
            personas = gest.recogerPersonas();
            for (int i = 0; i < personas.size(); i++) {
                jcbPersona.addItem(personas.get(i).getNombre());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JPPanelEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JPPanelEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbGenerar = new javax.swing.JButton();
        jcbPersona = new javax.swing.JComboBox<>();
        jcbEjercicio = new javax.swing.JComboBox<>();
        jcbPeso = new javax.swing.JComboBox<>();
        jbSalir = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        jbGenerar.setText("Generar");
        jbGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbGenerarActionPerformed(evt);
            }
        });

        jcbPersona.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPersonaActionPerformed(evt);
            }
        });

        jcbEjercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbEjercicioActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jbGenerar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcbPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jbSalir)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jbGenerar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jcbPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addGap(63, 63, 63))
        );

        add(jPanel1, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jbGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbGenerarActionPerformed

        try {
            DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();
            datos = gest.recogerDatos((String) jcbPersona.getSelectedItem(), (String) jcbEjercicio.getSelectedItem(), (String) jcbPeso.getSelectedItem());
            for (int i = 0; i < datos.size(); i++) {
                line_chart_dataset.addValue(datos.get(i).getVelocidad(), "velocidad", datos.get(i).getFecha());
            }
            // Creando el Grafico
            JFreeChart chart = ChartFactory.createLineChart("Progresión",
                    "Fecha", "Velocidad", line_chart_dataset, PlotOrientation.VERTICAL,
                    true, true, false);

            // Mostrar Grafico
            ChartPanel chartPanel = new ChartPanel(chart);
            this.jfe.panel4.add(chartPanel);
            this.jfe.panel4.validate();
            datos.clear();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JPPanelEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JPPanelEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jbGenerarActionPerformed

    private void jcbPersonaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPersonaActionPerformed
        try {
            ejercicios = new ArrayList();
            jcbEjercicio.removeAllItems();
            ejercicios = gest.recogerEjerciciosPesona((String) jcbPersona.getSelectedItem());
            for (int i = 0; i < ejercicios.size(); i++) {
                jcbEjercicio.addItem(ejercicios.get(i).getNombre());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JPPanelEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JPPanelEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbPersonaActionPerformed

    private void jcbEjercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbEjercicioActionPerformed
        try {
            // TODO add your handling code here:
            jcbPeso.removeAllItems();
            pesos = gest.recogerPesos((String) jcbPersona.getSelectedItem(), (String) jcbEjercicio.getSelectedItem());
            for (int i = 0; i < pesos.size(); i++) {
                jcbPeso.addItem(pesos.get(i).getPeso());
            }
            pesos.clear();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JPPanelEstadisticas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbEjercicioActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        this.jfe.cambiaPanel("p1");
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbGenerar;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbEjercicio;
    private javax.swing.JComboBox<String> jcbPersona;
    private javax.swing.JComboBox<String> jcbPeso;
    // End of variables declaration//GEN-END:variables
}
