package com.commonbond.challenge.question1;

import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

public class MissingAlphabets {
	
	public static final Logger LOGGER = Logger.getLogger(MissingAlphabets.class.getName());
	public static final String ALPHABETS = "abcdefghijklmnopqrstuvwxyz";
	
	/**
	 * A method that returns a string containing missing alphabets in the input string that prevent it from being a Pangram
	 * ( A pangram is a string that uses all the alphabets in english)
	 * @param s - input string
	 * @return - string with missing alphabets (naturally ordered as per English language)
	 */
	public static String listMissingLetters(String s){
		StringBuilder missingLetters = new StringBuilder();
		if( s != null){
			//just assuming that output will be ordered(could use a HashSet if thats not a requirement)
			Set<Character> alpha = new TreeSet<Character>(); 
			for(char x : ALPHABETS.toCharArray())
				alpha.add(x);
			String lowerCaseInput = s.toLowerCase();
			for(char c : lowerCaseInput.toCharArray()){
				if(alpha.contains(c))
					alpha.remove(c);
			}
			for(char c : alpha)
				missingLetters.append(c);
		}
		else{
			LOGGER.warning("INCORRECT INPUT : Input String is null");
		}
		return missingLetters.toString();
	}
}
