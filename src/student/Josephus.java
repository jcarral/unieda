package student;

import java.util.*;

public class Josephus<T> {
	
	
	public static void josephusProblem(int n, int m){
		LinkedList<Integer> lista = iniciarLista(n);
		int size = lista.size();
		int aux = 0;
		int elem;
		while(size > 1 ){
			aux = (aux+m-1)%size;
			elem = lista.remove(aux);
			System.out.print(elem + " ");
			size--;
		}
		
		
	}
	
	public static void josephusProblemArray(int n, int m){
		ArrayList<Integer> lista = iniciarListaArray(n);
		int size = n;
		int aux = 0;
		int elem;
		while(size > 1 ){
			aux = (aux+m-1)%size;
			elem = lista.remove(aux);
			System.out.print(elem + " ");
			size--;
		}
		
		
	}
	
	private static LinkedList<Integer> iniciarLista(int n){
		LinkedList<Integer> lista = new LinkedList<Integer>();
		for(int i = 0; i<n; i++)
			lista.add(i);
		return lista;
	}
	
	private static ArrayList<Integer> iniciarListaArray(int n){
		ArrayList<Integer> lista = new ArrayList<Integer>();
		for(int i = 0; i<n; i++)
			lista.add(i);
		return lista;
	}
	public static void main(String[] args){
		
		long time_start, time_end;
		
		time_start = System.currentTimeMillis();
		josephusProblem(100000, 3);
		System.out.println("");
		time_end = System.currentTimeMillis();
		
		long listTime = time_end - time_start;
		
		time_start = System.currentTimeMillis();
		josephusProblemArray(100000, 3);
		System.out.println("");
		System.out.println("");
		time_end = System.currentTimeMillis();
		
		long arrayTime = time_end - time_start;
		
		System.out.println("Tiempo lista: " + listTime + "\nTiempo array: " + arrayTime);
		System.out.println((float) (listTime/arrayTime)+ " veces más lenta la lista");
		
	}
}
