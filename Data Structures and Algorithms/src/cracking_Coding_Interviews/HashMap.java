package cracking_Coding_Interviews;

import java.util.Scanner;

import edu.princeton.cs.introcs.StdOut;
import algorithms_Course_1_BST.BST;


public class HashMap<Key extends Comparable<Key>,Value> {	
	private int N;
	private int M;
	private BST<Key,Value> [] table;//Array of BST's
	
	public HashMap()
	{
		this(5);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap(int m)
	{
		this.N=0;	
		this.M=m;
		this.table = (BST<Key,Value> []) new BST[M];
		for(int i=0;i<M;i++) table[i] = new BST<Key,Value>();
	}
	
	public boolean isEmpty()
	{
		return size()==0;
	}
	
	public int size()
	{
		for(BST<Key, Value> bst: table)
		{
			System.out.println("Bst size "+bst.size());
			for (Key s : bst.keys()) StdOut.println(s + " " + bst.get(s));
			this.N+=bst.size();
		}
		return this.N;
	}
	
	private int hash(Key k)
	{
		return (k.hashCode() & 0x7fffffff)%M;
	}
	
	public void put(Key k,Value v)
	{
		int index = hash(k);
		table[index].put(k, v);
	}
	
	public Value get(Key k)
	{
		int index = hash(k);
		return table[index].get(k);
	}
	
	public boolean contains(Key k)
	{
		return get(k)!=null;
	}
	
	public void delete(Key k)
	{
		int index = hash(k);
		table[index].delete(k);
	}
	
	public static void main(String [] args){
		HashMap<String,Integer>map = new HashMap<String,Integer>();
		Scanner in = new Scanner(System.in);
		for(int i=1;i<11;i++)
		{
			map.put(""+i,(i)*10);
		}
		
		//check
		//System.out.println("Size of HashMap : "+map.size());
		
		for(int i=0;i<3;i++)
		{
			Integer result = map.get(in.next());
			String results=(result==null)?"Not found in map":result.toString();
			System.out.println(results);
			map.delete(in.next());
		}
		
		
		in.close();
	}
}
