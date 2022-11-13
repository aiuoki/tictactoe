import java.util.Scanner;

public class tictactoe {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		
		int [][] casilla = new int [3][3];
		
		int fila, columna;
		
		int contador = 0;
		
		boolean jugador1 = false;
		
		boolean jugador2 = false;
		
		
		System.out.println("◝(ᵔᵕᵔ)◜ ¡TIC TAC TOE! ◝(ᵔᵕᵔ)◜\n");
		
		do {
			
			if(contador % 2 == 0) System.out.println("Turno del jugador 1.");
			if(contador % 2 == 1) System.out.println("Turno del jugador 2.");
			
			System.out.println("Dime la fila:"); // PREGUNTAMOS POR LA FILA
			fila = teclado.nextInt();
			
			while(fila < 1 || fila > 3) { // SI LA FILA ES MENOR A 1 O MAYOR A 3 VOLVEREMOS A PREGUNTAR LA FILA
				System.out.println("Introduzca una fila del 1 al 3!");
			}
			
			
			System.out.println("Dime la columna:"); // PREGUNTAMOS POR LA COLUMNA
			columna = teclado.nextInt();
			
			
			while(columna < 1 || columna > 3) { // SI LA COLUMNA ES MENOR A 1 O MAYOR A 3 VOLVEREMOS A PREGUNTAR LA COLUMNA
				System.out.println("Introduzca una fila del 1 al 3!");
			}
			
			while(casilla[fila-1][columna-1] == 1 || casilla[fila-1][columna-1] == 2) { // SI LA CASILLA YA HA SIDO MARCADA PEDIRA QUE MARQUE OTRA CASILLA
				
				System.out.println("La casilla ha sido marcada!\nMarque otra casilla.\n");
				
				System.out.println("Dime la fila:"); // PREGUNTAMOS POR LA FILA
				fila = teclado.nextInt();
				
				while(fila < 1 || fila > 3) { // SI LA FILA ES MENOR A 1 O MAYOR A 3 VOLVEREMOS A PREGUNTAR LA FILA
					System.out.println("Introduzca una fila del 1 al 3!");
				}
				
				
				System.out.println("Dime la columna:"); // PREGUNTAMOS POR LA COLUMNA
				columna = teclado.nextInt();
				
				while(columna < 1 || columna > 3) { // SI LA COLUMNA ES MENOR A 1 O MAYOR A 3 VOLVEREMOS A PREGUNTAR LA COLUMNA
					System.out.println("Introduzca una fila del 1 al 3!");
				}
				
			}
			
			if(contador % 2 == 0) casilla[fila-1][columna-1] = 1;
			if(contador % 2 == 1) casilla[fila-1][columna-1] = 2;
			
			System.out.print("\n\t---\t---\t---\n\t|1|\t|2|\t|3|\n\t---\t---\t---\n\n"); // PRINTAMOS LAS COLUMNAS
			
			for(int i = 0; i < 3; i++) {
				
				System.out.print("---\n|" + (i+1) + "|"); // PRINTAMOS LAS FILAS
				
				for(int j = 0; j < 3; j++) {
					
					System.out.print("\t " + casilla[i][j]); // PRINTAMOS LAS CASILLAS
					
				}
				
				System.out.println("\n---\n");
				
			}
			
			fila = 0;
			columna = 0;
			
			if(
			(casilla[0][0] == 1 && casilla[0][1] == 1 && casilla[0][2] == 1) ||
			(casilla[1][0] == 1 && casilla[1][1] == 1 && casilla[1][2] == 1) ||
			(casilla[2][0] == 1 && casilla[2][1] == 1 && casilla[2][2] == 1) ||
			(casilla[0][0] == 1 && casilla[1][0] == 1 && casilla[2][0] == 1) ||
			(casilla[0][1] == 1 && casilla[1][1] == 1 && casilla[2][1] == 1) ||
			(casilla[0][2] == 1 && casilla[1][2] == 1 && casilla[2][2] == 1) ||
			(casilla[0][0] == 1 && casilla[1][1] == 1 && casilla[2][2] == 1) ||
			(casilla[0][2] == 1 && casilla[1][1] == 1 && casilla[2][0] == 1)
			) {
				System.out.println("El jugador 1 ha ganado");
				jugador1 = true;
			}
			
			if(
			(casilla[0][0] == 2 && casilla[0][1] == 2 && casilla[0][2] == 2) ||
			(casilla[1][0] == 2 && casilla[1][1] == 2 && casilla[1][2] == 2) ||
			(casilla[2][0] == 2 && casilla[2][1] == 2 && casilla[2][2] == 2) ||
			(casilla[0][0] == 2 && casilla[1][0] == 2 && casilla[2][0] == 2) ||
			(casilla[0][1] == 2 && casilla[1][1] == 2 && casilla[2][1] == 2) ||
			(casilla[0][2] == 2 && casilla[1][2] == 2 && casilla[2][2] == 2) ||
			(casilla[0][0] == 2 && casilla[1][1] == 2 && casilla[2][2] == 2) ||
			(casilla[0][2] == 2 && casilla[1][1] == 2 && casilla[2][0] == 2)
			) {
				System.out.println("El jugador 2 ha ganado");
				jugador2 = true;
			}

			contador++;
			
		}while(jugador1 != true && jugador2 != true);
		
		System.out.println("\nFIN DEL PROGRAMA! ◝(ᵔᵕᵔ)◜");
		
		
		teclado.close();
		
	}

}