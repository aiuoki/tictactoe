import java.util.Scanner;

public class tttoe {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		
		int menu = 0;
		
		System.out.println("◝(ᵔᵕᵔ)◜ ¡TIC TAC TOE! ◝(ᵔᵕᵔ)◜");
		
		do {
			
			do {
				System.out.println("\nSeleccione el modo de juego:\n1. - 2 Jugadores (un turno cada uno).\n2. - Jugador vs IA (Inteligencia Artificial).\n9. - Salir del programa.");
				menu = teclado.nextInt();
				if(menu != 1 && menu != 2 && menu != 9) System.out.println("\nSeleccione una opcion correcta!!");
			}while(menu != 1 && menu != 2 && menu != 9);
			
			
			if(menu == 1) {
				
				int [][] casilla = new int [3][3]; // TABLERO
				int fila, columna;
				
				int contador = 0;
				boolean fin = false;
				
				do {
					System.out.println("Turno del jugador " + ((contador % 2) + 1) + ".");
					do {
						do {
							System.out.println("Dime la fila (del 1 al 3):");
							fila = teclado.nextInt();
						}while(fila < 1 || fila > 3);
						do {
							System.out.println("Dime la columna (del 1 al 3):");
							columna = teclado.nextInt();
						}while(columna < 1 || columna > 3);
						if(casilla[fila-1][columna-1] != 0) System.out.println("La casilla ha sido marcada!\nMarque otra casilla.\n");
					}while(casilla[fila-1][columna-1] != 0);
					
					casilla[fila-1][columna-1] = ((contador % 2) + 1);
					
					System.out.print("\n\t---\t---\t---\n\t|1|\t|2|\t|3|\n\t---\t---\t---\n\n");
					for(int i = 0; i < 3; i++) {
						System.out.print("---\n|" + (i+1) + "|");
						for(int j = 0; j < 3; j++) {
							System.out.print("\t " + casilla[i][j]);
						}
						System.out.println("\n---\n");
					}
					
					int jug = ((contador % 2)+1);
					
					if( // VICTORIA JUGADOR
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
					
				}while(fin != true);
				
			}
			
			
			if(menu == 2) {
				
				int [][] casilla = new int [3][3]; // TABLERO
				int fila = 0;
				int columna = 0;
				
				int contador = 0;
				boolean fin = false;
				
				do {
					
					System.out.println("Contador: " + contador + "\n");
					
					if(contador % 2 == 1) { // TURNO JUGADOR ----------------------------------------------------------------------------------------------------------------------------------
						
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
					
					if(contador % 2 == 0) { // TURNO IA ---------------------------------------------------
						
						System.out.println("Turno IA.");
						
						
						// SI EMPIEZA LA IA
						if(contador == 0) casilla[2][0] = 2;
						
						
						// SI EL USUARIO ELIJE UNA POSICION CERCANA VAMOSA A ELEJIR UNA ESQUINA LEJANA
						if(contador == 2 && (casilla[1][0] == 1 || casilla [2][1] == 1)) {
							
							if(casilla[1][0] == 1) casilla[2][2] = 2;
							if(casilla[2][1] == 1) casilla[0][0] = 2;
							
						}
						
						if(contador == 4 && casilla[1][0] == 1 && casilla[2][1] != 1 && casilla[2][2] == 2) casilla[2][1] = 2; // GANA LA IA
						
						if(contador == 4 && casilla[1][0] == 1 && casilla[2][1] == 1 && casilla[2][2] == 2) casilla[0][2] = 2;
						if(contador == 6 && casilla[1][0] == 1 && casilla[2][1] == 1 && casilla[1][1] == 1 && casilla[2][2] == 2 && casilla[0][2] == 2) casilla[1][2] = 2; // GANA LA IA
						if(contador == 6 && casilla[1][0] == 1 && casilla[2][1] == 1 && casilla[1][2] == 1 && casilla[2][2] == 2 && casilla[0][2] == 2) casilla[1][1] = 2; // GANA LA IA
						
						
						if(contador == 4 && casilla[2][1] == 1 && casilla[1][0] != 1 && casilla[0][0] == 2) casilla[1][0] = 2; // GANA LA IA
						
						if(contador == 4 && casilla[2][1] == 1 && casilla[1][0] == 1 && casilla[0][0] == 2) casilla[0][2] = 2;
						if(contador == 6 && casilla[2][1] == 1 && casilla[1][0] == 1 && casilla[1][1] == 1 && casilla[0][0] == 2 && casilla[0][2] == 2) casilla[0][1] = 2; // GANA LA IA
						if(contador == 6 && casilla[2][1] == 1 && casilla[1][0] == 1 && casilla[0][1] == 1 && casilla[0][0] == 2 && casilla[0][2] == 2) casilla[1][1] = 2; // GANA LA IA
						
						
						// SI EL USUARIO ELIJE UNA ESQUINA VAMOS A ELEJIR UNA ESQUINA CONTRARIA
						if(contador == 2 && (casilla[0][0] == 1 || casilla [2][2] == 1)) {
							
							if(casilla[0][0] == 1) casilla[2][2] = 2;
							if(casilla[2][2] == 1) casilla[0][0] = 2;
							
						}
						
						if(contador == 4 && casilla[0][0] == 1 && casilla[2][1] != 1 && casilla[2][2] == 2) casilla[2][1] = 2; // GANA LA IA
						
						if(contador == 4 && casilla[0][0] == 1 && casilla[2][1] == 1 && casilla[2][2] == 2) casilla[0][2] = 2;
						if(contador == 6 && casilla[0][0] == 1 && casilla[2][1] == 1 && casilla[1][1] == 1 && casilla[2][2] == 2 && casilla[0][2] == 2) casilla[1][2] = 2;
						if(contador == 6 && casilla[0][0] == 1 && casilla[2][1] == 1 && casilla[1][2] == 1 && casilla[2][2] == 2 && casilla[0][2] == 2) casilla[1][1] = 2;
						
						
						if(contador == 4 && casilla[2][2] == 1 && casilla[1][0] != 1 && casilla[0][0] == 2) casilla[1][0] = 2; // GANA LA IA
						
						if(contador == 4 && casilla[2][2] == 1 && casilla[1][0] == 1 && casilla[0][0] == 2) casilla[0][2] = 2;
						if(contador == 6 && casilla[2][2] == 1 && casilla[1][0] == 1 && casilla[1][1] == 1 && casilla[0][0] == 2 && casilla[0][2] == 2) casilla[0][1] = 2; // GANA LA IA
						if(contador == 6 && casilla[2][2] == 1 && casilla[1][0] == 1 && casilla[0][1] == 1 && casilla[0][0] == 2 && casilla[0][2] == 2) casilla[1][1] = 2; // GANA LA IA
						
						
						// SI EL USUARIO ELIJE UNA POSICION LEJANA VAMOS A ELEJIR UNA ESQUINA LEJANA
						if(contador == 2 && (casilla[0][1] == 1 || casilla [1][2] == 1)) {
							
							if(casilla[0][1] == 1) casilla[0][0] = 2;
							if(casilla[1][2] == 1) casilla[2][2] = 2;
							
						}
						
						if(contador == 4 && casilla[0][1] == 1 && casilla[1][0] != 1 && casilla[0][0] == 2) casilla[1][0] = 2; // GANA LA IA
						
						if(contador == 4 && casilla[0][1] == 1 && casilla[1][0] == 1 && casilla[0][0] == 2) casilla[2][2] = 2;
						if(contador == 6 && casilla[0][1] == 1 && casilla[1][0] == 1 && casilla[1][1] == 1 && casilla[0][0] == 2 && casilla[2][2] == 2) casilla [2][1] = 2; // GANA LA IA
						if(contador == 6 && casilla[0][1] == 1 && casilla[1][0] == 1 && casilla[2][1] == 1 && casilla[0][0] == 2 && casilla[2][2] == 2) casilla [1][1] = 2; // GANA LA IA
						
						
						if(contador == 4 && casilla[1][2] == 1 && casilla[2][1] != 1 && casilla[2][2] == 2) casilla[2][1] = 2; // GANA LA IA
						
						if(contador == 4 && casilla[1][2] == 1 && casilla[2][1] == 1 && casilla[2][2] == 2) casilla[0][0] = 2;
						if(contador == 6 && casilla[1][2] == 1 && casilla[2][1] == 1 && casilla[1][1] == 1 && casilla[2][2] == 2 && casilla[0][0] == 2) casilla[1][0] = 2; // GANA LA IA
						if(contador == 6 && casilla[1][2] == 1 && casilla[2][1] == 1 && casilla[1][0] == 1 && casilla[2][2] == 2 && casilla[0][0] == 2) casilla[1][1] = 2; // GANA LA IA
						
						
						// SI EL USUARIO ELIJE UNA ESQUINA CONTRARIA VAMOS A ELEJIR OTRA ESQUINA
						if(contador == 2 && casilla[0][2] == 1) casilla[0][0] = 2;
						
						if(contador == 4 && casilla[0][2] == 1 && casilla[1][0] != 1 && casilla[0][0] == 2) casilla[1][0] = 2; // GANA LA IA
						
						if(contador == 4 && casilla[0][2] == 1 && casilla[1][0] == 1 && casilla[0][0] == 2) casilla[2][2] = 2;
						if(contador == 6 && casilla[0][2] == 1 && casilla[1][0] == 1 && casilla[1][1] == 1 && casilla[0][0] == 2 && casilla[1][0] == 2) casilla[2][1] = 2;
						if(contador == 6 && casilla[0][2] == 1 && casilla[1][0] == 1 && casilla[2][1] == 1 && casilla[0][0] == 2 && casilla[1][0] == 2) casilla[1][1] = 2;
						
						
						// SI EL USUARIO ELIJE EL MEDIO
						if(contador == 2 && casilla[1][1] == 1) casilla[0][2] = 2;
						
						
						if(contador == 4 && (casilla[0][0] == 1 || casilla[2][2] == 1)) { // SI EL USUARIO ELIJE EL MEDIO Y LUEGO UNA ESQUINA CERCANA
							
							if(casilla[1][1] == 1 && casilla[0][0] == 1 && casilla[0][2] == 2) casilla[2][2] = 2;
							if(casilla[1][1] == 1 && casilla[2][2] == 1 && casilla[0][2] == 2) casilla[0][0] = 2;
							
						}
						
						if(casilla[1][1] == 1 && contador == 6 && casilla[0][0] == 1 && casilla[2][1] == 1 && casilla[0][2] == 2 && casilla[2][2] == 2) casilla[1][2] = 2; // GANA LA IA
						if(casilla[1][1] == 1 && contador == 6 && casilla[0][0] == 1 && casilla[2][1] == 1 && casilla[0][2] == 2 && casilla[0][0] == 2) casilla[1][2] = 2; // GANA LA IA
						
						if(casilla[1][1] == 1 && contador == 6 && casilla[2][2] == 1 && casilla[1][0] == 1 && casilla[0][2] == 2 && casilla[2][2] == 2 && casilla[1][2] == 2) casilla[0][1] = 2; // GANA LA IA
						if(casilla[1][1] == 1 && contador == 6 && casilla[2][2] == 1 && casilla[0][1] == 1 && casilla[0][2] == 2 && casilla[0][0] == 2 && casilla[1][2] == 2) casilla[1][0] = 2; // GANA LA IA
						
						
						if(contador == 4 && (casilla[0][1] == 1 || casilla[1][0] == 1 || casilla[1][2] == 1 || casilla[2][1] == 1)) { // SI EL USUARIO ELIJE EL MEDIO Y LUEGO UNA POSICION DE LA CRUZ
							
							if(casilla[1][1] == 1 && casilla[0][1] == 1 && casilla[0][2] == 2) casilla[2][1] = 2;
							if(casilla[1][1] == 1 && casilla[1][0] == 1 && casilla[0][2] == 2) casilla[1][2] = 2;
							if(casilla[1][1] == 1 && casilla[1][2] == 1 && casilla[0][2] == 2) casilla[1][0] = 2;
							if(casilla[1][1] == 1 && casilla[2][1] == 1 && casilla[0][2] == 2) casilla[0][1] = 2;
							
						}
						
						if(contador == 6 && casilla[1][1] == 1 && casilla[0][1] == 1 && casilla[0][2] == 2 && casilla[2][1] == 2 && casilla[2][2] != 1) casilla[2][2] = 2; // GANA LA IA
						if(contador == 6 && casilla[1][1] == 1 && casilla[1][0] == 1 && casilla[0][2] == 2 && casilla[1][2] == 2 && casilla[2][2] != 1) casilla[2][2] = 2; // GANA LA IA
						if(contador == 6 && casilla[1][1] == 1 && casilla[1][2] == 1 && casilla[0][2] == 2 && casilla[1][0] == 2 && casilla[0][0] != 1) casilla[0][0] = 2; // GANA LA IA
						if(contador == 6 && casilla[1][1] == 1 && casilla[2][1] == 1 && casilla[0][2] == 2 && casilla[0][1] == 2 && casilla[0][0] != 1) casilla[0][0] = 2; // GANA LA IA
						
						if(contador == 6 && casilla[1][1] == 1 && casilla[0][1] == 1 && casilla[0][2] == 2 && casilla[2][1] == 2 && casilla[2][2] == 1) casilla[0][0] = 2;
						if(contador == 6 && casilla[1][1] == 1 && casilla[1][0] == 1 && casilla[0][2] == 2 && casilla[1][2] == 2 && casilla[2][2] == 1) casilla[0][0] = 2;
						if(contador == 6 && casilla[1][1] == 1 && casilla[1][2] == 1 && casilla[0][2] == 2 && casilla[1][0] == 2 && casilla[0][0] == 1) casilla[2][2] = 2;
						if(contador == 6 && casilla[1][1] == 1 && casilla[2][1] == 1 && casilla[0][2] == 2 && casilla[0][1] == 2 && casilla[0][0] == 1) casilla[2][2] = 2;
						
						if(contador == 8 && casilla[1][1] == 1 && casilla[0][1] == 1 && casilla[0][2] == 2 && casilla[2][1] == 2 && casilla[2][2] == 1 && casilla[0][0] == 2 && casilla[1][0] != 1) casilla[1][0] = 2; // GANA LA IA
						if(contador == 8 && casilla[1][1] == 1 && casilla[1][0] == 1 && casilla[0][2] == 2 && casilla[1][2] == 2 && casilla[2][2] == 1 && casilla[0][0] == 2 && casilla[0][1] != 1) casilla[0][1] = 2; // GANA LA IA
						if(contador == 8 && casilla[1][1] == 1 && casilla[1][2] == 1 && casilla[0][2] == 2 && casilla[1][0] == 2 && casilla[0][0] == 1 && casilla[2][2] == 2 && casilla[2][1] != 1) casilla[2][1] = 2; // GANA LA IA
						if(contador == 8 && casilla[1][1] == 1 && casilla[2][1] == 1 && casilla[0][2] == 2 && casilla[0][1] == 2 && casilla[0][0] == 1 && casilla[2][2] == 2 && casilla[1][2] != 1) casilla[1][2] = 2; // GANA LA IA
						
						if(contador == 8 && casilla[1][1] == 1 && casilla[0][1] == 1 && casilla[0][2] == 2 && casilla[2][1] == 2 && casilla[2][2] == 1 && casilla[0][0] == 2 && casilla[1][0] == 1) casilla[1][2] = 2; // EMPATE
						if(contador == 8 && casilla[1][1] == 1 && casilla[1][0] == 1 && casilla[0][2] == 2 && casilla[1][2] == 2 && casilla[2][2] == 1 && casilla[0][0] == 2 && casilla[0][1] == 1) casilla[2][1] = 2; // EMPATE
						if(contador == 8 && casilla[1][1] == 1 && casilla[1][2] == 1 && casilla[0][2] == 2 && casilla[1][0] == 2 && casilla[0][0] == 1 && casilla[2][2] == 2 && casilla[2][1] == 1) casilla[0][1] = 2; // EMPATE
						if(contador == 8 && casilla[1][1] == 1 && casilla[2][1] == 1 && casilla[0][2] == 2 && casilla[0][1] == 2 && casilla[0][0] == 1 && casilla[2][2] == 2 && casilla[1][2] == 1) casilla[1][0] = 2; // EMPATE
						
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
					
					if( // VICTORIA -----------------------------------------------------------------------------------
					contador % 2 == 0 &&
					(casilla[0][0] == 2 && casilla[0][1] == 2 && casilla[0][2] == 2) ||
					(casilla[1][0] == 2 && casilla[1][1] == 2 && casilla[1][2] == 2) ||
					(casilla[2][0] == 2 && casilla[2][1] == 2 && casilla[2][2] == 2) ||
					(casilla[0][0] == 2 && casilla[1][0] == 2 && casilla[2][0] == 2) ||
					(casilla[0][1] == 2 && casilla[1][1] == 2 && casilla[2][1] == 2) ||
					(casilla[0][2] == 2 && casilla[1][2] == 2 && casilla[2][2] == 2) ||
					(casilla[0][0] == 2 && casilla[1][1] == 2 && casilla[2][2] == 2) ||
					(casilla[0][2] == 2 && casilla[1][1] == 2 && casilla[2][0] == 2)
					) {
						System.out.println("La IA ha ganado.");
						fin = true;
					}else if(contador == 8) {
						System.out.println("Empate!");fin = true;
					}
					
					contador++;
					
				}while(fin == false);
				
			}
			
		}while(menu != 9);
		
		System.out.println("\nFIN DEL JUEGO ! ◝(ᵔᵕᵔ)◜");
		
		teclado.close();
		
		// FIRMADO POR DANIEL CEBAN 16/11/2022 14:34
		// AQUEST EXERCICI M'HA AGRADAT MOLT, SOL HE POGUT FER LA IA QUE MAI ES DEIXA GUANYAR PERO SOL SI COMENCA ELLA PER FALTA DE TEMPS 
		// AQUEST CAP DE SETMANA ACABARE LA IA PERQUE COMENCI DE FORMA RANDOM EL PRIMER I LA PUJARE AL GITHUB
		// GITHUB (DE MOMENT EL TINC EN PRIVAT FINS QUE ACABI LA PART DE LA IA): https://github.com/aiuoki/tictactoe
	}
}