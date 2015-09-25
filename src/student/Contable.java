package student;

import java.util.Iterator;

public class Contable {

	private String[] jugadores;
	private String falsario;
	private int[] cantidadInicial;
	private Iterator<Payment> itr;
	
	public Contable(String[] jugadores, String falsario, int[] cantidadInicial, Iterator<Payment> itr){
		
		this.jugadores = jugadores;
		this.falsario = falsario;
		this.cantidadInicial = cantidadInicial;
		this.itr = itr;
	}
	
	public int cantidadLegalDe(String jugador){
		return 0;
	}
}
