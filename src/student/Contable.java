package student;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Joseba Tiempo empleado: 20 minutos
 */
public class Contable {

	private String[] jugadores;
	private String falsario;
	private int[] cantidadInicial;
	private Iterator<Payment> itr;
	private LinkedList<Boolean>[] tacos;

	public Contable(String[] jugadores, String falsario, int[] cantidadInicial, Iterator<Payment> itr) {
		this.jugadores = jugadores;
		this.falsario = falsario;
		this.cantidadInicial = cantidadInicial;
		this.itr = itr;
		tacos =  new LinkedList[jugadores.length];

		iniciar();
		calcularPartida();
	}

	public int cantidadLegalDe(String jugador) {
		int playerPos = getPos(jugador);
		return calculateMoney(playerPos);
	}

	private void iniciar() {
		for (int i = 0; i < jugadores.length; i++) {
			tacos[i] = new LinkedList<Boolean>();
			iniciarPila(i);
		}
	}

	/**
	 * @param n
	 *            Posicion de la pila a iniciar
	 */
	private void iniciarPila(int n) {
		boolean real = !falsario.equals(jugadores[n]);
		for (int i = 0; i < cantidadInicial[n]; i++) {
			tacos[n].push(real);
		}
	}

	private void calcularPartida() {
		Payment pay;
		int[] players;
		while (itr.hasNext()) {
			pay = itr.next();
			players = getPos(pay.getWinner(), pay.getPayer());
			addMoney(players, pay.getAmount());
		}
	}

	/**
	 * 
	 * Transfiere el dinero del perdedor al ganador
	 * @param players
	 *            Array con las posiciones del perdedor y ganador
	 * @param amount
	 *            Cantidad de dinero a transferir
	 */
	private void addMoney(int[] players, int amount) {
		for (int i = 0; i < amount; i++) {
			tacos[players[0]].push(tacos[players[1]].pop());
		}
	}

	/**
	 * 
	 * Devuelve las posiciones de dos jugadores
	 * @param winner
	 *            Nombre del que recibira el dinero
	 * @param looser
	 *            Nombre del que dara el dinero
	 * @return [0] posicion del ganador [1] posicion del perdedor
	 */
	private int[] getPos(String winner, String looser) {
		int completed = 0;
		int[] res = new int[2];

		for (int i = 0; completed < 2 && i < jugadores.length; i++) {
			if (jugadores[i].equals(winner)) {
				res[0] = i;
				completed++;
			} else if (jugadores[i].equals(looser)) {
				res[1] = i;
				completed++;
			}
		}
		return res;
	}

	/**
	 * 
	 * Devuelve la posicion del jugador
	 * @param player
	 *            Nombre del jugador a buscar
	 * @return posicion del jugador en el array jugadores
	 */
	private int getPos(String player) {
		for (int i = 0; i < jugadores.length; i++) {
			if (jugadores[i].equals(player))
				return i;
		}
		return -1;
	}

	/**
	 * 
	 * Devuelve la cantidad de dinero real que tiene el jugador en la pos n
	 * @param pos
	 *            posicicion en el array jugadores del jugador que se calculara
	 *            su dinero
	 * @return cantidad de dinero real del jugador
	 */
	private int calculateMoney(int pos) {
		int amount = 0;
		int size = tacos[pos].size();
		for (int i = 0; i < size; i++) {
			if (tacos[pos].get(i))
				amount++;
		}
		return amount;
	}
}