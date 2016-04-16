package programcreek.array.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder1 {
	
	private static Set<String> dictionary = new HashSet<String>();
	
	private static Queue<String> queue = new LinkedList<String>();

	public static void main(String [] args){
		
	}
	
	private static int stepCount(String start, String target){
		int count = 0;
		addToQueue(start);
		String processed = start;
		
		while(!target.equals(processed)){
			String current = queue.poll();
			for(int i = 0; i < current.length() ; i++){
				processed = process(current, target, i);
				if(isInDict(processed) && !current.equals(processed)){
					count++;
					addToQueue(processed);
					break;
				}
			}
			
		}
		return count;
	}
	
	private static void addToQueue(String x){
		if(!queue.contains(x)) queue.add(x);
	}
	
	private static String process(String start, String target, int indexToChange){
		char [] startArr = start.toCharArray();
		char [] targetArr = target.toCharArray();
		startArr[indexToChange] = targetArr[indexToChange];
		return startArr.toString();
				
	}
	
	private static boolean isInDict(String x){
		return dictionary.contains(x);
	}
	
}
