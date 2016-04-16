package sorting;

public class BubbleSort {
	
	public static void main(String [] args){
		int [] input = new int []{3,6,5,1,8,7,2,4};
		printArr(input);
		bubbleSort(input);
		printArr(input);
		
	}
	
	
	//better implementation. Basically stops when no swaps have been made
	private static void bubbleSort(int [] arr){
		int size = arr.length;
		boolean swapped = true;
		int count = 0;
		while(swapped){
			swapped = false;
			for(int i = 0; i <= size - 2 ; i++ ){
				int j = i+1;
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					swapped = true;
				}
			}
			count++;
		}
		System.out.println(count);
	}
	
	private static void printArr(int [] arr){
		StringBuilder b = new StringBuilder();
		for(int n: arr) b.append(n+",");
		b.deleteCharAt(b.length() - 1);
		System.out.println(b.toString());
	}
	
	//3,6,5,1,8,7,2,4
		private static void sort(int [] arr){
			int size = arr.length;
			int iterCheck = size - 1;
			int count = 0;
			while(iterCheck >= 0){
				for(int i = 0; i <= size - 2 ; i++ ){
					int j = i+1;
					if(arr[i] > arr[j]){
						int temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
				iterCheck--;
				count++;
			}
			System.out.println(count);
		}

}
