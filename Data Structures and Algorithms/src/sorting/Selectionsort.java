package sorting;

public class Selectionsort {
	/*
	 * Selection sort algorithm
	 * O(N^2)
	 */
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] list)//using interfaces to generalize  for methods
	{
		int N = list.length;//N to hold size of list
		
		for(int i = 0;i<N; i++)//Iterate through every index of list
		{
			int min = i;//make current index the minimum
			
			for(int j=i+1;j<N;j++)//scan through all indexes to the right of current index i to find the minimum and swap with i
			{
				if(less(list[j],list[min]))//if we find an item smaller than I we set it as the minimum
				{
					min=j;
				}
			}
			exch(list,i,min);//Then exchange i with the minimum that we found
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static boolean less(Comparable x,Comparable y)//function to return true if one item is less than the other
	{
		return x.compareTo(y)==-1;
	}
	
	@SuppressWarnings({ "rawtypes"})
	private static void exch(Comparable[] list,int i,int j)//function that swaps comparable items
	{
		Comparable x = list[i];
		list[i]=list[j];
		list[j]=x;
	}

}
