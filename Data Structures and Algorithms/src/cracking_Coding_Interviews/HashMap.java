package cracking_Coding_Interviews;

import java.util.ArrayList;
import java.util.Scanner;

public class HashMap<Key extends Comparable<Key>,Value> {
	
	class Node{
		Key key;
		Value val;
		Node next;
	}
	
	private int N;
	private int M;
	private ArrayList<Node> table;
	public HashMap()
	{
		this(5);
	}
	
	public HashMap(int m)
	{
		this.table = new ArrayList<Node>();
		this.N=0;	
		this.M=m;
		for(int i=0;i<M;i++)
		{
			table.add(new Node());
		}
	}
	
	public boolean isEmpty()
	{
		return size()==0;
	}
	
	public int size()
	{
		return this.N;
	}
	
	private int hash(Key k)
	{
		return (k.hashCode() & 0x7fffffff)%M;
	}
	
	public void put(Key k,Value v)
	{
		int index = hash(k);
		table.set(index,add(table.get(index),k,v));
	}
	
	private Node add(Node root,Key k,Value v)
	{
		Node newNode = new Node();
		newNode.key=k;
		newNode.val=v;
		if(root.key==null){
			root=newNode;
			this.N++;
			return root;
		}
		Node temp = root;
		while(temp!=null && temp.key.compareTo(k)!=0)
		{
			temp=temp.next;
		}
		temp=newNode;
		this.N++;
		return root;
	}
	
	public Value get(Key k)
	{
		int index = hash(k);
		return find(table.get(index),k);
	}
	
	private Value find(Node root,Key k)
	{
		if(root.key.compareTo(k)==0)
		{
			System.out.print("root is "+root.key+" val "+root.val);
			return root.val;
		}
		
		Node temp = root.next;
	
		while(temp!=null && temp.key.compareTo(k)!=0)
		{
			temp=temp.next;
		}
		System.out.print("temp is "+temp.key+" val "+temp.val);
		if(temp.key.compareTo(k)!=0)
		{
			return temp.val;
		}
		return null;
	}
	
	public void delete(Key k)
	{
		int index = hash(k);
		delete(table.get(index),k);
	}
	
	private void delete(Node root,Key k)
	{
		if(root.key.compareTo(k)==0)
		{
			root=root.next;
			this.N--;
			return;
		}
		Node prev = root;
		while(prev.next!=null && prev.next!=k)
		{
			prev=prev.next;
		}
		if(prev.next.key==k)
		{
			prev.next=prev.next.next;
			this.N--;
		}
	}
	
	public static void main(String [] args){
		HashMap<String,Integer>map = new HashMap<String,Integer>();
		Scanner in = new Scanner(System.in);
		for(int i=0;i<10;i++)
		{
			map.put("String"+i+1,i+1);
		}
		
		//check
		for(int i=0;i<3;i++)
		{
			Integer result = map.get(in.next());
			String results=(result==null)?"Not found in map":result.toString();
			System.out.println(results);
		}
		in.close();
	}
}
