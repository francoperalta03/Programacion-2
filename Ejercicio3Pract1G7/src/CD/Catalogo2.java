//TRABAJO PRACTICO N°2: 
//INTEGRANTES: PERALTA FRANCO, SOSA TOMAS, SANABRIA RAMIRO
//CATALOGO CD
package CD;
import java.util.ArrayList;
import java.util.Scanner;

	public class Catalogo2 {
		// Inicia el scanner 
			static Scanner teclado = new Scanner(System.in);
					
			// Creamos el arraylist con los CD's (colección de CDs) 
			public static ArrayList<CD> catalogo = new ArrayList<CD> ();
			
			// Método para ingresar un CD
			public static void ingresarCD(CD a) {
				catalogo.add(a);
			}
			
			// Creamos funcion eliminatoria de CDs (El int i es la posición en la cual se encuentra el CD)
			public static void eliminarCD(String titulo) {
				boolean eliminado = false;
			    for (int i = 0; i < catalogo.size(); i++) {
			        CD cd = catalogo.get(i);
			        if (cd.getTitulo().equalsIgnoreCase(titulo)) {
			        	catalogo.remove(i);
			            eliminado = true;
			            break;
			        }
			    }
			    if (eliminado) {
			        System.out.println("El CD ha sido eliminado.\n");
			    } else {
			        System.out.println("No se ha encontrado un CD con ese titulo.\n");
			    }
			}
			
			//  Método para modificar los CDs por nombre
			public static void modificarCD(String nombre) {
				boolean modificado = false;
			    for (int i = 0; i < catalogo.size(); i++) {
			        CD cd = catalogo.get(i);
			        if (cd.getTitulo().equalsIgnoreCase(nombre)) {
			        	// Inputs
			        	System.out.println("Ingresar los datos del CD:");
			 			System.out.print("Ingrese el título del CD: ");
			 			String titulo = teclado.nextLine();
			 			System.out.print("Ingrese el interprete del CD: ");
				 		String interprete = teclado.nextLine();
				 		System.out.print("Ingrese cantidad de temas que tiene el CD: ");
				 		int cantidad = teclado.nextInt();
			 		    System.out.print("Ingrese el género del CD: ");
			 		   teclado.nextLine();
			 		    String genero = teclado.nextLine();
			 		    System.out.print("Ingrese la duracion en minutos del CD: ");
			 		    int duracion = teclado.nextInt();
			 		    teclado.nextLine();
			 		    System.out.print("¿Tiene el CD? (s/n): ");
			 		    boolean tenencia = teclado.nextLine().equalsIgnoreCase("s");
			 		    System.out.print("Ingrese un comentario (Excelente, Muy Buena, Buena, Regular, Mala): ");
			 		    String comentario = teclado.nextLine();


			 		    // Realizar los cambios
			 		    cd.setTitulo(titulo);
			 		    cd.setGenero(genero);
			 		    cd.setDuracion(duracion);
			 		    cd.settenencia(tenencia);
			 		    cd.setComentario(comentario);
			 		    cd.setinterprete(interprete);
			 		   cd.setCantidad(cantidad);
			 		    System.out.println("CD modificado correctamente.\n");
			            modificado = true;
			            break;
			        }
			    }
			    if (modificado) {
			        System.out.println("CD modificado correctamente.\n");
			    } else {
			        System.out.println("No se encontró un CD con el título ingresado.\n");
			    }
			}
			
			//   listar todos los CDs 
			public static void listarCDs() {
				System.out.println("Lista de los CD's que tengo: \n");
				for (int i = 0; i < catalogo.size(); i++) {
					CD CD = catalogo.get(i);
					System.out.println(CD);
				}
				System.out.println("\n");
			}
			
			//   listar todos los CDs en tenencia
			public static void listarCDEntenencia() {
				System.out.println("Lista de los CDs que tengo: \n");
				for (int i = 0; i< catalogo.size(); i++) {
					CD CD = catalogo.get(i);
					if (CD.istenencia() == true) {
						System.out.println(CD);
					}
				}
				System.out.println("\n");
			}
			
			//listar por duracion
			public static void listarPorTiempo(int tiempo) {
				System.out.println("Lista de los CDs que tengo menores a " + tiempo + " minutos:\n");
				for (int i = 0; i< catalogo.size(); i++) {
					CD CD = catalogo.get(i);
					if (CD.getDuracion() < tiempo) {
						System.out.println(CD);
					}
				}
				System.out.println("\n");
			}
			
			//  listar por interprete
				public static void listarPorinterprete(String interprete) {
				System.out.println("Lista de los CDs que tengo del interprete '" + interprete + "' \n");
				for (int i = 0; i< catalogo.size(); i++) {
					CD CD = catalogo.get(i);
					if (CD.getinterprete().equals(interprete)) {
						System.out.println(CD);
					}
				}
				System.out.println("\n");
				}
			
			//  listar todos los CDs ordenados
			public static void listarCDsOrdenados() {
	ArrayList<CD> copiacatalogo = new ArrayList<>(catalogo);
			    int n = copiacatalogo.size();

			    // Lista ordenada de cds
			    boolean intercambio = true;
			    while (intercambio) {
			        // Comenzar con intercambio 
			        intercambio = false;
			        // Comparar 2 elementos 
			        for (int i = 0; i < n - 1; i++) {
			            // Obtener los elementos 
			            CD actual = copiacatalogo.get(i);
			            CD siguiente = copiacatalogo.get(i + 1);
			            // Si el título del elemento actual es mayor que el título del siguiente elemento 
			            if (actual.getTitulo().compareToIgnoreCase(siguiente.getTitulo()) > 0) {
			                // Intercambiar los elementos
			                copiacatalogo.set(i, siguiente);
			                copiacatalogo.set(i + 1, actual);
			                // Establecer intercambio 
			                intercambio = true;
			            }
			        }
			        n--;
			    }
			    // Imprimir la lista ordenada
			    System.out.println("Lista de CDs ordenados por título:");
			    for (CD CD : copiacatalogo) {
			        // Para cada CD en la copia ordenada de la colección:
			        // Imprimir el CD 
			        System.out.println(CD);
			    }
			    // Imprimir una línea en blanco para separar la salida de la lista de CDs de otros mensajes
			    System.out.println();
			}
			
			// Método para decir la cantidad de CDs en tenencia
			public static void CDsEntenencia() {
				// Crear una nuevo array list donde se van a agregar todos los CDs que posea
				ArrayList<CD> CDQueTengo = new ArrayList<>();
				// Fijarse en la catalogo cuales poseo
				for (int i = 0; i< catalogo.size(); i++) {
					CD CD = catalogo.get(i);
					// Si lo poseo agregar a el array list
					if (CD.istenencia() == true) {
						CDQueTengo.add(CD);
					}
				}
				// Imprimir la cantidad total
				System.out.println("Cantidad total de CD que poseo: " + CDQueTengo.size());
			}

		}





