package topCoder;

import java.util.Stack;



public class DP{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getMinSteps(5));
		int seq[]={1,2,4,5,3,6};
		System.out.println("Longest LIS length is "+LISLength(seq));
		LIS(seq);
		LCS("abcdaf","acbcf");
	}
	
	public static int getMinSteps(int n){
		int dp[] = new int[n+1];
		for(int i = 2;i<=n;i++){
			dp[i]=1+dp[i-1];
			if(i%2==0)dp[i]=Math.min(dp[i], 1+dp[i/2]);
			if(i%3==0)dp[i]=Math.min(dp[i],1+dp[i/3]);
		}
		return dp[n];
	}
	
	public static int LISLength(int [] seq){
		int dp[] = new int[seq.length];
		dp[0]=1;
		for(int i=1;i<seq.length;i++){
			if(seq[i]>seq[i-1])dp[i]=dp[i-1]+1;
			else dp[i]=dp[i-1];
			//System.out.println("dp "+i+" is "+dp[i]);
		}
		return dp[seq.length-1];
	}
	
	@SuppressWarnings("unchecked")
	public static void LIS(int [] seq){
		Stack<Integer> LS [] = (Stack<Integer> []) new Stack[seq.length];
		
		LS[0]=new Stack<Integer>();
		LS[0].push(seq[0]);
		int max = LS[0].size();
		
		for(int i=1;i<seq.length;i++){
			LS[i]=new Stack<Integer>();
			
			for(int j=0;j<i;j++){
				if(seq[j]<seq[i] && LS[i].size()<LS[j].size()+1){
					if(LS[j].peek()<seq[i]){
						LS[i]=LS[j];
						max=i;
					}
				}
			}
			LS[i].push(seq[i]);
		}

		System.out.println(LS[max]);
	}
	
	public static void LCS(String X,String Y){
		int [][] XY = new int[X.length()+1][Y.length()+1];
		for(int i=1;i<XY.length;i++){
			for(int j=1;j<XY[0].length;j++){
				if(X.charAt(i-1)==Y.charAt(j-1)){
					XY[i][j]=XY[i-1][j-1]+1;
				}
				else{
					XY[i][j]=Math.max(XY[i-1][j],XY[i][j-1]);
				}
			}
		}
		System.out.println("LCS: "+XY[X.length()][Y.length()]);
	}
}
