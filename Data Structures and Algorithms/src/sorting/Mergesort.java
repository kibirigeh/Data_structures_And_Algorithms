package sorting;

public class Mergesort {
	
	private static Integer [] myList;//array to sort
	private static Integer [] tempList;//helper array
	private static int length;
	
	public static void sort(Integer [] list)
	{
		myList=list;
		length=list.length;
		if(length<=1)
		{
			return;
		}
		
		tempList=new Integer[length];
		sort(0,length-1);
	}
	
	private static void sort(int lo,int high)//Recursive function to sort array
	{
		if(lo<high)//if lo and high index meet then we cant sort the array
		{
			int midPoint = (lo+(high-lo)/2);
			sort(lo,midPoint);//sort the left array
			sort(midPoint+1,high);//sort the rigt array
			merge(lo,midPoint,high);//merge the two arrays
		}
	}
	
	private static void merge(int lo,int mid,int high)//merge function to merge left and right virtual arrays
	{
		for(int i=lo;i<= high;i++){
			tempList[i]=myList[i];
		}
		
		int i = lo;
		int j = mid+1;
		int k = lo;
		
		while(i <= mid && j <= high){
			if(tempList[i]<=tempList[j]){
				myList[k]=tempList[i];
				i++;
			}else{
				myList[k]=tempList[j];
				j++;
			}
			k++;
		}
		while(i<=mid){//if the left array still has values
			myList[k]=tempList[i];
			k++;
			i++;
		}
	}
}
