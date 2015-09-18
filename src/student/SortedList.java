package student;

public interface SortedList<T> {

	//Devuelve el tamaño de la secuencia
	public int size();
	
	public boolean add(T e);
	
	public T removeFirst();
	
	public T removeLast();
}
