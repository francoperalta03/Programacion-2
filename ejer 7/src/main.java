//EJERCICIO 7- PRACTICA 0 (MAIN CLASS)
// INTEGRANTES: PERALTA, SOSA, SANABRIA

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Inicio 
				dados d1 = new dados(dados.tirarDados(), dados.tirarDados());
				
				// Atributos (iniciacion)
				int suma = d1.getDado1() + d1.getDado2();
				int puntos = 0;
				boolean ganador = false;
				
				// Imprimir 
				System.out.println("el Dado 1 es: " + d1.getDado1() + ", el Dado 2 es: " + d1.getDado2() + ", la Suma de dados es de: " + suma + " puntos");
				
				// Verificar con un if
				if (suma == 7 || suma == 11) {
					System.out.println("¡Genial, Ganaste. te felicito!");
					ganador = true;
				} 
				else 
					if (suma == 2 || suma == 3 || suma == 12) {
					System.out.println("¡Perdiste!");
				}
					else {
					
				    System.out.println("el puntaje fue de " + suma + " puntos Totales.");
					// Establecer el valor de la suma a los puntos
					puntos = suma;
					// si no gana tira nuevamente 
					while (!ganador) {
						// Iniciar otros dados
						d1 = new dados(dados.tirarDados(), dados.tirarDados());
						suma = d1.getDado1() + d1.getDado2();
						// Imprimir 
						System.out.println("Dado 1: " + d1.getDado1() + ", Dado 2: " + d1.getDado2() + ", Suma de dados: " + suma);
						
						if (suma == puntos) {
						System.out.println("¡Felicidades, ganaste!¡Tus puntos son igual a la suma de dados!");
						ganador = true;
						
						} else if (suma == 7) {
							System.out.println("oh no! has perdido ya que te ha tocado un 7!");
							ganador = true;
							}
					}
				}
			}
		
	}


