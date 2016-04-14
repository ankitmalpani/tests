package com.commonbond.challenge.question2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.apache.commons.lang3.StringUtils;

/**
 * A class that displays the sharpnel movements at each time interval 
 * @author amalpani
 *
 */
public class SharpnelMovement {

	public static final Logger LOGGER = Logger.getLogger(SharpnelMovement.class.getName());
	public static final String VALID_INPUT = "valid";

	public String[] explode(String bombs, int force){
		List<String> output = new ArrayList<String>();
		String validity = validateInput(bombs, force);
		if(VALID_INPUT.equals(validity)){
			output = process(bombs,force);
		}
		else{
			LOGGER.warning(validity);
			System.exit(-1);
		}
		String [] newArray = new String [output.size()];
		return output.toArray(newArray);
	}

	/**
	 * The main process function - which drives when to stop.
	 * TODO: some more unit tests for bad cases
	 * @param input
	 * @param f
	 * @return
	 */
	public List<String> process(String input, int f){
		List<String> output = new ArrayList<String>();
		output.add(input);
		int dotCount = StringUtils.countMatches(input, '.');
		String toProcess = input;
		while(dotCount < input.length()){
			String currOutput = change(toProcess, f);
			output.add(currOutput);
			dotCount = StringUtils.countMatches(currOutput, '.');
			toProcess = currOutput;
		}
		return output;
	}

	/**
	 * This method does the meat of the work - implements changes at time T 
	 * TODO: INCOMPLETE : testing some edge cases (only basic input unit tests have passed)
	 * @param input
	 * @param force
	 * @return
	 */
	public String change(String input, int force){
		char [] bombsArray = input.toCharArray();
		char [] tempArray = new char [input.length()] ;
		Arrays.fill(tempArray, '.');
		for(int i = 0 ; i < input.length() ; i++){
			if(bombsArray[i] == 'B' || bombsArray[i] == 'X'){
				int leftSIndex = i - force;
				int rightSIndex = i + force;
				if(leftSIndex >= 0){
					if('>' == (tempArray[leftSIndex]))
						tempArray[leftSIndex] = 'X';
					else
						tempArray[leftSIndex] = '<';
				}
				if(rightSIndex < input.length()){
					if('<' == tempArray[rightSIndex])
						tempArray[rightSIndex] = 'X';
					else
						tempArray[rightSIndex] = '>';
				}
			}
			else if(bombsArray[i] == '>'  ){
				int rightSIndex = i + force;
				if(rightSIndex < input.length()){
					if('<' == tempArray[rightSIndex])
						tempArray[rightSIndex] = 'X';
					else
						tempArray[rightSIndex] = '>';
				}
			}
			else if(bombsArray[i] == '<' ){
				int leftSIndex = i - force;
				if(leftSIndex >= 0){
					if('>' == (tempArray[leftSIndex]))
						tempArray[leftSIndex] = 'X';
					else
						tempArray[leftSIndex] = '<';
				}
			}
		}
		return String.valueOf(tempArray);
	}
	
	private String validateInput(String bombs, int force){
		Set<Character> validInputSet = new HashSet<Character>();
		validInputSet.add('.');
		validInputSet.add('B');
		if(bombs == null) return "INCORRECT INPUT: input is null";
		if("".equals(bombs) || bombs.length() > 50) return "INCORRECT INPUT: length of bombs string should be between 1 & 50 as per requiremnt" + bombs ;
		for(char x  : bombs.toCharArray())
			if(!validInputSet.contains(x)) return "INCORRECT INPUT: input string contains values other than '.' and 'B'"+bombs;
		if(force < 1 || force > 10) 
			return "INCORRECT INPUT: force is not between required values of 1-10"+force;
		return VALID_INPUT;
	}
	
}




