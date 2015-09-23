package student;

public class ArrayListSortedOfInteger implements SortedList<Integer>{
	
	private static final int DEFAULT_SIZE = 10;
	private Integer[] a;
	private int size;
	
	public ArrayListSortedOfInteger(){
		 this(DEFAULT_SIZE);
	}
	
	public ArrayListSortedOfInteger(int capacity){
		if(capacity <= 0) throw new IllegalArgumentException("El tamaño no puede ser negativo");
		
		a = new Integer[capacity];
		size = 0;
	}
	
	@Override
	public int size() {
		return this.size;
	}

	@Override
	public boolean add(Integer e) {
		int i;
		if(a.length == size){
			ajustarCapacidad(size*2);
		}
		for(i = 0; i<size; i++){
			if(a[i] == e)
				return false;
			else if(a[i]< e)
				continue;
			break;
		}
		add(i, e);
		return true;
	}
	private void ajustarCapacidad(int size){
		Integer[] newArray = new Integer[size];
		
		for(int i = 0; i<this.size; i++){
			newArray[i] = a[i];
		}
		a = newArray;
	}
	
	private void add(int i, int e){
		for(int j = size; j>i; j--){
			a[j] = a[j-1];
		}
		a[i] = e;
	}

	@Override
	public Integer removeFirst() {
		if(size()==0)
			return null;
		int element = a[0];
		ajustarArray();
		size--;
		return element;
	}
	
	private void ajustarArray(){
		for(int i = 0; i<size; i++){
			a[i]=a[i+1];
		}
	}
	@Override
	public Integer removeLast() {
		if(size() == 0)
			return null;
		int element = a[size-1];
		a[size-1] = null;
		size--;
		return element;
	}

	
}
