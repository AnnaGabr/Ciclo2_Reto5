/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Acceso.ClienteDAO;
import Modelo.ModeloCliente;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import utils.ConnectionDB;

/**
 *
 * @author Gaby
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    ConnectionDB conn;
    ClienteDAO DAO_cliente;

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        conn = new ConnectionDB();
        DAO_cliente = new ClienteDAO();
        initComponents();
        initNombreUsuarios();
    }
    
    public void initNombreUsuarios(){
        cb_cliUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(DAO_cliente.listaNombreUsuarios()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        df_cliNombre = new javax.swing.JTextField();
        df_cliApellido = new javax.swing.JTextField();
        df_cliEmail = new javax.swing.JTextField();
        df_cliCelular = new javax.swing.JTextField();
        df_cliClave = new javax.swing.JTextField();
        df_cliFecha = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClientes = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        cb_cliUsuario = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario");

        jLabel2.setText("Nombre");

        jLabel3.setText("Apellido");

        jLabel4.setText("Email");

        jLabel5.setText("Celular");

        jLabel6.setText("Clave");

        jLabel7.setText("Fecha");

        df_cliCelular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                df_cliCelularActionPerformed(evt);
            }
        });

        df_cliClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                df_cliClaveActionPerformed(evt);
            }
        });

        jButton1.setText("Insertar Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Nombre", "Apellido", "Email", "Celular", "Clave", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(tablaClientes);

        jButton2.setText("Consultar Todo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        cb_cliUsuario.setEditable(true);
        cb_cliUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_cliUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_cliUsuarioActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar Usuario");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Actualiza Usuario");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cb_cliUsuario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(df_cliFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(df_cliClave, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(df_cliCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(df_cliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(df_cliNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                    .addComponent(df_cliApellido))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(33, 33, 33)
                        .addComponent(jButton3)
                        .addGap(40, 40, 40)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(25, 25, 25))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cb_cliUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(df_cliNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(df_cliApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(df_cliEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(df_cliCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(df_cliClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(df_cliFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void df_cliClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_df_cliClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_df_cliClaveActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Capturar los valores del usuario
        String usuario = (String)cb_cliUsuario.getSelectedItem();
        String nombre = df_cliNombre.getText();
        String apellido = df_cliApellido.getText();
        String email = df_cliEmail.getText();
        long celular = Long.parseLong(df_cliCelular.getText());
        String clave = df_cliClave.getText();
        String fecha = df_cliFecha.getText();
        ModeloCliente cliente = new ModeloCliente(usuario, nombre, apellido, email, celular, clave, fecha);
        if (DAO_cliente.agregarCliente(cliente)) {
            JOptionPane.showMessageDialog(this, "Se creo el cliente exitosamente");
            initNombreUsuarios();
            df_cliNombre.setText("");
            df_cliApellido.setText("");
            df_cliEmail.setText("");
            df_cliCelular.setText("");
            df_cliClave.setText("");
            df_cliFecha.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un problema al crear el cliente");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void df_cliCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_df_cliCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_df_cliCelularActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Aqui se hace la consulta
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
                DAO_cliente.obtenerClientes_obj(),
                new String[]{
                    "Usuario", "Nombre", "Apellido", "Email", "Celular", "Clave", "Fecha"
                }
        ));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void cb_cliUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_cliUsuarioActionPerformed
        // TODO add your handling code here:
        String NombreUsuarioSeleccionado = (String)cb_cliUsuario.getSelectedItem();
        String[] listaNombreUsuarios_vector = DAO_cliente.listaNombreUsuarios();
        ArrayList<String> listaNombreUsuarios;
        listaNombreUsuarios = new ArrayList<String>(Arrays.asList(listaNombreUsuarios_vector));
        //listaNombreUsuarios = ArrayList(Arrays.asList(DAO_cliente.listaNombreUsuarios()));
        if(listaNombreUsuarios.contains(NombreUsuarioSeleccionado)){
            ModeloCliente clienteSeleccionado = DAO_cliente.obtenerCliente(NombreUsuarioSeleccionado);
            df_cliNombre.setText(clienteSeleccionado.getNombre());
            df_cliApellido.setText(clienteSeleccionado.getApellido());
            df_cliEmail.setText(clienteSeleccionado.getEmail());
            df_cliCelular.setText(clienteSeleccionado.getNumeroCelular()+"");
            df_cliClave.setText(clienteSeleccionado.getClave());
            df_cliFecha.setText(clienteSeleccionado.getFecha());
        }
    }//GEN-LAST:event_cb_cliUsuarioActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String NombreUsuarioSeleccionado = (String)cb_cliUsuario.getSelectedItem();
        DAO_cliente.eliminarCliente(NombreUsuarioSeleccionado);
        initNombreUsuarios();
        df_cliNombre.setText("");
        df_cliApellido.setText("");
        df_cliEmail.setText("");
        df_cliCelular.setText("");
        df_cliClave.setText("");
        df_cliFecha.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String usuario = (String)cb_cliUsuario.getSelectedItem();
        String nombre = df_cliNombre.getText();
        String apellido = df_cliApellido.getText();
        String email = df_cliEmail.getText();
        long celular = Long.parseLong(df_cliCelular.getText());
        String clave = df_cliClave.getText();
        String fecha = df_cliFecha.getText();
        ModeloCliente cliente = new ModeloCliente(usuario, nombre, apellido, email, celular, clave, fecha);
        if (DAO_cliente.actualizarCliente(cliente)) {
            JOptionPane.showMessageDialog(this, "Se creo actualizo exitosamente");
            String NombreUsuarioSeleccionado = (String)cb_cliUsuario.getSelectedItem();
            String[] listaNombreUsuarios_vector = DAO_cliente.listaNombreUsuarios();
            ArrayList<String> listaNombreUsuarios;
            listaNombreUsuarios = new ArrayList<String>(Arrays.asList(listaNombreUsuarios_vector));
            if(listaNombreUsuarios.contains(NombreUsuarioSeleccionado)){
                ModeloCliente clienteSeleccionado = DAO_cliente.obtenerCliente(NombreUsuarioSeleccionado);
                df_cliNombre.setText(clienteSeleccionado.getNombre());
                df_cliApellido.setText(clienteSeleccionado.getApellido());
                df_cliEmail.setText(clienteSeleccionado.getEmail());
                df_cliCelular.setText(clienteSeleccionado.getNumeroCelular()+"");
                df_cliClave.setText(clienteSeleccionado.getClave());
                df_cliFecha.setText(clienteSeleccionado.getFecha());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un problema al actualizar el cliente");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_cliUsuario;
    private javax.swing.JTextField df_cliApellido;
    private javax.swing.JTextField df_cliCelular;
    private javax.swing.JTextField df_cliClave;
    private javax.swing.JTextField df_cliEmail;
    private javax.swing.JTextField df_cliFecha;
    private javax.swing.JTextField df_cliNombre;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaClientes;
    // End of variables declaration//GEN-END:variables
}