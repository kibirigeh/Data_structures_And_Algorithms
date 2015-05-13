package algorithms_Course_2_Graphs;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

public class BFSPaths {
	/*
	 * class to perform BFS on a Graph from source Vertex s
	 */
	private boolean [] marked;
	private int[] edgeTo;
	private int [] dstTo;
	private int s;
	
	public BFSPaths(Graph G,int v) {
		// TODO Auto-generated constructor stub
		marked = new boolean[G.V()];
		edgeTo = new int[G.V()];
		dstTo = new int[G.V()];
		s=v;
		BFS(G,s);
	}
	
	private void BFS(Graph G,int v){//Breadth First Algorithm
		Queue<Integer> q = new Queue<Integer>();//queue to prioritize vertices
		q.enqueue(v);//add the source node to q;
		marked[v]=true;//mark the source node as visited
		while(!q.isEmpty()){//while the q is not empty
			int x=q.dequeue();//Dequeue the first vertex
			for(int w:G.adj(x)){//for all the vertices adjacent to the dequeued vertex
				if(!marked[w]){//check if they have been visited or not
					q.enqueue(w);//if not add them to the queue
					marked[w]=true;//mark them as visited
					edgeTo[w]=x;//add the vertex we came from to the edgeTo array
					dstTo[w] = dstTo[v] + 1;
				}
			}
		}
	}
	
	public int distTo(int v){
		return dstTo[v];
	}
	public boolean hasPathTo(int v){//does a path exist between s and v
		return marked[v];
	}
	
	 public Iterable<Integer> pathTo(int v) {
	        if (!hasPathTo(v)) return null;
	        Stack<Integer> path = new Stack<Integer>();
	        int x;
	        for (x = v; dstTo[x] != 0; x = edgeTo[x])
	            path.push(x);
	        path.push(x);
	        return path;
	}
	 
	 /**
	     * Unit tests the <tt>BreadthFirstPaths</tt> data type.
	     */
	    public static void main(String[] args) {
	        In in = new In(args[0]);
	        Graph G = new Graph(in);
	        // StdOut.println(G);

	        int s = Integer.parseInt(args[1]);
	        BFSPaths bfs = new BFSPaths(G, s);

	        for (int v = 0; v < G.V(); v++) {
	            if (bfs.hasPathTo(v)) {
	                StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
	                for (int x : bfs.pathTo(v)) {
	                    if (x == s) StdOut.print(x);
	                    else        StdOut.print("-" + x);
	                }
	                StdOut.println();
	            }

	            else {
	                StdOut.printf("%d to %d (-):  not connected\n", s, v);
	            }

	        }
	    }
}
