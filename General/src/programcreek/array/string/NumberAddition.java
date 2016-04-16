package programcreek.array.string;

public class NumberAddition {
	
	public static void main(String [] args){
		int [] a = new int [] {2,2,2,3};
		int [] b = new int [] {1,1,1,9};
		int [] result = addNum(a,b);
		StringBuilder builder = new StringBuilder();
		for(int x : result) builder.append(x);
		System.out.println(builder.toString());
	}
	
	private static int [] addNum(int [] a, int [] b){
		int [] result = new int [a.length];
		int digit = a.length - 1;
		int carry = 0;
		while(digit > -1){
			int sumDigit = carry + a[digit] + b[digit];
			if(sumDigit >= 10){
				carry = 1;
				result[digit] = sumDigit % 10;
			}
			else{
				result[digit] = sumDigit;
				carry = 0;
			}
			digit--;
		}
		return result;
	}

}
