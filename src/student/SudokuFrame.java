package student;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by joseba on 3/12/15.
 */
public class SudokuFrame extends JFrame {
    private JButton btnCalcular, btnClear, btnCrear;
    private final int filas = 9, columnas = 9;
    private JTextField[][] subPanels;

    SudokuFrame() {

        super("Sudoku");
        final JPanel GuiPanel = new JPanel(new GridLayout(filas, columnas));
        subPanels = new JTextField[filas][columnas];
        btnCalcular = new JButton("Calcular");
        btnClear = new JButton("Borrar");
        btnCrear = new JButton("Crear Tablero");
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(GuiPanel);
        setLocationRelativeTo(null);

        Border outerBorder = BorderFactory.createLineBorder(Color.black, 2);
        Border innerBorder = BorderFactory.createLineBorder(Color.BLUE, 1);

        GuiPanel.setBorder(outerBorder);


        for (int r = 0; r < filas; r++) {
            for (int c = 0; c < columnas; c++) {

                subPanels[r][c] = new JTextField("");
                subPanels[r][c].setForeground(Color.blue);

                if ((r / 3 + c / 3) % 2 == 0)
                    subPanels[r][c].setBackground(Color.lightGray);


                subPanels[r][c].setHorizontalAlignment(JTextField.CENTER);
                subPanels[r][c].setBorder(innerBorder);
                subPanels[r][c].setBorder(innerBorder);
                if ((r < 3 || r > 5) && ((c < 3 || c > 5)) || ((r > 2 && r < 6) && (c > 2 && c < 6)))
                    subPanels[r][c].setBackground(new Color(0x9F9F9F));
                else
                    subPanels[r][c].setBackground(Color.WHITE);
                colorear(r, c);
                GuiPanel.add(subPanels[r][c]);

            }
        }


        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Sudoku s1 = new Sudoku();
                int[][] tablero = getTablero();
                if (!esValido(tablero))
                    JOptionPane.showMessageDialog(null, "Tablero no valido");
                else {
                    tablero = s1.resolverSudoku(getTablero());
                    setTablero(tablero);
                }


            }
        });

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        subPanels[i][j].setText("");
                    }
                }
            }
        });

        btnCrear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Ya si eso mañana lo meto
            }
        });

        final JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ButtonPanel.setLayout(new BorderLayout());
        ButtonPanel.add(btnCalcular, BorderLayout.WEST);
        ButtonPanel.add(btnClear, BorderLayout.EAST);
        ButtonPanel.add(btnCrear, BorderLayout.CENTER);
        add(ButtonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }


    private void setTablero(int[][] tablero) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                subPanels[i][j].setText(Integer.toString(tablero[i][j]));
            }
        }
    }


    private int[][] getTablero() {
        int[][] tablero = new int[filas][columnas];
        String val;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                val = subPanels[i][j].getText();
                if (!isNumeric(val) || (Integer.parseInt(val) > 10 || Integer.parseInt(val) < 0)) {
                    tablero[i][j] = 0;
                    continue;
                }
                tablero[i][j] = Integer.parseInt(val);
            }
        }
        return tablero;
    }

    public static boolean isNumeric(String str) {
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private boolean esValido(int[][] tablero) {
        boolean valido;
        //Comprobar fila
        for (int i = 0; i < columnas; i++) {
            if (!comprobarFila(tablero[i]))
                return false;
        }

        //Comprobar columna
        for (int i = 0; i < filas; i++) {
            if (!comprobarColumna(tablero, i))
                return false;
        }

        //Comprobar cuadrado
        for (int i = 0; i < filas; i += 3) {
            for (int j = 0; j < columnas; j += 3) {
                if (!comprobarCuadrado(tablero, i, j))
                    return false;
            }
        }
        return true;
    }

    private boolean comprobarFila(int[] linea) {
        int[] newLinea = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < columnas; i++) {
            if (linea[i] != 0)
                if (newLinea[linea[i] - 1] != 0)
                    return false;
                else
                    newLinea[linea[i] - 1] = linea[i];
        }
        return true;
    }

    private boolean comprobarColumna(int[][] tablero, int columna) {
        int[] newLinea = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = 0; i < filas; i++) {
            if (tablero[i][columna] != 0)
                if (newLinea[tablero[i][columna] - 1] != 0)
                    return false;
                else
                    newLinea[tablero[i][columna] - 1] = tablero[i][columna];
        }
        return true;
    }

    private boolean comprobarCuadrado(int[][] tablero, int x, int y) {
        int[] newLinea = {0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                if (tablero[i][j] != 0)
                    if (newLinea[tablero[i][j] - 1] != 0)
                        return false;
                    else
                        newLinea[tablero[i][j] - 1] = tablero[i][j];
            }
        }
        return true;
    }

    private void colorear(int r, int c) {
        subPanels[r][c].addFocusListener(new FocusListener() {
            Color original;

            @Override
            public void focusGained(FocusEvent e) {
                original = subPanels[r][c].getBackground();
                colorearFila(c, Color.YELLOW);
                colorearColumna(r, Color.YELLOW);
            }

            @Override
            public void focusLost(FocusEvent e) {
                colorearFila(c, null);
                colorearColumna(r, null);
            }
        });

    }

    private void colorearFila(int c, Color color) {
        boolean limpiar = (color == null);
        for (int i = 0; i < filas; i++) {
            if (limpiar)
                color = getColorOriginal(i, c);
            subPanels[i][c].setBackground(color);
        }
    }

    private void colorearColumna(int r, Color color) {
        boolean limpiar = (color == null);
        for (int i = 0; i < columnas; i++) {
            if (limpiar)
                color = getColorOriginal(r, i);
            subPanels[r][i].setBackground(color);
        }
    }

    private Color getColorOriginal(int r, int c) {
        if ((r < 3 || r > 5) && ((c < 3 || c > 5)) || ((r > 2 && r < 6) && (c > 2 && c < 6)))
            return new Color(0x9F9F9F);
        else
            return Color.WHITE;
    }
    public static void main(String[] args) {
        SudokuFrame s = new SudokuFrame();
    }
}
