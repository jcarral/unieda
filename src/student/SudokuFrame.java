package student;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
                foo(r, c);
                GuiPanel.add(subPanels[r][c]);

            }
        }


        btnCalcular.addActionListener(e -> {

            Sudoku s1 = new Sudoku();
            int[][] tablero = getTablero();
            if (!esValido(tablero))
                JOptionPane.showMessageDialog(null, "Tablero no valido");
            else {
                tablero = s1.resolverSudoku(getTablero());
                setTablero(tablero);
            }


        });

        btnClear.addActionListener(e -> {

                for (int i = 0; i < filas; i++) {
                    for (int j = 0; j < columnas; j++) {
                        subPanels[i][j].setText("");
                        subPanels[i][j].setEditable(true);
                        subPanels[i][j].setForeground(Color.blue);
                    }
                }

        });

        btnCrear.addActionListener(e -> {
            setTablero(crearPartida());
        });

        final JPanel ButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        ButtonPanel.setLayout(new BorderLayout());
        ButtonPanel.add(btnCalcular, BorderLayout.WEST);
        ButtonPanel.add(btnClear, BorderLayout.EAST);
        ButtonPanel.add(btnCrear, BorderLayout.CENTER);
        add(ButtonPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    private int[][] crearPartida(){
       int[][] tablero = new int[filas][columnas];

        int num_elementos = (int) Math.floor(Math.random()*30)+1; //Entre 1 y 30

        for(int i = 0; i<num_elementos; i++){
            insertar_en_tablero(tablero);
        }
        return tablero;
    }

    private void insertar_en_tablero(int[][] tablero){

        int num, x, y;
        while(true){
            num = (int) Math.floor(Math.random()*8)+1;
            x = (int) Math.floor(Math.random()*8);
            y = (int) Math.floor(Math.random()*8);

            tablero[x][y] = num;

                if(posicionValida(tablero, x, y))
                    break;
                else
                    tablero[x][y] = 0;
        }

    }

    private boolean posicionValida(int[][] tablero, int x, int y){
        return comprobarFila(tablero[x]) && comprobarColumna(tablero, y) && comprobarCuadrado(tablero, (x-(x%3)),(y-(y%3)));
    }

    private void setTablero(int[][] tablero) {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if(tablero[i][j] != 0) {
                    subPanels[i][j].setText(Integer.toString(tablero[i][j]));
                    subPanels[i][j].setEditable(false);
                    subPanels[i][j].setForeground(Color.black);
                }
                else
                    subPanels[i][j].setText("");
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
        int i=0, j=0;

            for (i = x; i < x + 3; i++) {
                for (j = y; j < y + 3; j++) {
                    if (tablero[i][j] != 0)
                        if (newLinea[tablero[i][j] - 1] != 0)
                            return false;
                        else
                            newLinea[tablero[i][j] - 1] = tablero[i][j];
                }
            }
        return true;
    }

    private void foo(int x, int y){
        subPanels[x][y].getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                if(!comprobarCambio(x, y)) {
                    requestFocusInWindow();
                    JOptionPane.showMessageDialog(null, "Valor invalido");
                    /* Remove value */

                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });
    }

    private boolean comprobarCambio(int x, int y){
        int[][] tablero = getTablero();
        try{
           int val = Integer.parseInt(subPanels[x][y].getText());
            if(val>9 || val<1)
                return false;
            else
                tablero[x][y] = val;
        }catch(Exception e){
            return false;
        }

        return esValido(tablero);
    }
    private void colorear(int r, int c) {
        subPanels[r][c].addFocusListener(new FocusListener() {
            Color original;

            @Override
            public void focusGained(FocusEvent e) {
                original = subPanels[r][c].getBackground();
                colorearFila(c, Color.YELLOW);
                colorearColumna(r, Color.YELLOW);
                colorearCuadro(r, c, Color.YELLOW);
            }

            @Override
            public void focusLost(FocusEvent e) {
                colorearFila(c, null);
                colorearColumna(r, null);
                colorearCuadro(r, c, null);
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

    private void colorearCuadro(int r, int c, Color color) {
        int i = r - (r % 3);
        int j = c - (c % 3);
        if (color == null)
            color = getColorOriginal(r, c);

        for (int k = i; k < i + 3; k++) {
            for (int z = j; z < j + 3; z++) {
                subPanels[k][z].setBackground(color);
            }
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
