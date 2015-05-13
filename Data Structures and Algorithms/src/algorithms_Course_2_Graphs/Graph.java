package algorithms_Course_2_Graphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.introcs.In;

public class Graph {
/*
 * Implementation of a graph data structure
 */
	private final int v;
	private Bag<Integer>[]  adj;
	
	@SuppressWarnings("unchecked")
	public Graph(int n){
		v=n;
		adj= (Bag<Integer>[])new Bag[v];
		for(int i=0;i<n;i++){
			adj[i]=new Bag<Integer>();
		}
	}
	
	public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }
	
	public void addEdge(int v,int w){
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v){
		return adj[v];
	}
	
	public int V(){
		return v;
	}
}
