package sorting;

public class Insertionsort {
	
	/*
	 * Insertion sort algorithm
	 * O(N^2)
	 */
	
	@SuppressWarnings("rawtypes")
	public static void sort(Comparable[] list)
	{
		int N = list.length;//store size of list
		
		for(int i=0; i<N; i++)//iterate over all elements in list using i
		{
			for(int j=i; j>0; j--)//find larger item to the left of i
			{
				if(less(list[j],list[j-1]))//if we find a larger element to the left of i we exchange until we are in the right position
				{
					exch(list,j,j-1);
				}
				else//if the less than order is not broken we just break and move on with searching for anomalies
				{
					break;
				}
			}
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
