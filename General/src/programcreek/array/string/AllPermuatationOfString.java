package programcreek.array.string;


public class AllPermuatationOfString {
	
	public static void main(String [] args){
		String input = "abcd";
		findPermutations("",input);
	}
	
	public static void findPermutations(String prefix, String input){
		if(input.length() == 0) 
			System.out.println(prefix);
		else{
			for(int i = 0 ; i < input.length() ; i++)
				findPermutations(prefix + input.charAt(i), input.substring(0,i)+input.substring(i+1));
		}
	}
	


}
