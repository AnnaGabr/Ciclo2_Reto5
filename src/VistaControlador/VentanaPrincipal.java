package VistaControlador;

import Acceso.ClienteDAO;
import Modelo.ModeloCliente;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import utils.ConnectionDB;

public class VentanaPrincipal extends javax.swing.JFrame {
    
    // Declaramos el argumento conn del tipo ConnectionDB
    ConnectionDB conn;
    // Declaramos el argumento DAO_cliente del tipo ClienteDAO
    ClienteDAO DAO_cliente;
    
    // Creamos el contructor
    public VentanaPrincipal() {
        // En el constructor iniciamos las variables anteriormente declaradas
        conn = new ConnectionDB();
        DAO_cliente = new ClienteDAO();
        // Iniciamos los componentes (definidos mas adelante)
        initComponents();
        // Iniciamos la lista de usuarios, para que apenas abra la ventana aparezca ya
        initNombreUsuarios();
        // Iniciamos la tabla, para que apenas se abra aparezca ya actualizada
        initTabla();
        // Le ponemos titulo a nuestra ventana
        setTitle("Reto 5 - Jose Cabrera - Anna Salazar");
    }
    
    // Definimos como iniciamos la lista de nombre de usuarios
    public void initNombreUsuarios(){
        // Es simplemente que en el Combo Box "cb_cliUsuario" aparezca la lista de usuarios que hay
        // actualmente en la base de dato, esto lo hacemos llamando al metodo "listaNombreUsuarios" del
        // objeto DAO_cliente que es de la clase ClienteDAO
        cb_cliUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(DAO_cliente.listaNombreUsuarios()));
    }
    
    // Definimos como iniciamos la tabla
    private void initTabla(){                                         
        // Aqui se hace la consulta, llamamos al metodo obtenerClientes del objeto DAO_cliente
        // para llenar nuestra tabla (llamada tablaClientes)
        tablaClientes.setModel(new javax.swing.table.DefaultTableModel(
                DAO_cliente.obtenerClientes_obj(),
                new String[]{
                    "Usuario", "Nombre", "Apellido", "Email", "Celular", "Clave", "Fecha"
                }
        ));
    }
    
    // Este es el codigo generado al hacer el diseño de la tabla mediante el metodo que vimos en clase
    /**
     * This method is called from within the constructor to initialize the form.
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
        cb_cliUsuario = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(df_cliFecha)
                            .addComponent(df_cliClave)
                            .addComponent(df_cliCelular)
                            .addComponent(df_cliEmail)
                            .addComponent(cb_cliUsuario, 0, 133, Short.MAX_VALUE)
                            .addComponent(df_cliApellido)
                            .addComponent(df_cliNombre))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(140, 140, 140)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void df_cliClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_df_cliClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_df_cliClaveActionPerformed
    
    // Este metodo define que sucede al darle click al boton "Insertar Usuario"
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Capturar los valores del usuario
        String usuario = (String)cb_cliUsuario.getSelectedItem();
        String nombre = df_cliNombre.getText();
        String apellido = df_cliApellido.getText();
        String email = df_cliEmail.getText();
        long celular = Long.parseLong(df_cliCelular.getText());
        String clave = df_cliClave.getText();
        String fecha = df_cliFecha.getText();
        // Crea un objeto de la clase ModeloCliente con estos valores
        ModeloCliente cliente = new ModeloCliente(usuario, nombre, apellido, email, celular, clave, fecha);
        // Usamos el metodo agregarCliente del objeto DAO_cliente, para agregar
        // el objeto ModeloCliente definido en la linea anterior
        if (DAO_cliente.agregarCliente(cliente)) { // Este modelo retorna un booleano de valor true si el cliente fue exitosamente agregado a la base de datos
            // De ser asi anza una ventana emergente con el mensaje de que se creo el cliente exitosamente
            JOptionPane.showMessageDialog(this, "Se creo el cliente exitosamente");
            // Volvemos a iniciar la lista de nombres de usuario para que aparezca tambien el nuevo usuario recien creado
            initNombreUsuarios();
            // Volvemos a poner las cajas de texto vacias
            df_cliNombre.setText("");
            df_cliApellido.setText("");
            df_cliEmail.setText("");
            df_cliCelular.setText("");
            df_cliClave.setText("");
            df_cliFecha.setText("");
            // Iniciamos de nuevo la tabla para que aparezca actualizada con el nuevo usuario
            initTabla();
        } else {
            // En caso de que no se haya agregado el cliente y el metodo agregarCliente nos devuelva un false
            // Una ventana emergente nos dira que hubo un problema (esta ventana sale despues de
            // la ventana de error definida en el metodo agregarCliente)
            JOptionPane.showMessageDialog(this, "Hubo un problema al crear el cliente");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void df_cliCelularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_df_cliCelularActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_df_cliCelularActionPerformed

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
    
    // Aqui definimos lo que sucede al hacer click al boton "Eliminar Usuario"
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Capturamos el nombre de usuario seleccionado
        String NombreUsuarioSeleccionado = (String)cb_cliUsuario.getSelectedItem();
        // Llamamos al metodo eliminarCliente del objeto DAO_Cliente
        DAO_cliente.eliminarCliente(NombreUsuarioSeleccionado);
        // Volvemos a iniciar la lista de usuarios para que aparezca ya actualizada sin el cliente eliminado
        initNombreUsuarios();
        // Vaciamos las cajas de texto
        df_cliNombre.setText("");
        df_cliApellido.setText("");
        df_cliEmail.setText("");
        df_cliCelular.setText("");
        df_cliClave.setText("");
        df_cliFecha.setText("");
        // Volvemos a iniciar la tabla para que aparezca actualizada sin el cliente eliminado
        initTabla();
    }//GEN-LAST:event_jButton3ActionPerformed
    
    // Aqui definimos el boton "Actualizar Usuario"
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Primero capturamos lo que haya escrito el usuario
        String usuario = (String)cb_cliUsuario.getSelectedItem();
        String nombre = df_cliNombre.getText();
        String apellido = df_cliApellido.getText();
        String email = df_cliEmail.getText();
        long celular = Long.parseLong(df_cliCelular.getText());
        String clave = df_cliClave.getText();
        String fecha = df_cliFecha.getText();
        // Creamos un objeto de la clase ModeloCliente pasandole la informacion que capturamos
        ModeloCliente cliente = new ModeloCliente(usuario, nombre, apellido, email, celular, clave, fecha);
        // Llamamos al metodo actualizarCliente del objeto DAO_cliente y le pasamos el objeto de clase ModeloCliente que creamos
        if (DAO_cliente.actualizarCliente(cliente)) {
            // Si el metodo actualizarCliente nos devuelve un True, significa que se actualizo exitosamente y mostramos ese mensaje ne una ventana emergente
            JOptionPane.showMessageDialog(this, "Se actualizo exitosamente");
            // Se muestra el usuario tal cual como quedo en la base de datos:
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
                initTabla();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un problema al actualizar el cliente");
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    
    public static void main(String args[]) {
        
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
