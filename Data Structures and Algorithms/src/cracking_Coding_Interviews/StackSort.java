package cracking_Coding_Interviews;

import java.util.Stack;

public class StackSort {

	/*
	 * Program to sort a stack in ascending order(Biggest to smallest)
	 * Only one additional stack can be used.
	 * No using any other data structures.
	 */
	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Comparable> test = new Stack<Comparable>();
		test.push(1);
		test.push(4);
		test.push(7);
		test.push(5);
		test.push(2);
		test.push(8);
		
		test=sort(test);
		while(!test.isEmpty()){
			System.out.println(test.pop());
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static Stack<Comparable> sort(Stack<Comparable> A){
		Stack<Comparable> B = new Stack<Comparable>();
		Comparable top;
		while(!A.isEmpty()){
			top=A.pop();
			while(!B.isEmpty()&&B.peek().compareTo(top)==1){
				A.push(B.pop());
			}
			B.push(top);
		}
		return B;
	}

}
