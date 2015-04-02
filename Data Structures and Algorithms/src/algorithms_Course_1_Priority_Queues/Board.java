package algorithms_Course_1_Priority_Queues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

	private int [] board;
	private int N;
	private int blankSpace;
	private int manhattanDst;//cache the manhattan to beat the time
	private int hammingCount;
	
	public Board(int [][] blocks)// construct a board from an N-by-N array of blocks (where blocks[i][j] = block in row i, column j)
	{
		this.N=blocks.length;//set the dimensions
		board = new int [N*N];//using a 1D array for less memory usage
		int k=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				board[k]=blocks[i][j];
				if(board[k]==0)blankSpace=k;
				k++;
			}
		}
		
		this.manhattanDst=this.getManhattan();//cache the manhattan
		this.hammingCount=this.gethamming();//cache the hamming
	}
	
	public int dimension()// board dimension N
	{
		return N;
	}
	public int hamming()// number of blocks out of place
	{
		return hammingCount;
	}
	private int gethamming()//utility to find the hamming count
	{
		int needFix = 0;
		for(int i=0;i<board.length;i++){
			if(board[i]-1!=(i)&& (board[i]!=0)) needFix++;
		}
		return needFix;
	}
	
	public int manhattan()// sum of Manhattan distances between blocks and goal
	{
		return manhattanDst;
	}
	
	private int getManhattan()//private utility to set the manhattan dst
	{
		int manhattan=0;
		for(int i=0;i<board.length;i++){
			if(board[i]-1!=(i)&& (board[i]!=0)) manhattan+=dst(board[i],i+1);
		}
		return manhattan;
	}
	
	public boolean isGoal()// is this board the goal board?
	{
		return hamming()==0;
	}
	
	public Iterable<Board> neighbors()// all neighboring boards
	{
		List<Board> boards = new ArrayList<Board>();
		
		int left=blankSpace-1;
		int right=blankSpace+1;
		int up=blankSpace-N;
		int down=blankSpace+N;
	
		if( (left>=0 && left<(N*N) && (left%N)!=N-1) ){
			//left can not be in leftmost column and must be on the board
			boards.add(new Board(get2DWithExch(board,blankSpace,left)));
		}
		if( (right>=0 && right<(N*N) && (right%N)!=0) ){
			//right can not be in rightmost column and must be on the board
			boards.add(new Board(get2DWithExch(board,blankSpace,right)));
		}
		if( (up>=0 && up<(N*N)) ){
			//up must be on the board
			boards.add(new Board(get2DWithExch(board,blankSpace,up)));
		}
		if( (down>=0 && down<(N*N)) ){
			//down must be on the board
			boards.add(new Board(get2DWithExch(board,blankSpace,down)));
		}
		
		return boards; 
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
		if (!(y instanceof Board)) return false;
		if (!Arrays.equals(this.board, ((Board)y).board))return false;
		return true;
	}
	
	private int [][] get2DWithExch(int [] a, int x, int y)//utility function to convert a 1D array to 2D and exchange 2 items
	{
		int [][] a2D = new int[N][N];
		int k=0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				a2D[i][j]=a[k];//copy into new 2D array
				if(k==x)a2D[i][j]=a[y];//exchange x with y
				if(k==y)a2D[i][j]=a[x];//exchange y with x
				k++;
			}
		}	
		
		return a2D;
	}
	
	private int dst(int a,int b)//utility function to get manhattan distance between 2 points in 2d
	{
		
		int x1=getRow(a),y1=getCol(a),x2=getRow(b),y2=getCol(b);	
		return Math.abs(x2-x1) + Math.abs(y2-y1);
	}
	
	private int getRow(int a)//given a 1D index returns the row in 2D eg. (a,0)
	{
		return (a==0)?(0):(a-1)/N;
	}
	
	private int getCol(int a)//given a 1D index returns the col in 2D eg. (0,a)
	{
		
		return (a==0)?(0):(a-1)%N;
	}
	
/*	
	public static void main(String[] args) // unit tests (not graded)
	{
		// create initial board from file
	    In in = new In(args[0]);
	    int N = in.readInt();
	    int[][] blocks = new int[N][N];
	    for (int i = 0; i < N; i++)
	        for (int j = 0; j < N; j++)
	            blocks[i][j] = in.readInt();
	    Board initial = new Board(blocks);
	    
	    for(Board b: initial.neighbors())
	    {
	    	 System.out.println(b.toString());
	    	 System.out.println(b.manhattan());
	    }
	}
	*/
}
