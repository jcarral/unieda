package student;

public class ArrayListSortedOfInteger implements SortedList<Integer>{

	private int first, last;
	private int[] a;
	private static final int MAX_DEFAULT = 10;
	
	
	
	public ArrayListSortedOfInteger() {
		a = new int[MAX_DEFAULT];
	}
	
	public ArrayListSortedOfInteger(int n){
		a = new int[n];
	}

	@Override
	public int size() {
		return last-first+1;
	}

	@Override
	public boolean add(Integer e) {
		for(int i = 0; i<a.length; i++){
			if(a[i] == e)
				return false;
			if(a[i] < e ){
				addElem(e, i);
				return true;
			}						
		}
		addElem(e, a.length);
		return true;
	}

	private void addElem(int e, int pos){
		if(last == a.length)
			resize();	
		for(int i = pos; i<a.length;i++){
			int aux = a[i];
			a[i] = e;
			e = aux;
		}
	}
	
	private void resize(){
		int i,j,  newSize = (last-first+1)*2;
		int [ ] old = a;
		a = new int[newSize];
		for(i=0, j = first;j<last;i++, j++)
			a[i] = old[j];
		first = 0;
		last = i;
	}
	
	@Override
	public Integer removeFirst() {
		int aux = a[first];
		a[first] = -1;
		first++;
		return aux;
	}

	@Override
	public Integer removeLast() {
		int aux = a[last];
		if(last == 0)
			last = a.length-1;
		else
			last--;
		return aux;
	}
	
	private void print(){
		String s = "[ ";
		for(int i : a)
			s += i + ", ";
		s+= "]";
		System.out.println(s);
	}
	
	public static void main(String[] args){
		ArrayListSortedOfInteger lista = new ArrayListSortedOfInteger(20);
		for(int i = 0; i < 20; i++){
			lista.add(i+5);
			int b = (i%5 == 0)?lista.removeFirst():lista.removeLast();
			
		}
		lista.print();
	}
}
