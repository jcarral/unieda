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
		return iguales(this, s);
	}

	private boolean iguales(StringPlus t1, StringPlus t2) {

		LinkedList<StringPlus> pilaPrefix = new LinkedList<StringPlus>();
		LinkedList<StringPlus> pilaCadena = new LinkedList<StringPlus>();
		StringPlus auxPrefix = t1, auxCadena = t2;
		String prefix = obtenerPrimeraCadena(auxPrefix, pilaPrefix),
				cadena = obtenerPrimeraCadena(auxCadena, pilaCadena);
		int i = -1, j = 0;

		while (!pilaPrefix.isEmpty() || (i < prefix.length() && i>0)) {
			if (i == prefix.length()) {
				auxPrefix = pilaPrefix.pop();
				prefix = obtenerPrimeraCadena(auxPrefix, pilaPrefix);
				i = 0;
			}else if(i <0){
				i = 0;
			}
			if (j == cadena.length()) {
				auxCadena = pilaCadena.pop();
				cadena = obtenerPrimeraCadena(auxCadena, pilaCadena);
				j = 0;
			}

			for (; j < cadena.length() && i < prefix.length(); i++, j++) {
				if (prefix.charAt(i) != cadena.charAt(j))
					return false;
			}

		}

		return true;
	}

	private String obtenerPrimeraCadena(StringPlus s, LinkedList<StringPlus> list) {
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
			throw new IndexOutOfBoundsException();
		
		//Variables
		int auxIndice = 0, aux, size = (endIndex-beginIndex);
		LinkedList<StringPlus> pila = new LinkedList<StringPlus>();
		LinkedList<String> pilaSubstring = new LinkedList<String>();
		String actual;
		StringPlus auxNodo;
		pila.push(this);
		do{
			auxNodo = pila.pop();
			actual = obtenerPrimeraCadena(auxNodo, pila);
			
			if(auxIndice < beginIndex && beginIndex>actual.length()){
				auxIndice += actual.length();
			}else if (auxIndice <= beginIndex){
				aux = beginIndex - auxIndice;
				auxIndice = beginIndex;
				
				if(actual.length()>size+1){
					pilaSubstring.push(actual.substring(aux, aux+size+1));
					break;
				}else{
					pilaSubstring.push(actual.substring(aux, actual.length()));
					size -= actual.length();
				}
				
			}
			
		}while(!pila.isEmpty());
		return montarArbol(pilaSubstring);
	}
	
	private StringPlus montarArbol(LinkedList<String> lista){
		String aux;
		if(lista.size()==0)
			return new StringPlus("Error");
		else if(lista.size() == 1)
			return new StringPlus(lista.pop());
		
		LinkedList<StringPlus> nodos = new LinkedList<StringPlus>();
		aux = lista.pop();
		nodos.push(new StringPlus(lista.pop()).concat(new StringPlus(aux))); //Crea el primer arbol con los dos primeros elementos
		while(!lista.isEmpty()){
			nodos.push(new StringPlus(lista.pop()).concat(nodos.pop()));
		}
		
		return nodos.pop();
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

	private StringBuilder toString(StringPlus t) {
		if (t.txt != null)
			return new StringBuilder(t.txt);
		StringBuilder sb = toString(t.left);
		sb.append(toString(t.right));
		return sb;
	}

	public static void main(String[] args) {
		StringPlus s1 = new StringPlus("fra").concat(new StringPlus("s"));

		StringPlus s2 = new StringPlus("a ").concat(new StringPlus("escribir"));
		StringPlus s3 = new StringPlus("ase ").concat(s2);
		StringPlus s4 = new StringPlus("fr").concat(s3);

		System.out.println(s1.toString());
		System.out.println(s4.toString());
		System.out.println(s1.isPrefix(s4));
		
		System.out.println(s4.substring(3, 11).toString());

	}
}
