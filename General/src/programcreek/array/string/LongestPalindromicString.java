package programcreek.array.string;

import java.util.Scanner;

public class LongestPalindromicString {
	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		System.out.println(longestPalindromicSubString(input));
		//System.out.println(isPalindrome(input));
	}
	
	private static String longestPalindromicSubString(String input){
		if(input == null || input.length() == 0) return null;
		if(input.length() == 1) return input;
		else if(isPalindrome(input)) return input;
		else if(isPalindrome(input.substring(1))) return input.substring(1);
		else return null;
	}
	
	private static boolean isPalindrome(String input){
		if(input == null || input.length() == 0) return false;
		if(input.length() == 1 ) return true;
		if(input.length() == 2) return (input.charAt(0) == input.charAt(1));
		else if(input.charAt(0) != input.charAt(input.length() -1 ))
			return false;
		else{
			return isPalindrome(input.substring(1, input.length() - 1 ));
		}
	}

}
