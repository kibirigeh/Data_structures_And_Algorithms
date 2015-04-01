package algorithms_Course_1_Priority_Queues;

import edu.princeton.cs.algs4.MinPQ;

public class Board {

	private int [] board;
	private int N;
	private int blankSpace;
	
	public Board(int [][] blocks)// construct a board from an N-by-N array of blocks (where blocks[i][j] = block in row i, column j)
	{
		int N=blocks.length;
		board = new int [N*N];
		int k=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				board[k]=blocks[i][j];
				if(board[k]==0)blankSpace=k;
				k++;
			}
		}
	}
	
	public int dimension()// board dimension N
	{
		return N;
	}
	
	public int hamming()// number of blocks out of place
	{
		int needFix = 0;
		for(int i=0;i<board.length;i++){
			if(board[i]-1!=(i)&& (board[i]!=0)) needFix++;
		}
		return needFix;
	}
	
	public int manhattan()// sum of Manhattan distances between blocks and goal
	{
		int manhattan=0;
		for(int i=0;i<board.length;i++){
			if(board[i]-1!=(i)&& (board[i]!=0)) manhattan+=dst(board[i]-1,i);
		}
		return manhattan;
	}
	
	public boolean isGoal()// is this board the goal board?
	{
		return hamming()==0;
	}
	
	public Iterable<Board> neighbors()// all neighboring boards
	{
		MinPQ<Board> pq = new MinPQ<Board>();
		
		int left=blankSpace-1;
		int right=blankSpace+1;
		int up=blankSpace-N;
		int down=blankSpace+N;
	
		if( (left>=0 && left<(N*N) && (left%N)!=N-1) ){
			//left can not be in leftmost column and must be on the board
			pq.insert(new Board(get2DWithExch(board,blankSpace,left)));
		}
		if( (right>=0 && right<(N*N) && (right%N)!=0) ){
			//right can not be in rightmost column and must be on the board
			pq.insert(new Board(get2DWithExch(board,blankSpace,right)));
		}
		if( (up>=0 && up<(N*N)) ){
			//up must be on the board
			pq.insert(new Board(get2DWithExch(board,blankSpace,up)));
		}
		if( (down>=0 && down<(N*N)) ){
			//down must be on the board
			pq.insert(new Board(get2DWithExch(board,blankSpace,down)));
		}
		
		return pq; 
	}
	
	public String toString()// string representation of this board (in the output format specified below)
	{
		StringBuilder s = new StringBuilder();
	    s.append(N + "\n");
	    int k=0;
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            s.append(String.format("%2d ", board[k++]));
	        }
	        s.append("\n");
	    }
	    return s.toString();
	}
	
	public Board twin()// a board that is obtained by exchanging two adjacent blocks in the same row
	{
		int[][] newBoard = get2DWithExch(this.board,0,0);
    	boolean flag = false;
    	for(int i=0;i<N;i++){
    		for(int j=0;j<N-1;j++){
    			if(newBoard[i][j]>0 && newBoard[i][j+1]>0) {
    				int tmp = newBoard[i][j];
    				newBoard[i][j] = newBoard[i][j+1];
    				newBoard[i][j+1] = tmp;
    				flag = true;
    				break;
    			}
    		}
    		if(flag) break;
    	}
    	return new Board(newBoard);
	}
	
	public boolean equals(Object y)// does this board equal y?
	{
		if (y == this) return true;
		if (y == null) return false;
		if (y.getClass() != this.getClass()) return false;
		
		Board that = (Board) y;
		
		if(this.board != that.board) return false;
		if(this.dimension() != that.dimension()) return false;
		
		return true;
	}
	
	private int [][] get2DWithExch(int [] a, int x, int y)//utility function to convert a 1D array to 2D and exchange 2 items
	{
		int [][] a2D = new int[N][N];
		int k=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				a2D[i][j]=a[k++];
			}
		}
		//exchange 
		int temp =  a2D [((x%N)%x)] [x%N];
		a2D [((x%N)%x)] [x%N] = a2D [((y%N)%y)] [y%N];
		a2D [((y%N)%y)] [y%N]=temp;
		
		return a2D;
	}
	
	private int dst(int a,int b)//utility function to get distance between 2 points
	{
		int x1=((a%N)%a),y1=(a%N);
		int x2=((b%N)%a),y2=(b%N);
	
		int dst = (int) Math.sqrt( Math.pow((double)(x2-x1),2) + Math.pow((double)(y2-y1),2) );
		
		return Math.abs(dst)+1;
	}
}
