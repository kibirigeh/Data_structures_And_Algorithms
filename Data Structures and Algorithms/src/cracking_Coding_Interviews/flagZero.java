package cracking_Coding_Interviews;

public class flagZero {

	/*
	 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
	 */
	public static void main(String[] args) {
		int [][] a = {{0,2,3},{4,5,6},{7,8,9},{10,11,12}};
		a=transform(a);
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
			{
				System.out.print(" "+a[i][j]);
			}
			System.out.println("");
		}
		
	}
	/*
	 * method that does 2 sweeps over the entire matrix
	 * Sweep 1 will flag the cols and rows that need to be transformed
	 * Sweep 2 will do the transformation based on the flagged rows and cols
	 * O(2(MN)) really O(N) because we can split the sweeps into separate functions then rate each differently
	 */
	public static int [][] transform(int[][] a){
		int cols=a[0].length;
		int rows=a.length;
		boolean [] cflagged = new boolean[cols];
		boolean [] rflagged = new boolean[rows];
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(a[i][j]==0){
					cflagged[j]=true;
					rflagged[i]=true;
				}
			}
		}
		
		for(int i=0;i<rows;i++)
		{
			for(int j=0;j<cols;j++)
			{
				if(cflagged[j] || rflagged[i]) a[i][j]=0;
			}
		}
		return a;
	}
}
