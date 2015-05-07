package cracking_Coding_Interviews;

import java.util.Arrays;

public class IsPermutation {
	/*
	 * Algorithm to find if 2 strings are permutations of each other
	 * Assuming strings are ASCII and whitespace is ignored
	 * isPermtation O(n) no extra space
	 * isPermutation2 uses sorting to achieve results so depends on sort
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean permutation = isPermutation2("abc","cab");
		if(permutation)
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}

	}
	/*
	 * method to return true if 2 strings are permutations
	 * Uses ASCII 256 representation to get a score for each string as we go through the characters then compare the scores
	 */
	public static boolean isPermutation(String a,String b)
	{
		if(a.length()!=b.length())return false;
		int scoreA=0,scoreB=0;
		for(int i=0;i<a.length();i++)
		{
			scoreA+=a.charAt(i);
			scoreB+=b.charAt(i);
		}
		return (scoreA==scoreB);
	}
	
	/*
	 * use the QuickSort algorithm that Arrays.Sort uses for primitives O(n log n)
	 * Then compare the sorted strings
	 */
	public static boolean isPermutation2(String a,String b)
	{
		if(a.length()!=b.length())return false;
		return sort(a).equals(sort(b));
	}
	
	private static String sort(String s)
	{
		char [] content = s.toCharArray();
		Arrays.sort(content);
		return new String(content);
	}

}
