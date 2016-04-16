package cci.arraysandstrings;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Class to find if all characters of a string are unique 
 * @author meghna71
 *
 */
public class Question1 {
	
	public static void main(String [] args){
		Scanner in = new Scanner(System.in);
		String test = in.nextLine();
		boolean isUniqueDS = isUniqueDS(test);
		boolean isUniqueNoDS = isUniqueNoDS(test);
		System.out.println(isUniqueDS+" : "+isUniqueNoDS);
		
	}
	
	//abcda //aabc //abccd //abcdef
	private static boolean isUniqueNoDS(String test){
		char [] array = test.toCharArray();
		for(int i = 0 ; i < test.length() - 1 ; i++){
			for(int j = i+1 ; j < test.length() ; j++){
				if(array[i] == array[j])
					return false;
			}
		}
		return true;
	}
	
	private static boolean isUniqueDS(String test){
		Set<Character> recSet = new HashSet<Character>();
		for(Character c : test.toCharArray()){
			if(recSet.contains(c)){
				return false;
			}
			else
				recSet.add(c);
		}
		return true;
	}

}
