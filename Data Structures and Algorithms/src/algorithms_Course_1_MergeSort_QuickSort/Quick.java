package algorithms_Course_1_MergeSort_QuickSort;

import edu.princeton.cs.introcs.StdRandom;

public class Quick {
	
	/*
	 * Cousera implementation of QuickSort
	 * O(n log n) computation time
	 * Used on primitive data types mostly
	 * In-place algorithm-Does not need extra memory
	 * Use Random pivot in index 0 for better performance ie. Shuffle list prior to sorting
	 * Use 3-Way QuickSort for even better guaranteed performance
	 * 
	 */
	
	@SuppressWarnings("rawtypes")
	private static int partition(Comparable [] a, int lo , int hi)//function that sorts list of items in-place using partition element and returns the index of the next partition element 
	{
		int i = lo,j=hi+1;
		
		Comparable v = a[lo];//pivot
		
		while(true)
		{
			while(less(a[++i],v))//find item on left
				if(i==hi) break;
			while(less(v,a[--j]))//find item on right
				if(j==lo)break;
			if(i>=j)break;//check if i and j cross then break
			exch(a,i,j);
		}
		exch(a,lo,j);//swap with partitioning item. Always swap with j
		return j;//return index of item now known to be in place
	}
	
	@SuppressWarnings("rawtypes")
	public static void Sort(Comparable [] a)
	{
		StdRandom.shuffle(a);//(You can use manually shuffle array), Shuffle list initially. Results improve when 1st partition element is randomly picked from the list  
		Sort(a,0,a.length-1);
	}
	
	@SuppressWarnings("rawtypes")
	private static void Sort(Comparable[]a , int lo, int hi)
	{
		if(hi<=lo)return;//Don't bother sorting because hi is less than lo
		int j=partition(a,lo,hi);//partition item
		Sort(a,lo,j-1);//sort left side
		Sort(a,j+1,hi);//sort right side
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less (Comparable a,Comparable b)//utility function to check if a is less than b
	{
		return a.compareTo(b)==-1;
	}
	
	@SuppressWarnings({ "rawtypes"})
	private static void exch(Comparable[] list,int i,int j)//utility function that swaps comparable items
	{
		Comparable x = list[i];
		list[i]=list[j];
		list[j]=x;
	}
	
	/*
	 * -------------Below is an implementaton of 3Way QuickSort-----------------
	 */
	@SuppressWarnings("rawtypes")
	public static void Sort_3Way(Comparable [] a)//public function to sort using 3Way QuickSort
	{
		Sort_3Way(a,0,a.length-1);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void Sort_3Way(Comparable []a,int lo,int hi)//private function that implements 3Way-QuickSort
	{
		if(hi<=lo)return;//Don't bother since hi is less than or equal to lo
		int lt = lo,gt=hi;//left and right iterators respectively
		Comparable v = a[lo];//pivot item
		int i = lo;//All items iterator i
		
		while(i<=gt)//while i is less than gt
		{
			int cmp = a[i].compareTo(v);//compare between current and pivot item
			if(cmp<0)exch(a,lt++,i++);//if pivot is greater then swap left item with current item
			else if(cmp>0)exch(a,i,gt--);//if pivot is less then swap current item with right item
			else i++;//increment iterator
		}
		
		Sort_3Way(a,lo,lt-1);//sort left side
		Sort_3Way(a,gt+1,hi);//sort right side
	}
}
