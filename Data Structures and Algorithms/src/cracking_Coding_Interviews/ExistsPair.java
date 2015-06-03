package cracking_Coding_Interviews;

public class ExistsPair {
	/*
	 * Program to find if we have any 2 numbers in different positions that sum up to SUM
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] nums = {8,1,5,3};
		int sum=8;
		boolean exists = pairExists(nums,sum);//check if a pair exists in nums that sums up to SUM
		if(exists)System.out.println("True");
		else System.out.println("False");
	}
	/*
	 * O(N) solution worst case
	 * Assuming the map put,contains operations are not a factor 
	 * Next brute solution would have been to sort/group the array based on difference to sum
	 */
	public static boolean pairExists(int [] nums,int sum){
		if(nums.length<1)return false;//or throw an Exception
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();//map to keep track of pair<nums[i],numdifference between sum and item i
		for(Integer i:nums){
			if(map.contains(sum-i))return true;//check if pair exist
			map.put(i,(sum-i));//store pair in map
		}
		return false;
	}
}
