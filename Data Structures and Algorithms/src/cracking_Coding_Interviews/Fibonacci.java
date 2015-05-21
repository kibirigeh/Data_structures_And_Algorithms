package cracking_Coding_Interviews;

public class Fibonacci {
	
	static final int MAX = 256;
	
	static int [] fib = new int[MAX];//use constant array or use HASH MAP
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(nthFibonnaci(3));
	}
	
	public static int nthFibonnaci(int n){
		return fibonnaci(n);
	}
	/*
	 * find nth Fibonnaci number using DP and recursion
	 * Cache the numbers to avoid huge recursion stack
	 * O(n)
	 */
	private static int fibonnaci(int n){
		if(n==0)return 0;
		if(n==1)return 1;
		if(fib[n]==0) fib[n]=fibonnaci(n-1)+fibonnaci(n-2);
		return fib[n];
	}

}
