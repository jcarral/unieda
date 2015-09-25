package student;

//Tiempo empleado: 30minutos
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
	public SortedLinkedListOfInteger(){
		size=0;
	}
	
	//Metodos
	
	
	public int size() {
		return size;
	}

	
	public boolean add(Integer e) {
		
		Node newNode = new Node(null, null, e);
		
		if(size==0){//lista vacia
			first = newNode;
			last = newNode;
			size++;
			
		}else if(size==1){//lista de un elemento
			if(e == first.item)
				return false;
			else if(e>first.item){
				last = newNode;
				first.next = last;
				last.prev = first;
			}
			else{
				newNode.next = first;
				first.prev = newNode;
				first = newNode;			
			}
			size++;
		}else{//lista de m�s de un elemento
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
			
			if(current == null){ //a�adir al final
				addLast(newNode);
			}else if(current==first){
				//addFirst(newNode);
			}
			else
				addBefore(newNode, current);
		}
		return true;
		 
	}
	
	private void addFirst(Node node){
		first.prev = node;
		node.next = first;
		first = node;
		size++;
	}
	
	private void addLast(Node node){
		last.next = node;
		node.prev = last;
		last = node;
		size++;
	}
	
	private void addBefore(Node node, Node current){
		current.prev.next = node;
		node.prev = current.prev;
		current.prev = node;
		node.next = current;
		size++;
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
