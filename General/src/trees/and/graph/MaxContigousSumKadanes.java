package trees.and.graph;

public class MaxContigousSumKadanes {
	
	private static int maxContiguousSum(int [] arr){
		int maxNow = 0, maximum = 0;
		for(int x : arr){
			maxNow = max(0,x + maxNow);
			maximum = max(maximum, maxNow);
		}
		return maximum;
	}
	
	private static int max(int a, int b){
		return a > b ? a : b;
	}
}
