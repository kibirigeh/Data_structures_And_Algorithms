package cracking_Coding_Interviews;

public class SortTest {

	/*
	 * Quickly test the basic sorting algorithms
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int nums [] = {5,2,3,1,6,8,4,7};
		int numsA [] = {1,4,8,0,0,0,0},numsB [] = {2,3,5,6};
		quickSort(nums);
		for(int i:nums){
			System.out.println(i);
		}
		binarySearch(nums,2);
		for(int i: merge2SArrays(numsA,numsB)){
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
	
	/*
	 * Swap elements a and b in an array
	 */
	public static void swap(int [] array,int a,int b){
		int temp = array[a];
		array[a]=array[b];
		array[b]=temp;
	}
	
	/*
	 * Call quickSort on an array
	 */
	public static void quickSort(int array []){
		quickSort(array,0,array.length-1);
	}
	
	/*
	 * implement the quickSort algorithm 
	 */
	public static void quickSort(int array[],int left,int right){
		int index = partition(array,left,right); //partition the array
		if(left<index-1){//sort the left side
			quickSort(array,left,index-1);
		}
		if(index<right){//sort the right side
			quickSort(array,index,right);
		}
	}
	
	/*
	 * Partition an array for quickSorting
	 */
	public static int partition(int array[],int left,int right){
		int pivot = array[(left+right)/2];//get the middle element as the pivot(For efficiency shuffle the array)
		while(left<=right){
			while(array[left]<pivot)left++;//find out of place from left
			while(array[right]>pivot)right--;//find out of place from right
			if(left<=right){
				swap(array,left,right);//swap the two
				left++;
				right--;
			}
		}
		return left;
	}
	
	public static void binarySearch(int [] array,int x){
		System.out.println("Binary Search for "+x+" is : "+binarySearch(array,x,0,array.length-1));
	}
	
	/*
	 * Binary search algorithm
	 */
	public static int binarySearch(int [] array,int x,int left,int right){
		if(left>right)return -1;//if the left side has crossed the right then item is not found
		
		int mid = (left+right)/2;//get the mid point
		
		if(x < array[mid])//if item is less than mid point then item is on left
			return binarySearch(array,x,left,mid-1);
		else if(x > array[mid])//if item is greater than mid point then item is on right
			return binarySearch(array,x,mid+1,right);
		else//otherwise its the middle element since its equal to the item at the mid point
			return array[mid];
	}
	
	/*
	 * Method to merge 2 sorted arrays (11.1)
	 * Merge B into A
	 * A has space at the end for B
	 */
	public static int[] merge2SArrays(int [] A,int []B){
		int [] C = new int[A.length];//helper array C
		int helperLeft = 0,helperRight = 0,Asize = (A.length-B.length),Bsize = (B.length),current=0;//helper iterators
		while(current<C.length){//loop over all available spots to fill
			if(helperLeft<Asize && helperRight<Bsize){//get if both A and B still have elements
				if(A[helperLeft]<B[helperRight]) C[current++] = A[helperLeft++];//take from left
				else C[current++] = B[helperRight++];//take from right
			}
			else if(helperRight<Bsize) C[current++] = B[helperRight++];//only right has elements
			else C[current++] = A[helperLeft++];//only left has elements
		}
		return C;
	}

}
