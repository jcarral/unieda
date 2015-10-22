package tests;

import javax.swing.JOptionPane;

import hw2.ArrayListSortedOfInteger;

public class TestArrayListInteger {
	
	public static void main(String[] args){
		ArrayListSortedOfInteger lista = new ArrayListSortedOfInteger(Integer.parseInt(JOptionPane.showInputDialog("Introduce el tamaÒo del array")));
		
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
