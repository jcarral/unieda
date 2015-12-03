package student;

/*
 * Tiempo empleado: 30 minutos
 */

import java.util.LinkedList;
import java.util.List;

public class MazeSolver {
    public static final int MARCADA = 1, LIBRE = 2, BLOQUEADA = 3; // Constantes
    private static Coords[][] laberinto;

    public MazeSolver(boolean[][] maze) {
        crearLab(maze);
    }

    public List<Coords> searchPath(Coords from, Coords to) {

        LinkedList<Coords> lista = new LinkedList<Coords>();
        crearLista(lista, laberinto[from.row][from.column], laberinto[to.row][to.column]);
        return lista;
    }


    /**
     * Genera un laberinto de objetos de tipo Coords
     *
     * @param maze Matriz cuadrada con valores booleanos
     */
    private void crearLab(boolean[][] maze) {
        laberinto = new Coords[maze.length][maze[0].length];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                laberinto[i][j] = new Coords(i, j);
                laberinto[i][j].setEstado(maze[i][j]);
            }
        }
    }

    /**
     * Funcion auxiliar que genera la lista con todas las coordenadas que forman
     * parte del recorrido. S Solución de forma recursiva
     *
     * @param lista lista donde se almacenan las coordenadas que forman parte del
     *              recorrido
     * @param from  Coordenada inicial
     * @param to    Coordenada final
     * @return valor booleano que indica true si ha llegado al final
     */
    private boolean crearLista(LinkedList lista, Coords from, Coords to) {

        boolean fin = false;

        if (estaDentro(from)) {
            from.estado = MARCADA;
            if (from.equals(to))
                return true;
            else {
                if (from.row + 1 < laberinto.length)
                    fin = crearLista(lista, laberinto[from.row + 1][from.column], to);
                if (!fin && from.column + 1 < laberinto[0].length)
                    fin = crearLista(lista, laberinto[from.row][from.column + 1], to);
                if (!fin && from.row - 1 >= 0)
                    fin = crearLista(lista, laberinto[from.row - 1][from.column], to);
                if (!fin && from.column - 1 >= 0)
                    fin = crearLista(lista, laberinto[from.row][from.column - 1], to);
            }
            if (fin)
                lista.add(from);
        }
        return fin;

    }

    /**
     * Función que comprueba si una casilla es valida, es decir, esta dentro de
     * los limites y esta libre
     *
     * @param c Coordenada que se va a buscar
     * @return True si es una casilla valida
     */
    private boolean estaDentro(Coords c) {
        return (c.column < laberinto[0].length && c.row < laberinto.length && c.estado == LIBRE);

    }

    static public class Coords {
        public int row;
        public int column;
        public int estado;

        public Coords(int row, int column) {
            this.row = row;
            this.column = column;

        }

        /**
         * Función que le da un valor al estado de la casilla en función de si
         * es true=libre o false=bloqueada
         */
        public void setEstado(boolean estado) {
            if (!estado)
                this.estado = BLOQUEADA;
            else
                this.estado = LIBRE;
        }

        public boolean equals(Coords c) {
            return (this.column == c.column && this.row == c.row);
        }

        public String toString() {
            return "[ " + this.row + ", " + this.column + " ] ";

        }
    }

    public static void main(String[] args) {
        boolean[][] lab = {{false, false, false, true, false, false, false, false, false},
                {false, true, true, true, false, true, true, false, true},
                {false, true, false, true, false, true, false, false, false},
                {false, true, false, true, true, true, true, true, false},
                {false, true, false, false, false, false, true, false, false},
                {false, true, false, true, true, true, true, true, false},
                {false, false, false, false, true, false, false, true, false},
                {false, true, true, true, true, false, true, true, false},
                {false, false, false, false, true, false, false, false, false}};

        MazeSolver maze = new MazeSolver(lab);
        List<Coords> lista = maze.searchPath(new Coords(0, 3), new Coords(8, 4));
        for (Coords c : lista) {
            System.out.println(c);
        }

    }

}
