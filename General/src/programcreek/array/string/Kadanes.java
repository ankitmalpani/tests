package programcreek.array.string;

import java.util.ArrayList;
import java.util.List;

public class Kadanes {
	
	public static void main(String [] args){
		int [] array = new int []{-2, 1, -3, 4, -1, 2, 1, -5, 4};
		//int [] array = new int []{-2, 1, 3};
		findMaxContiguousSum(array);
	}
	
	public static void findMaxContiguousSum(int [] input){
		List<Integer> record = new ArrayList<Integer>();
		int currentMax = 0;
		int prevCurrMax = 0;
		int prevTotalMax = 0;
		int totalMax = 0;
		for(int i = 0 ; i < input.length; i++){
			prevCurrMax = currentMax;
			currentMax = Math.max(0, input[i]+currentMax);
			if(currentMax == 0){
				record.clear();
				continue;
			}	
			prevTotalMax = totalMax;
			totalMax = Math.max(totalMax,currentMax);
			if(currentMax >= prevCurrMax ){
				if(totalMax >= prevTotalMax)
					record.add(input[i]);
			}
		}
		System.out.println(totalMax);
		for(int n : record){
			System.out.println(n);
		}
	}
}

