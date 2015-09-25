package student;

import javax.swing.JOptionPane;

public class TestArrayListOfInteger {
	
	public static void main(String[] args){
		ArrayListSortedOfInteger lista = new ArrayListSortedOfInteger(Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaño del array")));
		
		lista.add(18);
		lista.add(18);
		printList(lista);
		lista.add(16);
		lista.add(34);
		lista.add(25);
		lista.add(12);
		lista.add(1);
		lista.add(12);
		printList(lista);
		
		lista.removeFirst();
		printList(lista);
		lista.removeFirst();
		printList(lista);
		
		lista.removeLast();
		printList(lista);
		lista.removeFirst();
		printList(lista);
		lista.removeLast();
		printList(lista);
		lista.removeFirst();
		printList(lista);
		lista.removeLast();
		printList(lista);
		lista.removeLast();
		printList(lista);
		
	}
	
	private static void printList(ArrayListSortedOfInteger a){
		System.out.println(a.toString());
	}
}
