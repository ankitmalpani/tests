package trees.and.graph;

public class Factorial {
	
	public static void main(String [] args){
		int a = 5;
		System.out.println(factorial(a));
		System.out.println(factorial(a,1));
		System.out.println(fibonacci(6));
		System.out.println(fibonacciNonRec(6));
	}
	
	private static int factorial (int x){
		if( x == 0 || x == 1) return 1;
		else return x * factorial(x - 1);
	}
	
	private static int factorial(int x, int acc){
		if( x == 0 ) return acc;
		else return factorial ( x -1 , acc* x);
	}
	
	private static int fibonacci(int n){
		if ( n <= 1) return n;
		else return fibonacci(n-1) + fibonacci(n-2);
	}
	
	private static int fibonacciNonRec(int n){
		if( n <= 1 ) return n;
		else{
			int fib =1 , prev = 1;
			for(int i = 2 ; i < n; i++){
				int curr = fib;
				fib = curr + prev;
				prev = curr;
			}
			return fib;
		}
	}

}
