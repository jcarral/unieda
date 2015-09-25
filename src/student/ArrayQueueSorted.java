package student;

import java.util.Comparator;

public class ArrayQueueSorted<T> implements SortedList<T> {
	
	private Comparator<?  super T> cmp;
	private int size;
	private int first;
	private int last;
	private T[] a;
	private final int DEFAULT_SIZE = 10;
	
	
	public ArrayQueueSorted(Comparator<?  super T> comparator){
		a = (T[]) new  Object[DEFAULT_SIZE];
		size = 0;
		cmp = comparator;
	}
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean add(T e) {
		int i = first;
		if(size==0){
			a[0] = e;
			size++;
		}
		if(a.length == size){
			ajustarCapacidad(size*2);
		}
		while(first != last){
			if(a[i].equals(e))
				return false;
			else if(cmp.compare(a[i], e) == -1){
				if(i == a.length)
					i = 0;
				else 
					i++;
				continue;
			}
			break;	
		}
		add(i, e);
		return true;
	}
	
	private void add(int pos, T e){
		int i = last+1;
		while(i != pos){
			a[i] = a[i-1];
			
			if(i == 0){
				i = a.length;
			}else{
				i--;
			}
			a[pos] = e;
		}
	}
	
	private void ajustarCapacidad(int size){
		T[] newArray = (T[]) new Object[size];
		
		for(int i = 0; i<this.size; i++){
			newArray[i] = a[first];
			if(first==a.length)
				first=0;
		}
		a = newArray;
		first = 0;
		last = size-1;
	}
	
	@Override
	public T removeFirst() {
		if(size == 0) throw new IllegalStateException("Lista vacia, no se puede quitar");
		T elem = a[first];
		a[first] = null;
		if (first==a.length-1)
			first = 0;
		else
			first++;
		size--;
		return elem;
			
	}

	@Override
	public T removeLast() {
		if(size == 0) throw new IllegalStateException("Lista vacia, no se puede quitar");
		T elem = a[last];
		a[last] = null;
		if (last == 0)
			last = a.length-1;
		else
			last--;
		size--;
		return elem;
	}

}
