package algorithms_Course_1;


import java.util.Iterator;
import java.util.NoSuchElementException;


public class RandomizedQueue<Item> implements Iterable<Item> {

	private int size;
	private Item [] queue;
	
	public RandomizedQueue(){
		
		queue= (Item[]) new Object[2]; //create queue using generic array 
		size=0;//not necessary
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int size(){
		return size;
	}
	
	public void enqueue(Item item){
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
	
	public Item dequeue(){
		if(size()<=0){
			throw new java.util.NoSuchElementException();
		}
		
		Item item = null;
		int random = StdRandom.uniform(0, size-1);
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
	
	public Item sample(){
		int random = StdRandom.uniform(0, size-1);
		return queue[random];
	}
	
	private void resize(int N){
		Item [] tempQueue = queue;
		queue = (Item []) new Object [N];//resize the array by making it twice what it ws earlier
		//copy the list items back
		for(int i=0;i<tempQueue.length;i++)
		{
			queue[i]=tempQueue[i];
		}
	}

	@Override
	public Iterator<Item> iterator() 
	{
		// TODO Auto-generated method stub
		return new ListIterator();
	}
	
	private class ListIterator implements Iterator<Item>{
		private int i=0;
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i >= 0;
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
