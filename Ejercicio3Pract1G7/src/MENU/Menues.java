//TRABAJO PRACTICO N°2: 
//INTEGRANTES: PERALTA FRANCO, SOSA TOMAS, SANABRIA RAMIRO
//MENU EN GENERAL
package MENU;

import java.util.Scanner;
import CD.CD;
import CD.Catalogo2;
import DVD.Dvd; 
import DVD.Catalogo;
public class Menues {
	public static void menuDvd(){
		// Iniciar scanner para input
		Scanner teclado = new Scanner(System.in);
		// Iniciar un boolean para que termine el programa en falso para que pueda comenzar
		boolean salir = false;
	    while (!salir) {
	    	// Imprimir menu de opciones
	    	System.out.println("\033[33m1. Ingresar informacion sobre un DVD");
	    	System.out.println("\033[33m2. Eliminar un DVD conociendo el titulo");
	    	System.out.println("\033[33m3. Modificar los valores de uno o mas atributos conociendo el titulo");
	    	System.out.println("\033[32m4. Listar todos los DVD");
	    	System.out.println("5. Listar los DVD que tengo");
	    	System.out.println("6. Listar los DVD que duran menos de un tiempo dado en minutos");
	    	System.out.println("7. Listar los DVD de un determinado director");
	    	System.out.println("8. Listar todos los DVD ordenados por titulo");
	    	System.out.println("\033[31m9. Informar la cantidad total de DVD");
	    	System.out.println("10. Informar la cantidad de DVD que tengo");
	    	System.out.println("11. Salir");
	    	
	    	// Input 
	    	System.out.print("\033[36mIngrese una opcion: \n");
	    	int opcion = teclado.nextInt();
	    	// Limpiar el buffer de entrada
	    	teclado.nextLine(); 
	    	
	    	// Opciones
	    	switch (opcion) {
	    		// información sobre un DVD 
		 		case 1:
		 			System.out.print("Ingrese el título del DVD: ");
		 		    String titulo = teclado.nextLine();
		 		    System.out.print("Ingrese el género del DVD: ");
		 		    String genero = teclado.nextLine();
		 		    System.out.print("Ingrese el nombre del director: ");
		 		    String director = teclado.nextLine();
		 		    System.out.print("Ingrese la duración en minutos del DVD: ");
		 		    int duracion = teclado.nextInt();
		 		    // Limpiar el buffer
		 		    teclado.nextLine(); 
		 		    System.out.print("¿Tiene el DVD? (s/n): ");
		 		    boolean tenencia = teclado.nextLine().equalsIgnoreCase("s");
		 		    System.out.print("Ingrese un comentario (Excelente, Muy Buena, Buena, Regular, Mala): ");
		 		    String comentario = teclado.nextLine();
		 		    // se crea el nuevo dvd
 		 		    Catalogo.ingresarDVD(new Dvd(titulo, genero, duracion, tenencia, comentario, director));
		 		    System.out.println("DVD añadido correctamente.\n");
		 			break;
		 		// Eliminar un DVD 
		 		case 2:
		 			System.out.print("Ingrese el titulo del DVD a eliminar: ");
		 		    String tituloAEliminar = teclado.nextLine();
		 			Catalogo.eliminarDVD(tituloAEliminar);
		 			break;
	 			// Modificar los valores de uno o más atributos conociendo el título
		 		case 3:
		 			System.out.print("Ingrese el título del DVD a modificar: ");
		 		    String tituloAModificar = teclado.nextLine();
		 			Catalogo.modificarDvd(tituloAModificar);
		 			break;
	 			// Listar todos los DVDs q hay
		 		case 4:
			    	Catalogo.listarDvds();
			        break;
			    // Listar los DVDs que yo tengo
		 		case 5:
		 			Catalogo.listarDvdEntenencia();
			        break;
			    // Listar los DVD que duran menos de un tiempo estimando en minutos
		 		case 6:
		 			System.out.print("Ingrese el tiempo máximo que debe durar el dvd (En minutos): ");
		 		    int tiempo = teclado.nextInt();
		 		   Catalogo.listarPorTiempo(tiempo);
			        break;
			    // Listar los DVD de un determinado director    
			    case 7:
			    	System.out.print("Ingrese el nombre del director del que deseas obtener el listado: ");
		 		    String directorListado = teclado.nextLine();
			    	Catalogo.listarPorDirector(directorListado);
			        break;
			    // Listar todos los DVD ordenados por título
			    case 8:
			    	Catalogo.listarDvdsOrdenados();
			        break;
			    // Informar la cantidad total de DVDs
			    case 9:
			        System.out.println("Cantidad total de DVD: " + Catalogo.catalogo.size() + "\n");
			        break;
				// Informar la cantidad de DVD que tengo en tenencia
			    case 10:
			    	Catalogo.dvdsEntenencia();
				    break;
	            // Salir
			    case 11:
	                salir = true;
	                break;
	            default:
	                System.out.println();
		         }
		 	 }   
		// Cerrar teclado
	    teclado.close();
	}
	public static void menuCD(){
		// Iniciar scanner para input
		Scanner teclado = new Scanner(System.in);
		// Iniciar un boolean para que termine el programa en falso para que pueda comenzar
		boolean salir = false;
	    while (!salir) {
	    	// Imprimir menu de opciones
	    	System.out.println("\033[33m1. Ingresar informacion sobre un CD");
	    	System.out.println("\033[33m2. Eliminar un CD conociendo el titulo");
	    	System.out.println("\033[33m3. Modificar los valores de uno o mas atributos conociendo el titulo");
	    	System.out.println("\033[32m4. Listar todos los CD");
	    	System.out.println("5. Listar los CD que tengo");
	    	System.out.println("6. Listar los CD que duran menos de un tiempo dado en minutos");
	    	System.out.println("7. Listar los CD de un determinado interprete");
	    	System.out.println("8. Listar todos los CD ordenados por titulo");
	    	System.out.println("\033[31m9. Informar la cantidad total de CD");
	    	System.out.println("10. Informar la cantidad de CD que tengo");
	    	System.out.println("11. Salir");
	    	
	    	// Input de la opción elegida
	    	System.out.print("\033[36mIngrese una opcion: \n");
	    	int opcion = teclado.nextInt();
	    	// Limpiar el buffer de entrada
	    	teclado.nextLine(); 
	    	
	    	// Opciones
	    	switch (opcion) {
	    		// Ingresar información sobre un CD 
		 		case 1:
		 			System.out.print("Ingrese el título del CD: ");
		 		    String titulo = teclado.nextLine();
		 		   
		 		    System.out.print("Ingrese el interprete del CD: ");
		 		    String interprete = teclado.nextLine();
		 		   
		 		   System.out.print("Ingrese cantidad de temas que tiene el CD: ");
		 		    int cantidad = teclado.nextInt();
		 		    
		 		    System.out.print("Ingrese el genero del CD: ");
		 		    teclado.nextLine(); 
		 		    String genero = teclado.nextLine();
		 		    System.out.print("Ingrese la duración en minutos del CD: ");
		 		    int duracion = teclado.nextInt();
		 		    // Limpiar el buffer de entrada
		 		  
		 		    System.out.print("¿Tiene el CD? (s/n): ");
		 		    boolean tenencia = teclado.nextLine().equalsIgnoreCase("s");
		 		   teclado.nextLine(); 
		 		    System.out.print("Ingrese un comentario (Excelente, Muy Buena, Buena, Regular, Mala): ");
		 		    String comentario = teclado.nextLine();
		 		    // Una vez ingresados los datos en el input se ingresa el nuevo CD (Creandolo)
 		 		    Catalogo2.ingresarCD(new CD(titulo, genero, duracion, tenencia, comentario, interprete, cantidad));
		 		    System.out.println("CD añadido correctamente.\n");
		 			break;
		 		// Eliminar un CD conociendo el nombre
		 		case 2:
		 			System.out.print("Ingrese el titulo del CD a eliminar: ");
		 		    String tituloAEliminar = teclado.nextLine();
		 			Catalogo2.eliminarCD(tituloAEliminar);
		 			break;
	 			// Modificar los valores de uno o más atributos conociendo el título
		 		case 3:
		 			System.out.print("Ingrese el título del CD a modificar: ");
		 		    String tituloAModificar = teclado.nextLine();
		 			Catalogo2.modificarCD(tituloAModificar);
		 			break;
	 			// Listar todos los CDs
		 		case 4:
			    	Catalogo2.listarCDs();
			        break;
			    // Listar los CDs que tengo
		 		case 5:
		 			Catalogo2.listarCDEntenencia();
			        break;
			    // Listar los CD que duran menos de un tiempo dado en minutos
		 		case 6:
		 			System.out.print("Ingrese el tiempo máximo que debe durar el CD (En minutos): ");
		 		    int tiempo = teclado.nextInt();
		 		   Catalogo2.listarPorTiempo(tiempo);
			        break;
			    // Listar los CD de un determinado interprete    
			    case 7:
			    	System.out.print("Ingrese el nombre del interprete del que deseas obtener el listado: ");
		 		    String interpreteListado = teclado.nextLine();
			    	Catalogo2.listarPorinterprete(interpreteListado);
			        break;
			    // Listar todos los CD ordenados por título (no funciona ;( )
			  //  case 8:
			    //	Catalogo2.listarCDsOrdenado();
			     //   break;
			    // Informar la cantidad total de CDs
			    case 9:
			        System.out.println("Cantidad total de CD: " + Catalogo.catalogo.size() + "\n");
			        break;
				// Informar la cantidad de CD que tengo en tenencia
			    case 10:
			    	Catalogo2.CDsEntenencia();
				    break;
	            // Salir
			    case 11:
	                salir = true;
	                break;
	            default:
	                System.out.println();
		         }
		 	 }   
		// Cerrar teclado
	    teclado.close();
	}
}
