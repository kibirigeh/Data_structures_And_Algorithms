package topCoder;

import java.util.Arrays;

public class BoyerMoore {
/*
 * BoyerMoore algorithm that searches for patterns in average case of O(N/M)
 * Worst case can be O(N*M) 
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(search("ababcdabcdaaba","abcda"));
	}
	
	public static int search(String txt,String pat){
		int N=txt.length();
		int M=pat.length();
		int [] right = new int[256];
		Arrays.fill(right,-1);
		for(int i=0;i<M;i++)right[pat.charAt(i)]=i;
		//Pattern searching 
		int skip;
		for(int i=0;i<N-M;i+=skip){
			skip=0;//reset skip for every pattern search
			for(int j=M-1;j>=0;j--){
				if(pat.charAt(j)!=txt.charAt(i+j)){
					skip=Math.max(1, j-right[txt.charAt(i+j)]);//shift by j - right most index of unmatched char in txt or shift by 1
				}
			}
			if(skip==0)return i;
		}
		return N;
	}

}
