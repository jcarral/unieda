
package student;

import java.util.*;

/**
 * Tiempo empleado: 45mins
 *
 */
public class BinaryTree {

	public Node raiz;

	public void printByLevel() {

		Queue<Node> currentLevel = new LinkedList<Node>();
		Queue<Node> nextLevel = new LinkedList<Node>();

		currentLevel.add(raiz);

		while (!currentLevel.isEmpty()) {
			Iterator<Node> iter = currentLevel.iterator();
			while (iter.hasNext()) {
				Node currentNode = iter.next();
				if (currentNode.left != null) {
					nextLevel.add(currentNode.left);
				}
				if (currentNode.right != null) {
					nextLevel.add(currentNode.right);
				}
				System.out.print(currentNode.value + " ");
			}
			System.out.println();
			currentLevel = nextLevel;
			nextLevel = new LinkedList<Node>();

		}
	}

	public List<Node> getLeafNodes() {
		List<Node> list = new LinkedList<Node>();
		getLeafNodes(raiz, list);
		return list;
	}

	private void getLeafNodes(Node ptr, List<Node> list) {
		if (ptr != null) {
			getLeafNodes(ptr.left, list);
			getLeafNodes(ptr.right, list);

			if (ptr.left == null && ptr.right == null) {
				list.add(ptr);
			}
		}
	}

	public static BinaryTree build(int[] inorder, int[] preorder) {
		BinaryTree bt = new BinaryTree();
		bt.raiz = build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
		return bt;
	}

	public static Node build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if (preStart > preEnd || inStart > inEnd) {
			return null;
		}

		int v = preorder[preStart];
		Node p = new Node(null, v, null);

		int pos = 0;
		for (int i = 0; i < inorder.length; i++) {
			if (v == inorder[i]) {
				pos = i;
				break;
			}
		}

		p.left = build(preorder, preStart + 1, preStart + (pos - inStart), inorder, inStart, pos - 1);
		p.right = build(preorder, preStart + (pos - inStart) + 1, preEnd, inorder, pos + 1, inEnd);

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
	
	
	
	public static void main(String args[]){
		
		int [] aInorder = {10, 12, 20, 30, 37, 40, 45};
		int [] aPreorder = {30, 20, 10, 12, 40, 37, 45};
		
		/*Salida:
		* 30
		* 20 40
		* 10 37 45
		* 12
		*/
		BinaryTree tree = build(aInorder, aPreorder);
		tree.printByLevel();
		List<Node> list = new LinkedList();
		tree.getLeafNodes(tree.raiz, list);
		
		System.out.print("\nHojas: ");
		for(int i=0;i<list.size();i++){
		    System.out.print(list.get(i).value + " ");
		}
		
		
	}

}
