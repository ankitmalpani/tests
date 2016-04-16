package cci.arraysandstrings;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Question5 {
	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		String test = in.nextLine();
		String result = compressString(test);
		System.out.println(result);
	}
	
	//aaabbbccddd a3b3c2d3 //aaabbaa a3b2a2
	private static String compressString(String input){
		String test = input+ '\0'; //adding special character for the loop to work
		//null and empty check
		StringBuilder builder = new StringBuilder();
		char prev = test.charAt(0);
		int currCount = 0;
		for(char x : test.toCharArray()){
			if(x != prev ){
				builder.append(prev);
				builder.append(currCount);
				currCount=1;
			}
			else{
				currCount++;
			}
			prev = x;
		}
		return (builder.length() < input.length()) ? builder.toString() : input;
			
	}

}
