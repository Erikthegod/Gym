package com.erikthegod.gym.interfaz;

import com.erikthegod.gym.modelo.Calculator;
import com.erikthegod.gym.modelo.Ejercicios;
import com.erikthegod.gym.modelo.Personas;
import com.erikthegod.gym.modelo.Rutina;
import com.erikthegod.gym.persistencia.GestorBBDD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ErikTheGod
 */
public class JPPanelUsarRutina extends javax.swing.JPanel {

    private JFVentana jfe;
    private Vector vNombres;
    private DefaultTableModel dtm;
    private double pesoDeseado;
    private Personas per = new Personas();
    private Ejercicios ejer = new Ejercicios();
    private Rutina rut = new Rutina();
    private Calculator cal = new Calculator();
    private GestorBBDD gest = new GestorBBDD();
    private ArrayList<Rutina> nombresRutinas = new ArrayList();
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
        jlUsuario = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 204, 255));

        jcbRutina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbRutinaActionPerformed(evt);
            }
        });

        jbCalcular.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
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

        jbSalir.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jcbRutina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jcbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jbCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbEjercicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbRutina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbCalcular, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbPersona, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jtfSegundos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jcbRutina.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void jbCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCalcularActionPerformed
        try {
            if (gest.usuario.getNombre().compareTo("Entrenador") == 0 && gest.usuario.getPass().compareTo("Entrenador") == 0) {
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
            } else {
                gest.insertarDato((String) jcbEjercicio.getSelectedItem(), gest.usuario.getNombre(), jtfPeso.getText(), jtfSegundos.getText());
                dtm = new DefaultTableModel(vNombres, 0);
                jtSeries.setModel(dtm);
                ejer = gest.recogerEjercicioRutina((String) jcbRutina.getSelectedItem(), (String) jcbEjercicio.getSelectedItem());
                for (int i = 0; i < ejer.getSeries().size(); i++) {
                    pesoDeseado = cal.calculoTotal(ejer.getNombre(), jtfSegundos.getText(), jtfPeso.getText(), ejer.getSeries().get(i).getRmSerie(), gest.usuario.getNombre());
                    dtm.setRowCount(dtm.getRowCount() + 1);
                    jtSeries.setValueAt(i + 1, i, 0);
                    jtSeries.setValueAt(ejer.getSeries().get(i).getRmSerie(), i, 1);
                    jtSeries.setValueAt(ejer.getSeries().get(i).getRepeticiones(), i, 2);
                    jtSeries.setValueAt(pesoDeseado, i, 3);
                }
                ejer.getSeries().clear();
            }
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
    protected static javax.swing.JComboBox<String> jcbPersona;
    protected static javax.swing.JComboBox<String> jcbRutina;
    protected static javax.swing.JLabel jlUsuario;
    private javax.swing.JTable jtSeries;
    private javax.swing.JTextField jtfPeso;
    private javax.swing.JTextField jtfSegundos;
    // End of variables declaration//GEN-END:variables
}
