package student;

public class Expresion {

	// Constantes
	private static final int NUMERO = 0, OPERADOR = 1, NOMBRE = 2;
	Node raiz; // Nodo raiz

	/**
	 * Construye un nuevo árbol que representa la expresion formada por el
	 * entero v
	 * 
	 * @param v
	 *            Entero que forma la expresion
	 */
	public Expresion(int v) {
		raiz = new Node(v);
	}

	/**
	 * Construye un nuevo árbol que representa la expresion formada por el
	 * String name
	 * 
	 * @param name
	 *            String que forma la expresión
	 */
	public Expresion(String name) {
		raiz = new Node(name);
	}

	/**
	 * Construye un nuevo árbol que representa la expresion formada por el
	 * operador y otras dos expresiones
	 * 
	 * @param opr
	 *            String que corresponde al operador
	 * @param left
	 *            Rama izquierda
	 * @param right
	 *            Rama derecha
	 */
	public Expresion(String opr, Expresion left, Expresion right) {
		raiz = new Node(opr, left.raiz, right.raiz);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return toString(raiz);
	}

	/**
	 * Función auxiliar que imprime el arbol en inorder
	 * 
	 * @param node
	 * @return devuelve un String con los nodos
	 */
	private String toString(Node node) {
		if (node == null)
			return "";

		String s = toString(node.left);
		s += getData(node) + " ";
		s += toString(node.right);
		return s;
	}

	/**
	 * Función auxiliar para sacar el dato del nodo
	 * 
	 * @param ptr
	 *            Nodo del que se saca el dato
	 * @return Un String con el dato
	 */
	private String getData(Node ptr) {
		switch (ptr.tipo) {
		case NUMERO:
			return Integer.toString(ptr.numero);
		case OPERADOR:
			return ptr.op;
		case NOMBRE:
			return ptr.nombre;
		default:
			return " ";
		}
	}

	/**
	 * Función que devuelve si hay algún nodo del tipo nombre
	 * 
	 * @return Devuelve true si no hay nodos del tipo nombre
	 */
	public boolean isClosed() {
		if (raiz == null)
			return false;
		return isClosed(raiz);
	}

	/**
	 * Función auxiliar para recorrer recursivamente el árbol
	 * 
	 * @param ptr
	 *            Nodo del arbol
	 * @return Devuelve true si no hay nodos del tipo nombre
	 */
	private boolean isClosed(Node ptr) {
		if (ptr == null)
			return true;
		if (ptr.tipo == NOMBRE)
			return false;
		if (!isClosed(ptr.left))
			return false;
		else
			return isClosed(ptr.right);

	}

	/**
	 * Se sustituyen en la expresión todas las apariciones del nombre indicado
	 * por el valor inidicado
	 * 
	 * @param name
	 *            nombre a sustituir
	 * @param v
	 *            nuevo valor del nodo
	 */
	public void substitute(String name, int v) {
		substitute(name, v, raiz);
	}

	/**
	 * Función auxiliar para recorrer recursivamente el árbol
	 * 
	 * @param name
	 *            nombre a sustituir
	 * @param v
	 *            nuevo valor del nodo
	 * @param ptr
	 *            Nodo que se verifica
	 */
	private void substitute(String name, int v, Node ptr) {
		if (ptr == null)
			return;
		if (ptr.tipo == NOMBRE && ptr.nombre.equals(name)) {
			ptr.tipo = NUMERO;
			ptr.numero = v;
		}
		substitute(name, v, ptr.left);
		substitute(name, v, ptr.right);
	}

	/**
	 * Función para obtener el valor del camino más largo
	 * 
	 * @return valor del recorrido más largo
	 */
	public int longestPath() {
		return longestPath(raiz);
	}

	/**
	 * Función auxiliar
	 * 
	 * @param ptr
	 * @return
	 */
	private int longestPath(Node ptr) {
		if (ptr == null)
			return -1;
		int iz = longestPath(ptr.left) + 1;
		int dc = longestPath(ptr.right) + 1;
		return (iz > dc) ? iz : dc;
	}

	/**
	 * Función que devuelve si el arbol actual es ismorfico respecto al que se
	 * pasa por parametro
	 * 
	 * @param t
	 *            Expresion a comparar
	 * @return devuelve true si son isomorficos
	 */
	public boolean isIsomorphicTo(Expresion t) {
		return isIsomorphicTo(this.raiz, t.raiz);
	}

	/**
	 * Función auxiliar
	 */
	public boolean isIsomorphicTo(Node t1, Node t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		return (isIsomorphicTo(t1.left, t2.right) && isIsomorphicTo(t1.right,
				t2.left))
				|| (isIsomorphicTo(t1.left, t2.left) && isIsomorphicTo(
						t1.right, t2.right));
	}

	class Node {
		private int tipo;
		private int numero;
		private String nombre;
		private String op;
		private Node left;
		private Node right;

		Node(int val) {
			tipo = NUMERO;
			numero = val;
		}

		Node(String s) {
			tipo = NOMBRE;
			nombre = s;
		}

		Node(String op, Node left, Node right) {
			tipo = OPERADOR;
			this.op = op;
			this.left = left;
			this.right = right;
		}

	}

	public static void main(String args[]) {
		Expresion n1 = new Expresion(3);
		Expresion n2 = new Expresion("a");
		Expresion e1 = new Expresion("+", n1, n2);
		Expresion e2 = new Expresion("*", new Expresion(8), e1);
		System.out.println(e2.toString());
		System.out.println(e2.isClosed());
		e2.substitute("a", 288);
		System.out.println(e2.toString());
		System.out.println(e2.longestPath());
		Expresion e3 = new Expresion("-", new Expresion(123), e2);
		System.out.println(e3.longestPath());
		System.out.println(e3.toString());
		System.out.println(e3.isIsomorphicTo(e2));
	}
}
