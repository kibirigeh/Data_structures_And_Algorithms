package topCoder;

import java.util.Stack;

public class ZigZag{
	public int longestZigZag(int [] seq){
		if(seq.length<=2)return seq.length;
		Stack<Integer>Up = new Stack<Integer>();
		Stack<Integer>Down = new Stack<Integer>();
		Up.push(1);
		Down.push(1);
		for(int i=1;i<seq.length;i++){
			if(seq[i-1]<seq[i]) 
				Up.push(Down.peek()+1);
			else if(seq[i-1]>seq[i])
				Down.push(Up.peek()+1);	
		}
		return Math.max(Up.peek(),Down.peek());
	}
}