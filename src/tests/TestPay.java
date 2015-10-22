package tests;

import java.util.Iterator;
import java.util.LinkedList;

import hw3.Contable;
import hw3.Payment;

public class TestPay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] jugadores = {"Jug0", "Jug1", "Jug2", "Jug3"};
		int[] cantidadInicial = {100, 100, 100, 100};
		String falsario = "Jug3";
		LinkedList<Payment> lista = new LinkedList<Payment>();
		lista.add(new Payment("Jug0", 20, "Jug2"));
		lista.add(new Payment("Jug2", 30, "Jug3"));
		lista.add(new Payment("Jug3", 50, "Jug1"));
		
		Contable cont = new Contable(jugadores, falsario, cantidadInicial, lista.iterator());
		System.out.println(cont.cantidadLegalDe("Jug3") == 0);
		System.out.println(cont.cantidadLegalDe("Jug0") == 80);
		System.out.println(cont.cantidadLegalDe("Jug2") == 90);
		System.out.println(cont.cantidadLegalDe("Jug1") == 130);
		

		lista.add(new Payment("Jug2", 15, "Jug3"));
		lista.add(new Payment("Jug3", 20, "Jug1"));
		lista.add(new Payment("Jug0", 10, "Jug2"));
		lista.add(new Payment("Jug2", 45, "Jug3"));
		lista.add(new Payment("Jug3", 10, "Jug1"));
		
		
		
		Contable cont2 = new Contable(jugadores, falsario, cantidadInicial, lista.iterator());
		
		System.out.println(cont2.cantidadLegalDe("Jug3") == 35);
		System.out.println(cont2.cantidadLegalDe("Jug0") == 70);
		System.out.println(cont2.cantidadLegalDe("Jug2") == 40);
		System.out.println(cont2.cantidadLegalDe("Jug1") == 155);
	}

}
