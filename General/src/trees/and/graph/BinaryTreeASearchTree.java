package trees.and.graph;

public class BinaryTreeASearchTree {
	
	private static boolean isBst(Node root){
		if(root == null) return true;
		if(!(root.left.data <= root.data && root.right.data >= root.data)){
			return false;
		}
		else{
			return (isBst(root.left) && isBst(root.right));
		}
		
	}

}
