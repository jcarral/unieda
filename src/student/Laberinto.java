package student;


import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Como en clase comentaste que en vez de el ejercicio de apt-get se podía hacer otro, he hecho este que se propone en varios libros.
 * Se trata de generar un laberinto perfecto, un laberinto perfecto es aquel que no tiene areas innacesibles ni bucles, es decir, un circuito cerrado.
 * Además he implementado una función muy simple para mostrar graficamente como queda el laberinto.
 *
 * Tiempo empleado: 2h
 */
public class Laberinto {

    private final int LIBRE = 0, CAMINO = 1;
    private final int NORTE = 0, SUR = 1, ESTE = 2, OESTE = 3;
    private int[][] maze;
    private int size;


    /**
     * Constructor que crea un laberinto y lo dibuja en pantalla.
     *
     * @param N Tamaño del laberinto
     */
    Laberinto(int N) {

        size = (N > 0)?N:15;
        iniciarLaberinto();
        generar();
        draw();

    }


    private void iniciarLaberinto() {

        maze = new int[size][size];
    }

    /**
     * Empieza a generar el laberinto desde una casilla al azar.
     */
    private void generar() {
        int x = (int) Math.floor(Math.random() * size), y = (int) Math.floor(Math.random() * size);
        maze[x][y] = CAMINO;
        generar(x, y);
    }

    /**
     * De forma recursiva genera un laberinto perffecto
     * @param x Coordenada x actual
     * @param y Coordenada y actual
     */
    private void generar(int x, int y) {
        LinkedList<Integer> listRandomVecinos = (LinkedList) randomVecinos(x, y);
        int numRandomVecinos = listRandomVecinos.size();


        for (int i = 0; i < numRandomVecinos; i++) {

            int n = listRandomVecinos.poll();

            if (n == NORTE && x - 2 >= 0 && maze[x - 2][y] == LIBRE) {
                maze[x - 2][y] = CAMINO;
                maze[x - 1][y] = CAMINO;
                generar(x - 2, y);

            } else if (n == SUR && x + 2 <= size - 1 && maze[x + 2][y] == LIBRE) {
                maze[x + 2][y] = CAMINO;
                maze[x + 1][y] = CAMINO;
                generar(x + 2, y);

            } else if (n == ESTE && y + 2 <= size - 1 && maze[x][y + 2] == LIBRE) {
                maze[x][y + 2] = CAMINO;
                maze[x][y + 1] = CAMINO;
                generar(x, y + 2);

            } else if (n == OESTE && y - 2 >= 0 && maze[x][y - 2] == LIBRE) {

                maze[x][y - 2] = CAMINO;
                maze[x][y - 1] = CAMINO;
                generar(x, y - 2);

            }

        }


    }

    /**
     * Genera una lista ordenada de forma aleatoria con todos los posibles vecinos a los que se puede acceder
     * @param x Coordenada x de la posición actual
     * @param y Coordenada y de la posición actual
     * @return Lista con los posibles vecinos
     */
    private List randomVecinos(int x, int y) {
        List vecinos = new LinkedList<>();

        if (x - 1 >= 0 && maze[x - 1][y] == LIBRE)
            vecinos.add(NORTE);

        if (x + 1 < size && maze[x + 1][y] == LIBRE)
            vecinos.add(SUR);

        if (y - 1 >= 0 && maze[x][y - 1] == LIBRE)
            vecinos.add(OESTE);

        if (y + 1 < size && maze[x][y + 1] == LIBRE)
            vecinos.add(ESTE);

        Collections.shuffle(vecinos);
        return vecinos;
    }

    /**
     * Función que dibuja un tablero usando swing
     */
    private void draw() {
        JFrame frame = new JFrame("Laberinto");
        final JPanel GuiPanel = new JPanel(new GridLayout(size, size));
        JTextField[][] subPanels = new JTextField[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                subPanels[i][j] = new JTextField(" ");
                if (maze[i][j] == 1)
                    subPanels[i][j].setBackground(new Color(255, 224, 25));
                else
                    subPanels[i][j].setBackground(new Color(0x000000));
                subPanels[i][j].setEditable(false);
                GuiPanel.add(subPanels[i][j]);
            }
        }

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.add(GuiPanel);
        frame.setVisible(true);
    }


    public static void main(String[] args) {
        int size;
        try {
            size = Integer.parseInt(JOptionPane.showInputDialog(null, "Tamaño del laberinto"));
        } catch (Exception e) {
            size = 15; //Tamaño por defecto
        }

        Laberinto l = new Laberinto(size);


    }

}
