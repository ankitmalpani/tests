package programcreek.array.string;

public class SpiralPrint {
	
	public static void main(String [] args){
		int [] a = new int [] { 1,2,3,4,5};
		int [] b = new int [] { 6,7,8,9,10};
		int [] c = new int [] { 11,12,13,14,15};
		int [] d = new int [] { 16,17,18,19,20};
		int [] [] input = new int [4] [5];
		input[0] = a;
		input[1] = b;
		input[2] = c;
		input[3] = d;
		int mMax = input.length-1;
		int nMax = input[0].length-1;
		spiralPrint(input,0,0,nMax,mMax);
	}
	
	private static void spiralPrint(int [] [] input, int nMin, int mMin, int nMax, int mMax){
		int currM = mMin;
		int currN = nMin;
		while(nMin < nMax && mMin < mMax){
			while(currN <= nMax ){ //go right
				currN++;
			}
			currM++;
			while(currM <= mMax	){ //go down
				currM++;
			}
			currN-=2;
			while(currN >= nMin){ //go left
				currN--;
			}
			currM-=2;
			while(currM > mMin){ //go up
				currM--;
			}
			nMin++; mMin++;
			nMax--; mMax--;
			currM=mMin;
			currN=nMin;
		}
		
		//spiralPrint(input, nMin+1, mMin+1, nMax-0, mMax-0);
	}
	
	
}
