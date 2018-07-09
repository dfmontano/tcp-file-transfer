/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filetransferserver;

import java.awt.Image;
import java.io.File;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author cristian mendoza
 */
public class Enviar_imagen extends javax.swing.JFrame {

    /**
     * Creates new form Enviar_imagen
     */
    public String ip, puerto, tamano;
    public File archivo;

    public Enviar_imagen() {
        initComponents();

                ip = (jtip.getText());
                puerto = (jtpuerto.getText());
                jltam.setText(tamano);
                this.setSize(800,500); 
                jLabel4.setVisible(false);
                jltam.setVisible(false);
                jbenviar.setVisible(false);

      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jtip = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtpuerto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jlimagen = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jltam = new javax.swing.JLabel();
        jbenviar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Enviar archivo");
        getContentPane().setLayout(null);

        jtip.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtip.setBorder(null);
        jtip.setMargin(new java.awt.Insets(0, 0, 0, 0));
        getContentPane().add(jtip);
        jtip.setBounds(20, 150, 270, 20);

        jLabel2.setText("Puerto: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 210, 60, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Dirección IP: ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 120, 250, 30);

        jtpuerto.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jtpuerto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtpuerto.setText("4480");
        jtpuerto.setBorder(null);
        jtpuerto.setEnabled(false);
        getContentPane().add(jtpuerto);
        jtpuerto.setBounds(90, 210, 70, 20);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/atributos.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 90, 290, 120);

        jButton1.setText("Seleccionar Archivo");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 130, 240, 30);
        getContentPane().add(jlimagen);
        jlimagen.setBounds(310, 180, 440, 240);

        jLabel4.setText("Tamaño: ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(590, 130, 60, 30);

        jltam.setText("jLabel5");
        getContentPane().add(jltam);
        jltam.setBounds(650, 130, 120, 30);

        jbenviar.setText("Enviar");
        jbenviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbenviarActionPerformed(evt);
            }
        });
        getContentPane().add(jbenviar);
        jbenviar.setBounds(120, 350, 110, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo1.png"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, -10, 785, 480);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/fondo.PNG"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, -30, 880, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(this);
        archivo = file.getSelectedFile();

        int tamano = (int) archivo.length();
        String tam = String.valueOf(tamano);
        jltam.setText(tam + " Bytes");

        String ruta = String.valueOf(archivo);
        URL url = this.getClass().getResource(ruta);
        ImageIcon icono = new ImageIcon(ruta);
        Icon iconoI = new ImageIcon(icono.getImage().getScaledInstance(jlimagen.getWidth(), jlimagen.getHeight(), Image.SCALE_DEFAULT));
        jlimagen.setIcon(iconoI);
        jLabel4.setVisible(true);
        jltam.setVisible(true);
        jbenviar.setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbenviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbenviarActionPerformed
        // TODO add your handling code here:
//        if(ip.length()>0){
        if (jtip.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una Direccion");
        } else {
            ip = jtip.getText();
            System.out.println("dirección2: "+ip);
            String ruta = String.valueOf(archivo);
            EnviarArchivo ea = new EnviarArchivo(ruta);
            ea.ip = jtip.getText();
            ea.enviarArchivo();
            
        }

        //}
//        if (ip.length()==0) {
//            
//    
// 
//
//
//        }
    }//GEN-LAST:event_jbenviarActionPerformed

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
            java.util.logging.Logger.getLogger(Enviar_imagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Enviar_imagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Enviar_imagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Enviar_imagen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Enviar_imagen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton jbenviar;
    private javax.swing.JLabel jlimagen;
    private javax.swing.JLabel jltam;
    private javax.swing.JTextField jtip;
    private javax.swing.JTextField jtpuerto;
    // End of variables declaration//GEN-END:variables
}
