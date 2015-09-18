package student;

import java.awt.*;

import javax.swing.*;

public class MatrizVisual {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame marco = new JFrame("Matriz Ordenada Diagonalmente");
		marco.setSize(500, 700);
		marco.setLocationRelativeTo(null);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.add(new Lamina());
		marco.setVisible(true);
	}

}

class Lamina extends JPanel{
	Lamina(){
		JPanel jp1 = new JPanel();
		jp1.setBackground(new Color(200, 150, 100));
	}
}
