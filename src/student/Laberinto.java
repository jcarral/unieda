package student;


import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Joseba on 12/01/2016.
 */
public class Laberinto {

    private final int LIBRE = 0, CAMINO = 1;
    private final int NORTE = 0, SUR = 1, ESTE = 2, OESTE = 3;
    private int[][] maze;
    private int size;

    private JTextField subPanels;

    Laberinto(int N) {

        size = N;
        iniciarLaberinto();
        generar();
        draw();

    }


    private void iniciarLaberinto() {

        maze = new int[size][size];
    }

    private void generar() {
        int x = (int) Math.floor(Math.random() * size), y = (int) Math.floor(Math.random() * size);
        maze[x][y] = CAMINO;
        generar(x, y);
    }

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


    public int[][] getMaze() {
        return maze;
    }

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
            size = 15;
        }

        Laberinto l = new Laberinto(size);


    }

}
