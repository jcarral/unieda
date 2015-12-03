package student;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                GuiPanel.add(subPanels[r][c]);

            }
        }


        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Sudoku s1 = new Sudoku();
                int[][] tablero = s1.resolverSudoku(getTablero());
                setTablero(tablero);
                setVisible(true);
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
                if (!isNumeric(val)) {
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
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        SudokuFrame s = new SudokuFrame();


    }
}
