package sorting;

public class Quicksort {
	
	/*function that returns the split point in a list following the QuickSort analogy of a pivot*/
	private static <T extends Comparable<T>> int split(T[] list,int lo, int hi)
	{
		int left = lo+1;//left cursor
		int right = hi;//right cursor
		T pivot = list[lo];//get the pivot
		
		while(true)
		{
			while(left <= right){ //find first greater than pivot left side
				if(list[left].compareTo(pivot) < 0)
				{
					left++;
				}
				else{
					break;
				}
			}
			
			while(right > left){//find first less than pivot from right side
				if(list[right].compareTo(pivot)<0)
				{
					break;
				}
				else{
					right--;
				}
			}
			
			if(left>=right)
			{
				break;
			}
			
			//swap left and right items
			T temp = list[left];
			list[left]=list[right];
			list[right]=temp;
			//advance left and right one step
			left++;
			right--;
		}
		
		//swap pivot with wherever the left cursor is currently
		list[lo]=list[left-1];
		list[left-1]=pivot;
		
		return left-1;
	}
	
	/*recursive function to implement quicksort*/
	private static <T extends Comparable<T>> void sort(T[] list,int lo,int hi)
	{
		if(hi-lo <= 0)//if their is fewer than 2 items return
		{
			return;
		}
		int splitPoint = split(list,lo,hi);
		sort(list,lo,splitPoint-1);//recursively sort the left array
		sort(list,splitPoint+1,hi);//recursively sort the right array
		
	}
	
	/*generic public sort function that will takle a list and implement the quick sport algorithm on it.*/
	public static <T extends Comparable<T>> void sort(T[] list){
		if(list.length <= 1){
			return ;
		}	
		sort(list,0,list.length-1);
	}

}
