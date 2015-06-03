package cracking_Coding_Interviews;

import java.util.Iterator;

public class CircularArray<T>implements Iterable {
/*
 * Implementation of a Circular Array
 * Works by keeping track of the head index
 * (This is pretty much a stack)
 * rotate n can be push(pop()) n times on a stack
 * 
 */
	T [] items;
	int head=0;
	
	CircularArray(int s){
		items = (T[]) new Object[s];
	}
	
	private int convert(int idx){
		if(idx<0)idx+=items.length;
		return (head+idx)%items.length;
	}
	
	public void rotate(int rightShift){
		head = convert(rightShift);
	}
	
	public T get(int i){
		check(i);
		return items[convert(i)];
	}
	
	private void check(int i){
		if(i<0 || i>=items.length)throw new java.lang.IndexOutOfBoundsException(i+" is out of bound for this array with size "+items.length);
	}
	
	public void set(int i,T item){
		check(i);
		items[convert(i)]=item;
	}
	
	@Override
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return new CircularArrayIterator<T>(this);
	}
	
	private class CircularArrayIterator<T> implements Iterator<T>{
		T[] myArray;
		int current = -1;
		
		CircularArrayIterator(CircularArray<T> x){
			myArray = x.items;
		}
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return current<myArray.length-1;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			current++;
			return myArray[convert(current)];
		}
		
	}
	/*
	 * Test program
	 */
	public static void main(String [] args){
		CircularArray<Integer> circle = new CircularArray<Integer>(8);
		
		for(int i=0;i<8;i++){
			circle.set(i,i);
		}
		circle.rotate(4);
		for(Object i : circle){
			System.out.println((Integer)i);
		}
	}
	
}
