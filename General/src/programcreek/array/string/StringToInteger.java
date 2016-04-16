package programcreek.array.string;

import java.util.Scanner;

public class StringToInteger {
	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		int output = StringToInt(input);
		System.out.println(output);
		String inputA = in.nextLine();
		String x = IntToString(Integer.parseInt(inputA));
		System.out.println(x);
	}
	
	private static int StringToInt(String input){
		char [] array = input.toCharArray();
		int num = 0;
		for(char x : array){
			num *= 10;
			num +=  (x - '0') ;
			System.out.println(num);
		}
		return num;
	}
	
	private static String IntToString(int x){
		int n = x;
		StringBuilder b = new StringBuilder();
		while( n > 0){
			int dig = n % 10;
			n = n /10;
			b.append(dig + '0');
		}
		System.out.println(b.toString());
		return b.reverse().toString();
	}
	
	private static int StringToInt2(String input){
		char [] temp = input.toCharArray();
		int num = 0;
		for(char x : temp){
			num = num * 10;
			num = num + ( x - '0');
		}
		return num;
	}

}
