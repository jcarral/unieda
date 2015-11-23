package hw6;
/*
 * Tiempo empleado: 30minutos
 */
public class Expresion {

	//Constantes
	private static final int NUMERO = 0, OPERADOR = 1, NOMBRE = 2;
	private int tipo;
	private int numero;
	private String nombre;
	private String op;
	private Expresion left;
	private Expresion right;

	/**
	 * Construye un nuevo �rbol que representa la expresion formada por el
	 * entero v
	 * 
	 * @param v
	 *            Entero que forma la expresion
	 */
	public Expresion(int v) {
		tipo = NUMERO;
		numero = v;
	}

	/**
	 * Construye un nuevo �rbol que representa la expresion formada por el
	 * String name
	 * 
	 * @param name
	 *            String que forma la expresi�n
	 */
	public Expresion(String name) {
		tipo = NOMBRE;
		nombre = name;
	}

	/**
	 * Construye un nuevo �rbol que representa la expresion formada por el
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
		tipo = OPERADOR;
		op = opr;
		this.left = left;
		this.right = right;
	}

	public String toString() {
		return toString(this);
	}

	/**
	 * Función auxiliar que imprime el arbol en inorder
	 * 
	 * @param node
	 * @return devuelve un String con los nodos
	 */
	private String toString(Expresion node) {
		if (node == null)
			return "";

		String s = toString(node.left);
		s += getData(node) + " ";
		s += toString(node.right);
		if(node.left != null && node.left.tipo == NUMERO)
			s = "(" + s + ")";
		return s;
	}

	/**
	 * Funci�n auxiliar para sacar el dato del nodo
	 * 
	 * @param ptr
	 *            Nodo del que se saca el dato
	 * @return Un String con el dato
	 */
	private String getData(Expresion ptr) {
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
	 * Funci�n que devuelve si hay alg�n nodo del tipo nombre
	 * 
	 * @return Devuelve true si no hay nodos del tipo nombre
	 */
	public boolean isClosed() {
		if (this == null)
			return false;
		return isClosed(this);
	}

	/**
	 * Función auxiliar para recorrer recursivamente el árbol
	 * 
	 * @param ptr
	 *            Nodo del arbol
	 * @return Devuelve true si no hay nodos del tipo nombre
	 */
	private boolean isClosed(Expresion ptr) {
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
	 * Se sustituyen en la expresi�n todas las apariciones del nombre indicado
	 * por el valor inidicado
	 * 
	 * @param name
	 *            nombre a sustituir
	 * @param v
	 *            nuevo valor del nodo
	 */
	public void substitute(String name, int v) {
		substitute(name, v, this);
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
	private void substitute(String name, int v, Expresion ptr) {
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
	 * Funci�n para obtener el valor del camino m�s largo
	 * 
	 * @return valor del recorrido m�s largo
	 */
	public int longestPath() {
		return longestPath(this);
	}

	/**
	 * Función auxiliar
	 * 
	 * @param ptr
	 * @return
	 */
	private int longestPath(Expresion ptr) {
		if (ptr == null)
			return -1;
		int iz = longestPath(ptr.left) + 1;
		int dc = longestPath(ptr.right) + 1;
		return (iz > dc) ? iz : dc;
	}

	/**
	 * Funci�n que devuelve si el arbol actual es ismorfico respecto al que se
	 * pasa por parametro
	 * 
	 * @param t
	 *            Expresion a comparar
	 * @return devuelve true si son isomorficos
	 */
	public boolean isIsomorphicTo(Expresion t) {
		return isIsomorphicTo(this, t);
	}

	public static boolean isIsomorphicTo(Expresion t1, Expresion t2) {
		if (t1 == null && t2 == null)
			return true;
		if (t1 == null || t2 == null)
			return false;
		return (isIsomorphicTo(t1.left, t2.right) && isIsomorphicTo(t1.right, t2.left))
				|| (isIsomorphicTo(t1.left, t2.left) && isIsomorphicTo(t1.right, t2.right));
	}
	
	/**
	 * Calcula el resultado de la expresión
	 * @return Devuelve el resultado de la expresión del árbol
	 */
	public int calcular(){
		if(tipo == NUMERO)
			return numero;
		else
			return operar(left.calcular(), op, right.calcular());	
	}
	
	private static int operar(int izq, String op, int dcha){
		switch(op){
			case "*":
				return izq * dcha;
			case "+":
				return izq + dcha;
			case "-":
				return izq - dcha;
			case "/":
				return izq / dcha;
			case "%":
				return izq % dcha;
			default:
				return 0;
		}
	}
	
}
