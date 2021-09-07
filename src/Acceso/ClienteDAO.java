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

public class ClienteDAO{
    
    // Iniciamos una coneccion vacia
    private Connection conn = null;
    
    // Creamos el metodo "obtenerClientes" mediante un ArrayList (Este metodo al final no lo usamos)
    public ArrayList<ModeloCliente> obtenerClientes(){
        // Creamos el arrayList vacio
        ArrayList<ModeloCliente> listaClientes = new ArrayList();
        // Usamos try para poder agarrar cualquier excepcion que nos mande
        try{
            // Si la coneccion es vacia lo conectamos con ConnectionDB.getConnection()
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            // Creamos el string con la consulta a sql
            String sql = "SELECT cliUserName, cliNombre, cliApellido, cliEmail, cliCelular, cliClave, cliFechaNto FROM cliente;";
            // Creamos el statement de esta consulta
            Statement statement = conn.createStatement();
            // Ejecutamos la consulta y guardamos los resultados en result
            ResultSet result = statement.executeQuery(sql);
            // Empezamos un while que recorre los resultados de la consulta
            while(result.next()){
                // Creamos un objeto de tipo ModeloCliente con los resultados que nos va arrojando
                ModeloCliente cliente = new ModeloCliente(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5), result.getString(6), result.getString(7));
                // Y lo agregamos en nuestra lista listaClientes
                listaClientes.add(cliente);
            }
        }
        catch(SQLException ex){
            // Si nos da algun error lo imprimimos en la consola
            // (Ya que no estamos usando este metodo en la ventana, no pedimos que lo imprima en una ventana emergente)
            ex.printStackTrace();
        }
        // Nos devuelve la listaClientes
        return listaClientes;
    }
    
    // Creamos el metodo "obtenerClientes" mediante una matriz Object[][]
    public Object[][] obtenerClientes_obj(){
        // Primero creamos un ArrayList
        ArrayList<Object[]> listaClientes = new ArrayList();
        // Usamos try para poder agarrar cualquier excepcion que nos mande
        try {
            // Guardamos la consulta en un String llamado sql
            String sql = "SELECT cliUserName, cliNombre, cliApellido, cliEmail, cliCelular, cliClave, cliFechaNto FROM cliente;";
            // Comprobamos si la coneccion es nula, si es asi, lo conectamos mediando ConnectionDB.getConnection
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            // Creamos el statement de esta consulta
            Statement statement = conn.createStatement();
            // Ejecutamos la consulta y guardamos los resultados en result
            ResultSet result = statement.executeQuery(sql);
            // Iteramos sobre los resultados que nos da la consulta
            while(result.next()){
                // Creamos un nuevo vector Object[]
                Object[] array = new Object[7];
                // Colocamos los resultados de que nos esta dando la consulta en cada uno de los elementos del vector
                array[0] = result.getString("cliUserName");
                array[1] = result.getString("cliNombre");
                array[2] = result.getString("cliApellido");
                array[3] = result.getString("cliEmail");
                array[4] = result.getString("cliCelular");
                array[5] = result.getString("cliClave");
                array[6] = result.getString("cliFechaNto");
                // Luego agregamos este vector a nuestra lista
                listaClientes.add(array);
            }
            // Creamos una nueva matriz para ubicar lo que tenemos en nuestroa listaClientes
            Object[][] resultadoListaClientes = new Object[listaClientes.size()][7];
            // Iteramos sobre esta matriz
            for(int i = 0; i < listaClientes.size(); i++){
                // creamos un vector llamado filaCliente, que reciba uno por uno los vectores de nuestra listaClientes
                Object[] filaCliente = listaClientes.get(i);
                // Y luego colocamos ese vector sobre la matriz
                resultadoListaClientes[i][0] = filaCliente[0];
                resultadoListaClientes[i][1] = filaCliente[1];
                resultadoListaClientes[i][2] = filaCliente[2];
                resultadoListaClientes[i][3] = filaCliente[3];
                resultadoListaClientes[i][4] = filaCliente[4];
                resultadoListaClientes[i][5] = filaCliente[5];
                resultadoListaClientes[i][6] = filaCliente[6];
            }
            // Al final retornamos la matriz
            return resultadoListaClientes;
        } catch (SQLException ex) {
            // Como este metodo si lo estamos usando en la ventana,
            // si nos genera una excepcion pedimos que nos la muestre en una ventana emergente
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        // Si no retorno la matriz que creamos (resultadoListaClientes) quiere decir que algo salio mal, y retornamos null
        return null;
    }
    
    // Creamos el metodo para obtener la informaicon de un cliente mediante el nombre de usuario
    public ModeloCliente obtenerCliente(String nombreUsuario){
        // Creamos un objeto de tipo ModeloCliente, nulo por el momento
        ModeloCliente cliente = null;
        // Usamos try para poder agarrar cualquier excepcion que nos mande
        try{
            // Si la coneccion es vacia lo conectamos mediante ConnectionDB.getConnection()
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            // Dado que estamos haciendo una consulta (que no modifica la base de datos) creamos el string directamente,
            // agregando el nombre de usuario con \""+nombreUsuario+"\"
            // en lugar de usar ? y luego perparar el statement.
            String sql = "SELECT cliUserName, cliNombre, cliApellido, cliEmail, cliCelular, cliClave, cliFechaNto FROM cliente WHERE cliUserName = \""+nombreUsuario+"\";";
            // Creamos el statement (como ya esta todo en el String, no es necesario poner PreparedStatement ni .prepareStatement)
            Statement statement = conn.createStatement();
            // Guardamos los resultados de la ocnsulta en result
            ResultSet result = statement.executeQuery(sql);
            // Iteramos sobre los resultados de nuestra consulta
            while(result.next()){
                // llenamos nuestro objeto del tipo ModeloCliente con estos resultados
                cliente = new ModeloCliente(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getLong(5), result.getString(6), result.getString(7));
                break;
            }
        }
        catch(SQLException ex){
            // Si nos lanza alguna excepcion, la mostramos en una ventana emergente
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
           }
        // Devolvemos nuestro objeto del tipo ModeloCliente
        return cliente;
    }

    // Creamos el metodo agregarCliente que nos devuelve un booleano
    // true si pudo agregar al cliente y false si no.
    public boolean agregarCliente(ModeloCliente cliente){
        // Usamos try para agarrar cualquier excepcion que nos mande
        try{
            // Verificamos si la coneccion es vacia, si es asi se conecta mediante ConnectionDB.getConnection()
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            // Creamos nuestro string con la consulta, poniendo ? en los campos que debe llenar el usuario
            String sql = "INSERT INTO cliente VALUES(?, ?, ?, ?, ?, ?, ?);";
            // Creamos un statement del tipo PreparedStatement para poder agregarle lso campos faltantes
            PreparedStatement statement = conn.prepareStatement(sql);
            // Agregamos los campos faltantes segun el objeto de tipo ModeloCliente que nos hayan pasado
            statement.setString(1, cliente.getNombreUsuario());
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getApellido());
            statement.setString(4, cliente.getEmail());
            statement.setLong(5, cliente.getNumeroCelular());
            statement.setString(6, cliente.getClave());
            statement.setString(7, cliente.getFecha());
            // Ejecutamos la consulta y guardamos la cantidad de filas afectadas en filasInsertadas
            int filasInsertadas = statement.executeUpdate();
            // Si la cantidad de filas afectadas por la consulta es mayor a 0 significa que si agrego algo y se retorna true
            if(filasInsertadas > 0){
                //System.out.println("Se agrego el nuevo cliente");
                return true;
            }
        }
        // Si nos lanza alguna excepcion pedimos que nos muestre el error en una ventana emergente
        catch(SQLException ex){
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        // Si no devolvio true en su momento quiere decir que hubo algun error y pedimos que nos devuelva false
        return false;
    }
    
    // Creamos el metodo eliminarCliente mediante el nombre de usuario
    public void eliminarCliente(String nombreUsuario){
        // Usamos try para agarrar cualquier excepcion que nos mande
        try{
            // Comprobamos si la coneccion es nula, si es asi lo conectamos mediando ConnectionDB.getConnection()
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            // Creamos el comando sql para eliminar el cliente en un String llamado sql
            String sql = "DELETE FROM cliente WHERE cliUserName = ?;";
            // Preparamos el statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Agregamos el nombre de usuario a nuestro statement
            statement.setString(1, nombreUsuario);
            // Ejecutamos el statement y guardamos en filasEliminadas la cantidad de filas que fueron eliminadas
            int filasEliminadas = statement.executeUpdate();
            // Si la cantidad de filas eliminadas es mayor a 0 nos manda una ventana emergente con el mensaje de que se elimino exitosamente
            if(filasEliminadas > 0){
                //System.out.println("Se eliminó");
                JOptionPane.showMessageDialog(null, "El cliente se eliminó exitosamente!");
            }else{ // En caso de que las filasEliminadas sean 0, nos manda el mensaje de que no se elimino
                //System.out.println("No se eliminó");
                JOptionPane.showMessageDialog(null, "El cliente no se eliminó!");
            }
        }
        catch(SQLException ex){ // Si nos lanza alguna excepcion, imprimimos el error en una ventana emergente
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }
    
    // Creamos el metodo para actualizar un cliente
    // se le entrega un objeto de tipo ModeloCliente y nos devuelve un booleano
    public boolean actualizarCliente(ModeloCliente cliente){
        // Usamos try para agarrar cualquier excepcion que nos mande
        try{
            // Primero revisamos si la coneccion es nula, si es asi se conecta mediante ConnectionDB.getConnection()
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            // Creamos nuestro string con la consulta sql, colocnado ? en los campos que debe llenar el usuario
            String sql = "UPDATE cliente SET cliEmail = ?, cliCelular = ?, cliClave = ? WHERE cliUserName = ?;";
            // Preparamos el statement
            PreparedStatement statement = conn.prepareStatement(sql);
            // Colocamos la informacion de nuestro objeto ModeloCliente en las ? que habiamos puesto en el string con la consulta sql
            statement.setString(1, cliente.getEmail());
            statement.setLong(2, cliente.getNumeroCelular());
            statement.setString(3, cliente.getClave());
            statement.setString(4, cliente.getNombreUsuario());
            // Ejecutamos el statement y guardamos en un entero el numero de filas afectadas a
            int filasActualizadas = statement.executeUpdate();
            // Si este numero de filas actualizadas es mayor a 0, significa que si sucedio algo
            // y devolvemos un valor true
            if(filasActualizadas > 0){
                //System.out.println("Se insertó");
                //JOptionPane.showMessageDialog(null, "El registro se actualizó exitosamente!");
                return true;
            }
        }
        catch(SQLException ex){ // Si nos lanza una excepcion abrimos una ventana emergente con el error
            //ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        // En caso de que no nos haya devuelvo true, significa que algo salio mal, y nos devuelve false
        return false;
    }
    
    // Creamos un metodo que nos devuelva un String[] con los nombres de usuario qu ehay hasta el momento
    public String[] listaNombreUsuarios(){
        // Primero creamos un ArrayList vacio
        ArrayList<String> listaClientes = new ArrayList();
        try {
            // Y antes que nada, como siempre, verificamos si la ocneccion es nula, de ser asi lo conectamos
            if(conn == null){
                conn = ConnectionDB.getConnection();
            }
            // Creamos nuestro statement
            Statement statement = conn.createStatement();
            // Y el string que tiene nuestra consulta sql
            String sql = "SELECT cliUserName FROM cliente ORDER BY 1;";
            // Y lo ejecutamos, guardando los resultados de nuestra consulta en result
            ResultSet result = statement.executeQuery(sql);
            // Luego iteramos sobre nuestro resultado
            while(result.next()){
                // Y lo vamos agregando a nuestro ArrayList
                listaClientes.add(result.getString(1));
            }
        } catch (SQLException ex) {
            // Si nos lanza alguna excepcion sacamos una ventana emergente con el error
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
        // Y al final retornamos nuestro ArrayList pero convertido en un String[]
        return listaClientes.toArray(new String[0]);
    }
}
