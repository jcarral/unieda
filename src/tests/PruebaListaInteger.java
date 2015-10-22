package tests;

import hw2.SortedLinkedListOfInteger;

public class PruebaListaInteger {
	
	public static void main(String[] args){
		SortedLinkedListOfInteger lista = new SortedLinkedListOfInteger();
		
		lista.add(18);
		printList(lista);
		lista.add(18);
		printList(lista);
		lista.add(16);
		printList(lista);
		lista.add(34);
		printList(lista);
		lista.add(26);
		printList(lista);
		lista.add(-4);
		printList(lista);
		lista.add(25);
		printList(lista);
		lista.add(12);
		printList(lista);
		lista.add(1);
		printList(lista);
		lista.add(12);
		
		
		
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
		
		
	}
	
	private static void printList(SortedLinkedListOfInteger a){
		for(int n : a){
			System.out.print(n + ", ");
		}
		System.out.println(" ");
	}
}
