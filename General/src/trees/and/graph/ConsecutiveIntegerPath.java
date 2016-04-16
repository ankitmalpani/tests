package trees.and.graph;

import java.util.Set;

public class ConsecutiveIntegerPath {
	
	
	
	public static void main(String [] args){
		
	}
	
	private int findLongestPath(Node root){
		int longestPathLength = 0;
		int currPathLength = 1;
		if(root == null) return -1;
		for(Node n : root.adjNodes){
			if(isConsecutive(root, n)){
				currPathLength = currPathLength + findLongestPath(n);
			}
			longestPathLength = max(currPathLength, longestPathLength);
			currPathLength = 1;
		}
		
		return longestPathLength;
	}
	
	private int max(int a, int b){
		return a > b ? a : b;
	}
	
	private boolean isConsecutive(Node a, Node b){
		if(a == null || b == null) return false;
		if(b.value - a.value == 1)
			return true;
		return false;
	}
	
	
	public class Node{
		int value;
		Set<Node> adjNodes;
	}

}
