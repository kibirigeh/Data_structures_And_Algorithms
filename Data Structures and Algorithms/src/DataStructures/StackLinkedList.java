package DataStructures;

import java.util.Iterator;

public class StackLinkedList<Item> implements Iterable<Item>{
	
	private Node first;//variable to hold top of stack node
	
	private class Node{//Node structure
		Item item;
		Node next;
	}
	
	public boolean isEmpty()//if list/Stack is empty
	{
		return first==null;
	}
	
	public void push(Item item)//push item to the top of the stack
	{
		Node oldFirst = first;//store the current first node
		first=new Node();//create a new node at the top
		first.item=item;//populate node
		first.next=oldFirst;//point the new node to the old top if any
	}
	
	public Item pop()//pop item for top of the stack
	{
		Item temp = first.item;//store item popped 
		first=first.next;//point top of the stack to the next node if any
		return temp;//return item for confirmation
	}
	
	public void print()//prints a linked list if its not empty
	{
		if(isEmpty()){//if empty don't bother
			return;
		}
		
		Node temp=first;//temporary handle to first node in list
		System.out.print("\n[ "+temp.item);//print first node
		temp=temp.next;//move to next node
		
		while(temp!=null){//print all nodes until the last node is done
			System.out.print(" , "+temp.item);
			temp=temp.next;//increment through nodes
		}
		
		System.out.print(" ]");
	}
	
	/*
	 * Methods below are Implementing the Iterable Interface
	 */
	@Override
	public Iterator<Item> iterator()//public method that returns a class that implements the Iterator interface
	{
		return new ListIterator();
	}
	
	//private class ListIterator that implements the Iterator interface
	private class ListIterator implements Iterator<Item>{
		
		private Node current = first ;
		
		@Override
		public boolean hasNext()//method to check if their is any more nodes to traverse
		{
			return current!=null;
		}
		
		@Override
		public Item next()//method that increments the iterator 
		{
			Item item = current.item;
			current=current.next;
			return item;
		}
		
		@Override
		public void remove(){
			/*
			 * We wont be implementing this method until necessary
			 */
		}
	}
}
