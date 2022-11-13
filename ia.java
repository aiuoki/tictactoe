import java.util.Scanner;

public class ia {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int [][] casilla = new int [3][3]; // TABLERO
		int fila = 0;
		int columna = 0;
		
		int contador = 0;
		boolean fin = false;
		
		do {
			
			System.out.println("Contador: " + contador + "\n");
			
			if(contador % 2 == 0) { // TURNO JUGADOR ----------------------------------------------------------------------------------------------------------------------------------
				
				System.out.println("Turno Jugador.");
				
				do{
					
					do {
						System.out.println("Dime la fila (del 1 al 3):");
						fila = teclado.nextInt();
					}while(fila < 1 || fila > 3); // VOLVERA A PEDIR LOS DATOS SI SE INTRODUCEN INCORRECTAMENTE
					
					do {
						System.out.println("Dime la columna (del 1 al 3):");
						columna = teclado.nextInt();
					}while(columna < 1 || columna > 3); // VOLVERA A PEDIR LOS DATOS SI SE INTRODUCEN INCORRECTAMENTE
					
					if(casilla[fila-1][columna-1] != 0) System.out.println("La casilla ha sido marcada!\nMarque otra casilla.\n"); // LO MOSTRARA SI AL CASILLA YA ESTA OCUPADA
				
				}while(casilla[fila-1][columna-1] != 0); // MIENTRAS LA CASILLA NO ESTE OCUPADA
				
				casilla[fila-1][columna-1] = 1;
				
			}
			
			if(contador % 2 == 1) { // TURNO IA ---------------------------------------------------
				
				System.out.println("Turno IA.");
				
				do{
					
					fila = (int) (Math.random()*3); // GENERA UNA FILA RANDOM
					
					columna = (int) (Math.random()*3); // GENERA UNA COLUMNA RANDOM
					
				}while(casilla[fila][columna] != 0); // MIENTRAS LA CASILLA NO ESTE OCUPADA
				
				System.out.println("Fila: " + fila + "\nColumna: " + columna);
				
				casilla[fila][columna] = 2;
				
			}
			
			// TABLERO --------------------------------------------------------------------------
			
			System.out.print("\n\t---\t---\t---\n\t|1|\t|2|\t|3|\n\t---\t---\t---\n\n");
			for(int i = 0; i < 3; i++) {
				System.out.print("---\n|" + (i+1) + "|");
				for(int j = 0; j < 3; j++) {
					System.out.print("\t " + casilla[i][j]);
				}
				System.out.println("\n---\n");
			}
			
			int jug = ((contador % 2)+1);
			
			if( // VICTORIA -----------------------------------------------------------------------------------
			(casilla[fila-1][0] == jug && casilla[fila-1][1] == jug && casilla[fila-1][2] == jug) ||
			(casilla[0][columna-1] == jug && casilla[1][columna-1] == jug && casilla[2][columna-1] == jug) ||
			(casilla[0][0] == jug && casilla[1][1] == jug && casilla[2][2] == jug) ||
			(casilla[0][2] == jug && casilla[1][1] == jug && casilla[2][0] == jug)
			) {
				System.out.println("El jugador " + jug + " ha ganado");fin = true;
			}else if(contador == 8) {
				System.out.println("Empate!");fin = true;
			}
			
			contador++;
			
		}while(fin == false);
		
		System.out.println("FIN DEL JUEGO");
		
		teclado.close();
	}
}
