import java.util.Scanner;

public class tictactoe {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		int [][] casilla = new int [3][3]; // TABLERO
		int fila, columna;
		
		int contador = 0;
		boolean fin = false;
		
		System.out.println("◝(ᵔᵕᵔ)◜ ¡TIC TAC TOE! ◝(ᵔᵕᵔ)◜\n");
		
		do {
			
			System.out.print("\n\t---\t---\t---\n\t|1|\t|2|\t|3|\n\t---\t---\t---\n\n");
			for(int i = 0; i < 3; i++) {
				System.out.print("---\n|" + (i+1) + "|");
				for(int j = 0; j < 3; j++) {
					System.out.print("\t " + casilla[i][j]);
				}
				System.out.println("\n---\n");
			}
			
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
		
		System.out.println("\nFIN DEL PROGRAMA! ◝(ᵔᵕᵔ)◜");
		teclado.close();
	}
}
