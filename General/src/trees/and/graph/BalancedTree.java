package trees.and.graph;

public class BalancedTree {
	
	private static boolean isTreeBalanced(Node root){
		if(root == null) return false;
		int diff = Math.abs(findHeight(root.left) - findHeight(root.right));
		if( diff == 1 || diff == 0)
			return true;
		return false;
	}
	
	private static int findHeight(Node n){
		if(n == null) return -1;
		return 1 + max(findHeight(n.left), findHeight(n.right));
	}
	
	private static int max(int a, int b){
		return a > b ? a : b;
	}
	
	
	
	
	public class Node{
		Node left;
		Node right;
		int height;
	}

}
