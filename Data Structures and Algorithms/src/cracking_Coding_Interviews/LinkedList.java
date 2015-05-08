package cracking_Coding_Interviews;

public class LinkedList<Item> {
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
	
	private void reversePrint(Node r)//recursively reverse print a list from Node r
	{
		if(r==null){
			return ;
		}
		reversePrint(r.next);
		System.out.println(r.item);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> list = new LinkedList<String>();
		for(int i=1;i<21;i++){
			list.add("abc"+i);
		}
		list.delete("abc5");
		list.delete("abc2");
		list.print();
		list.find("abc3");
		list.find("abc5");
		list.reversePrint();
	}
}
