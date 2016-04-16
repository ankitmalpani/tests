package sorting;

public class InsertionSort {
	
	public static void main(String [] args){
		int [] input = new int []{3,6,5,1,8,7,2,4};
		printArr(input);
		insertionSort(input);
		printArr(input);
		
	}
	
	public static void insertionSort( int [ ] arr){
		for(int i = 1; i < arr.length; i++){ 
			int key = arr[ i ]; //not zeroth but the next one.
			System.out.println("arr["+i+"] "+ key);
			int x = i - 1;
			while( x >= 0 && arr[x] > key ){
				arr[ x+1 ] = arr[ x ];
				x--;
			}
			arr[ x+1 ] = key;    // Put the key in its proper location
			System.out.println("arr["+(x+1)+"] ");
			printArr(arr);
		}
	}
	
	private static void printArr(int [] arr){
		StringBuilder b = new StringBuilder();
		for(int n: arr) b.append(n+",");
		b.deleteCharAt(b.length() - 1);
		System.out.println(b.toString());
	}
	

}
