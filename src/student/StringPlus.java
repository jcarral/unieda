package student;

import java.util.*;

/**
 * Tiempo empleado: 1h
 *
 */
public class StringPlus {

	private final int size;
	private String txt;
	private StringPlus left;
	private StringPlus right;

	public StringPlus(String s) {
		txt = s;
		size = s.length();
	}

	private StringPlus(StringPlus sp1, StringPlus sp2) {
		size = sp1.size() + sp2.size();
		left = sp1;
		right = sp2;
	}

	public int size() {
		return size;
	}

	/**
	 * Devuelve un nuevo objeto que representa la secuencia de este StringPlus
	 * concatenada al especificado
	 * 
	 * @param otro
	 *            StringPlus que se concatena
	 * @return nuevo StringPlus
	 */
	public StringPlus concat(StringPlus otro) {
		return new StringPlus(this, otro);
	}

	/**
	 * Devuelve true si la cadena de caracteres representada por este StringPlus
	 * es un prefijo de la secuencia de caracteres por el StringPlus
	 * especificado
	 * 
	 * @param s
	 *            StringPlus especificado
	 * @return true si 'this' es prefijo de 's'
	 */
	public boolean isPrefix(StringPlus s) {
		if (size > s.size())
			return false;
		return isPrefix(this, s);
	}

	private boolean isPrefix(StringPlus t1, StringPlus t2) {

		LinkedList<StringPlus> pilaPrefix = new LinkedList<StringPlus>();
		LinkedList<StringPlus> pilaCadena = new LinkedList<StringPlus>();
		StringPlus auxPrefix = t1, auxCadena = t2;
		String prefix = obtenerSiguienteCadena(auxPrefix, pilaPrefix),
				cadena = obtenerSiguienteCadena(auxCadena, pilaCadena);
		int i = -1, j = 0;

		while (!pilaPrefix.isEmpty() || (i < prefix.length() && i > 0)) {
			if (i == prefix.length()) {
				auxPrefix = pilaPrefix.pop();
				prefix = obtenerSiguienteCadena(auxPrefix, pilaPrefix);
				i = 0;
			} else if (i < 0) {
				i = 0;
			}
			if (j == cadena.length()) {
				auxCadena = pilaCadena.pop();
				cadena = obtenerSiguienteCadena(auxCadena, pilaCadena);
				j = 0;
			}

			for (; j < cadena.length() && i < prefix.length(); i++, j++) {
				if (prefix.charAt(i) != cadena.charAt(j))
					return false;
			}

		}

		return true;
	}

	/**
	 * Devuelve el siguiente string del arbol y actualiza la pila
	 * 
	 * @param s
	 *            Nodo del arbol en el que se busca el String
	 * @param list
	 *            Lista con todos los nodos de ese arbol
	 * @return El primer String en inorder
	 */
	private String obtenerSiguienteCadena(StringPlus s, LinkedList<StringPlus> list) {
		StringPlus aux = s;
		while (aux.txt == null) {
			list.push(aux.right);
			aux = aux.left;
		}
		return aux.txt;
	}

	/**
	 * Devuelve una subsecuencia de la secuencia de caracteres representada por
	 * este StringPlus.
	 * 
	 * @param beginIndex
	 * @param endIndex
	 * @return StringPlus que representa una subsecuencia de caracteres.
	 * @throws IndexOutOfBoundsException
	 */
	public StringPlus substring(int beginIndex, int endIndex) throws IndexOutOfBoundsException {
		if (beginIndex < 0 || endIndex > this.size() || beginIndex > endIndex)
			throw new IndexOutOfBoundsException("Te has pasado de los limites");

		int auxIndice = 0, aux, size = (endIndex - beginIndex);
		LinkedList<StringPlus> pila = new LinkedList<StringPlus>();
		LinkedList<String> pilaSubstring = new LinkedList<String>();
		String actual;
		StringPlus auxNodo;
		pila.push(this);

		do {
			auxNodo = pila.pop();
			actual = obtenerSiguienteCadena(auxNodo, pila);
			if (auxIndice < beginIndex && beginIndex >= actual.length()) {
				aux = beginIndex - auxIndice;
				auxIndice += actual.length();
				// Si el substring esta dentro de la misma hoja
				if (auxIndice >= beginIndex && aux + size <= actual.length())
					pilaSubstring.push(actual.substring(aux, aux + size));
			}

			else if (auxIndice <= beginIndex) {
				aux = beginIndex - auxIndice;
				auxIndice = beginIndex;
				if (actual.length() > size) {
					pilaSubstring.push(actual.substring(aux, aux + size));
					break;
				} else {
					pilaSubstring.push(actual.substring(aux, actual.length()));
					size -= actual.length();
				}

			}

		} while (!pila.isEmpty() && size > 0);
		return montarArbol(pilaSubstring);
	}

	/**
	 * Genera un arbol StringPlus con los elementos de la pila
	 * 
	 * @param lista
	 *            con los elementos que formaran el arbol
	 * @return StringPlus nuevo
	 */
	private StringPlus montarArbol(LinkedList<String> lista) {
		String aux;
		StringPlus arbol;
		if (lista.size() == 1)
			return new StringPlus(lista.pop());
		LinkedList<StringPlus> nodos = new LinkedList<StringPlus>();
		aux = lista.pop();
		// Crea el primer arbol con los dos primeros elementos
		arbol = new StringPlus(lista.pop()).concat(new StringPlus(aux));
		while (!lista.isEmpty()) {
			nodos.push(new StringPlus(lista.pop()).concat(arbol));
		}

		return arbol;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		// U
		if (txt != null)
			return txt;
		return toString(this).toString();

	}

	/**
	 * Funcion auxiliar que devuelve un objeto del tipo StringBuilder con el resultado
	 * @param t Arbol que se intenta convertir a String
	 * @return Objeto tipo StringBuilder con el valor del arbol
	 */
	private StringBuilder toString(StringPlus t) {
		if (t.txt != null)
			return new StringBuilder(t.txt);
		StringBuilder sb = toString(t.left);
		sb.append(toString(t.right));
		return sb;
	}

	public static void main(String[] args) {
		StringPlus s1 = new StringPlus("fra ").concat(new StringPlus("se e"));

		StringPlus s2 = new StringPlus("a ").concat(new StringPlus("escribir"));
		StringPlus s3 = new StringPlus("ase ").concat(s2);
		StringPlus s4 = new StringPlus("fr").concat(s3);

		System.out.println(s1.toString());
		System.out.println(s4.toString());
		System.out.println(s1.isPrefix(s4));

		System.out.println(s4.substring(1, 1).toString());

	}
}
