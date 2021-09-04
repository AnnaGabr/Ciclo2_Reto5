/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acceso;

import Modelo.ModeloCliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.ConnectionDB;

/**
 *
 * @author Gaby
 */
public class ClienteDAO {
    
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
    
    public ModeloCliente obtenerCliente(String nombreUsuario){
        ModeloCliente cliente = null;
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            String sql = "SELECT cliUserName, cliNombre, cliApellido, cliEmail, cliCelular, cliClave, cliFechaNto FROM cliente WHERE cliUserName = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombreUsuario);
            ResultSet result = statement.executeQuery(sql);
            while(result.next()){
                cliente = new ModeloCliente(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5), result.getString(6), result.getString(7));
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

    public void agregarCliente(ModeloCliente cliente){
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
            statement.setInt(5, cliente.getNumeroCelular());
            statement.setString(6, cliente.getClave());
            statement.setString(7, cliente.getFecha());
            int filasInsertadas = statement.executeUpdate();
            if(filasInsertadas > 0){
                System.out.println("Se insertó");
            }else{
                System.out.println("No se inertó");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
            //                            + "\nError :" + ex.getMessage());
        }
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
                System.out.println("Se eliminó");
                //JOptionPane.showMessageDialog(null, "El registro se eliminó exitosamente!")
            }else{
                System.out.println("No se eliminó");
                //JOptionPane.showMessageDialog(null, "El registro no se eliminó!")
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
            //                            + "\nError :" + ex.getMessage());
        }
    }
    
    public void actualizarCliente(ModeloCliente cliente){
        try{
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            String sql = "UPDATE cliente SET cliEmail = ?, cliCelular = ?, cliClave = ? WHERE cliUserName = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, cliente.getEmail());
            statement.setInt(2, cliente.getNumeroCelular());
            statement.setString(3, cliente.getClave());
            statement.setString(4, cliente.getNombreUsuario());
            int filasInsertadas = statement.executeUpdate();
            if(filasInsertadas > 0){
                System.out.println("Se insertó");
                //JOptionPane.showMessageDialog(null, "El registro se actualizó exitosamente!")
            }else{
                System.out.println("No se inertó");
                //JOptionPane.showMessageDialog(null, "El registro no se actualizó!")
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
            //                            + "\nError :" + ex.getMessage());
        }
    }
}
