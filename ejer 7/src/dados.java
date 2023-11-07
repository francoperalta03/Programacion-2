//EJERCICIO 7 PRACTICA 0 (DADOS CLASS)
// INTEGRANTES: PERALTA- SOSA-SANABRIA
import java.util.Random;

public class dados {
	// Inicializacion del random.
	private static final Random random = new Random();
	
	//variables
	private int dado1;
	private int dado2;

	
	public dados(int d1, int d2) {
		this.dado1 = d1;
		this.dado2 = d2;
	}

	//getters
	public int getDado1() {
		return dado1;
	}
	public int getDado2() {
		return dado2;
	}

	//random; funcion para tirar un numero al azar
	public static int tirarDados() {
	    return random.nextInt(6) + 1;
	}	
}