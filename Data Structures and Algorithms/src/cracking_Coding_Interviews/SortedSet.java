package cracking_Coding_Interviews;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.TreeSet;

public class SortedSet {
	
	static TreeSet set;
	public static void main(String[] args) throws FileNotFoundException{
		
		set =  new TreeSet();
		
		if(args.length<0)return ;
		
		Scanner in = new Scanner(new FileReader(args[0]));
		
		while(in.hasNext()){
			set.add(in.nextInt());
		}
		
		track(5);
		
	}
	
	public static void  track(int x){
		Object [] temp =  set.toArray();
		int t = binarySearch(temp,x,0,temp.length-1);
		System.out.println("Tracking "+x+" to "+t);
		 
	}
	
	public static int binarySearch(Object [] array,Integer x,int left,int right){
		if(left>right)return -1;//if the left side has crossed the right then item is not found
		
		int mid = (left+right)/2;//get the mid point
		Integer t = (Integer) array[mid];
		
		int cmp = x.compareTo(t);
		if( cmp == -1  )//if item is less than mid point then item is on left
			return binarySearch(array,x,left,mid-1);
		else if(cmp == 1 )//if item is greater than mid point then item is on right
			return binarySearch(array,x,mid+1,right);
		else//otherwise its the middle element since its equal to the item at the mid point
			return mid;
	}
	
	
}
