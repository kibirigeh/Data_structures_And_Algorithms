package cracking_Coding_Interviews;

import java.util.Stack;

public class MyQueue {

	/*
	 * Queue implementation using 2 Stacks
	 */
	private Stack<Integer>newest;
	private Stack<Integer>oldest;
	
	public MyQueue() {
		// TODO Auto-generated constructor stub
		newest= new Stack<Integer>();
		oldest= new Stack<Integer>();
	}
	
	public int size(){
		return oldest.size()+newest.size();
	}
	
	public int deque(){
		shiftStack();
		return oldest.pop();
	}
	
	public int peek(){
		shiftStack();
		return oldest.peek();
	}
	
	public void enque(int d){
		newest.push(d);
	}
	public void shiftStack(){
		if(newest.isEmpty())return;
		while(!newest.isEmpty()){
			oldest.push(newest.pop());
		}
	}
	
	public static void main(String args[]){
		MyQueue test = new MyQueue();
		for(int i=0;i<5;i++){
			test.enque(i);
		}
		System.out.println("Size : "+test.size());
		System.out.println("peek: "+test.peek());
		System.out.println("removed: "+test.deque());
		System.out.println("Size : "+test.size());
		System.out.println("peek: "+test.peek());
		System.out.println("removed: "+test.deque());
		System.out.println("Size : "+test.size());
	}
}
