package programcreek.array.string;

public class RotationWithSubstring {
	
	public static boolean isRotation(String input, String x){
		String firstArg = input + input;
		return isSubstring(firstArg,x);
	}
	
	public static boolean isSubstring(String a, String b){
		return true;
	}

}
