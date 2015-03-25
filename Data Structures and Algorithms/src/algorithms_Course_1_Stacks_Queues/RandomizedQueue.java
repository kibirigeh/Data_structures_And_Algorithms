package algorithms_Course_1_Stacks_Queues;


import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.introcs.StdRandom;


public class RandomizedQueue<Item> implements Iterable<Item> {
	/*
	 * A randomized queue is similar to a stack or queue, except that the 
	 * item removed is chosen uniformly at random from items in the data structure.
	 */

	private int size;
	private Item [] queue;
	
	@SuppressWarnings("unchecked")
	public RandomizedQueue(){ // construct an empty randomized queue
		
		queue= (Item[]) new Object[2]; //create queue using generic array 
		size=0;//not necessary
	}
	
	public boolean isEmpty(){// is the queue empty?
		return size==0;
	}
	
	public int size(){// return the number of items on the queue
		return size;
	}
	
	public void enqueue(Item item){ // add the item
		if(item == null)
		{
			throw new java.lang.NullPointerException();
		}
		//resize if half space used
		if(size==(queue.length/2)){
			resize(queue.length*2);
		}
		queue[size]=item;
		size++;
	}
	
	public Item dequeue(){ // remove and return a random item
		if(size()<=0){
			throw new java.util.NoSuchElementException();
		}
		
		Item item = null;
		int random = StdRandom.uniform(0, size);
		item=queue[random];
		
		queue[random]=queue[size-1];
		queue[size-1]=null;
		size--;
		
		//shrink if quarter of space used
		if(size>0 && size == queue.length/4){
			resize(queue.length/2);
		}
		
		return item;
	}
	
	public Item sample(){// return (but do not remove) a random item
		if(size<=0){
			throw new java.util.NoSuchElementException();
		}
		int random = StdRandom.uniform(0,size);
		return queue[random];
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int N){
		Item [] tempQueue = queue;
		queue = (Item []) new Object [N];//resize the array by making it twice what it ws earlier
		//copy the list items back
		for(int i=0;i<size;i++)
		{
			queue[i]=tempQueue[i];
		}
	}

	@Override
	public Iterator<Item> iterator() // return an independent iterator over items in random order
	{
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private int i=0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i >= 0 && i<size;
		}

		@Override
		public Item next() {
			// TODO Auto-generated method stub
			if (!hasNext()) throw new NoSuchElementException();
			return queue[i++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			 throw new UnsupportedOperationException();
		}
		
	}
	
}
