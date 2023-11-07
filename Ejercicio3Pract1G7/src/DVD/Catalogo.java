//TRABAJO PRACTICO N°2: 
//INTEGRANTES: PERALTA FRANCO, SOSA TOMAS, SANABRIA RAMIRO
//CATALOGO DVD
package DVD;

import java.util.ArrayList;
import java.util.Scanner;

public class Catalogo {
	// metodo scanner 
	static Scanner teclado = new Scanner(System.in);
			
	// arraylist con los DVD's  
	public static ArrayList <Dvd> catalogo = new ArrayList <> ();
	
	// 1) Método para ingresar un dvd
	public static void ingresarDVD(Dvd a) {
		catalogo.add(a);
	}
	
	//  funcion eliminatoria de dvds 
	public static void eliminarDVD(String titulo) {
		boolean eliminado = false;
	    for (int i = 0; i < catalogo.size(); i++) {
	        Dvd dvd = catalogo.get(i);
	        if (dvd.getTitulo().equalsIgnoreCase(titulo)) {
	        	catalogo.remove(i);
	            eliminado = true;
	            break;
	        }
	    }
	    if (eliminado) {
	        System.out.println("El DVD ha sido eliminado.\n");
	    } else {
	        System.out.println("No se ha encontrado un DVD con ese titulo.\n");
	    }
	}
	
	//   modificar los dvds 
	public static void modificarDvd(String nombre) {
		boolean modificado = false;
	    for (int i = 0; i < catalogo.size(); i++) {
	        Dvd dvd = catalogo.get(i);
	        if (dvd.getTitulo().equalsIgnoreCase(nombre)) {
	        	// Inputs
	        	System.out.println("Ingresar los datos del DVD:");
	 			System.out.print("Ingrese el título del DVD: ");
	 		    String titulo = teclado.nextLine();
	 		    System.out.print("Ingrese el género del DVD: ");
	 		    String genero = teclado.nextLine();
	 		   teclado.nextLine();
	 		    System.out.print("Ingrese la duración en minutos del DVD: ");
	 		    int duracion = teclado.nextInt();
	 		    teclado.nextLine(); // Limpiar el buffer de entrada
	 		    System.out.print("¿Tiene el DVD? (s/n): ");
	 		    boolean tenencia = teclado.nextLine().equalsIgnoreCase("s");
	 		    System.out.print("Ingrese un comentario (Excelente, Muy Buena, Buena, Regular, Mala): ");
	 		    String comentario = teclado.nextLine();
	 		    System.out.print("Ingrese el nombre del director: ");
	 		    String director = teclado.nextLine();
	 		    // Realizar los cambios
	 		    dvd.setTitulo(titulo);
	 		    dvd.setGenero(genero);
	 		    dvd.setDuracion(duracion);
	 		    dvd.settenencia(tenencia);
	 		    dvd.setComentario(comentario);
	 		    dvd.setDirector(director);
	 		    System.out.println("DVD modificado correctamente.\n");
	            modificado = true;
	            break;
	        }
	    }
	    if (modificado) {
	        System.out.println("DVD modificado correctamente.\n");
	    } else {
	        System.out.println("No se encontró un DVD con el título ingresado.\n");
	    }
	}
	
	//  listar todos los dvds 
	public static void listarDvds() {
		System.out.println("Lista de los DVD's que tengo: \n");
		for (int i = 0; i < catalogo.size(); i++) {
			Dvd dvd = catalogo.get(i);
			System.out.println(dvd);
		}
		System.out.println("\n");
	}
	
	//  listar todos los dvds en tenencia
	public static void listarDvdEntenencia() {
		System.out.println("Lista de los dvds que tengo: \n");
		for (int i = 0; i< catalogo.size(); i++) {
			Dvd dvd = catalogo.get(i);
			if (dvd.istenencia() == true) {
				System.out.println(dvd);
			}
		}
		System.out.println("\n");
	}
	
	// listar por duracion
	public static void listarPorTiempo(int tiempo) {
		System.out.println("Lista de los dvds que tengo menores a " + tiempo + " minutos:\n");
		for (int i = 0; i< catalogo.size(); i++) {
			Dvd dvd = catalogo.get(i);
			if (dvd.getDuracion() < tiempo) {
				System.out.println(dvd);
			}
		}
		System.out.println("\n");
	}
	
	// listar por director
		public static void listarPorDirector(String director) {
		System.out.println("Lista de los dvds que tengo del director '" + director + "' \n");
		for (int i = 0; i< catalogo.size(); i++) {
			Dvd dvd = catalogo.get(i);
			if (dvd.getDirector().equals(director)) {
				System.out.println(dvd);
			}
		}
		System.out.println("\n");
		}
	
	// listar todos los dvds ordenados
	public static void listarDvdsOrdenados() {
	    ArrayList<Dvd> copiacatalogo = new ArrayList<>(catalogo);
	    int n = copiacatalogo.size();

	    // Lista ordenada
	    boolean intercambio = true;
	    while (intercambio) {
	        // Comenzar con intercambio 
	        intercambio = false;
	        // Comparar 2 elementos seguidos
	        for (int i = 0; i < n - 1; i++) {
	            // Obtener los elementos 
	            Dvd actual = copiacatalogo.get(i);
	            Dvd siguiente = copiacatalogo.get(i + 1);
	            // Si el título del elemento actual es mayor que el título del siguiente elemento 
	            if (actual.getTitulo().compareToIgnoreCase(siguiente.getTitulo()) > 0) {
	                // Intercambiar los elementos
	                copiacatalogo.set(i, siguiente);
	                copiacatalogo.set(i + 1, actual);
	                // Establecer intercambio 
	                intercambio = true;
	            }
	        }
	        // Reducir el tamaño de la lista 
	        n--;
	    }
	    // Imprimir la lista ordenada
	    System.out.println("Lista de DVDs ordenados por título:");
	    for (Dvd dvd : copiacatalogo) {
	        // Para cada dvd en la copia ordenada de la colección:
	        // Imprimir el dvd 
	        System.out.println(dvd);
	    }
	    // Imprimir una línea en blanco para separar la salida de la lista de dvds 
	    System.out.println();
	}
	
	// 10) Método para decir la cantidad de dvds en tenencia
	public static void dvdsEntenencia() {
		// Crear una nuevo array list donde se van a agregar todos los dvds que posea
		ArrayList<Dvd> dvdQueTengo = new ArrayList<>();
		// Fijarse en la catalogo cuales poseo
		for (int i = 0; i< catalogo.size(); i++) {
			Dvd dvd = catalogo.get(i);
			// Si lo poseo agregar a el array list
			if (dvd.istenencia() == true) {
				dvdQueTengo.add(dvd);
			}
		}
		// Imprimir la cantidad total
		System.out.println("Cantidad total de DVD que poseo: " + dvdQueTengo.size());
	}

}
