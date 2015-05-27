package cracking_Coding_Interviews;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Program to group a list of strings by anagrams
 * A faster approach would be to store the anagrams based on the sum in a hash map like 
 * Map<Integer,List<String>>
 * This way we group by anagram and have no need to sort. 
 */
public class SortByAnagram{
	
	public static void main(String[] args){
		
		String [] words = {"abc","mad","dam","cab"};
		sortByAnagram(words);
		for(String w:words){
			System.out.println(w);
		}
	}
	
	/*
	 * solution takes O(n log n) since we use Java's Built in sort to sort based on our custom comparator 
	 */
	public static void sortByAnagram(String [] words){
		Arrays.sort(words,new AnagramComparator());
	}
	
	
	/*
	 * Create an anagram comparator that will be used to sort the list
	 */
	static class AnagramComparator implements Comparator<String>{
		public Integer getSum (String w){
			int sum=0;
			for(int i=0;i<w.length();i++){
				sum+=w.charAt(i);
			}
			return sum;
		}
		/*
		 * We can store the value of <String,getSum(String)>  in a hash map for faster sorting 
		 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
		 */
		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			return getSum(arg0).compareTo(getSum(arg1));
		}
	}
}