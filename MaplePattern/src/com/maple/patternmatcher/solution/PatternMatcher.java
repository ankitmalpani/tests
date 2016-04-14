package com.maple.patternmatcher.solution;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;

/**
 * A class that implements code to match given paths to a set of given patterns (for some specific requirements)
 * 
 * @author amalpani
 *
 */
public class PatternMatcher {
	
	private static final Logger LOGGER = Logger.getLogger(PatternMatcher.class.getName());
	private static final String FILE_RUN_OPTION = "file";
	
	public static void main(String... args){
		Scanner in = null;
		if(args == null){
			LOGGER.log(Level.WARNING, "Cannot run: no input. Usage: java -jar MaplePattern.jar <file> <fullfilepathandfilename>");
			System.exit(1);
		}
		else{
			if(args.length == 2 && FILE_RUN_OPTION.equals(args[0])){
				String fileName = args[1];
				if(fileName == null || "".equals(fileName)){
					LOGGER.log(Level.WARNING,"No fileName provided. Cannot proceed. Usafe for file: java -jar MaplePattern.jar <file> <filepathandfilename>");
					System.exit(1);
				}
				else{
					try {
						in = new Scanner(new File(fileName),"UTF-8"); //conforms to requirement of UTF-8 inputs
					} catch (IOException e) {
						LOGGER.log(Level.WARNING, "cannot read file. Make sure the path is correct",e);
					}
				}
			}
			else{
				in = new Scanner(System.in, "UTF-8"); //conforms to requirement of UTF-8 inputs
			}
			try{
				int noOfPatterns = Integer.parseInt(in.nextLine());
				while(noOfPatterns > 0){
					String patt = in.nextLine();
					int fieldCount = getFieldCount(patt,",");
					if(patt.contains("*"))
						starPatternMap.put(patt.replace(",", "/"),fieldCount); //a quick pre-process before putting on the set
					else
						patternMap.put(patt.replace(",", "/"),fieldCount);
					noOfPatterns--;
				}
				assert((patternMap.size() + starPatternMap.size()) == noOfPatterns); 
				int noOfPaths = Integer.parseInt(in.nextLine());
				while(noOfPaths > 0){
					printBestMatchingPattern(in.nextLine());
					noOfPaths--;
				}
				System.out.println("\n");
				in.close();
			}
			catch(NumberFormatException e){
				LOGGER.log(Level.WARNING,"Incorrect input.Expected to read the number specifying total patterns or paths.", e);
			}
			finally{
				in.close();
			}	
		}
	}
	
	/**
	 * This method prints the required output for every path.
	 * It finds the best possible path - as described in the problem and prints it out
	 * 
	 * @param path - input to be matched
	 */
	private static void printBestMatchingPattern(String path){
		if(path == null || path == "")
			LOGGER.warning("Bad Path - Empty or Null input: "+path);
		int pathFieldCount = getFieldCount(path, "/");
		for(String pattern : patternMap.keySet()){
			if(patternMap.get(pattern) == pathFieldCount){
				if(isMatch(pattern,path)){
					System.out.println(deProcessPattern(pattern));
					return;
				}	
			}
		}
		for(String pattern : starPatternMap.keySet()){
			if(starPatternMap.get(pattern) == pathFieldCount){
				if(isMatch(pattern.replace("*", ".*[^/]"),path)){ //additional processing for language specific pattern compilation
					System.out.println(deProcessPattern(pattern));
					return;
				}	
			}
		}
		System.out.println("NO MATCH");
	}//starPatternSet.parallelStream().filter(x -> isMatch(x,path));
	
	/**
	 * Checks is a given path (original and without leading/trailing slashes) matches a given pattern
	 * @param pattern - pattern to be matched on
	 * @param path - the input path to be tested
	 * @return
	 */
	private static boolean isMatch(String pattern, String path){
		Pattern patternRegEx = Pattern.compile(pattern,Pattern.UNICODE_CHARACTER_CLASS);
		if(patternRegEx.matcher(path).matches() || patternRegEx.matcher(removeLeadingTrailingSlashes(path)).matches())
			return true;
		return false;
	}
	
	/**
	 * Helper method for removing leading and trailing slashes from the path (Requirement specific)
	 * @param path
	 * @return
	 */
	private static String removeLeadingTrailingSlashes(String path){
		if(path.startsWith("/") && path.endsWith("/"))
			return path.substring(1, path.length()-1);
		else if(path.startsWith("/") && !path.endsWith("/"))
			return path.substring(1);
		else if(!path.startsWith("/") && path.endsWith("/"))
			return path.substring(0, path.length()-1);
		else return path;
	}
	
	/**
	 * Helper method to get the count of fields
	 * @param input - string(pattern or path) 
	 * @param delimiter - could be , or /
	 * @return fieldCount
	 */
	private static int getFieldCount(String input, String delimiter){
		if(input == null || "".equals(input))
			return 0;
		else
			if(input.startsWith(delimiter))
				return input.substring(1).split(delimiter).length;
			 return input.split(delimiter).length;
		
	}
	
	/**
	 * Helper method for requirement specific printing/output
	 * @param pattern
	 * @return
	 */
	private static String deProcessPattern(String pattern){
		//return pattern.replace(".*[^/]", "*").replace('/', ',');
		return pattern.replace('/', ',');
	}
	
	//holds patterns with no wildcards - preferred in output and hence tested first (proceed only if a match is not found against elements of this set)
	private static Map<String,Integer> patternMap = new HashMap<String,Integer>();
	
	
	/**
	 * Holds patterns with wildcards. Comparator provides requirement specific ordering.
	 * Notes to the reader:
	 * 	1) The comparator is recursive
	 * 	2) For conflicting paths - the better match will stay higher up in the ordering and will be checked first
	 * 	3) The real logic is after the lines with "shouldn't happen" comments (Before that includes null/empty checks and base cases)
	 * 	4) Makes use of Apache common's lib StringUtils for char count.
	 * 
	 */
	private static Map<String,Integer> starPatternMap = new TreeMap<String,Integer>(new Comparator<String>(){
			
				public int compare(String pattern1, String pattern2){
					//System.out.println(pattern1 + "vs" + pattern2);
					if((pattern1 == null && pattern2 == null))
						return 0;
					if("".equals(pattern1) && "".equals(pattern2))
						return 0;
					else if(pattern1 == null && pattern2 != null)
						return -1;
					else if("".equals(pattern1) && !"".equals(pattern2))
						return -1;
					else if(pattern1 != null && pattern2 == null)
						return 1;
					else if(!"".equals(pattern1) && "".equals(pattern2))
						return 1;
					else if(pattern1.equals(pattern2))
						return 0;
					else if(pattern1.contains("* ") && !pattern2.contains("*")) //shouldn't happen
						return 1;
					else if(!pattern1.contains("*") && pattern2.contains("*")) //shouldn't happen
						return -1;
					else{
						if(StringUtils.countMatches(pattern1, '*') > StringUtils.countMatches(pattern2, '*'))
							return 1;
						else if(StringUtils.countMatches(pattern1, '*') < StringUtils.countMatches(pattern2, '*'))
							return -1;
						else{
							if(pattern1.indexOf('*') > pattern2.indexOf('*')){
								return -1;
							}
							else if(pattern1.indexOf('*') < pattern2.indexOf('*')){
								return 1;
							}
							else{
								return compare(pattern1.substring(pattern1.indexOf('*')+1), pattern2.substring(pattern2.indexOf('*')+1));
							}
						}
					}
				}			
	});

}
