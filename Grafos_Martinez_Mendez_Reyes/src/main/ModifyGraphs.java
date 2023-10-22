/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;

import java.io.File;
import javax.swing.JOptionPane;

/**
 *
 * @author mariv
 */
public class ModifyGraphs extends javax.swing.JFrame {
    User user = new User();
    private String [] filetxt;
    private File direcciontxt;
    
    public void setFiletxt(String[] filetxt) {
        this.filetxt = filetxt;
    }

    public void setDirecciontxt(File direcciontxt) {
        this.direcciontxt = direcciontxt;
    }
    

    /**
     * Creates new form ModifyGraphs
     */
    public ModifyGraphs() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        TextNombre = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        AgregarNombre = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        Box1 = new javax.swing.JComboBox<>();
        Box2 = new javax.swing.JComboBox<>();
        Relacionar = new javax.swing.JButton();
        Llenarbox = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modificar Usuarios de Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 30, 360, -1));

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Eliminar Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));

        jTextField1.setBackground(new java.awt.Color(153, 153, 153));
        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(102, 102, 102));
        jTextField1.setText("Agrege el nombre de usuario (@ejemplo)");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 180, 254, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 51));
        jButton1.setText("Eliminar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 180, -1, -1));

        TextNombre.setBackground(new java.awt.Color(255, 255, 255));
        TextNombre.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        TextNombre.setForeground(new java.awt.Color(102, 102, 102));
        TextNombre.setText("Agrege el nombre de usuario (@ejemplo)");
        TextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextNombreActionPerformed(evt);
            }
        });
        getContentPane().add(TextNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 51));
        jButton2.setText("< --");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nueva Relacion ");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        AgregarNombre.setBackground(new java.awt.Color(255, 255, 255));
        AgregarNombre.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        AgregarNombre.setForeground(new java.awt.Color(0, 0, 51));
        AgregarNombre.setText("Agregar");
        AgregarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarNombreActionPerformed(evt);
            }
        });
        getContentPane().add(AgregarNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 300, -1, -1));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Agregar Usuario");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        Box1.setBackground(new java.awt.Color(255, 255, 255));
        Box1.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Box1.setForeground(new java.awt.Color(0, 0, 51));
        getContentPane().add(Box1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, -1));

        Box2.setBackground(new java.awt.Color(255, 255, 255));
        Box2.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Box2.setForeground(new java.awt.Color(0, 0, 51));
        getContentPane().add(Box2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 370, -1, -1));

        Relacionar.setBackground(new java.awt.Color(255, 255, 255));
        Relacionar.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Relacionar.setForeground(new java.awt.Color(0, 0, 51));
        Relacionar.setText("Relacionar");
        Relacionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RelacionarActionPerformed(evt);
            }
        });
        getContentPane().add(Relacionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, -1, -1));

        Llenarbox.setBackground(new java.awt.Color(255, 255, 255));
        Llenarbox.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        Llenarbox.setForeground(new java.awt.Color(0, 0, 51));
        Llenarbox.setText("Ver Usuarios");
        Llenarbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LlenarboxActionPerformed(evt);
            }
        });
        getContentPane().add(Llenarbox, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 80, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/ImagenModify.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    
    public void setDato(User user){
        this.user = user;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // El main de la interfaz principal
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Main main = new Main();
                main.setDato(user);
                main.setFiletxt(filetxt);
                main.setDirecciontxt(direcciontxt);
                main.setVisible(true);
            }
        });
        
        // Ocultar esta interfaz
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void AgregarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgregarNombreActionPerformed
        Grafo nuevografo = new Grafo(filetxt.length+1);
        String nombre = TextNombre.getText();
        TextNombre.setText("Agrege el nombre de usuario (@ejemplo)");
        setFiletxt(nuevografo.AñadirUsuario(nombre, filetxt));
        user.Save(filetxt);
        for (int i = 1; !filetxt[i].replaceAll("\\p{C}", "").equals("relaciones"); i++) {
                 Box1.addItem(filetxt[i].replaceAll("\\p{C}", ""));
                 Box2.addItem(filetxt[i].replaceAll("\\p{C}", ""));
                     }

    }//GEN-LAST:event_AgregarNombreActionPerformed

    private void TextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextNombreActionPerformed

    private void LlenarboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LlenarboxActionPerformed
        for (int i = 1; !filetxt[i].replaceAll("\\p{C}", "").equals("relaciones"); i++) {
                 Box1.addItem(filetxt[i].replaceAll("\\p{C}", ""));
                 Box2.addItem(filetxt[i].replaceAll("\\p{C}", ""));
                     }
    }//GEN-LAST:event_LlenarboxActionPerformed

    private void RelacionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RelacionarActionPerformed
        Grafo nuevografo = new Grafo(filetxt.length+1);
        if(Box1.getSelectedItem().toString().equals(Box2.getSelectedItem())){
            JOptionPane.showMessageDialog(null, "Error! \n Se deben relacionar ususarios diferentes.");
        }else{
            String relacion = Box1.getSelectedItem().toString()+", "+Box2.getSelectedItem();
            setFiletxt(nuevografo.RelacionarUsuario(relacion, filetxt));
            user.Save(filetxt);
        }

    }//GEN-LAST:event_RelacionarActionPerformed

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
            java.util.logging.Logger.getLogger(ModifyGraphs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModifyGraphs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModifyGraphs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModifyGraphs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModifyGraphs().setVisible(true);
            }
        });
    }
    
    public boolean Check(){
        int maximo = 10;
        
        if (maximo-user.getSize() > 0){
            return true;
        } else {
            return false;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AgregarNombre;
    private javax.swing.JComboBox<String> Box1;
    private javax.swing.JComboBox<String> Box2;
    private javax.swing.JButton Llenarbox;
    private javax.swing.JButton Relacionar;
    private javax.swing.JTextField TextNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
