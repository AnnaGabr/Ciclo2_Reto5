package Acceso;

import Modelo.ModeloCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import utils.ConnectionDB;

/**
 *
 * @author Gaby
 */
public class ClienteDAO{
    
    private Connection conn = null;
    
    public ArrayList<ModeloCliente> obtenerClientes(){
        ArrayList<ModeloCliente> listaClientes = new ArrayList();
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT cliUserName, cliNombre, cliApellido, cliEmail, cliCelular, cliClave, cliFechaNto FROM cliente;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                ModeloCliente cliente = new ModeloCliente(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5), result.getString(6), result.getString(7));
                listaClientes.add(cliente);
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
            // 
        }
        return listaClientes;
    }
    
    public Object[][] obtenerClientes_obj(){
        ArrayList<Object[]> listaClientes = new ArrayList();
        try {
            String sql = "SELECT * FROM cliente;";
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                Object[] array = new Object[7];
                array[0] = result.getString("cliUserName");
                array[1] = result.getString("cliNombre");
                array[2] = result.getString("cliApellido");
                array[3] = result.getString("cliEmail");
                array[4] = result.getString("cliCelular");
                array[5] = result.getString("cliClave");
                array[6] = result.getString("cliFechaNto");
                listaClientes.add(array);
            }
            Object[][] resultadoListaClientes = new Object[listaClientes.size()][7];
            for(int i = 0; i < listaClientes.size(); i++){
                Object[] filaCliente = listaClientes.get(i);
                resultadoListaClientes[i][0] = filaCliente[0];
                resultadoListaClientes[i][1] = filaCliente[1];
                resultadoListaClientes[i][2] = filaCliente[2];
                resultadoListaClientes[i][3] = filaCliente[3];
                resultadoListaClientes[i][4] = filaCliente[4];
                resultadoListaClientes[i][5] = filaCliente[5];
                resultadoListaClientes[i][6] = filaCliente[6];
            }
            return resultadoListaClientes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return null;        
    }
    
    public ModeloCliente obtenerCliente(String nombreUsuario){
        ModeloCliente cliente = null;
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            
            String sql = "SELECT cliUserName, cliNombre, cliApellido, cliEmail, cliCelular, cliClave, cliFechaNto FROM cliente WHERE cliUserName = \""+nombreUsuario+"\";";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                cliente = new ModeloCliente(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getLong(5), result.getString(6), result.getString(7));
                break;
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
            //            
        }
        return cliente;
    }

    public boolean agregarCliente(ModeloCliente cliente){
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            String sql = "INSERT INTO cliente VALUES(?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getNombreUsuario());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellido());
            statement.setString(4, cliente.getEmail());
            statement.setLong(5, cliente.getNumeroCelular());
            statement.setString(6, cliente.getClave());
            statement.setString(7, cliente.getFecha());
            int filasInsertadas = statement.executeUpdate();
            if(filasInsertadas > 0){
                //System.out.println("Se insertó");
                return true;
            }else{
                //System.out.println("No se inertó");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        return false;
    }
    
    public void eliminarCliente(String nombreUsuario){
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            String sql = "DELETE FROM cliente WHERE cliUserName = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombreUsuario);
            int filasEliminadas = statement.executeUpdate();
            if(filasEliminadas > 0){
                //System.out.println("Se eliminó");
                JOptionPane.showMessageDialog(null, "El registro se eliminó exitosamente!");
            }else{
                //System.out.println("No se eliminó");
                JOptionPane.showMessageDialog(null, "El registro no se eliminó!");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
            //                            + "\nError :" + ex.getMessage());
        }
    }
    
    public boolean actualizarCliente(ModeloCliente cliente){
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            String sql = "UPDATE cliente SET cliEmail = ?, cliCelular = ?, cliClave = ? WHERE cliUserName = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getEmail());
            statement.setLong(2, cliente.getNumeroCelular());
            statement.setString(3, cliente.getClave());
            statement.setString(4, cliente.getNombreUsuario());
            int filasInsertadas = statement.executeUpdate();
            if(filasInsertadas > 0){
                //System.out.println("Se insertó");
                //JOptionPane.showMessageDialog(null, "El registro se actualizó exitosamente!");
                return true;
            }else{
                //System.out.println("No se inertó");
                JOptionPane.showMessageDialog(null, "El registro no se actualizó!");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
            //                            + "\nError :" + ex.getMessage());
        }
        return false;
    }
    
    public String[] listaNombreUsuarios(){
        ArrayList<String> listaClientes = new ArrayList();
        try {
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            Statement statement = conn.createStatement();
            String sql = "SELECT cliUserName FROM cliente ORDER BY 1;";
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                listaClientes.add(result.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes.toArray(new String[0]);
    }
}
