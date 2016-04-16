package programcreek.array.string;

public class RotateArray {
	
	public static void main(String [] args){
		int [] input = new int [] {1,2,3,4,5,6,7};
		int [] op = rotateRec(input,3);
		for(int n : op) System.out.println(n);
	}
	
	private static int [] rotateRec(int [] input, int k){
		if(k == 0)
			return input;
		else{
			int len = input.length;
			int opIncr = 0;
			int [] output = new int [len];
			output[opIncr++] = input[len - 1];
			for(int i = 0 ; i < len-2 ; i++){ //leave the last/kth element out as it has been rotated and moved to the front
				output[opIncr++] = input[i];
			}
			return rotateRec(output, k-1);
		}
			
	}
	
	private static int [] arrayConcat(int [] a, int [] b){
		int opLen = a.length + b.length;
		int [] output = new int [opLen];
		int opIncr = 0;
		for(int x : a){
			output[opIncr++] = x;
		}
		for(int x : b){
			output[opIncr++] = x;
		}
		return output;
	}	
	

}
