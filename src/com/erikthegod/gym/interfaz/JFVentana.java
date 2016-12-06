/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.erikthegod.gym.interfaz;

import com.erikthegod.gym.modelo.Personas;
import java.awt.CardLayout;

/**
 *
 * @author ErikTheGod
 */
public class JFVentana extends javax.swing.JFrame {

    /**
     * Creates new form JFVentana
     */
    JPPanel panel = new JPPanel(this);
    JPPanelCrearRutina panel2 = new JPPanelCrearRutina(this);
    JPPanelUsarRutina panel3 = new JPPanelUsarRutina(this);
    JPPanelEstadisticas panel4 = new JPPanelEstadisticas(this);
    JPRegistro panelRegistro = new JPRegistro(this);
    JPPanelIniciarSesion panelInicioSesion = new JPPanelIniciarSesion(this);

    public JFVentana() {
        initComponents();
        this.getContentPane().add(panelInicioSesion, "p6");
        this.getContentPane().add(panel, "p1");
        this.getContentPane().add(panel2, "p2");
        this.getContentPane().add(panel3, "p3");
        this.getContentPane().add(panel4, "p4");
        this.getContentPane().add(panelRegistro, "p5");
        setBounds(100, 100, 600, 500);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFVentana().setVisible(true);
            }
        });
    }

    protected void cambiaPanel(String nombrePanel) {
        CardLayout c = (CardLayout) (getContentPane().getLayout());
        c.show(getContentPane(), nombrePanel);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
