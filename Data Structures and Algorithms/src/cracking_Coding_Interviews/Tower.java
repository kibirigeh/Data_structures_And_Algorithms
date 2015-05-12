package cracking_Coding_Interviews;

import java.util.Stack;
	/*
	 * Implementation of the famous Towers of Hanoi problem.
	 */
	public class Tower {
		private Stack<Integer> disks;//a stack to hold disks
		private int index;//index of this Tower in our towers list
			
		public Tower(int i) {
			// TODO Auto-generated constructor stub
			disks = new Stack<Integer>();
			index = i;
		}
			
		public int index(){
			return index;
		}
		
		public void add(int d){//add a disk to this tower
			if(!disks.isEmpty() && disks.peek()<=d){
				System.out.println("Error placing disk "+d);
			}
			else
			{
				disks.push(d);
			}
		}
			
		public void moveTopTo(Tower destination){//move a disk from top of this tower to top of destination
			int top = disks.pop();
			destination.add(top);
			System.out.println("Moved "+top+" from "+index()+" to "+destination.index());
		}
			
		public void moveDisks(int n,Tower destination, Tower buffer){//move n disks from this tower to destination using buffer as a buffer
			if(n>0){
				moveDisks(n-1,buffer,destination);//move n-1 disk from origin to buffer using destination as a buffer
				moveTopTo(destination);//move the top disk on tower to destination
				buffer.moveDisks(n-1,destination,this);//move n-1 disks to destination using origin as buffer
			}
		}
		
		public static void main(String [] args){
			int n=3;
			//array of n towers that will be used in the game
			Tower [] towers = new Tower[n];
			//init the towers
			for(int i=0;i<3;i++){
				towers[i] = new Tower(i);
			}
			for(int i=n-1;i>=0;i--){
				towers[0].add(i);
			}
			towers[0].moveDisks(n,towers[2],towers[1]);
		}
	}


