package trees.and.graph;

public class CommonAncestor {
	
	private static Node commonAncestor(Node root, Node a, Node b){
		if(Math.max(a.data, b.data) < root.data)
			return commonAncestor(root.left, a, b);
		else if(Math.min(a.data, b.data) > root.data)
			return commonAncestor(root.right, a, b	);
		else
			return root;
		
	}
	

}
