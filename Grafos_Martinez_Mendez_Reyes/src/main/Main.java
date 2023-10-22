/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package main;
import java.io.File;
import java.io.FileReader;
import javax.swing.JFileChooser;    
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author mariv
 */
public class Main extends javax.swing.JFrame {
    private User user = new User();
    private String [] filetxt;
    private File direcciontxt;
    private boolean savetxt= false;

    
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

    }

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 153, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre Grafos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 310, -1));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 51));
        jButton1.setText("Cargar Archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, -1, -1));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 51));
        jButton2.setText("Mostrar Grafos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 51));
        jButton3.setText("Modificar Grafos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 410, -1, -1));

        jButton5.setBackground(new java.awt.Color(204, 204, 204));
        jButton5.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jButton5.setForeground(new java.awt.Color(0, 0, 51));
        jButton5.setText("Guardar Cambios");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 6, -1, 20));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 160, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pictures/ImagenMain.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 710, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        if (user.getGrafo() != null){
            String contenidonew="";
            for (int i = 0; i < filetxt.length; i++) {
                contenidonew = contenidonew+filetxt[i].replaceAll("\\p{C}", "")+"\n";
            }
            user.ActualizarFile(direcciontxt, contenidonew);
            JOptionPane.showMessageDialog(null, "El archivo se ha actualizado exitosamente.");
            savetxt=true;
        }else{
            JOptionPane.showMessageDialog(null, "ERROR! \n No se ha cargado ningun archivo");
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (user.getGrafo() == null){
            try{
            FileReader lector = new FileReader ("UsuariosOriginal.txt");
            String contenido = "";
            int valor = lector.read( );

            while (valor != -1){
                contenido += (char)valor;
                valor = lector.read( );
            }

            String [] divide = contenido.split("\n");
            filetxt= divide;
            user.Save(filetxt);

            File fichero = new File("UsuariosOriginal.txt");
            setDirecciontxt(fichero);

            } catch (Exception e){
                e.printStackTrace( );
            }
        }

        //Main de la interfaz modify graphs
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModifyGraphs i3 = new ModifyGraphs();
                i3.setDato(user);
                i3.setFiletxt(filetxt);
                i3.setDirecciontxt(direcciontxt);
                i3.setVisible(true);
            }
        });

        // Ocultar esta interfaz
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (user.getGrafo() == null){
            try{
            FileReader lector = new FileReader ("UsuariosOriginal.txt");
            String contenido = "";
            int valor = lector.read( );

            while (valor != -1){
                contenido += (char)valor;
                valor = lector.read( );
            }

            String [] divide = contenido.split("\n");
            filetxt= divide;
            user.Save(filetxt);

            File fichero = new File("UsuariosOriginal.txt");
            setDirecciontxt(fichero);

            } catch (Exception e){
                e.printStackTrace( );
            }
        }
 
        
        // El main de la interfaz de show graphs
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ShowGraphs i2 = new ShowGraphs();
                i2.setDato(user);
                i2.setFiletxt(filetxt);
                i2.setDirecciontxt(direcciontxt);
                i2.setVisible(true);
            }
        });

        // Ocultar esta interfaz
        this.setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if (user.getGrafo() != null && savetxt == false){
            JOptionPane.showMessageDialog(null, "ALERTA! \n Recuerde guardar los cambios antes de subir un nuevo archivo.");
        }else{
            JFileChooser buscador = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        buscador.setFileFilter(filter);

        // Abrimos la ventana
        int seleccion = buscador.showOpenDialog(this);

        // Si el usuario acepta la opcion de archivo
        if (seleccion == JFileChooser.APPROVE_OPTION){
            // Selecciona el fichero
            File fichero = buscador.getSelectedFile( );

            String fileType = buscador.getTypeDescription(fichero);

            try (FileReader lector = new FileReader (fichero) ) {
                String contenido = "";
                int valor = lector.read( );

                while (valor != -1){
                    contenido += (char)valor;
                    valor = lector.read( );
                }

                if (contenido.contains("usuarios") && contenido.contains("relaciones") && (fileType.equals("Text Document")) ||fileType.equals("Documento de texto")){
                    String [] divide = contenido.split("\n");
                    filetxt= divide;
                    user.Save(filetxt);
                    setDirecciontxt(fichero);

                } else {
                    JOptionPane.showMessageDialog(null, "ERROR!\nCargue un archivo valido");
                }

            } catch (Exception e){
                e.printStackTrace( );
            }
        }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    public void setDato(User user){
        this.user = user;
    }
    public void setFiletxt(String[] filetxt) {
        this.filetxt = filetxt;
    }

    public String[] getFiletxt() {
        return filetxt;
    }
    public void setDirecciontxt(File direcciontxt) {
        this.direcciontxt = direcciontxt;
    }
    
        
  
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
