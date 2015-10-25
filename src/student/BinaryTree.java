package student;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	public Node raiz;
	
	public void printByLevel(){
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
	
	public List<Node> getLeafNodes(){
		
	}
	
	public static BinaryTree build(int[] inorder, int[] preorder){
		
	}
	
	static public class Node{
		public int value;
		public Node left;
		public Node right;
		public Node parent;
		
		public Node(Node left, int value, Node parent, Node right){
			this.value = value;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}

}
