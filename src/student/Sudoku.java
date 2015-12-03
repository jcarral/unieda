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

	public static void main(String[] args){
		int tablero[][] = new int[9][9];

		tablero[0][0] = 0;
		tablero[0][1] = 0;
		tablero[0][2] = 0;
		tablero[0][3] = 3;
		tablero[0][4] = 0;
		tablero[0][5] = 0;
		tablero[0][6] = 2;
		tablero[0][7] = 0;
		tablero[0][8] = 0;
		tablero[1][0] = 0;
		tablero[1][1] = 0;
		tablero[1][2] = 0;
		tablero[1][3] = 0;
		tablero[1][4] = 0;
		tablero[1][5] = 8;
		tablero[1][6] = 0;
		tablero[1][7] = 0;
		tablero[1][8] = 0;
		tablero[2][0] = 0;
		tablero[2][1] = 7;
		tablero[2][2] = 8;
		tablero[2][3] = 0;
		tablero[2][4] = 6;
		tablero[2][5] = 0;
		tablero[2][6] = 3;
		tablero[2][7] = 4;
		tablero[2][8] = 0;
		tablero[3][0] = 0;
		tablero[3][1] = 4;
		tablero[3][2] = 2;
		tablero[3][3] = 5;
		tablero[3][4] = 1;
		tablero[3][5] = 0;
		tablero[3][6] = 0;
		tablero[3][7] = 0;
		tablero[3][8] = 0;
		tablero[4][0] = 1;
		tablero[4][1] = 0;
		tablero[4][2] = 6;
		tablero[4][3] = 0;
		tablero[4][4] = 0;
		tablero[4][5] = 0;
		tablero[4][6] = 4;
		tablero[4][7] = 0;
		tablero[4][8] = 9;
		tablero[5][0] = 0;
		tablero[5][1] = 0;
		tablero[5][2] = 0;
		tablero[5][3] = 0;
		tablero[5][4] = 8;
		tablero[5][5] = 6;
		tablero[5][6] = 1;
		tablero[5][7] = 5;
		tablero[5][8] = 0;
		tablero[6][0] = 0;
		tablero[6][1] = 3;
		tablero[6][2] = 5;
		tablero[6][3] = 0;
		tablero[6][4] = 9;
		tablero[6][5] = 0;
		tablero[6][6] = 7;
		tablero[6][7] = 6;
		tablero[6][8] = 0;
		tablero[7][0] = 0;
		tablero[7][1] = 0;
		tablero[7][2] = 0;
		tablero[7][3] = 7;
		tablero[7][4] = 0;
		tablero[7][5] = 0;
		tablero[7][6] = 0;
		tablero[7][7] = 0;
		tablero[7][8] = 0;
		tablero[8][0] = 0;
		tablero[8][1] = 0;
		tablero[8][2] = 9;
		tablero[8][3] = 0;
		tablero[8][4] = 0;
		tablero[8][5] = 5;
		tablero[8][6] = 0;
		tablero[8][7] = 0;
		tablero[8][8] = 0;

		Sudoku s1 = new Sudoku();

		printTablero(tablero);
		printTablero(s1.resolverSudoku(tablero));

	}
}
