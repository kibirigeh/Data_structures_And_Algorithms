package algorithms_Course_2_Graphs;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class DFSPaths {
	/*
	 * Class that performs DFS on a Graph given a source vertex 
	 */
	private boolean [] marked;
	private int [] edgeTo;
	private int s;
	
	public DFSPaths(Graph G,int v) {
		// TODO Auto-generated constructor stub
		s=v;
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		dfs(G,s);
	}
	
	private void dfs(Graph G,int v){//Depth first algorithm
		marked[v]=true;//mark v as visited
		for(int vertex: G.adj(v)){//run DFS on all adjacent vertices of v
			if(!marked[vertex]){//only run the DFS if vertex has not been visited
				edgeTo[vertex]=v;//To get to "vertex", you come from "v"
				dfs(G,vertex);	
			}
		}
	}
	
	public boolean hasPathTo(int v){//does a path exist between s and v
		return marked[v];
	}
	
	public Iterable<Integer> pathTo(int v){//get the path between s and v
		if(!hasPathTo(v)) return null;//return null if no path exists
		Stack<Integer> path = new Stack<Integer>();//create a Stack if the path exists since DFS builds edges in reverse order 
		for(int x=v;x!=s;x=edgeTo[x]){//back trace all the edges found in the path of s to v. since we don't store any value for s in array make sure to add s last
			path.push(x);//push the vertex found to Stack
		}
		path.push(s);//add the start point s
		return path;//return the path
	}
	
	/**
     * Unit tests the <tt>DepthFirstPaths</tt> data type.
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        int s = Integer.parseInt(args[1]);
        DFSPaths dfs = new DFSPaths(G, s);

        for (int v = 0; v < G.V(); v++) {
            if (dfs.hasPathTo(v)) {
                StdOut.printf("%d to %d:  ", s, v);
                for (int x : dfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d:  not connected\n", s, v);
            }

        }
    }

}