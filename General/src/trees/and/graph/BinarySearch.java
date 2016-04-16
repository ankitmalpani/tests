package trees.and.graph;

public class BinarySearch {
	
	public static void main(String [] args){
		int [] input = new int [] {1,2,3,4,5,6,9,10,12,14,16 };
		System.out.println(search(input,5));
		System.out.println(search(input,14));
		System.out.println(search(input,8));
		System.out.println(search(input,18));
	}
	
	public static int search(int [] input, int key){
		int len = input.length;
		return binarySearch(input,key,0,len-1);
	}
	
	public static int binarySearch( int [] input, int key, int lo, int hi){
		if( lo > hi) return -1;
		int mid = lo + (hi - lo)/2;
		if(input[mid] == key) return mid;
		else if( input[mid] > key) return binarySearch(input, key, lo, mid-1);
		else if( input[mid] < key) return binarySearch(input, key, mid+1,hi);
		else return -1;
	}

}
