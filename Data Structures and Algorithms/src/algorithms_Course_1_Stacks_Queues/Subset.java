package algorithms_Course_1_Stacks_Queues;

import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/*
 * 
 * Write a client program Subset.java that takes a command-line integer k; reads in a sequence of N strings from standard input using StdIn.readString();
 * and prints out exactly k of them, uniformly at random.
 * Each item from the sequence can be printed out at most once. You may assume that 0 <= k <= N, where N is the number of string on standard input.
 */

public class Subset {
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length>=1)
		{
			int k=Integer.parseInt(args[0]);
			RandomizedQueue<String> randQ = new RandomizedQueue<String>();
			
			// read strings from std input:
			String [] s = StdIn.readLine().split(" ");
	        for(String i: s)
	        {
	             randQ.enqueue(i);
	        }
		
			for(int i=0;i<k;i++){
				StdOut.println(randQ.dequeue());
			}
		}
	}
	

}
