package cracking_Coding_Interviews;

public class SortTest {

	/*
	 * Quickly test the basic sorting algorithms
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums [] = {5,2,3,1,6,8,4,7};
		mergeSort(nums);
		for(int i:nums){
			System.out.println(i);
		}
	}
	
	public static void mergeSort(int [] array)
	{
		int [] helper = new int [array.length];
		mergeSort(array,helper,0,array.length-1);//call the mergeSort algorithm
	}
	
	public static void mergeSort(int [] array,int helper[],int low,int high){
		if(low<high) {//only continue if low is less than high
			int middle = (low+high)/2;//find the middle
			mergeSort(array,helper,low,middle);//mergeSort the left side of the array
			mergeSort(array,helper,middle+1,high);//mergeSort the right Side of the array
			merge(array,helper,low,middle,high);//merge the 2 sides
		}
	}
	
	public static void merge(int [] array,int [] helper, int low,int middle,int high){
		/*
		 *Copy array into helper
		 */
		for(int i=low;i<=high;i++){
			helper[i]=array[i];
		}
		/*
		 * Create left iterator, right iterator and the current iterator
		 */
		int helperLeft = low;
		int helperRight = middle+1;
		int current = low;
		/*
		 * loop through both left and right arrays while inserting minimum value into current
		 */
		while (current <= high){
			
			if(helperLeft<=middle && helperRight <= high){
				if(helper[helperLeft]<=helper[helperRight]) 
					array[current++]=helper[helperLeft++];
				else 
					array[current++]=helper[helperRight++];
			}
			else if(helperLeft<=middle){
				array[current++]=helper[helperLeft++];
			}
			else{
				array[current++]=helper[helperRight++];
			}
		}
	}

}
