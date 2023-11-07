//TRABAJO PRACTICO N°2: 
//INTEGRANTES: PERALTA FRANCO, SOSA TOMAS, SANABRIA RAMIRO
//MAIN
package MENU;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		while(true) {
			System.out.println("1.Catalogo DVD");
			System.out.println("2.Catalogo CD");
			System.out.println("INGRESE UNA OPCION:");
			var opcion = teclado.nextLine();
			if (opcion.equals("1")) {
				Menues.menuDvd();
			} 
			else if (opcion.equals("2")) {
				Menues.menuCD();
				
			}
			// cerrar teclado 
			teclado.close();
			}
	}
}
