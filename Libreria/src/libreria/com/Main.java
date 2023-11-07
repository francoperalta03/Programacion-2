package libreria.com;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import entities.Datos;
import utilities.Constants;

public class Main {
	 
	 public static void main(String[] args) {
		 Datos datos; //almacenar los datos de un libro
		 
		 ArrayList<Datos> lista = new ArrayList<>(); //almacenar los datos de todos los libros.
		 
		 //conexion con base de datos
		 //una consulta SQL para obtener los datos de los libros.  
		 try{   
			 Connection c = Conexion.obtener();
			  //se le asigna la Query que se ejecuta
			 PreparedStatement pstmt =  c.prepareStatement(Constants.SQL_CONSULTA1);
			  //se ejecuta
			 //lo guarda en el ResultSet
			 ResultSet rs= pstmt.executeQuery(); // El resultado de la consulta se guarda en un objeto
			 
			 while(rs.next()) //se recorre del resultset, 
			 {
				 //se obtienen los valores de las columnas, con Int o String segun el tipo de dato
				 datos = new Datos();
				 datos.setIdlibro(rs.getInt(1));
				 datos.setTitulo(rs.getString(2));
				 datos.setPaginas(rs.getInt(3));
				 datos.setAnioedicion(rs.getInt(4));
				 datos.setEditorial(rs.getString(5));
				 datos.setGenero(rs.getString(6));
				 datos.setAutor(rs.getString(7));
				 
//		
				 //lista con los datos de todos los libros cargados 
				 lista.add(datos);
			 }
			 
			 //Se crea un objeto MyFrame pasando la lista lista como parámetro
		 MyFrame f = new MyFrame(lista); //esta clase MyFrame es la que representa la interfaz gráfica de la aplicación
 
			 //maneja excepciones que puedan ocurrir durante la ejecución del código contenido en el bloque try
		 }catch(Exception e)
		 { System.out.println(e);
			 
		 }  
		}  
	 
	
}

	 

