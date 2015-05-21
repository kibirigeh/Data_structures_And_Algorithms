package cracking_Coding_Interviews;

public class CountWays {

	/*
	 * with n steps, and can hop either 1 step, 2 steps, or
	 * 3 steps at a time. Implement a method to count 
	 * how many possible ways the child can run up the stairs.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		int [] cache = new int[N+1];
		for(int i =0;i<N+1;i++) cache[i]--;
		System.out.println(countWaysDP(5,cache));
	}
	
	public static int countWaysDP(int n,int [] cache){
		if(n<0)return 0;
		else if(n==0)return 1;
		else if(cache[n]>-1)return cache[n];
		else cache[n]=countWaysDP(n-1,cache)+countWaysDP(n-2,cache)+countWaysDP(n-3,cache);
		return cache[n];
	}
	
	public static int countWays(int n){
		if(n<0)return 0;
		else if(n==0)return 1;
		else return countWays(n-1)+countWays(n-2)+countWays(n-3);
	}

}
