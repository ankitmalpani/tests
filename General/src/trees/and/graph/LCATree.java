package trees.and.graph;

public class LCATree {
	
	private static Node LCA(Node a, Node b){
		if( a.equals(b)) return a;
		else if( a.parent.equals(b)) return b;
		else if(b.parent.equals(a)) return a;
		else if(getDepth(a) < getDepth(b)) return (LCA(a.parent,b));
		else if(getDepth(b) < getDepth(a)) return (LCA(a,b.parent));
		else return (LCA(a.parent, b.parent));
	}
	
	private static int getDepth(Node a){
		int depthCount = 0;
		while(a.parent != null){
			a = a.parent;
			depthCount++;
		}
		return depthCount;
	}
	
	public class Node{
		int data;
		Node left;
		Node right;
		Node parent;
		
		public Node(int data, Node left, Node right, Node parent){
			this.data = data;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
	}
}
