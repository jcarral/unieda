package student;

import java.util.Iterator;
import java.util.LinkedList;

public class TestPay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] jugadores = {"Joseba", "Jon", "Iker", "Mikel"};
		int[] cantidadInicial = {100, 100, 100, 100};
		String falsario = "Mikel";
		LinkedList<Payment> lista = new LinkedList<Payment>();
		lista.add(new Payment("Joseba", 20, "Iker"));
		lista.add(new Payment("Iker", 30, "Mikel"));
		lista.add(new Payment("Mikel", 60, "Jon"));
		
		Contable cont = new Contable(jugadores, falsario, cantidadInicial, lista.iterator());
		System.out.println(cont.cantidadLegalDe("Jon"));
	}

}
