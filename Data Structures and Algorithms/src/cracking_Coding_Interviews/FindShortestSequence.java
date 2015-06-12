package cracking_Coding_Interviews;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindShortestSequence {
	/*
	 * Program to find the shortest sequence of words from set X in a sentence S
	 * You are given a sequence of words S, and a sequence of words T. 
	 * Find the shortest continuous subsequence of words in S such that the words in T appear in that order. 
	 * Handling of capitalization, punctuation, tie-breaking, etc. are optional
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence = "One Ring to rule them all, One Ring to find them, One Ring to bring them all and in the darkness bind them";
 		String[] sequence = {"find","them","all"};
		System.out.println(Solution1(sentence,sequence));
	}
	/*
	 * My brute force solution is to use java's REGEX Engine.
	 * I search for the longest pattern and keep on probing to see if their is anything shorter than it. 
	 * Solution works well regardless of the spread of the sequence we are searching for. 
	 */
	public static String Solution1(String sentence, String[] sequence){
		//Create the Pattern Object that will be used for the REGEX Matching
		Pattern pattern = Pattern.compile(createPattern(sequence));
		//Create the Matcher
		Matcher match = pattern.matcher(sentence);
		String shortSQ = "No Match Found";
		//if the the longest sequence is found 
		while(match.find()){
			shortSQ=match.group();//set the shortest sequence to the found match
			String temp = shortSQ.substring(0,shortSQ.lastIndexOf(sequence[sequence.length-1]));
			temp=shortSQ.substring(temp.length()-sequence[0].length(),temp.length());//then search the longest sequence for a shorter sequence
			match = pattern.matcher(temp);
		}
		return shortSQ;//return the shortest sequence if any
	}
	/*
	 * Function to create a REGEX string from an array of strings
	 * This REGEX pattern will be used to find the longest pattern in a sentence
	 */
	public static String createPattern(String [] sequence){
		StringBuilder x = new StringBuilder();
		String pattern = "(\\W(\\w*))*";
		for(int i=0;i<sequence.length;i++){
			x.append(sequence[i]);
			if(i!=sequence.length-1) x.append(pattern);
		}
		return x.toString();
	}

}
