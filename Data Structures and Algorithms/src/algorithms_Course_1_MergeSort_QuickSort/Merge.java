package algorithms_Course_1_MergeSort_QuickSort;

public class Merge {

	/* 
	 *Implementation of generic MergeSort following Cousera algorithms course 
	 *O(n lon n) computation time
	 *Stable algorithm
	 *Used on objects most of the times
	 *Not in-place-Requires extra memory 
	 *Add insertion sort if items are few to make sorting faster
	 */
	
	@SuppressWarnings({ "rawtypes" })
	private static void merge(Comparable[] a, Comparable[]aux,int lo,int mid,int hi)//function to actually merge two lists
	{
		for(int k = lo;k<=hi;k++)//copy list into aux list making mergesort not in-place
		{
			aux[k]=a[k];
		}
		
		int i=lo,j=mid+1;
		//Merging process starts
		for(int k=lo;k<=hi;k++)
		{
			if(i>mid)a[k]=aux[j++];//if we have already exhausted I 
			else if(j>hi) a[k]=aux[i++];//if j is exhausted
			else if(less(aux[j],aux[i]))a[k]=aux[j++];
			else a[k]=aux[i++];
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less (Comparable a,Comparable b)//utility function to check if a is less than b
	{
		return a.compareTo(b)==-1;
	}
	
	@SuppressWarnings("rawtypes")
	private static void Sort(Comparable [] a,Comparable[] aux, int lo, int hi)//private recursive Sort function to do the work
	{
		if(hi<=lo)return;//No need to sort
		int mid=lo+(hi-lo)/2;//find midpoint
		Sort(a,aux,lo,mid);//Sort the left Side
		Sort(a,aux,mid+1,hi);//Sort the right Side
		merge(a,aux,lo,mid,hi);//Merge the two sides
	}
	
	@SuppressWarnings("rawtypes")
	public static void Sort(Comparable [] a)//public Sort method that takes objects that implement Comparable Interface
	{
		Comparable [] aux = new Comparable[a.length];
		Sort(a,aux,0,a.length-1);	
	}
}
