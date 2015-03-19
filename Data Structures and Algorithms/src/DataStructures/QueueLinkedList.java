package DataStructures;

import java.util.Iterator;

public class QueueLinkedList<Item> implements Iterable<Item>{//Using JAVA Generic's to make data structure
	
	private Node first,last;//Nodes to hold top and bottom of the list for faster transactions
	
	private class Node{	//Node structure
		Item item;
		Node next;
	}
	
	public boolean isEmpty()//return true if list is empty
	{
		return first==null;//if the first node is empty then list is empty
	}
	
	public void enque(Item item)//adds an Item to the queue
	{
		Node oldLast = last;//store the current last variable in a new node;
		last=new Node();//set last to a new Node
		last.item=item;//populate the new last node
		last.next=null;
	
		if(isEmpty())//if list is empty we only have one node so last and first are equal
		{
			first=last;
		}
		else
		{
			oldLast.next=last;//point the previous last to current last
		}
	}
	
	public Item deque()//removes an Item from the queue
	{
		Item temp = first.item;//store item at top of list in a temporary variable
		first=first.next;//set the first to whatever node came after it
		if(isEmpty())//if the list is empty then set last to empty as well
		{
			last=null;
		}
		return temp;//return the temporary item for confirmation
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
	 * methods and classes from implementing the Iterable interface
	 * 
	 */
	@Override
	public Iterator<Item> iterator() //public method that returns a class that implements the Iterator interface
	{
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>//private class ListIterator that implements the Iterator interface
	{
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}
		
		@Override
		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current=current.next;
			return item;
		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			//We don't implement this.Not yet anyway
		}
		
	}
}
