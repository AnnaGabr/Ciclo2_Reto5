package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.*;
import org.json.simple.parser.*;

public class ConnectionDB {
    
    // Vamos a definir el metodo por el cual nos conectamos a la base de datos
    public static Connection getConnection(){
        // Iniciamos un lecto de JSON
        JSONParser parser = new JSONParser();
        // Iniciamos una coneccion nula
        Connection conn = null;
        
        try {
            // System.getProperty("user.dir") nos dara el path en donde se encuentra este proyecto,
            // y lo concatenamos con el path en el que estan nuestras credenciales
            String credentials_path = System.getProperty("user.dir") + "/src/utils/credentials.json";
            // Leemos las credenciales
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(credentials_path));
            
            // Sacamos el host (localhost), el puerto (3306), el usuario y la contraseña
            String host     = (String)jsonObject.get("db_ip");
            String port     = (String)jsonObject.get("dp_port");
            String username = (String)jsonObject.get("db_user");
            String password = (String)jsonObject.get("db_pssword");
            // Escribimos la direccion de nuestra base de datos
            String dbURL = "jdbc:mysql://"+host+":"+port+"/reto4" ;
            // Y nos conectamos con Drivermanager
            conn = DriverManager.getConnection(dbURL, username, password);
            // Revisamos si esta conectado
            if( conn != null ) 
                System.out.println ( "Conectado a la base de datos" );
            if( conn == null ) 
                System.out.println ( "No conectado a la base de datos" );
        }
        // Si hay excepciones las imprimimos
        catch( SQLException | FileNotFoundException ex ) {
            ex.printStackTrace();
        } 
        catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        // Retornamos esta coneccion
        return conn;
    }
    
    public static void main(String[] args){
        getConnection();
    }
}
