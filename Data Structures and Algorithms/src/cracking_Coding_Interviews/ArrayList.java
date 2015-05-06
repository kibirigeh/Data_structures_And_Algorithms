package cracking_Coding_Interviews;

/*
 * My implementation of an ArrayList
 * The core functions only
 * Other functions might need work
 */

public class ArrayList<Item>{
	
	private int M;//space allocated for list
	private int N;//size of list
	private int curr;//current pointer for faster operations
	private int nulls;//track count of deletions done before resizing
	private Item[] items;//array that will be resized
	
	ArrayList()//construct a list with 5 spaces allocated
	{
		this(5);
	}
	
	@SuppressWarnings("unchecked")
	ArrayList(int m)//construct list with m spaces allocated
	{
		this.M=m;
		items = (Item []) new Object[M];
	}
	
	public void add(Item v)//add item to list
	{
		if(N<=(M/2)){
			items[curr++]=v;
			N++;
			System.out.println("added "+items[curr-1]);
			return;
		}
		System.out.println("N is "+N+" going to resize");
		items=resize(M*2);
		add(v);
	}
	
	public void delete(int i)//delete item at index i
	{
		if (i>=M)return;
		Item temp = items[i];
		if(temp!=null){
			System.out.println("Deleted : "+getItemAt(i).toString());
			items[i]=null;
			nulls++;
			N--;
			if(nulls>=(M)/2)
			{
				items=resize(M/2);
			}
		}
	}
	
	public int indexOf(Item v)//get index of item v in list 
	{
		for(int i=0;i<M;i++)
		{
			if(v.equals(items[i]))
			{
				return i;
			}
		}
		return -1;
	}
	
	public boolean contains(Item v)//does item exist in list
	{
		return (indexOf(v)!=-1);
	}
	
	public Item getItemAt(int x)//get item stored at index x
	{
		if(x>=M)return null;
		return (x>=M)?(null):items[x];
	}
	
	public void print()//print all spaces and the items in them
	{
		int j=0;
		for(Item i : items)
		{
			System.out.println("Index "+(j++)+" is "+i);
		}
	}
	
	@SuppressWarnings("unchecked")
	private Item [] resize(int s)//resize the array if needed to capacity s
	{
		System.out.println("Increasing stack size from "+M+" To "+s);
		Item [] temp =(Item []) new Object[s];
		int j=0;
		for(int i=0;i<M;i++)
		{
			if(items[i]!=null) temp[j++]=items[i];
		}
		this.M=s;
		this.curr=j;
		this.nulls=0;
		return temp;
	}
	
	public int size()//get size of list
	{
		return this.N;
	}
	
	public boolean isEmpty()//is the list empty 
	{
		return (size()==0);
	}
	
	public static void main(String args[])
	{
		ArrayList<String> list = new ArrayList<String>();
		
		for(int i=1;i<11;i++)
		{
			list.add(""+(i*10));
		}
		//check
		System.out.println("\nSize of list is "+list.size());
		list.delete(1);
		System.out.println("\nSize of list is "+list.size());
		list.print();
		System.out.println("\nRetrieved : "+list.indexOf("20"));
	}
}