package student;

public class SinglyLinked<T> {
	static private class Node<T>{
		private T data;
		private Node next;
		
		public Node(T data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<T> head;
	
	public SinglyLinked(){
		
	}
	
	
	public int size(){
		return 0;
	}
	
	public void print(){
		
	}
	
	public boolean test(T x){
		return false;
	}
	
	public void add(T x){
		Node aux = head;
		while(aux!=null){
			if(aux.next == null)
				break;
			aux = aux.next;
		}
		aux.next = new Node(x, null);
	}
	
	public void remove(T x){
		Node aux = head;
		
		while(aux != null){
			if(aux.next.data.equals(x)){
				aux.next = aux.next.next;
				return;
			}
				
		}
	}
}
