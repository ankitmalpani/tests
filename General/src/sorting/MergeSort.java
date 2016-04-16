package sorting;

public class MergeSort {
	
	public static void main(String [] args){
		int [] input = new int []{3,6,5,1,8,7,2,4};
		printArr(input);
		sort(input,0,input.length-1);
		printArr(input);
		
	}
	
	private static void sort(int [] arr, int start, int end){
		int size = arr.length;
		int mid = size/2;
		sort(arr,start,mid);
		sort(arr,mid+1,end);
		merge(arr,start, mid, end);
	}
	
	private static void merge(int [] input, int start, int mid, int end){
		int [] sortedArr = new int [input.length];
		int sortedIncr = 0;
		if(input[mid] < input[mid+1]){
			for(int i = start ; i <=mid ;i++){
				sortedArr[sortedIncr++] = input[i];
			}
		}
		else if(input[mid+1] < input[start]){
			for(int i = mid+1 ; i <= end ;i++){
				sortedArr[sortedIncr++] = input[i];
			}
		}
		else{
			int i = start;
			int j = mid+1;
			if(input[i] <= input[j]){
				sortedArr[sortedIncr++] = input[i++];
			}
			else{
				sortedArr[sortedIncr++] = input[j++];
			}
		}
	}
	
	private static void printArr(int [] arr){
		StringBuilder b = new StringBuilder();
		for(int n: arr) b.append(n+",");
		b.deleteCharAt(b.length() - 1);
		System.out.println(b.toString());
	}
	

}
