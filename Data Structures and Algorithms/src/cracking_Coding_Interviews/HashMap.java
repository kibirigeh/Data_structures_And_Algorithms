package cracking_Coding_Interviews;

import java.util.Scanner;

import algorithms_Course_1_BST.BST;

/*
 * My implementation of a Hash map utilizing BST's in a 
 * separate chaining implementation 
 * 
 * Can remove worst case complexity by using redBlack BST instead of BST chains.
 */

public class HashMap<Key extends Comparable<Key>,Value> {	
	private int N;//Size of HashMap
	private int M;//Number of chains
	private BST<Key,Value> [] table;//Array of BST's
	
	public HashMap()//construct a HashMap with 5 chains
	{
		this(5);
	}
	
	@SuppressWarnings("unchecked")//construct a HashMap with m chains
	public HashMap(int m)
	{
		this.N=0;	
		this.M=m;
		this.table = (BST<Key,Value> []) new BST[M];//declare chains
		for(int i=0;i<M;i++) table[i] = new BST<Key,Value>();//init chains
	}
	
	public boolean isEmpty()//is HashMap empty
	{
		return size()==0;
	}
	
	public int size()//get size of HashMap O(n) where n is the number of chains
	{
		for(BST<Key, Value> bst: table)
		{
			this.N+=bst.size();
		}
		return this.N;
	}
	
	private int hash(Key k)//hash function to get index for lookup O(1)
	{
		return (k.hashCode() & 0x7fffffff)%M;
	}
	
	public void put(Key k,Value v)//insert/Update <key,Value> into HashMap O(log n) from BST insert worst case O(n) if tree is totally unbalanced
	{
		int index = hash(k);
		table[index].put(k, v);
	}
	
	public Value get(Key k)//get value of key k from HashMap. O(log n) from BST search worst case O(n) if tree is totally unbalanced
	{
		int index = hash(k);
		return table[index].get(k);
	}
	
	public boolean contains(Key k)//true/False if key k exists. O(log n) from BST search worst case O(n) if tree is totally unbalanced
	{
		return get(k)!=null;
	}
	
	public void delete(Key k)//delete a key k from HashMap. O(log n) from BST delete worst case O(n) if tree is totally unbalanced
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
