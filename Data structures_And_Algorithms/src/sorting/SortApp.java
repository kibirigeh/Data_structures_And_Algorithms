package sorting;

import java.util.Scanner;


public class SortApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter list of Integers coma separeted: ");
		String liststr = sc.next();
		String []items = liststr.split(",");
		
		Integer[]list = new Integer[items.length];
		
		for(int i=0;i<list.length;i++)
		{
			list[i]=Integer.parseInt(items[i]);
		}
		
		System.out.print("Before : ");
		print(list);
		
		Shellsort.sort(list);//sorting algorithm used
		System.out.print("After : ");
		print(list);
		
		sc.close();
		
	}
	
	private static void print(Integer[] list)
	{
		System.out.print("[ ");
		if(list.length > 0){
			System.out.print(list[0]);
		}
		for(int i=1;i<list.length;i++)
		{
			System.out.print(" , "+list[i]);
		}
		System.out.println(" ]");
	}

}
