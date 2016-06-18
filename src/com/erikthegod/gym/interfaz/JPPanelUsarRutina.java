package com.erikthegod.gym.interfaz;

import com.erikthegod.gym.modelo.Calculator;
import com.erikthegod.gym.modelo.Ejercicios;
import com.erikthegod.gym.modelo.Personas;
import com.erikthegod.gym.modelo.Rutina;
import com.erikthegod.gym.interfaz.JFVentana;
import com.erikthegod.gym.persistencia.GestorBBDD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kinton
 */
public class JPPanelUsarRutina extends javax.swing.JPanel {

    private JFVentana jfe;
    Vector vNombres;
    DefaultTableModel dtm;
    double pesoDeseado;
    Personas per = new Personas();
    Ejercicios ejer = new Ejercicios();
    Rutina rut = new Rutina();
    Calculator cal = new Calculator();
    GestorBBDD gest = new GestorBBDD();
    private ArrayList<Rutina> nombresRutinas = new ArrayList();
    private ArrayList<Personas> personas = new ArrayList();
    private ArrayList<Ejercicios> ejercicios = new ArrayList();

    public JPPanelUsarRutina(JFVentana _jfe) {
        try {
            initComponents();
            this.jfe = _jfe;
            vNombres = new Vector();
            vNombres.add("Serie");
            vNombres.add("RM");
            vNombres.add("Repeticiones");
            vNombres.add("Peso");
            dtm = new DefaultTableModel(vNombres, 0);
            jtSeries.setModel(dtm);
            initComponents();
            nombresRutinas = gest.recogerNombreRutina();
            for (int i = 0; i < nombresRutinas.size(); i++) {
                jcbRutina.addItem(nombresRutinas.get(i).getNombre());
            }
            personas = gest.recogerPersonas();
            for (int i = 0; i < personas.size(); i++) {
                jcbPersona.addItem(personas.get(i).getNombre());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JPPanelUsarRutina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JPPanelUsarRutina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jcbRutina = new javax.swing.JComboBox<>();
        jcbEjercicio = new javax.swing.JComboBox<>();
        jcbPersona = new javax.swing.JComboBox<>();
        jtfSegundos = new javax.swing.JTextField();
        jtfPeso = new javax.swing.JTextField();
        jbCalcular = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtSeries = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jbSalir = new javax.swing.JButton();

        jcbRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbRutinaActionPerformed(evt);
            }
        });

        jbCalcular.setText("Calcular");
        jbCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCalcularActionPerformed(evt);
            }
        });

        jtSeries.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtSeries);

        jLabel1.setText("Segundos");

        jLabel2.setText("Peso");

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcbRutina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbEjercicio, 0, 134, Short.MAX_VALUE)
                            .addComponent(jcbPersona, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(23, 23, 23)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfSegundos, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                                    .addComponent(jtfPeso))
                                .addGap(24, 24, 24))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jbCalcular)
                                .addContainerGap(134, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jbSalir))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(24, 24, 24))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbRutina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbCalcular))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(jbSalir)
                .addContainerGap())
        );

        jcbRutina.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void jbCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularActionPerformed
        try {
            // TODO add your handling code here:
            gest.insertarDato((String) jcbEjercicio.getSelectedItem(), (String) jcbPersona.getSelectedItem(), jtfPeso.getText(), jtfSegundos.getText());
            dtm = new DefaultTableModel(vNombres, 0);
            jtSeries.setModel(dtm);
            ejer = gest.recogerEjercicioRutina((String) jcbRutina.getSelectedItem(), (String) jcbEjercicio.getSelectedItem());
            for (int i = 0; i < ejer.getSeries().size(); i++) {
                pesoDeseado = cal.calculoTotal(ejer.getNombre(), jtfSegundos.getText(), jtfPeso.getText(), ejer.getSeries().get(i).getRmSerie(), (String) jcbPersona.getSelectedItem());
                dtm.setRowCount(dtm.getRowCount() + 1);
                jtSeries.setValueAt(i + 1, i, 0);
                jtSeries.setValueAt(ejer.getSeries().get(i).getRmSerie(), i, 1);
                jtSeries.setValueAt(ejer.getSeries().get(i).getRepeticiones(), i, 2);
                jtSeries.setValueAt(pesoDeseado, i, 3);
            }
            ejer.getSeries().clear();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JPPanelUsarRutina.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jbCalcularActionPerformed

    private void jcbRutinaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbRutinaActionPerformed
        try {
            ejercicios = new ArrayList();
            jcbEjercicio.removeAllItems();
            ejercicios = gest.recogerNombreEjerciciosRutina((String) jcbRutina.getSelectedItem());
            for (int i = 0; i < ejercicios.size(); i++) {
                jcbEjercicio.addItem(ejercicios.get(i).getNombre());
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JPPanelUsarRutina.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JPPanelUsarRutina.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jcbRutinaActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        // TODO add your handling code here:
        this.jfe.cambiaPanel("p1");
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbCalcular;
    private javax.swing.JButton jbSalir;
    private javax.swing.JComboBox<String> jcbEjercicio;
    private javax.swing.JComboBox<String> jcbPersona;
    protected static javax.swing.JComboBox<String> jcbRutina;
    private javax.swing.JTable jtSeries;
    private javax.swing.JTextField jtfPeso;
    private javax.swing.JTextField jtfSegundos;
    // End of variables declaration//GEN-END:variables
}
