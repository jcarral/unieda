package student;

import java.util.Comparator;

public class ArrayQueueSorted<T> implements SortedList<T> {
	private int first = 0, last = 0;
	private T[] a;
	private Comparator<? super T> comparator;
	private final static int MAX_DEFAULT = 10;
	
	
	public ArrayQueueSorted(Comparator <? super T> comparator){
		this.comparator = comparator;
		a = (T[]) new Object[MAX_DEFAULT];
	}
	
	@Override
	public int size() {
		return last-first+1;
	}

	@Override
	public boolean add(T e) {
		
		return false;
	}

	@Override
	public T removeFirst() {
		T aux = a[first];
		a[first] = null;
		first++;
		return aux;
	}

	@Override
	public T removeLast() {
		T aux = a[last];
		if(last == 0)
			last = a.length-1;
		else
			last--;
		return aux;
	}

	
}
