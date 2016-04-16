package trees.and.graph;

import java.util.HashSet;
import java.util.Set;

public class PathCheckGraph {
	
	private static Set<Node> visited = new HashSet<Node>();
	
	public static boolean doesPathExist(Node a, Node b){
		if(a == null || b == null) return false;
		visit(a);
		return isVisited(b);
	}
	
	public static void visit(Node a){
		visited.add(a);
		for(Node n : a.neighbors){
			if(!isVisited(n))
				visit(n);
		}
	}
	
	private static boolean isVisited(Node a){
		if(visited.contains(a))
			return true;
		return false;
	}
	
	public class Node{
		int data;
		Set<Node> neighbors;
	}

}
