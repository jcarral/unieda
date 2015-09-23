package student;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SortedLinkedListOfInteger implements SortedList<Integer>, Iterable<Integer> {
	//
	private class Node{
		Node next, prev;
		int item;
		
		Node(Node prev, Node next, int item){
			this.prev = prev;
			this.next = next;
			this.item = item;
		}
		
	}
	
	//Atributos
	private int size;
	private Node first, last;
	
	
	//Constructor
	SortedLinkedListOfInteger(){
		size=0;
	}
	
	//Metodos
	
	
	public int size() {
		return size;
	}

	
	public boolean add(Integer e) {
		Node current = first;
		
		while (current != null){
			if(current.item == e)
				return false;
			if(current.item<e){
				current = current.next;
				continue;
			}
			break;		
		}
		Node newNode = new Node(current.prev, current, e);
		current.prev.next = newNode;
		current.prev = newNode;
		size++;
		return true;
		 
	}

	
	public Integer removeFirst() {
		int ret;
		if(size<2)
			return listaCorta();
		else{
			ret = first.item;
			first.next.prev = null;
			first = first.next;
			size--;
			return ret;
		}
	}

	
	public Integer removeLast() {
		int ret;
		if(size<2)
			return listaCorta();
		else{
			ret = last.item;
			last.prev.next = null;
			last = last.prev;
			size--;
			return ret;
		}
	}
	
	private Integer listaCorta(){
		int ret;
		if(size == 0)
			throw new NoSuchElementException("No se puede borrar de lista vacia");
		ret = first.item;
		first = null;
		last = null;
		size--;
		return  ret;
		
	}

	
	public Iterator<Integer> iterator() {
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Integer>{
		private Node nextNode = first;
		
		public boolean hasNext() {
			return nextNode != null;
		}

		
		public Integer next() {
			int item = nextNode.item;
			nextNode = nextNode.next;
			return item;
		}
		
	}
}
