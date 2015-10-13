package student;

import java.util.*;

/**
 * Tiempo empleado: 15 minutos
 *
 */
public class Robot {
	private LinkedList<Integer> cilindros, cubos; //Listas con los elementos de las listas
	private int pesoCubos, pesoCilindros; //Peso total de cada balanza

	/**
	 * Constructor, se inicializan los parámetros
	 */
	public Robot() {
		cilindros = new LinkedList<Integer>();
		cubos = new LinkedList<Integer>();
		pesoCubos = 0;
		pesoCilindros = 0;
	}

	/**
	 * Atiende los elementos que van llegando por la cinta
	 * 
	 * @param num
	 *            Entero con el peso y tipo de elemento que pasa por la cinta
	 */
	public void atiende(int num) {
		String msg;
		if (num == 0) {
			msg = llegaCesta();

		} else if (num > 0) {
			llegaCilindro(num);
			msg = "Llega cilindro peso " + num;
		} else {
			llegaCubo(num);
			msg = "Llega cubo peso " + (-1 * num);
		}
		System.out.println(msg);
	}

	/**
	 * Iguala la balanza
	 * 
	 * @return Devuelve un String con los datos de los cubos/cilindros retirados
	 *         en caso de tener que retirarse
	 */
	private String llegaCesta() {
		String msg = "";
		int pesoAux;
		if (pesoCubos == pesoCilindros)
			return "";
		else if (pesoCubos > pesoCilindros) {
			while (pesoCubos > pesoCilindros) {
				pesoAux = cubos.removeLast();
				pesoCubos -= pesoAux;
				msg += "Retirar cubo peso " + pesoAux + "\n";
			}

		} else {
			while (pesoCilindros > pesoCubos) {
				pesoAux = cilindros.removeLast();
				pesoCilindros -= pesoAux;
				msg += "Retirar cilindro peso " + pesoAux + "\n";
			}
		}
		return msg;

	}

	/**
	 * Añade un cilindro a la lista
	 * 
	 * @param n
	 *            peso del cilindro
	 */
	private void llegaCilindro(int n) {
		cilindros.addLast(n);
		pesoCilindros += n;
	}

	/**
	 * Añade un cubo a la lista
	 * 
	 * @param n
	 *            peso del cubo en negativo
	 */
	private void llegaCubo(int n) {
		n *= -1;
		cubos.addLast(n);
		pesoCubos += n;
	}

	
}
