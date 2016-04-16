//package trees.and.graph;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
////TODO: fix
//public class MazeSearch {
//	
//	private static Node cheese = new MazeSearch.Node(3,3, false);
//	private static int [] [] maze = null;
//	private static Set<List<Node>> allPaths = new HashSet<List<Node>>();
//	
//	public static void solveMaze(Node a){
//		if(moveRight(a) != null){
//			List<Node> currPath = mazeSearch(moveRight(a));
//			allPaths.add(currPath);
//		}
//		if(moveLeft(a) != null){
//			List<Node> currPath = mazeSearch(moveLeft(a));
//			allPaths.add(currPath);
//		}
//		if(moveUp(a) != null){
//			List<Node> currPath = mazeSearch(moveUp(a));
//			allPaths.add(currPath);
//		}
//		if(moveDown(a) != null){
//			List<Node> currPath = mazeSearch(moveDown(a));
//			allPaths.add(currPath);
//		}
//	}
//	
//	public static List<Node> mazeSearch(Node start){
//		List<Node> currPath = new ArrayList<Node>();
//		Node curr = new Node(start.x, start.y, false);
//		currPath.add(curr);
//		while(curr.x != cheese.x && curr.y != cheese.y){
//			Node rightNode = moveRight(curr);
//			if(isMoveValid(curr,rightNode)){
//				currPath.addAll(mazeSearch(rightNode));
//				allPaths.add(currPath);
//			}
//			
//			//TODO: fix for function definition
//			if(isMoveValid(moveRight(curr))) //moveRight
//				mazeSearch(currX + 1, currY);
//			else if(isMoveValid(currX, currY, currX -1 , currY)) //moveLeft
//				mazeSearch(currX-1,currY);
//			else if( isMoveValid(currX, currY, currX, currY+1)) //moveDown
//				mazeSearch(currX, currY+1);
//			else if( isMoveValid(currX, currY, currX, currY-1)) //moveUp
//				mazeSearch(currX, currY-1);
//			
//		}
//	}
//	
//	
//	public static boolean isMoveValid(int sourceX, int sourceY, int destX, int destY){
//		if(maze[destX] [destY] == 1 || maze[destX] [destY] == Integer.MIN_VALUE)
//			return false;
//		if(Math.abs(destX - sourceX) == 1 && Math.abs(destY - sourceY) == 1 ) return false;
//		if(destX - sourceX !=1 || destY - sourceY != 1)
//			return false;
//		return true;
//	}
//	
//	public static boolean isMoveValid(Node a, Node b){
//		if(maze[b.x] [b.y] == 1 || !isInBounds(b))
//			return false;
//		if(Math.abs(b.x - a.x) == 1 && Math.abs(b.y - a.y) == 1 ) return false; //diagonal
//		if(b.x - a.x !=1 || b.y - a.y != 1)
//			return false;
//		return true;
//	}
//	
//	public static boolean isInBounds(Node a){
//		if(a.x > maze[0].length -1) return false;
//		if(a.x < 0) return false;
//		if(a.y > maze.length-1) return false;
//		if(a.y < 0) return false;
//		return true;
//	}
//	
//	public static Node moveRight1(Node a){
//		 return new Node(a.x + 1, a.y, false);
//	}
//	
//	public static Node moveRight(Node a){
//		 Node rightNode =  new Node(a.x + 1, a.y, false);
//		 if(isMoveValid(a,rightNode)) return rightNode;
//		 else return null;
//	}
//	
//	
//	public static Node moveLeft(Node a){
//		 return new Node(a.x - 1, a.y, false);
//	}
//	
//	public static Node moveUp(Node a){
//		 return new Node(a.x, a.y-1, false);
//	}
//	
//	public static Node moveDown(Node a){
//		 return new Node(a.x, a.y+1, false);
//	}
//	
//	public static class Node{
//		int x;
//		int y;
//		boolean isVisited;
//		
//		public Node(int x, int y, boolean isVisited){
//			this.x = x;
//			this.y = y;
//			this.isVisited = isVisited;
//		}
//	}
//
//}
