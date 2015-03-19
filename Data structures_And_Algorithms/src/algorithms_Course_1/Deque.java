package algorithms_Course_1;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> 
{
	/*
	 * A double-ended queue or deque (pronounced "deck") is a generalization of a stack 
	 * and a queue that supports adding and removing items from either the front or the 
	 * back of the data structure
	 */
	
	public class Node{
		Item item;
		Node next;
		Node pre;
	}
	
	Node first;//front of deque
	Node last;//back of deque
	int size;//size of deque
	
	public Deque(){//create deque
		size=0;
	}
	
	public int size(){//get size of deque
		return size;
	}
	
	public void addFirst(Item item){//insert item to front of deque
		
		if(item == null)
		{
			throw new java.lang.NullPointerException();
		}
		
		Node oldFirst = first;
		first=new Node();
		first.item=item;
		
		if(isEmpty()){
			last=first;
			size++;
			return;
		}
		
		oldFirst.pre=first;
		first.next=oldFirst;
		size++;
	}
	
	public void addLast(Item item){//insert item to back of deque
		
		if(item==null)
		{
			throw new java.lang.NullPointerException();
		}
		
		
		Node oldLast = last;
		last=new Node();
		last.item=item;
		
		
		if(isEmpty()){
			first=last;
			size++;
			return;
		}
		
		last.pre=oldLast;
		oldLast.next=last;
		
		size++;
	}
	
	public Item removeLast(){//remove item from back of deque
		
		if(size()<=0){
			throw new java.util.NoSuchElementException();
		}
		
		Item item = last.item;
		
		if(size()>=2){
			last.pre.next=null;
			last=last.pre;
		}
		else
		{
			last=null;
			first=last;
		}
		
		size--;
		return item;
	}
	
	public Item removeFirst(){//remove item from front of deque
		
		if(size()<=0){
			throw new java.util.NoSuchElementException();
		}
		
		Item item = first.item;
		
		if(size()>=2){
			first.next.pre=null;
			first=first.next;
		}
		else
		{
			first=null;
			last=first;
		}
		
		size--;
		return item;
	}
	
	public boolean isEmpty(){//is deque empty?
		return size()==0;
	}
	
	public void print()//prints a list if its not empty
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
	
	public void reversePrint()//prints a deque if its not empty from back to front
	{
		if(isEmpty()){//if empty don't bother
			return;
		}
		
		Node temp=last;//temporary handle to first node in list
		System.out.print("\n[ "+temp.item);//print first node
		temp=temp.pre;//move to next node
		
		while(temp!=null){//print all nodes until the last node is done
			System.out.print(" , "+temp.item);
			temp=temp.pre;//increment through nodes
		}
		
		System.out.print(" ]");
	}
	
	@Override
	public Iterator<Item> iterator() {//iterator for iteration when required
		// TODO Auto-generated method stub
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item>{//class to implement iteration
		
		private Node current = first;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current != null;
		}

		public Item next() {
			// TODO Auto-generated method stub
			Item item = current.item;
			current=current.next;
			return item;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			throw new java.lang.UnsupportedOperationException();
		}
		
	}	
}
