package programcreek.array.string;

import java.util.HashMap;
import java.util.List;

public class SortArrayBasedOnOther {
	
	public String sortByD(String s, List<Character> dict){
		String output = "";
		HashMap<Character, String> map = new HashMap<Character, String>();
		for (char c : dict)
			map.put(c,"");
		for (int i = 0; i < s.length(); ++i)
			map.put(s.charAt(i),map.get(s.charAt(i))+s.charAt(i));
		for (char c : dict)
			output += map.get(c);
		return output;
	}

}
