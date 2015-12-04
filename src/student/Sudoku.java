package student;

import javax.swing.JOptionPane;

public class Sudoku {

	private boolean fin = false;

	public Sudoku(){
		fin = false;
	}

	/**
	 * Resuelve un sudoku
	 *
	 * @param tablero matriz 9x9 con los valores del sudoku
	 * @return devuelve el sudoku resuelto si tiene solución
	 */
	public int[][] resolverSudoku(int[][] tablero) {
		int x = 0, y = 0;
		int[] posibles;

		if (completado(tablero)) {
			fin = true;
			return tablero;
		} else {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if(tablero[i][j]== 0){
						x = i;
						y = j;
						break;
					}
				}
			}
			posibles = calcularPosibilidades(tablero, x, y);
		}

		for (int val: posibles) {
			if(val != 0){
				tablero[x][y] = val;
				tablero = resolverSudoku(tablero);
				if(fin)
					return tablero;
			}
		}
		if(!fin)
			tablero[x][y]=0;
		return tablero;

	}

	/**
	 * Comprueba si el sudoku se ha completado
	 * @param tablero
	 * @return true si el tablero tiene todas las casillas llenas
	 */
	private static boolean completado(int[][] tablero) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (tablero[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	/**
	 * Calcula todas los numeros que se pueden introducir en la casilla de la posición (x,y)
	 * @param tablero
	 * @param x fila en la que está la casilla
	 * @param y columna en la que esta la casilla
	 * @return Un array donde todas las posiciones validas son diferentes de 0
	 */
	private static int[] calcularPosibilidades(int[][] tablero, int x, int y){
		int[] retPosibilidades;
		//iniciar array opciones
		retPosibilidades = iniciarArray();
		//linea vertical
		retPosibilidades = calcularVertical(tablero, retPosibilidades, x);
		//linea horizontal
		retPosibilidades = calcularHorizontal(tablero, retPosibilidades, y);
		//Mismo cuadro
		retPosibilidades = calcularCuadro(tablero, retPosibilidades, x, y);
		return retPosibilidades;
	}

	/**
	 * Inicia el array con todos los valores desde 1 a 9
	 * @return Array con los valores posibles
	 */
	private static int[] iniciarArray(){
		int[] retPosibilidades = new int[9];
		for(int i = 0; i<9; i++)
			retPosibilidades[i]=i+1;
		return retPosibilidades;
	}

	/**
	 * Calcula las posibilidades sobre la linea horizontal
	 * @param tablero
	 * @param posibilidades
	 * @param y Columna en la que esta la casilla
	 * @return Array actualizado descartando los numeros que se encuentran en la misma fila
	 */
	private static int[] calcularHorizontal(int[][] tablero, int[] posibilidades, int y){
		for(int i=0; i<9; i++){
			if(tablero[i][y]!=0)
				posibilidades[tablero[i][y]-1]=0;
		}
		return posibilidades;
	}

	/**
	 * Calcula las posibilidades sobre la linea vertical
	 * @param tablero
	 * @param posibilidades
	 * @param x Fila en la que se encuentra la casilla
	 * @return Array actualizado descartando los numeros que se encuentran en la misma columna
	 */
	private static int[] calcularVertical(int[][] tablero, int[] posibilidades, int x){
		for(int i = 0; i<9; i++){
			if(tablero[x][i] != 0)
				posibilidades[tablero[x][i]-1]=0;
		}
		return posibilidades;
	}

	/**
	 * Calcula las posibilidades sobre el cuadrado
	 * @param tablero
	 * @param posibilidades
	 * @param x Fila en la que esta la casilla
	 * @param y Columna en la que esta la casilla
	 * @return Array actualizado descartando los numeros que estan el mismo cuadrado
	 */
	private static int[] calcularCuadro(int[][] tablero, int[] posibilidades, int x, int y){
		int i = x - (x % 3);
		int j = y -(y % 3);

		for(int k = i; k<i+3; k++){
			for(int z = j; z<j+3; z++){
				if(tablero[k][z] != 0)
					posibilidades[tablero[k][z]-1]=0;
			}
		}
		return posibilidades;
	}

	/**
	 * Función auxiliar para imprimir el tablero
	 *
	 * @param tablero
	 */
	public static void printTablero(int[][] tablero) {
		for (int i = 0; i<tablero.length; i++){
			System.out.print("[ ");
			for(int j = 0; j<tablero[0].length; j++){
				System.out.print(tablero[i][j] + ", ");
			}
			System.out.print(" ]\n");
		}
	}


}
