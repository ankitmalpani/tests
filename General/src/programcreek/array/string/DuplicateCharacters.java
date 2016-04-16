package programcreek.array.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class DuplicateCharacters {
	
	public void findFirstNonRepeatingCharacter(String s){
		Map<Integer, Character> tracker = new LinkedHashMap<Integer, Character>();
		for(int i = 0 ; i < s.length();){
			int curr = s.codePointAt(i);
			Character val = tracker.get(curr);
			if(val == null) tracker.put(curr, 'O');
			else if(val == 'O') tracker.put(curr,'M');
			//else do nothing
			i += Character.charCount(curr);
		}
	}
	

}
