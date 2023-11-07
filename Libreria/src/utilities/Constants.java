package utilities;

public class Constants {

	 
	// Esta constante contiene una consulta SQL que se utiliza para obtener los datos principales de los libros de la tabla libro en la base de datos
	 public static final String SQL_CONSULTA1 = "SELECT l.idlibro, l.titulo, l.paginas, l.anio, "
		 		+ " l.editorial, l.genero, l.nombreyapellidoAutor FROM libreria.libro l " ;
	 
	 

	 
	 public static final String SQL_INSERT_LIBRO = "INSERT INTO libreria.libro (titulo, paginas, anio, editorial, genero, nombreyapellidoAutor) "
		 		+ " VALUES (?, ?, ?, ?, ?, ?)";
	 
	 public static final String SQL_BUSCAR_LIBRO = "SELECT l.idlibro, l.titulo, l.paginas, l.anio, "
		 		+ " l.editorial, l.genero, l.nombreyapellidoAutor FROM libreria.libro l  where l.titulo like ? ";
	 
	 public static final String SQL_DELETE_LIBRO = " delete from libreria.libro where idlibro = ?";
	 
	 public static final String SQL_UPDATE_LIBRO = "UPDATE libreria.libro "
	 		+ "SET titulo = ?, paginas = ?, anio = ?, editorial =?, genero = ? , nombreyapellidoAutor = ? "
	 		+ "WHERE idlibro = ?";
	 
	 public static final String SQL_CONSULTA_AUTORES = "select  autor from  (SELECT "
			 + "  substring_index(trim(l.nombreyapellidoAutor), ',', 1) as autor "
			 + "     FROM libreria.libro l) a group by a.autor "
					+ "  order by autor asc ";
	 
	 public static final String SQL_CONSULTA_LIBROS = "SELECT l.titulo FROM libreria.libro l "
		 		+ "order by l.titulo asc " ; 
	
	 
	 public static final String SQL_CONSULTA_X_GENERO = "select l.titulo, l.nombreyapellidoAutor, l.paginas, l.anio, "
		 		+ " l.editorial"
			    + " FROM libreria.libro l where upper(l.genero) like ?";
			 
	 public static final String SQL_CONSULTA_X_AUTOR = "select l.titulo, l.nombreyapellidoAutor, l.paginas, l.anio, "
		 		+ " l.editorial, l.genero"
			    + " FROM libreria.libro l where upper(l.nombreyapellidoAutor) like ?"; //upper es para que se ponga en mayuscula
			 
	public static final String SQL_CONSULTA_AUTOR_X_EDITORIAL = "SELECT autor FROM ("
					+ "SELECT nombreyapellidoAutor as autor FROM libreria.libro l WHERE upper (l.editorial) like  ?) a group by a.autor";
	
	public static final String SQL_CONSULTA_LIBRO_X_EDITORIAL = "SELECT titulo, nombreyapellidoAutor, paginas, anio, genero FROM libreria.libro WHERE UPPER(editorial) LIKE ?";


	public static final String SQL_CONSULTA_LIBRO_X_AÑO = "SELECT titulo, nombreyapellidoAutor, paginas, editorial, genero "
	        + "FROM libreria.libro "
	        + "WHERE upper(anio) LIKE ? "
	        + "GROUP BY titulo, nombreyapellidoAutor, paginas, editorial, genero";

	public static final String SQL_CONSULTA_RANGO_DE_AÑOS = "SELECT l.titulo, l.nombreyapellidoAutor, l.paginas, l.anio, l.editorial, l.genero FROM libreria.libro l WHERE upper(l.editorial) LIKE ? AND l.anio >= ? AND l.anio <= ?";

	public static final String SQL_CONSULTA_LIBROS_X_LETRA_AUTOR = "SELECT l.titulo, l.nombreyapellidoAutor, l.paginas, l.editorial, l.genero, l.anio "
	        + "FROM libreria.libro l "
	        + "WHERE SUBSTRING_INDEX(TRIM(l.nombreyapellidoAutor), ',', 1) LIKE ? "
	        + "ORDER BY l.nombreyapellidoAutor ASC";


}
