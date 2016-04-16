package programcreek.array.string;

public class MedianOfTwoArrays {
	
	public static void main(String [] args){
		int a [] = new int [] {1,2,3,5,6};
		int b [] = new int [] {2,4,5,7,8};
		int [] res = mergeSorted(a,b);
		StringBuilder op = new StringBuilder();
		for(int x : res ){
			op.append(x);
			op.append(",");
		}
		System.out.println(op);
		System.out.println(median(a,b));
	}
	
	public static double median(int [] a, int [] b){
		int [] merged = mergeSorted(a,b);
		int length = merged.length;
		if(merged.length % 2 == 0){
			int halfLen = (length - 1)/2;
			int firstMid = merged[halfLen];
			int secondMid = merged[halfLen+1];
			System.out.println(firstMid+"+"+secondMid);
			return (firstMid + secondMid)/2;
		}
		else{
			return merged[(length-1)/2];
		}
	}

	public static int [] mergeSorted(int [] a, int [] b){
		int n = a.length;
		int m = b.length;
		int [] merged = new int[m+n];
		int aIncr = 0, bIncr = 0,mergeIncr = 0;
		if(a[0] > b[m-1]){
			while(bIncr < m){
				merged[mergeIncr++] = b[bIncr++];
			}
			while(aIncr < n){
				merged[mergeIncr++] = a[aIncr++];
			}
		}
		else if(b[0] > a[n-1]){
			while(aIncr < n){
				merged[mergeIncr++] = a[aIncr++];
			}
			while(bIncr < m){
				merged[mergeIncr++] = b[bIncr++];
			}			
		}
		else{
			while(aIncr < n && bIncr < m){
				if(a[aIncr] < b[bIncr])
					merged[mergeIncr++] = a[aIncr++];
				else
					merged[mergeIncr++] = b[bIncr++];
			}
			while(aIncr < n)
				merged[mergeIncr++] = a[aIncr++];
			while(bIncr < m)
				merged[mergeIncr++] = b[bIncr++];
		}
		return merged;
		
	}
	
}
