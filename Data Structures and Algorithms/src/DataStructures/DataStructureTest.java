package DataStructures;

import java.util.Scanner;

public class DataStructureTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter list of numbers separated by a coma ");
		
		String list = sc.next();
		String [] nums = list.split(",");
		

		/*
		 * Testing Queue and Stack here
		 */
		
		QueueLinkedList<String> queue = new QueueLinkedList<String>();
		StackLinkedList<String> stack = new StackLinkedList<String>();
		
		for(String num:nums)
		{
			queue.enque(num);
			stack.push(num);
		}
		
		queue.deque();
		stack.pop();
		
		queue.print();
		stack.print();
		
		System.out.println("\nTesting Iterable interface");
		for(String i:queue)//implementing Iterable interface made this for statement possible
		{
			System.out.println("Iterating over a node with item "+i);
		}
		
		
		/*
		 * Queue and Stack test ends here
		 */
		
		/**
		 * Testing Deque Assignment
		 */
		
		/*
		Deque<String> deque = new Deque<String>();
		
		for(String num:nums)
		{
			deque.addFirst(num);
		}
		
		deque.print();
		deque.reversePrint();
		
		System.out.println("\nTesting Iterable interface");
		
		for(String i:deque)//implementing Iterable interface made this for statement possible
		{
			System.out.println("Iterating over a node with item "+i);
		}
		
		*/
		/*
		 * Deque assignment test ends here
		 */
		
	}

}