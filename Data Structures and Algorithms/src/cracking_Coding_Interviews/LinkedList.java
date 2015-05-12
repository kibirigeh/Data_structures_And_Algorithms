package cracking_Coding_Interviews;

import java.util.Random;

public class LinkedList<Item extends Comparable<Item>> {
	/*
	 * My version of a generic linked list
	 * Only core functions implemented
	 */
	class Node
	{
		Item item;
		Node next;
	}
	
	private Node root;
	private int size;
	private int kth;
	
	public LinkedList() {
		size=0;
	}

	public void add(Item x)//add items to the list
	{
		root=add(root,x);
	}
	
	private Node add(Node r,Item x)//add items to a list traversing from root r
	{
		if(r==null){
			Node temp = new Node();
			temp.item=x;
			r=temp;
			size++;
		}
		else
		{
			r.next=add(r.next,x);
		}
		return r;
	}
	
	public void find(Item x)//find item x in a list
	{
		Node temp = find(root,x);
		if(temp!=null){
			System.out.println(temp.item+" was found");
			return ;
		}
		System.out.println(x+" was not found");
	}
	
	private Node find(Node r,Item x)//return a node with item x traversing from node r
	{
		if(r==null)return null;
		Node temp=r;
		while(temp!=null)
		{
			if(temp.item.equals(x)) return temp;
			temp=temp.next;
		}
		return null;
	}
	
	public void delete(Item x)//delete a node with item x from the list
	{
		if(root.item.equals(x)){
			root=root.next;
			size--;
			System.out.println("Deleted: "+x);
			return;
		}
		Node prev=root;
		while(prev.next!=null){
			if(prev.next.item.equals(x)){
				prev.next=prev.next.next;
				size--;
				System.out.println("Deleted: "+x);
				return;
			}
			prev=prev.next;
		}
	}
	
	public int size()//get the size of the list
	{
		return size;
	}
	
	public void print()//print the list from the root node
	{
		System.out.println("Size is "+size());
		if(size<1)return;
		Node temp = root;
		while(temp!=null){
			System.out.println(temp.item);
			temp=temp.next;
		}
	}
	
	public void reversePrint()//reverse print the list
	{
		reversePrint(root);
		
	}
	
	public void testPartition(Item p){
		System.out.println("partitioning based on "+p);
		reversePrint(partition(root,p));
	}
	
	private void reversePrint(Node r)//recursively reverse print a list from Node r
	{
		if(r==null){
			return ;
		}
		reversePrint(r.next);
		System.out.println(r.item);
	}
	
	public Node findKthToLast(Node n,int k)//utility to find kth element in list
	{
		if(n.next==null){
			kth++;
			if(kth==k)return n;
			return null;
		}
		Node temp = findKthToLast(n.next,k);
		if(kth==k){	
			kth++;
			return n;
		}
		kth++;
		return temp;
	}
	
	public void findKthToLast(int k)//find kth item in list
	{
		kth=1;
		Node temp = findKthToLast(root,k);
		if(temp!=null){
			System.out.println("Item "+k+" is "+temp.item);
		}
		else{
			System.out.println("No "+k+"th item in list");
		}
		kth=0;
	}
	
	private int printNthToLast(Node n,int k)//utility to print kth item in list
	{
		if(n==null)return 0;
		int i=printNthToLast(n.next,k)+1;
		if(i==k)System.out.println("Item "+k+" is "+n.item);
		return i;
	}
	
	public void printNthToLast(int k)//print kth item in list
	{
		printNthToLast(root,k);
	}

	public Node partition(Node n,Item x)//Method to partition singly linked list based on item x
	{
		if(n==null)return null;
		Node Head=null,less=null,great=null,Body=null,t=n;
		while(t!=null){
			System.out.println("looking at "+t.item);
			int cmp = t.item.compareTo(x);
			Node temp = new Node();
			temp.item=t.item;
			if(cmp<0){
				System.out.println("Adding "+temp.item+" to less than list");
				if(Head==null){
					Head=temp;
					less=Head;
					System.out.println("Adding "+Head.item+" to Head of Lees than list");
				}
				else{
					less.next=temp;
					System.out.println("Adding "+less.item+" to body of Lees than list");
					less=temp;
					
				}
			}
			else{
				System.out.println("Adding "+temp.item+" to Greater than list");
				if(Body==null){
					Body=temp;
					great=Body;
					System.out.println("Adding "+Body.item+" to Head of greater than list");
				}
				else
				{
					great.next=temp;
					System.out.println("Adding "+great.item+" to body of greater than list");
					great=temp;
				}
			}
			t=t.next;
		}
		less.next=Body;
		return Head;
	}
	
	public int Sum(Node n,int exp){
		if(n==null)return 0;
		return (int) (((Integer) n.item) * Math.pow(10,(double) exp))+(Sum(n.next, exp++));
	}
	
	@SuppressWarnings("unchecked")
	public Node addNodes(Node A,Node B){
		Node sum=null,sumIt=null;
		int a = Sum(A,0)+Sum(B,0);
		String aS=String.valueOf(a);
		for(int i=(aS.length()-1);i>=0;i--){
			Node t = new Node();
			t.item=(Item) ((Object)aS.charAt(i));
			System.out.print(t.item);
			if(sum==null){
				sum=t;
				sum.next=sumIt;
			}
			else{
				sumIt=t;
				sumIt=sumIt.next;
			}
		}
		return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list = new LinkedList<Integer>();
		 Random rand = new Random();
		for(int i=1;i<21;i++){
			int rNum =(int) rand.nextInt((20 - 1) + 1) + 1;
			list.add(rNum);
		}
		list.print();
		list.delete(10);
		list.delete(3);
		list.print();
		list.find(9);
		list.find(5);
		list.reversePrint();
		list.printNthToLast(2);
		//list.testPartition(6);
	}

}
