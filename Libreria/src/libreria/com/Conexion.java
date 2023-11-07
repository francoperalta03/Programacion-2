package libreria.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//conexion con base de datos
public class Conexion {
	 private static Connection cnx = null;
	 public static Connection obtener() throws SQLException, ClassNotFoundException {
	        if (cnx == null) {
	            try {
	                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria?useSSL=false&serverTimezone=UTC","root","12345");
	            } catch (SQLException ex) {
	                throw new SQLException(ex);
	            } 
	        }
	        return cnx;
	    }

	    public static void cerrar() throws SQLException {
	        if (cnx != null) {
	            cnx.close();
	        }
	    }
}

