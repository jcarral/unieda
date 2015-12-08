package student;

/**
 * Created by JosebaPC on 08/12/2015.
 */
public class Reinas {

    /**
     * Calcula el tablero de N-reinas siempre y cuando N sea mayor o igual que 4
     *
     * @param size Tamaño del parametro
     * @return El tablero generado
     * @throws IllegalArgumentException si n<4
     */
    public static int[][] calcularReinas(int size) throws IllegalArgumentException {
        if (size < 4)
            throw new IllegalArgumentException();

        int[][] tablero = new int[size][size];

        calcularReinas(tablero, 0);
        return tablero;
    }

    /**
     * Funcion auxiliar para crear el tablero usando backtracking
     *
     * @param tablero tablero inicial
     * @param y       columna donde se va a colocar la reina
     * @return True si se ha finalizado
     */
    private static boolean calcularReinas(int[][] tablero, int y) {
        if (y >= tablero.length)
            return true;
        for (int x = 0; x < tablero.length; x++) {
            if (posicionValida(tablero, x, y)) {
                tablero[x][y] = 1;
                if (calcularReinas(tablero, y + 1))
                    return true;
                tablero[x][y] = 0;
            }
        }
        return false;
    }

    /**
     * Función auxiliar para comprobar si una reina puede colocarse en esa posicion
     */
    private static boolean posicionValida(int[][] tablero, int x, int y) {
        return checkHorizontal(tablero, x) && checkVertical(tablero, y) && checkDiagonal(tablero, x, y);

    }

    /**
     * Comprueba si la horizontal está disponible
     */
    private static boolean checkHorizontal(int[][] tablero, int x) {
        if (x >= tablero.length)
            return false;
        for (int i = 0; i < tablero[0].length; i++) {
            if (tablero[x][i] != 0)
                return false;
        }
        return true;
    }

    /**
     * Comprueba si la vertical está disponible
     */
    private static boolean checkVertical(int[][] tablero, int y) {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][y] != 0)
                return false;
        }
        return true;
    }

    /**
     * Comprueba si la diagonal está disponible
     */
    private static boolean checkDiagonal(int[][] tablero, int x, int y) {
        int i, j;
        if (x > y) {
            i = x - y;
            j = 0;
        } else {
            i = 0;
            j = y - x;
        }
        for (; i < tablero.length && j < tablero[0].length; i++, j++) {
            if (tablero[i][j] != 0)
                return false;
        }
        return true;
    }

    public static String toString(int tablero[][]) {
        String res = "";

        for (int i = 0; i < tablero.length; i++) {
            res += "[ ";
            for (int j = 0; j < tablero[0].length; j++) {
                res += tablero[i][j] + ", ";
            }
            res += "]\n";
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(toString(calcularReinas(13)));
    }
}
