package cracking_Coding_Interviews;

import java.util.BitSet;

public class ExistsPair {
	/*
	 * Program to find if we have any 2 numbers in different positions that sum up to SUM
	 * Sorting the array then iterating with two pointers would solve this problem but
	 * I choose to avoid sorting and went with 2 other solutions
	 * Solution 1 uses a HashMap to Identify the pairs
	 * Solution 2 uses a bit set to identify the pairs  but it assumes the array has positive integers only
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {5,4,0,5,6,0,2,14};//list array or read in from Buffer/File
		int sum=8;//The sum required
		boolean exists = pairExists(nums,sum);//check if a pair exists in nums that sums up to SUM
		if(exists)System.out.println("True");
		else System.out.println("False");
	}
	/*
	 * O(N) solution worst case
	 * Assuming the map put,contains operations are not a factor 
	 * This solution works regardless of negative numbers in the array
	 */
	public static boolean pairExists(int [] nums,int sum){
		if(nums.length<1)return false;//or throw an Exception
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();//map to keep track of pair<nums[i],numdifference between sum and item i
		for(Integer i:nums){
			if(map.contains(sum-i)){
				//System.out.println("Pair ("+i+","+(sum-i)+")");
				return true;//check if pair exist
			}
			map.put(i,(sum-i));//store pair in map
		}
		return false;
	}
	/*
	 * This second solution uses a bit array which would be less space than a hashMap to flag the pairs
	 * It works perfectly assuming we don't have any negative numbers in the array 
	 * O(N) worst case
	 */
	public static boolean pairExists2(int [] nums,int sum){
		if(nums.length<1)return false;//return false if the array is less than 1
		BitSet flags = new BitSet(sum+1);//create a bitSet of size Sum+1 to use for flagging pairs
		for(Integer i: nums){
			if(i>=0 && i<=sum){//if I is possibly in our bitset
				if(flags.get(i))return true;//check if I has already been flagged in a pair
				flags.set(sum-i);//otherwise flag I in a pair
			}
		}
		return false;
	}
}
