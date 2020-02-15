
package controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    public static Connection conection = null;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conection = DriverManager.getConnection("jdbc:mysql://localhost/topFit", "root", "root");
            return conection;
       } catch (ClassNotFoundException | SQLException ex) {
                return null;        
       }
    }
}
