package student;

import java.util.Iterator;
import java.util.LinkedList;

public class Contable {

	private String[] jugadores;
	private String falsario;
	private int[] cantidadInicial;
	private Iterator<Payment> itr;
	private LinkedList[] pilaBilletes;
	
	public Contable(String[] jugadores, String falsario, int[] cantidadInicial, Iterator<Payment> itr){
		
		this.jugadores = jugadores;
		this.falsario = falsario;
		this.cantidadInicial = cantidadInicial;
		this.itr = itr;
		iniciarPila();
		calcularPila();
	}
	
	
	public int cantidadLegalDe(String jugador){
		return 0;
	}
	
	private void iniciarPila(){
		
		for(int i = 0; i<jugadores.length; i++){
		 LinkedList pila = new LinkedList<Billetes>();
		 pila.add(new Billetes(!jugadores[i].equals(falsario), cantidadInicial[i]));
		 
		}
		
	}
	
	private void calcularPila(){
		Payment pay; 
		boolean falso;
		while(itr.hasNext()){
			pay = itr.next();
			
		}
	}
	
	private int getWinnerPos(String s){
		for(int i = 0; i<jugadores.length; i++){
			if(jugadores[i].equals(s))
				return i;
		}
		return -1;
	}
	private class Billetes{
		
		private boolean verdadero;
		private int cantidad;
		
		Billetes(boolean verdadero, int cantidad){
			this.verdadero = verdadero;
			this.cantidad = cantidad;
		}
	}
}
