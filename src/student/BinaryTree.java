package student;

import java.util.*;

/**
 * Tiempo empleado: 45mins
 *
 */
public class BinaryTree {

	public Node raiz;

	/**
	 * Funci�n para imprimir todos los elementos de un arbol p�r niveles
	 */
	public void printByLevel() {
		Queue<Node> cola = new LinkedList<Node>(); // FIFO con el nivel actual
		Queue<Node> next; // FIFO cola con el siguiente nivel
		if (raiz == null)
			return;
		cola.add(raiz);
		do {
			next = new LinkedList<Node>(); // Instancia nueva
			printLevel(cola, next);
			System.out.println();
			cola = next;

		} while (!next.isEmpty());
	}

	/**
	 * Funci�n auxiliar para imprimir un nivel
	 * 
	 * @param cola
	 *            Nivel actual que se va a imprimir
	 * @param next
	 *            Cola donde se guardan los nodos del proximo nivel
	 */
	private void printLevel(Queue<Node> cola, Queue<Node> next) {
		Node actual;
		while (!cola.isEmpty()) {
			actual = cola.poll();
			if (actual.left != null)
				((LinkedList<Node>) next).addLast(actual.left);
			if (actual.right != null)
				((LinkedList<Node>) next).addLast(actual.right);
			System.out.print(actual.value + " ");
		}
	}

	/**
	 * Funci�n que introduce en una lista todos los elementos que son hojas de
	 * un �rbol
	 * 
	 * @return
	 */
	public List<Node> getLeafNodes() {
		List<Node> list = new LinkedList<Node>();
		getLeafNodes(raiz, list);
		return list;
	}

	/**
	 * Funci�n auxiliar para buscar recursivamente hasta encontrar las hojas
	 * 
	 * @param ptr
	 *            Nodo candidato a ser hoja
	 * @param list
	 *            Lista donde se ir�n guardando las hojas
	 */
	private void getLeafNodes(Node ptr, List<Node> list) {
		if (ptr != null) {
			getLeafNodes(ptr.left, list);
			getLeafNodes(ptr.right, list);

			if (ptr.left == null && ptr.right == null) {
				list.add(ptr);
			}
		}
	}

	/**
	 * Funci�n para generar un �rbol binario a partir de dos arrays
	 * 
	 * @param inorder
	 *            Array con los elementos leidos de forma 'inorder'
	 * @param preorder
	 *            Array con los elementos leidos de forma 'preorder'
	 * @return Un �rbol binario
	 */
	public static BinaryTree build(int[] inorder, int[] preorder) {
		BinaryTree bt = new BinaryTree();
		bt.raiz = build(preorder, 0, preorder.length - 1, inorder, 0,
				inorder.length - 1);
		return bt;
	}

	/**
	 * Funci�n auxiliar para crear el �rbol de forma recursiva
	 * 
	 * @param preorder
	 *            Array preorder
	 * @param preFirst
	 *            Indice desde donde empezar a buscar en el preorder
	 * @param preLast
	 *            Indice hasta donde buscar en el preorder
	 * @param inorder
	 *            Array inorder
	 * @param inFirst
	 *            Indice desde donde buscar en el inorder
	 * @param inLast
	 *            Indice hasta donde buscar en el inorder
	 * @return Puntero a un nodo padre
	 */
	public static Node build(int[] preorder, int preFirst, int preLast,
			int[] inorder, int inFirst, int inLast) {
		if (preFirst > preLast || inFirst > inLast) {
			return null;
		}

		int v = preorder[preFirst]; // Nodo padre
		Node p = new Node(null, v, null);

		int pos = 0;
		for (int i = 0; i < inorder.length; i++) { // Busca el padre en el
													// inorder
			if (v == inorder[i]) {
				pos = i;
				break;
			}
		}

		// Llamadas recursivas
		p.left = build(preorder, preFirst + 1, preFirst + (pos - inFirst),
				inorder, inFirst, pos - 1);
		p.right = build(preorder, preFirst + (pos - inFirst) + 1, preLast,
				inorder, pos + 1, inLast);

		return p;
	}

	static public class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(Node left, int value, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;

		}
	}

	public static void main(String args[]) {

		int[] aInorder = {  };
		int[] aPreorder = {  };

		/*
		 * Salida: 30 20 40 10 37 45 12
		 */

		BinaryTree tree = build(aInorder, aPreorder);
		tree.printByLevel();
		List<Node> list = new LinkedList();
		tree.getLeafNodes(tree.raiz, list);

		System.out.print("\nHojas: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).value + " ");
		}

	}

}
