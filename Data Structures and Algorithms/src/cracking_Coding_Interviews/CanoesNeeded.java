package cracking_Coding_Interviews;

import java.util.Arrays;

public class CanoesNeeded {
	/*
	 * If a canoe can hold 2 kids and a max weight of 150 lbs, 
	 * write a function that returns the minimum number of canoes needed, 
	 * given a list of kids and their weights.
	 */
	static final int canoeMAX = 150;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] kids = {35, 110, 111, 111, 114, 115, 149, 150};
		System.out.println("Canoes Needed: "+getMinCanoes(kids));
	}
	/*
	 * Solution is to sort the kids list
	 * then using one loop with 2 iterators(front & back) 
	 * assign the canoes based on criteria
	 */
	public static int getMinCanoes(int [] kids){
		int canoes = 0;
		Arrays.sort(kids);
		for(int i=0,j=kids.length-1;i<=j;canoes++){
			if(i==j){
				System.out.println("Kid "+kids[i]+" gets his own canoe");
				canoes+=1;
				break ;
			}
			if(kids[i]+kids[j]>canoeMAX){
				System.out.println("Kid "+kids[j]+" gets a canoe");
				j--;
			}
			else{
				System.out.println("Kids "+kids[i]+" & "+kids[j]+" share a canoe");
				j--;
				i++;
			}
		}
		return canoes;
	}
}
