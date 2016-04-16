package trees.and.graph;

public class CreateTree {
	
	public static Node createTree(int [] array){
		if(array.length == 0)
			return null;
		else if(array.length > 1){
			int maxLoc = array.length - 1;
			int minLoc = 0;
			int halfway = (int)Math.floor((maxLoc + minLoc)/2);
			int leftMax = Math.max(halfway - 1,halfway);
			int rightMin = Math.min(halfway + 1,maxLoc);
			int [] newLeftArray = createNewArray(array,minLoc,leftMax);
			int [] newRightArray = createNewArray(array,rightMin,maxLoc);
			Node root = new Node(array[halfway],createTree(newLeftArray),createTree(newRightArray));
			return root;
		}
		else{
			Node root = new Node(array[0], null, null);
			return root;
		}
		
	} 
	
	public static int [] createNewArray(int [] array, int startIndex, int endIndex){
		if(startIndex == endIndex) {
			int []  newSingleElementArr = new int [1];
			newSingleElementArr[0] = array[startIndex];
			return newSingleElementArr;
		}
		int [] arr = new int [endIndex - startIndex + 1];
		int newArrIndex = 0;
		for(int i = startIndex ; i <= endIndex ; i++){
			arr[newArrIndex] = array[i];
		}
		return arr;
	}
	
	private static Node createTree(int [] arr, int start, int end){
		if(arr.length == 0)
			return null;
		else if(arr.length > 1){
			int mid = start + (end -start)/2;
			return new Node(mid, createTree(arr, start, mid-1),createTree(arr,mid+1,end));
		}
		else return new Node(arr[0],null,null);
		
	}
	
}
