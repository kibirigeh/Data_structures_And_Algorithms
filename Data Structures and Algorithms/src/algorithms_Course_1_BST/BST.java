package algorithms_Course_1_BST;

import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

public class BST<Key extends Comparable<Key>,Value> {
	
	private class Node{
		private Key key;//key that will be used for retrieving values
		private Node left,right;//left and right nodes as children of this node
		private Value value;//value stored by this node
		private int N;//size of subtree from this node
		
		public Node(Key k,Value v,int n)
		{
			this.key=k;
			this.value=v;
			this.N=n;
		}
	}
	
	private Node root;//root node of the BST
	
	public boolean isEmpty()//is the BST empty
	{
		return root==null;
	}
	
	public int size()//return size of the BST
	{
		return size(root);
	}
	private int size(Node p)//private utility function to return size of subtree of a node
	{
		return (p==null)?(0):(p.N);
	}
	
	public boolean contains(Key k)//Does Key k exist in BST
	{
		return get(k)!=null;
	}
	
	public Value get(Key k)//Get value stored in Node with Key k
	{
		return get(root,k);
	}
	private Value get(Node n,Key k)//private utility to find and retrieve value of item with key k from a given node;
	{
		if(n==null)return null;//if Node is null return null
		int cmp = k.compareTo(n.key);//compare key k with current node key 
		if(cmp<0)return get(n.left,k);//if key k is less then search left branch of tree
		else if(cmp>0)return get(n.right,k);//if key k is greater then search right branch of tree
		else return n.value;//otherwise if the key is equal then we found our node  
	}
	
	public void put(Key k,Value v)//function to put value v in node with key k
	{
		if(v==null){delete(k);return;}//if value inserted is null then delete that key from BST
		root = put(root,k,v);//from the root find where to insert the value v
	}
	private Node put(Node n,Key k, Value v)//utility function to insert a value into BST and return the node where its inserted
	{
		if(n==null)return new Node(k,v,1);//if Node n is null return a new node;
		int cmp = k.compareTo(n.key);//compare key k with current node key 
		if(cmp<0) n.left = put(n.left,k,v);//if key k is less then search and put in left branch of tree
		else if(cmp>0) n.right = put(n.right,k,v);//if key k is greater then search and put in right branch of tree
		else{//otherwise if the key is equal then we found our node so just put in current node
			n.value=v;
			n.N=(1+size(n.left)+size(n.right));
		}
		return n;
	}
	
	public void delete(Key k)//public function to delete a node with key k from BST
	{
		root=delete(root,k);//Search and delete from the root
	}
	private Node delete(Node n,Key k)//utility function that takes a Node and searches for key k then deletes that node if found
	{
		if(n==null)return null;//Nothing to delete
		int cmp=k.compareTo(n.key);//compare key k with current node key 
		if(cmp<0)n.left=delete(n.left,k);
		else if (cmp>0)n.right=delete(n.right,k);
		else{
			if(n.right==null)return n.right;
			if(n.left==null)return n.left;
			Node temp = n;
			n=min(temp.right);
			n.right=deleteMin(temp.right);
			n.left=temp.left;
		}
		n.N=(1+size(n.left)+size(n.right));
		return n;
	}
	
	public void deleteMin()//delete the minimum key in BST
	{
		if(isEmpty())throw new NoSuchElementException("Symbol table underflow");
		root=deleteMin(root);
	}
	private Node deleteMin(Node n)///utility function to delete the minimum node from a certain node
	{
		if(n.left==null)return n.right;
		n.left=deleteMin(n.left);
		n.N=(1+size(n.left)+size(n.right));
		return n;
	}
	
	public void deleteMax()//delete the maximum key in BST
	{
		if(isEmpty())throw new NoSuchElementException("Symbol table underflow");
		root=deleteMax(root);
	}
	private Node deleteMax(Node n)//utility function to delete the maximum node from a certain node
	{
		if(n.right==null)return n.left;
		n.right=deleteMin(n.right);
		n.N=(1+size(n.left)+size(n.right));
		return n;
	}
	
	public Key min()//return the minimum key in BST
	{
		return (isEmpty())?(null):( min(root).key );
	}
	private Node min(Node n)//utility to return node with the minimum key from a certain Node
	{
		return (n.left==null)?(n):( min(n.left) );
	}
	
	public Key max()//return the maximum key in BST
	{
		return (isEmpty())?(null):( max(root).key );
	}
	private Node max(Node n)
	{
		return (n.right==null)?(n):( max(n.right) );//utility to return the maximum node from a certain node
	}
	
	public Key floor(Key k)//find the floor 
	{ 
		Node n = floor(root,k);
		return (n==null)?(null):n.key;
	}
	private Node floor(Node n,Key k)
	{
		if(n==null)return null;
		int cmp = k.compareTo(n.key);
        if (cmp == 0) return n;
        if (cmp <  0) return floor(n.left, k);
        Node t = floor(n.right, k); 
        if (t != null) return t;
        else return n; 
	}
	
	public Key ceiling(Key k)//find the ceiling
	{
		Node n = ceiling(root,k);
		return (n==null)?(null):n.key;
	}
	private Node ceiling(Node n,Key k)
	{
		if (n == null) return null;
        int cmp = k.compareTo(n.key);
        if (cmp == 0) return n;
        if (cmp < 0) { 
            Node t = ceiling(n.left, k); 
            if (t != null) return t;
            else return n; 
        } 
        return ceiling(n.right, k); 
	}
	
	public Key select(int k) 
	{
        if (k < 0 || k >= size()) return null;
        Node x = select(root, k);
        return x.key;
    }

    // Return key of rank k. 
    private Node select(Node x, int k) 
    {
        if (x == null) return null; 
        int t = size(x.left); 
        if      (t > k) return select(x.left,  k); 
        else if (t < k) return select(x.right, k-t-1); 
        else            return x; 
    } 

    public int rank(Key key) 
    {
        return rank(key, root);
    } 

    // Number of keys in the subtree less than key.
    private int rank(Key key, Node x) {
        if (x == null) return 0; 
        int cmp = key.compareTo(x.key); 
        if      (cmp < 0) return rank(key, x.left); 
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right); 
        else              return size(x.left); 
    } 

   /***********************************************************************
    *  Range count and range search.
    ***********************************************************************/
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<Key>();
        keys(root, queue, lo, hi);
        return queue;
    } 

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 

    public int size(Key lo, Key hi) {
        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }


    // height of this BST (one-node tree has height 0)
    public int height() { return height(root); }
    private int height(Node x) {
        if (x == null) return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }


    // level order traversal
    public Iterable<Key> levelOrder() {
        Queue<Key> keys = new Queue<Key>();
        Queue<Node> queue = new Queue<Node>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }

  /*************************************************************************
    *  Check integrity of BST data structure
    *************************************************************************/
    private boolean check() {
        if (!isBST())            StdOut.println("Not in symmetric order");
        if (!isSizeConsistent()) StdOut.println("Subtree counts not consistent");
        if (!isRankConsistent()) StdOut.println("Ranks not consistent");
        return isBST() && isSizeConsistent() && isRankConsistent();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    } 

    // are the size fields correct?
    private boolean isSizeConsistent() { return isSizeConsistent(root); }
    private boolean isSizeConsistent(Node x) {
        if (x == null) return true;
        if (x.N != size(x.left) + size(x.right) + 1) return false;
        return isSizeConsistent(x.left) && isSizeConsistent(x.right);
    } 

    // check that ranks are consistent
    private boolean isRankConsistent() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (Key key : keys())
            if (key.compareTo(select(rank(key))) != 0) return false;
        return true;
    }


   /*****************************************************************************
    *  Test client
    *****************************************************************************/
    public static void main(String[] args) { 
        BST<String, Integer> st = new BST<String, Integer>();
        
     	String [] set = StdIn.readLine().split(" ");//separate input by space
     	int i=0;
     	for(String key: set)
        {
             st.put(key, i++);
        }
     
        for (String s : st.levelOrder())
            StdOut.println(s + " " + st.get(s));

        StdOut.println();

        for (String s : st.keys())
            StdOut.println(s + " " + st.get(s));
    }
	

}
